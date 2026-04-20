package org.cqipu.edu;

import org.cqipu.edu.factory.WeaponFactory02;
import org.cqipu.edu.factory.Weapon;
import org.cqipu.edu.factory.GunFactory;
import org.cqipu.edu.factory.FighterFactory;
import org.cqipu.edu.factory.DaggerFactory;

public class Client03 {
    public static void main(String[] args) {
        WeaponFactory02 factory = new GunFactory();
        Weapon weapon = factory.get();
        weapon.attack();

        WeaponFactory02 factory1 = new FighterFactory();
        Weapon weapon1 = factory1.get();
        weapon1.attack();

        WeaponFactory02 factory2 = new DaggerFactory();
        Weapon weapon2 = factory2.get();
        weapon2.attack();
    }
}

