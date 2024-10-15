class Card {
    private char value;
    private boolean isMatched;

    public Card(char value) {
        this.value = value;
        this.isMatched = false;
    }

    public char getValue() {
        return value;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched() {
        isMatched = true;
    }
}