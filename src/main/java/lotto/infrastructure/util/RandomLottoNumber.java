package lotto.infrastructure.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.LottoNumber;

public class RandomLottoNumber {
  private static final List<LottoNumber> cachedNumbers;

  private RandomLottoNumber() {
  }

  static {
    cachedNumbers = new ArrayList<>();

    for (Integer i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER; i++) {
      cachedNumbers.add(LottoNumber.valueOf(i));
    }
  }

  public static List<LottoNumber> generate() {
    Collections.shuffle(cachedNumbers);

    return new ArrayList<>(cachedNumbers.subList(0, 6));
  }
}