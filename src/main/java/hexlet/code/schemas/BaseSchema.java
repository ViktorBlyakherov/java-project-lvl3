package hexlet.code.schemas;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 *  Класс базовой схемы, для наследования остальных схем.
 */
public abstract class  BaseSchema {
    private Map<String, Predicate> predicates = new LinkedHashMap<>();

    public final Map<String, Predicate> getPredicates() {
        return predicates;
    }
    protected final void addCheck(String name, Predicate predicate) {
        predicates.put(name, predicate);
    }
/**
 * Проверка схемы на валидность.
 * @param o - любой объект для проверки
 * @return возвращает boolean
 */
    public boolean isValid(Object o) {
        if (predicates.size() == 0) {
            return true;
        }

        for (Predicate p : predicates.values()) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }

    public abstract BaseSchema required();
}
