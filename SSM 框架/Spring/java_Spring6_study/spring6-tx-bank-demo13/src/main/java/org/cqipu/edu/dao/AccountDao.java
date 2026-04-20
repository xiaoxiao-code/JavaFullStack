package org.cqipu.edu.dao;

import org.cqipu.edu.pojo.Account;
public interface AccountDao {

    /**
     * 根据账号查询余额
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * @param act
     * @return
     */
    int update(Account act);

    int insert(Account act);
}

