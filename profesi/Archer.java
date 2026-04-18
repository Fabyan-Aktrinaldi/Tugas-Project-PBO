package profesi;

import characters.Player;

public class Archer extends Player {

    public Archer() {
        super(90, 15); // HP lebih kecil, attack lebih tinggi
    }

    @Override
    public int skill() {
        System.out.print("Archer menggunakan Rapid Shot!");
        System.out.println(" -> Damage: " + (getAttackPower() * 2));
        return getAttackPower() * 2;
    }
}