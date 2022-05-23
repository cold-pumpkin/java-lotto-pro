package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";


    private InputView() {}
    
    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String readWinningNumbers() {
        System.out.println("\n" + WINNING_NUMBERS_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
