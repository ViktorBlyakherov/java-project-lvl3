package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    @Override
    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || !(value instanceof Integer) || (Integer) value > 0);
        return this;
    }

    public NumberSchema range(Integer fromNumber, Integer toNumber) {
        addCheck("range", value -> ((int) value >= fromNumber && (int) value <= toNumber));
        return this;
    }
}
