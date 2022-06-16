package hexlet.code;

public final class RangePredicate implements Predicate {
    private Integer fromNumber;
    private Integer toNumber;

    public RangePredicate(Integer inpFromNumber, Integer inpToNumber) {
        this.fromNumber = inpFromNumber;
        this.toNumber = inpToNumber;
    }

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        return (Integer) o >= fromNumber && (Integer) o <= toNumber;
    }
}
