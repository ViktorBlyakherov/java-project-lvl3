package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    @Override
    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || !(value instanceof Integer) || (Integer) value > 0);
        //Так как предлагал ты - не работает. По условию null проверяется этим предикатом как true. Если убрать
        //instanceof то ваши тесты хекслет не проходят
        return this;
    }

    public NumberSchema range(int fromNumber, int toNumber) {
        addCheck("range", value -> ((int) value >= fromNumber && (int) value <= toNumber));
        return this;
    }
}
