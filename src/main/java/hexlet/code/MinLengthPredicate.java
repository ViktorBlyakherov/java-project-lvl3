package hexlet.code;

public final class MinLengthPredicate implements Predicate {
    private int countDigit;

    public MinLengthPredicate(Integer inpCountDigit) {
        this.countDigit = inpCountDigit;
    }

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        return o.toString().length() >= countDigit;
    }
}
