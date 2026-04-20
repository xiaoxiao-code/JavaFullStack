package org.cqipu.edu.factory;

public class DaggerFactory implements WeaponFactory02{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
