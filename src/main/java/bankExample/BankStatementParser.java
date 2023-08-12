package bankExample;

import java.util.List;

//결합도를 낮추기 위한 인터페이스
public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
