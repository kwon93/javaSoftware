package bankExample;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {

        final BankTransactionAnalyzerSimple4 bankAnalyzer
                = new BankTransactionAnalyzerSimple4();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        bankAnalyzer.analyze(args[0],bankStatementParser);
    }
}
