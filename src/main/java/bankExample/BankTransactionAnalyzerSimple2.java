package bankExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


/**
 * 2.0 ver
 * parding하는 기능을 따로 클래스로 구현해 분리해놓은 ver
 */
public class BankTransactionAnalyzerSimple2 {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + args[0]); //해당경로로 파일을 가져옴.
        final List<String> lines = Files.readAllLines(path); //파일의 행목록을 반환한다.

        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all Transactions In January is "+ calculateTotalAmount(bankTransactions));
        System.out.println("The total for all Transactions In January is "+ selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        ArrayList<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
                if (bankTransaction.getDate().getMonth() == month){
                    bankTransactionsInMonth.add(bankTransaction);
                }
        }
        return bankTransactionsInMonth;
    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
}
