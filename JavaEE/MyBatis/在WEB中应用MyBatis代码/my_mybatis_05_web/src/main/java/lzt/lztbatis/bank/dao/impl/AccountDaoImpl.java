package lzt.lztbatis.bank.dao.impl;

import lzt.lztbatis.bank.dao.AccountDao;
import lzt.lztbatis.bank.pojo.Account;
import lzt.lztbatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.selectOne("account.selectByActno", actno);
    }

    @Override
    public int update(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.update("account.update", act);
    }
}