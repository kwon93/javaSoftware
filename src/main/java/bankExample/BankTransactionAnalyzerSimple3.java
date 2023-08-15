package bankExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * collectSummary()를 통해 금액 계산 클래스의 메서드들을 호출해 훨씬 단순한 클래스로 개선함
 *
 * ver 3.0
 */

public class BankTransactionAnalyzerSimple3 {
    private static final String RESOURCES = "src/main/resources/";

    private static final BankStatementCSVParser bankStatementParser
            = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + args[0]); //해당경로로 파일을 가져옴.
        final List<String> lines = Files.readAllLines(path); //파일의 행목록을 반환한다.

        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor
                = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all Transactions In January is "
                + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for all Transactions In January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for all Transactions In July is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JULY));

        System.out.println("The total salary received is "+
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}

