package characters;

import java.util.Random;

public class Enemy extends Character {

    // Nama musuh (biar gak monoton)
    private String name;

    // Random untuk Sistem serang musuh  sederhana dengan variasi damage
    private Random random = new Random();

    // Constructor
    public Enemy(int health, int attackPower, String name) {
        super(health, attackPower);
        this.name = name;
    }

    // Method untuk mendapatkan nama musuh
    public String getName() {
        return name;
    }

    // Sistem serang sederhana musuh denagan variasi damage
    public int action() {
        // 80% attack, 20% “damage kecil random”
        int chance = random.nextInt(100);

        if (chance < 80) {
            System.out.println(attack());
            return attack(); // serangan normal
        } 
        else {
            System.out.println(attack() / 2);
            return attack() / 2; // serangan lemah (variasi)
        }
    }
}