package hexlet.code;
public final class RequiredNumberPredicate implements Predicate {

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        return o instanceof Integer;
    }
}
