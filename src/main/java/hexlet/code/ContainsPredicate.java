package hexlet.code;

public final class ContainsPredicate implements Predicate {
    private String pattern;

    ContainsPredicate(String inpPattern) {
        this.pattern = inpPattern;
    }

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        return o.toString().contains(pattern);
    }
}
