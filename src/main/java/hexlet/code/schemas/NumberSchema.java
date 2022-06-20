package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    @Override
    public NumberSchema required() {
        getPredicates().put("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        getPredicates().put("positive", value -> value == null || !(value instanceof Integer) || (Integer) value > 0);
        return this;
    }

    public NumberSchema range(Integer fromNumber, Integer toNumber) {
        getPredicates().put("range", value -> value != null && value instanceof Integer
                && ((Integer) value >= fromNumber && (Integer) value <= toNumber));
        return this;
    }
}
