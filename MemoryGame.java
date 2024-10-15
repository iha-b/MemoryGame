import java.util.*;
class MemoryGame {
    private Board board;
    private int player1Score;
    private int player2Score;

    public MemoryGame(int size) {
        this.board = new Board(size);
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isGameOver()) {
            System.out.println("Current Board:");
            board.displayBoard(-1, -1, -1, -1);

            System.out.println("Player 1's Turn:");
            playTurn(1);

            if (board.isGameOver()) {
                break;
            }

            System.out.println("Current Board:");
            board.displayBoard(-1, -1, -1, -1);

            System.out.println("Player 2's Turn:");
            playTurn(2);
        }

        announceWinner();
    }

    private void playTurn(int player) {
        Scanner scanner = new Scanner(System.in);
        int row1, col1, row2, col2;

        // Get the row and column of the first card
        System.out.print("Enter the row and column of the first card (e.g., 0 1): ");
        row1 = scanner.nextInt();
        col1 = scanner.nextInt();

        // Validate the input for the first card
        while (board.getCard(row1, col1).isMatched()) {
            System.out.println("Invalid input. Card already matched. Enter again:");
            System.out.print("Enter the row and column of the first card (e.g., 0 1): ");
            row1 = scanner.nextInt();
            col1 = scanner.nextInt();
        }

        // Display the value of the first card
        System.out.println("Card value: " + board.getCard(row1, col1).getValue());
        board.displayBoard(row1, col1, -1, -1);

        // Get the row and column of the second card
        System.out.print("Enter the row and column of the second card (e.g., 1 2): ");
        row2 = scanner.nextInt();
        col2 = scanner.nextInt();

        // Validate the input for the second card
        while (board.getCard(row2, col2).isMatched() || (row1 == row2 && col1 == col2)) {
            System.out.println("Invalid input. Card already matched or same as the first card. Enter again:");
            System.out.print("Enter the row and column of the second card (e.g., 1 2): ");
            row2 = scanner.nextInt();
            col2 = scanner.nextInt();
        }

        // Display the value of the second card
        System.out.println("Card value: " + board.getCard(row2, col2).getValue());
        board.displayBoard(row1, col1, row2, col2);

        // Check for a match and update scores
        if (board.getCard(row1, col1).getValue() == board.getCard(row2, col2).getValue()) {
            System.out.println("Match found! Player " + player + " scores 2 points.");
            if (player == 1) {
                player1Score += 2;
            } else {
                player2Score += 2;
            }
            board.setCardMatched(row1, col1);
            board.setCardMatched(row2, col2);
        } else {
            System.out.println("No match. Player " + player + "'s turn ends.");
        }
    }

    private void announceWinner() {
        System.out.println("Game Over!");
        System.out.println("Player 1 Score: " + player1Score);
        System.out.println("Player 2 Score: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player1Score < player2Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}