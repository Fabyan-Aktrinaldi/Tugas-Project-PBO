package profesi;

import characters.Player;

public class Knight extends Player {

    public Knight() {
        super(120, 10); // HP besar, attack kecil
    }

    @Override
    public int skill() {
    System.out.println("\nKnight menggunakan Shield Strike! -> Damage: " + (getAttackPower() +15));
    return getAttackPower() + 15;
}
}