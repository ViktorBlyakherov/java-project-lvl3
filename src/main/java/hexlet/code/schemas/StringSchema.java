package hexlet.code.schemas;
public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        getPredicates().put("required", value -> value != null && value instanceof String
                && ((String) value).length() > 0);
        return this;
    }

    public StringSchema minLength(Integer countDigit) {
        getPredicates().put("minLength", value -> value != null && value instanceof String
                && ((String) value).length() >= countDigit);
        return this;
    }

    public StringSchema contains(String pattern) {
        getPredicates().put("contains", value -> value != null && value instanceof String
                && ((String) value).contains(pattern));
        return this;
    }
}
