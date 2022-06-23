package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    @Override
    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || ((int) value) > 0);
        //Так как предлагал ты - не работает. По условию null проверяется этим предикатом как true
        return this;
    }

    public NumberSchema range(int fromNumber, int toNumber) {
        addCheck("range", value -> ((int) value >= fromNumber && (int) value <= toNumber));
        return this;
    }
}
