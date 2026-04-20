package org.cqipu.edu.service;

import org.cqipu.edu.dao.UserDao;

//public class UserService {
//    private UserDao aaa;
//
//    // 使用set方式注入，必须提供set方法。
//    // 反射机制要调用这个方法给属性赋值的。
//    public void setUserDao(UserDao userDao) {
//        this.aaa = userDao;
//    }
//    public void save(){
//        aaa.insert();
//    }
//}

//public class UserService{
//    private UserDao userDao;
//    public void setUserDao(UserDao userDao){
//        this.userDao = userDao;
//    }
//}
public class UserService {
    private UserDao aaa; // 这个不变

    // 这个set方法非常关键
//    public void setAaa(UserDao aaa) {
//        this.aaa = aaa;
//    }

    // set方法名变化了
//    public void setDao(UserDao aaa){
//        this.aaa = aaa;
//    }
    public void save(){
        aaa.insert();
    }
}
