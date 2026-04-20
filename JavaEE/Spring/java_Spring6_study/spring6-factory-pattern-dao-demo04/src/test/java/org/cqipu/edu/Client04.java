package org.cqipu.edu;

import org.cqipu.edu.factory.AbstractFactory;
import org.cqipu.edu.factory.FruitFactory;
import org.cqipu.edu.factory.WeaponFactory03;
import org.cqipu.edu.product.Fruit;
import org.cqipu.edu.product.Weapon;

public class Client04 {
    public static void main(String[] args) {
        // 客户端调用方法时只面向AbstractFactory调用方法。
        AbstractFactory factory = new WeaponFactory03(); // 注意：这里的new WeaponFactory()可以采用 简单工厂模式 进行隐藏。
        Weapon gun = factory.getWeapon("Gun");
        Weapon dagger = factory.getWeapon("Dagger");

        gun.attack();
        dagger.attack();

        AbstractFactory factory1 = new FruitFactory(); // 注意：这里的new FruitFactory()可以采用 简单工厂模式 进行隐藏。
        Fruit orange = factory1.getFruit("Orange");
        Fruit apple = factory1.getFruit("Apple");

        orange.ripeCycle();
        apple.ripeCycle();
    }
}

