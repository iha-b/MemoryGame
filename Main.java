import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of the board (even number): ");
        int size = scanner.nextInt();

        MemoryGame game = new MemoryGame(size);
        game.playGame();
    }
}