package lzt.lztbatis.bank.service.impl;

import lzt.lztbatis.bank.dao.AccountDao;
import lzt.lztbatis.bank.exception.AppException;
import lzt.lztbatis.bank.exception.MoneyNotEnoughException;
import lzt.lztbatis.bank.pojo.Account;
import lzt.lztbatis.bank.service.AccountService;
import lzt.lztbatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    // 注释掉之前自己写的实现类
    // private AccountDao accountDao = new AccountDaoImpl();

    // 注释掉上一步手写的 Javassist 动态代理
    // private AccountDao accountDao = (AccountDao)GenerateDaoByJavassist.getMapper(SqlSessionUtil.openSession(), AccountDao.class);

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {

        // 1. 获取当前线程绑定的 SqlSession（开启事务）
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 2. 核心魔法：使用 MyBatis 内置的接口代理机制获取 DAO 实现类
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        try {
            // 3. 查询转出账户的信息
            Account fromAct = accountDao.selectByActno(fromActno);
            if (fromAct == null) {
                throw new AppException("转出账户不存在！");
            }

            // 4. 判断余额是否充足
            if (fromAct.getBalance() < money) {
                throw new MoneyNotEnoughException("对不起，余额不足！");
            }

            // 5. 余额充足，查询转入账户的信息
            Account toAct = accountDao.selectByActno(toActno);
            if (toAct == null) {
                throw new AppException("转入账户不存在！");
            }

            // 6. 在内存中修改两个账户的余额
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);

            // 7. 调用代理对象的方法更新数据库
            int count = accountDao.update(fromAct);
            if (count != 1) {
                throw new AppException("转出账户更新失败！");
            }

            count = accountDao.update(toAct);
            if (count != 1) {
                throw new AppException("转入账户更新失败！");
            }

            // 8. 事务提交
            sqlSession.commit();

        } catch (Exception e) {
            // 9. 事务回滚
            sqlSession.rollback();
            if (e instanceof AppException) throw (AppException) e;
            if (e instanceof MoneyNotEnoughException) throw (MoneyNotEnoughException) e;
            throw new AppException("系统繁忙，转账失败：未知错误！");
        } finally {
            // 10. 释放资源并清空 ThreadLocal
            SqlSessionUtil.close(sqlSession);
        }
    }
}