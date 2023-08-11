package bankExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * ex)
 * 30-01-2023, -100, salary
 * 31-01-2023, 6000, rent
 * 02-02-2023, -500, Tesco
 *
 * 중간에 적혀있는 금액만 계산해 총 수입과 총 지출을을 구하는 프로그램
 */

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]); //해당경로로 파일을 가져옴.
        final List<String> lines = Files.readAllLines(path); //파일의 행목록을 반환한다.
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line : lines) {
            final String[]  columns = line.split(","); //콤마로 열을 분리하고 금액 추출
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN); //날짜만 parsing해서
            if (date.getMonth() == Month.JANUARY) { //parsing한 날짜의 월이 1월이라면
                final double amount = Double.parseDouble(columns[1]); // 금액을 double type 으로 parsing
                total += amount; //금액을 최종값에 더함.
            }
        }

        System.out.println("The total for all Transactions In January is "+total);
    }
}
