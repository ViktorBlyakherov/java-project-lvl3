package hexlet.code;
public final class StringSchema extends BaseSchema {

    @Override
    public BaseSchema required() {
        getPredicates().add(new RequiredStringPredicate());
        return this;
    }

    public BaseSchema minLength(Integer countDigit) {
        getPredicates().add(new MinLengthPredicate(countDigit));
        return this;
    }

    public BaseSchema contains(String pattern) {
        getPredicates().add(new ContainsPredicate(pattern));
        return this;
    }
}
