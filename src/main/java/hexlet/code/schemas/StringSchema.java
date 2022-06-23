package hexlet.code.schemas;
public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        addCheck("required", value -> value != null && value instanceof String
                && ((String) value).length() > 0);
        return this;
    }

    public StringSchema minLength(int countDigit) {
        addCheck("minLength", value -> ((String) value).length() >= countDigit);
        return this;
    }

    public StringSchema contains(String pattern) {
        addCheck("contains", value -> ((String) value).contains(pattern));
        return this;
    }
}
