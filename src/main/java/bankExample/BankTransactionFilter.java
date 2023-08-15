package bankExample;

@FunctionalInterface
public interface BankTransactionFilter {

    /**
     * BankTransaction의 특정 조건의 참 거짓 여부를 판단한다.
     * @param bankTransaction
     * @return boolean
     */
    boolean test (BankTransaction bankTransaction);
}
