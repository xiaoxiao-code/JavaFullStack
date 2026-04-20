package org.cqipu.edu.factory;

/**
 * 具体工厂角色
 **/
public class GunFactory implements WeaponFactory02{
    @Override
    public Weapon get() {
        return new Gun();
    }
}

