package hexlet.code.schemas;
import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Map<String, BaseSchema> predicatesMap = new HashMap<>();

    public void shape(Map<String, BaseSchema> tmpMap) {
        this.predicatesMap = tmpMap;
    }

    @Override
    public MapSchema required() {
        getPredicates().put("required", value -> value instanceof Map<?, ?>);
        return this;
    }

    @Override
    public boolean isValid(Object o) {
        if (!super.isValid(o)) {
            return false;
        }

        Map<?, ?> inputMap = (Map<?, ?>) o;

        for (String key : predicatesMap.keySet()) {
            if (inputMap.containsKey(key)) {
                BaseSchema bs = predicatesMap.get(key);
                if (!bs.isValid(inputMap.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    public MapSchema sizeof(Integer size) {
        getPredicates().put("sizeof", value -> value != null && value instanceof Map<?, ?>
                && ((Map<?, ?>) value).size() == size);
        return this;
    }
}
