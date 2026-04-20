package org.cqipu.edu.factory;

/**
 * 具体工厂角色
 **/
public class FighterFactory implements WeaponFactory02{
    @Override
    public Weapon get() {
        return new Fighter();
    }
}

