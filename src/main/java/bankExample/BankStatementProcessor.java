package bankExample;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction>  bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)){
                total+=bankTransaction.getAmount();
            }
        }
        return total;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : result) {
            if (bankTransaction.getAmount()>= amount){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsInMonth(final Month month){
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : result) {
            if (bankTransaction.getDate().getMonth() == month){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     *
     * 위 두가지 방식을 합친 메서드.
     * 단점: 거래 내역 속성을 조합할수록 코드가 점점 복잡해져감.
     * 반복 로직과 비지니스 로직이 결합되어 분리하기가 어려워진다.
     * 코드를 반복한다.
     * @param month
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount){
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : result) {
            if (bankTransaction.getAmount()>= amount && bankTransaction.getDate().getMonth() == month){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter filter){
        ArrayList<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : result) {
            if (filter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }

}
