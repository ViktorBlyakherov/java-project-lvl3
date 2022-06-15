package hexlet.code;

import java.util.Map;

public final class RequiredMapPredicate implements Predicate {

    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        return o instanceof Map;

    }
}
