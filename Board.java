import java.util.*;
class Board {
    private Card[][] cards;
    private int size;

    public Board(int size) {
        this.size = size;
        this.cards = new Card[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        char[] values = generateValues();
        shuffleArray(values);

        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cards[i][j] = new Card(values[k]);
                k++;
            }
        }
    }

    private char[] generateValues() {
        char[] values = new char[size * size];
        char currentChar = 'A';

        for (int i = 0; i < size * size; i += 2) {
            values[i] = values[i + 1] = currentChar++;
        }

        return values;
    }

    private void shuffleArray(char[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public void displayBoard(int row1, int col1, int row2, int col2) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == row1 && j == col1) || (i == row2 && j == col2) || cards[i][j].isMatched()) {
                    System.out.print(cards[i][j].getValue() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public Card getCard(int row, int col) {
        return cards[row][col];
    }

    public void setCardMatched(int row, int col) {
        cards[row][col].setMatched();
    }

    public boolean isGameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cards[i][j].isMatched()) {
                    return false;
                }
            }
        }
        return true;
    }
}
