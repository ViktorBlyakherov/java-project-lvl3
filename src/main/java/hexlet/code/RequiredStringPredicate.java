package hexlet.code;
public final class RequiredStringPredicate implements Predicate {

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof String) {
            return o.toString().length() != 0;
        }

        return false;
    }
}
