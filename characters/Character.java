package characters;

public class Character {
    // Atribut utama karakter
    private int health;
    private int attackPower;

    // Constructor untuk mengisi nilai awal
    public Character(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    // Method untuk menyerang (mengembalikan nilai damage)
    public int attack() {
        return attackPower;
    }

    // Method untuk menerima serangan (mengurangi health)
    public void takeDamage(int damage) {
        health -= damage;

        // Supaya health tidak negatif
        if (health < 0) {
            health = 0;
        }
    }

    // Getter untuk mengambil nilai health
    public int getHealth() {
        return health;
    }

    // Getter untuk mengambil nilai attackPower
    public int getAttackPower() {
        return attackPower;
    }

    // Setter untuk mengubah health (opsional, tapi berguna)
    public void setHealth(int health) {
        this.health = health;
    }

    // Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return health > 0;
    }
}