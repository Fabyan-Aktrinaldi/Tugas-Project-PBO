package characters;

public class Player extends Character {

    // Atribut tambahan khusus player
    private int gold;
    private int potion;

    // Constructor
    public Player(int health, int attackPower) {
        super(health, attackPower); // panggil constructor parent
        this.gold = 0;
        this.potion = 2;
    }

    // Method untuk menambah gold
    public void tambahGold(int jumlah) {
        gold += jumlah;
    }

    // Method untuk mengambil gold
    public int getGold() {
        return gold;
    }

    // Method menggunakan potion untuk heal
    public void gunakanPotion() {
        if (potion > 0) {
            setHealth(getHealth() + 20);
            potion--;
            System.out.println(" -> Kamu menggunakan potion dan HP bertambah!");
        } else {
            System.out.println(" -> Potion habis!");
        }
    }

    // Method untuk menambah potion
    public void tambahPotion() {
        potion++;
    }

    public void beliPotion(int jumlah) {
        int harga = 20; // harga per potion
        int totalHarga = harga * jumlah;

        if (gold >= totalHarga) {
            gold -= totalHarga;
            potion += jumlah;
            System.out.println(" => Kamu membeli " + jumlah + " potion!");
        } else {
            System.out.println(" => Gold tidak cukup untuk membeli potion!");
        }
    }

    // Getter potion
    public int getPotion() {
        return potion;
    }

    public int skill() {
    // skill default untuk semua player 
    return getAttackPower() * 2;
    }


    public void belikebebasan(String jawaban) {
        if (jawaban.equalsIgnoreCase("y") && gold >= 100) {
            System.out.println("\n ==> Selamat! Kamu telah membeli kebebasanmu dan keluar dari colosseum! <==");
        } else if (jawaban.equalsIgnoreCase("y") && gold < 100) {
            System.out.println("\n ==> Maaf, gold kamu belum cukup untuk membeli kebebasan! <==");
        } else {
            System.out.println("\n ==> Kamu memilih untuk tetap berjuang di colosseum! <==");
        }
    }


}