package lzt.lztbatis.bank.service;

import lzt.lztbatis.bank.exception.AppException;
import lzt.lztbatis.bank.exception.MoneyNotEnoughException;

/**
 * 账户业务接口
 */
public interface AccountService {

    /**
     * 账户转账业务
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     * @throws MoneyNotEnoughException 余额不足时抛出该异常
     * @throws AppException 应用级别异常，如数据库更新失败时抛出
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException;
}