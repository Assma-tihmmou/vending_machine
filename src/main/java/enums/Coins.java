package enums;

public enum Coins {
    HALF_DIRHAMS(1/2),
    ONE_DIRHAM(1),
    TWO_DIRHAMS(2),
    FIVE_DIRHAMS(5),
    TEN_DIRHAMS(10);

    private int coinsNumber;

    Coins(int coinsNumber) {
        this.coinsNumber = coinsNumber;
    }

    public int getCoinsNumber() {
        return coinsNumber;
    }
}
