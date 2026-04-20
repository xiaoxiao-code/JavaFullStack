package org.cqipu.edu.factory;

import org.cqipu.edu.product.Fruit;
import org.cqipu.edu.product.Weapon;
/**
 * 抽象工厂
 **/
public abstract class AbstractFactory {
    public abstract Weapon getWeapon(String type);
    public abstract Fruit getFruit(String type);
}

