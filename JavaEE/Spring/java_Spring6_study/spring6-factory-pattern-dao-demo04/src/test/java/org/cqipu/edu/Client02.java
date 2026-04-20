package org.cqipu.edu;
import org.cqipu.edu.factory.WeaponFactory02;
import org.cqipu.edu.factory.Weapon;
import org.cqipu.edu.factory.GunFactory;
import org.cqipu.edu.factory.FighterFactory;

public class Client02 {
    public static void main(String[] args) {
        WeaponFactory02 factory = new GunFactory();
        Weapon weapon = factory.get();
        weapon.attack();

        WeaponFactory02 factory1 = new FighterFactory();
        Weapon weapon1 = factory1.get();
        weapon1.attack();
    }
}

