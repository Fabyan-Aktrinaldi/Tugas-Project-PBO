package game;

import java.util.Scanner;
import characters.Player;
import characters.Enemy;
import profesi.Archer;
import profesi.Mage;
import profesi.Knight;

public class Game {

    private Player player;
    private Scanner input = new Scanner(System.in);

    private int targetGold = 100;

    public void start() {

        System.out.println("\n=========== GAME COLLOSEUM BATTLE ===========\n");
        System.out.println("Kamu adalah seorang budak yang harus bertarung untuk membeli kebebasan anda!");
        System.out.println("Kumpulkan " + targetGold + " gold untuk membeli kebebasan anda!\n");

        pilihRole();

        int level = 1;
        int bebas = 0;

        while (player.isAlive() && bebas == 0) {

            System.out.println("\n|=== ROUND " + level + " ===|");

            Enemy enemy = new Enemy(50 + level * 10, 10 + level * 3, "Gladiator " + level);

            battle(enemy);
            System.out.println("\n <!> Round " + level + " selesai! <!>\n");
            System.out.println("|=================================================|\n");

            if (player.isAlive()) {
                player.tambahGold(20 + level * 5);
                System.out.println(" Gold kamu sekarang: " + player.getGold());
                System.out.println(" HP kamu sekarang  : " + player.getHealth());
                System.out.println("\n Jumlah potion kamu: " + player.getPotion());
                System.out.print(" Apakah kamu ingin menggunakan potion? (y/n) : ");
                String jawaban_1 = input.next();
                if (jawaban_1.equalsIgnoreCase("y")) {
                    player.gunakanPotion();
                    System.out.println("\n HP kamu sekarang: " + player.getHealth());
                }else {
                    System.out.print(" Apakah kamu ingin membeli potion? (y/n) : ");
                    String jawaban_2 = input.next();
                        if (jawaban_2.equalsIgnoreCase("y")) {
                            System.out.print(" Berapa banyak potion yang ingin kamu beli? : ");
                            int jumlah = input.nextInt();
                            player.beliPotion(jumlah);
                        }   
                }
    
                level++;
                System.out.println("\n|=================================================|\n");
            }


            if (player.getGold() >= targetGold) {
                // player.displayStatus();
                System.out.println("\n -> Gold Kamu sudah mencapai " + player.getGold() + "!");
                System.out.print("\n => Apakah kamu ingin membeli kebebasanmu dan keluar dari colosseum? (y/n): ");
                String jawaban = input.next();
                if (jawaban.equalsIgnoreCase("y")) {
                    player.belikebebasan(jawaban);
                    bebas = 1;
                } else {
                    System.out.println("\n <<<>>> KAMU MEMILIH UNTUK TETAP BERJUANG DI COLOSSEUM! <<<>>>");
                    bebas = 0;
                }
            }

        }

        if (bebas == 1) {
            System.out.println("\n <<<>>> KAMU BERHASIL BEBAS DARI COLOSSEUM! <<<>>>\n\n");
        } else if (!player.isAlive()) {
            System.out.println("\n|===>!! ...KAMU MATI DAN KALAH DI ARENA... !!<===|\n\n");
        }
    }

    // Pilih role di awal game
    private void pilihRole() {

        System.out.println("Pilih Role:");
        System.out.println("1. Archer");
        System.out.println("2. Mage");
        System.out.println("3. Knight");
        System.out.print("Masukkan pilihan (1-3): ");

        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                player = new Archer();
                break;
            case 2:
                player = new Mage();
                break;
            case 3:
                player = new Knight();
                break;
            default:
                System.out.println("Pilihan salah, default Knight dipakai.");
                player = new Knight();
        }
    }

    // Battle system
    private void battle(Enemy enemy) {

        System.out.println("\nMusuh muncul: " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\nHP Kamu: " + player.getHealth());
            System.out.println("HP Musuh: " + enemy.getHealth());
            System.out.print("\n");

            System.out.println("1. Attack");
            System.out.println("2. Skill");
            System.out.print("Pilih aksi (1-2): ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                enemy.takeDamage(player.attack());
                System.out.println("\nKamu menyerang!" + " -> Damage: " + player.attack());
            }

            else if (pilihan == 2) {
                System.out.println("Kamu menggunakan skill!\n");
                enemy.takeDamage(player.skill());
            }

            // Musuh menyerang balik
            if (enemy.isAlive()) {
                System.out.print("Musuh menyerang!" + " -> Damage: ");
                player.takeDamage(enemy.action());
                System.out.println("\n|-------------------------------------------------|");

            }

        }

        if (!enemy.isAlive()) {
            System.out.println(" <-> Musuh kalah! <->" + " \n <-> Kamu mendapatkan gold! <->" );
        }

    }
}