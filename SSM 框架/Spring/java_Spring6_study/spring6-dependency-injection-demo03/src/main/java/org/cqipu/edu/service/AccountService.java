package org.cqipu.edu.service;
import org.cqipu.edu.dao.AccountDao;
public class AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save(){
        accountDao.insert();
    }
}
