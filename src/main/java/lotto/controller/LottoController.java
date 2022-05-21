package lotto.controller;

import lotto.model.*;

import static lotto.utils.InputUtils.*;
import static lotto.view.InputView.*;

public class LottoController {

    public static void run() {
        Purchase purchaseInfo = Purchase.createPurchase(convertToInteger(readPurchaseAmount()));
        purchaseInfo.printPurchaseCount();

        Lottos lottos = purchaseInfo.createLottos();
        lottos.printLottos();

        LottoNumbers winningNumbers = LottoNumbers.createWinningNumbers(convertToIntegerList(splitWithDelimiter(readWinningNumbers())));
        LottoNumber bonusNumber = LottoNumber.of(convertToInteger(readBonusNumber()));

        RankCount rankCount = lottos.rankCount(winningNumbers, bonusNumber);
        Earning earningRate = rankCount.earningRate(purchaseInfo);

        Statistics statistics = Statistics.of(rankCount, earningRate);
        statistics.printStatistics();
    }
}
