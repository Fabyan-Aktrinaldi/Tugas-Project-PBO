package profesi;

import characters.Player;

public class Mage extends Player {

    public Mage() {
        super(80, 20); // HP kecil, attack besar
    }

    @Override
    public int skill() {
    System.out.println("Mage menggunakan Fireball! -> Damage:" + (getAttackPower() * 3));
    return getAttackPower() * 3;
}
}