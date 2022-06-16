package hexlet.code;

public final class PositivePredicate implements Predicate {

    @Override
    public boolean check(Object o) {
        if (o == null || !(o instanceof Integer)) {
            return true;
        }

        return (Integer) o > 0;
    }
}
