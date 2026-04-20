package org.cqipu.edu.service;

import org.cqipu.edu.dao.AccountDao;
import org.cqipu.edu.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        // 优化：判断null，友好打印
        if (account == null) {
            System.out.println("查询的账户不存在：" + actno);
        } else {
            System.out.println("查询到的账户信息：" + account);
        }
    }
}

