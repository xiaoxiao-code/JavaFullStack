package org.cqipu.edu.factory;

import org.cqipu.edu.product.Dagger;
import org.cqipu.edu.product.Fruit;
import org.cqipu.edu.product.Gun;
import org.cqipu.edu.product.Weapon;

/**
 * 武器族工厂
 **/
public class WeaponFactory03 extends AbstractFactory{

    public Weapon getWeapon(String type){
        if (type == null || type.trim().length() == 0) {
            return null;
        }
        if ("Gun".equals(type)) {
            return new Gun();
        } else if ("Dagger".equals(type)) {
            return new Dagger();
        } else {
            throw new RuntimeException("无法生产该武器");
        }
    }

    @Override
    public Fruit getFruit(String type) {
        return null;
    }
}
