import game.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("|-----------------------------------------|");
            System.out.println("|         GAME COLLOSEUM BATTLE           |");
            System.out.println("|-----------------------------------------|");
            System.out.println("| 1. Mulai Game                           |");
            System.out.println("| 2. Keluar Game                          |");
            System.out.print("  => Pilih opsi (1/2): ");
            Scanner input = new Scanner(System.in);
            String pilihan = input.nextLine();
             System.out.println("|-----------------------------------------|");
            

            if (pilihan.equals("1")) {
                Game game = new Game();
                game.start();
            } else if (pilihan.equals("2")) {
                System.out.println("Terima kasih sudah bermain!");
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih 1 atau 2.");
            }

            
        }
        // Game game = new Game();
        // game.start();
    }
}