package lotto.enums;

import lotto.model.Prize;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Prize.of(2_000_000_000)),
    SECOND(5, Prize.of(30_000_000)),
    THIRD(4, Prize.of(1_500_000)),
    FOURTH(3, Prize.of(50_000)),
    LOSE(0, Prize.of(0));

    private final int matchingCount;
    private final Prize prize;

    Rank(int matchingCount, Prize prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == numberOfMatch)
                .findAny()
                .orElse(LOSE);
    }

    public Prize getPrize() {
        return prize;
    }
}
