package hexlet.code.schemas;

import hexlet.code.PositivePredicate;
import hexlet.code.RangePredicate;
import hexlet.code.RequiredNumberPredicate;

public final class NumberSchema extends BaseSchema {
    @Override
    public NumberSchema required() {
        getPredicates().add(new RequiredNumberPredicate());
        return this;
    }

    public NumberSchema positive() {
        getPredicates().add(new PositivePredicate());
        return this;
    }

    public NumberSchema range(Integer fromNumber, Integer toNumber) {
        getPredicates().add(new RangePredicate(fromNumber, toNumber));
        return this;
    }
}
