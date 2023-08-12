package bankExample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser{

    private static final DateTimeFormatter DATE_PATTERN
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //CSV에서 날짜, 금액, 명세별로 Parsing만 담당하는 메서드
//    private BankTransaction parseFromCSV(final String line){
//        final String[] columns = line.split(",");
//
//        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
//        final double amount = Double.parseDouble(columns[1]);
//        final String description = columns[2];
//
//        return new BankTransaction(date, amount, description);
//    }
//
//    //p
//    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
//        final List<BankTransaction> bankTransactions = new ArrayList<>();
//        for (final String line : lines) {
//            bankTransactions.add(parseFromCSV(line));
//        }
//        return bankTransactions;
//    }

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
