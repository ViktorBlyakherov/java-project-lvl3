package hexlet.code;

import java.util.Map;

public final class SizeOfPredicate implements Predicate {
    private Integer size;

    public SizeOfPredicate(Integer inpSize) {
        this.size = inpSize;
    }
    @Override
    public boolean check(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof Map) {
            return ((Map<?, ?>) o).size() == size;
        } else {
            return false;
        }
    }
}
