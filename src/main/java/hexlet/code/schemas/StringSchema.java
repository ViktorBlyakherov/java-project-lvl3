package hexlet.code.schemas;

import hexlet.code.ContainsPredicate;
import hexlet.code.MinLengthPredicate;
import hexlet.code.RequiredStringPredicate;

public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        getPredicates().add(new RequiredStringPredicate());
        return this;
    }

    public StringSchema minLength(Integer countDigit) {
        getPredicates().add(new MinLengthPredicate(countDigit));
        return this;
    }

    public StringSchema contains(String pattern) {
        getPredicates().add(new ContainsPredicate(pattern));
        return this;
    }
}
