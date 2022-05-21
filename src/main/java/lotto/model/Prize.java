package lotto.model;

import java.util.Objects;

public class Prize {
    final long amount;

    private Prize(long prize) {
        this.amount = prize;
    }

    public static Prize of(long amount) {
        checkPrizeRange(amount);
        return new Prize(amount);
    }

    private static void checkPrizeRange(long prize) {
        if (prize < 0) {
            throw new IllegalArgumentException("[ERROR] 당첨금액은 음수일 수 없습니다!");
        }
    }

    public Prize add(Prize prize) {
        return Prize.of(this.amount + prize.amount);
    }

    public Prize multiply(int count) {
        return Prize.of(this.amount * count);
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return amount == prize.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
