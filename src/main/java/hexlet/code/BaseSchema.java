package hexlet.code;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс базовой схемы, для наследования остальных схем.
 */
public abstract class  BaseSchema {
    private List<Predicate> predicates = new ArrayList<>();

    public final List<Predicate> getPredicates() {
        return predicates;
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
        for (Predicate p : predicates) {
            if (!p.check(o)) {
                return false;
            }
        }
        return true;
    }

    public abstract BaseSchema required();
}
