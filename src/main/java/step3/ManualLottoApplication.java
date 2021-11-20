package step3;

import step3.domain.LottoMatchResult;
import step3.domain.LottoTicket;
import step3.domain.LottoTicketPrice;
import step3.domain.LottoTickets;
import step3.domain.LottoWinningProfit;
import step3.domain.LottoWinningTicket;
import step3.domain.Money;
import step3.view.InputView;
import step3.view.ResultView;

public class ManualLottoApplication {

  public static void main(String[] args) {
    // 구입 금액 입력
    LottoTicketPrice ticketPrice = new LottoTicketPrice(new Money(InputView.getPurchasePriceInput()));

    // 구매 갯수 출럭
    int ticketCount = ticketPrice.getTicketCount();
    ResultView.printTicketCount(ticketCount);

    // 로또 티켓 내용 출력
    LottoTickets lottoTickets = new LottoTickets(ticketCount);
    ResultView.printTickets(lottoTickets);

    // 당첨 번호 입력
    LottoWinningTicket winningTicket = new LottoWinningTicket(InputView.getWinningNumbersInput(), InputView.getBonusNumberInput());

    // 당첨 결과 출력
    LottoMatchResult lottoMatchResult = lottoTickets.matchWinningNumbers(winningTicket);
    ResultView.printWinningPrice(lottoMatchResult);

    // 수익률 출력
    LottoWinningProfit lottoWinningProfit =
        lottoMatchResult.getLottoWinningPrice().getProfitOf(ticketPrice.getTotalPrice());
    ResultView.printWinningProfit(lottoWinningProfit.getProfit());
  }
}
