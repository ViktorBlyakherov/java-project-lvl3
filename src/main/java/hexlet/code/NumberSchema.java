package hexlet.code;
public final class NumberSchema extends BaseSchema {
    @Override
    public BaseSchema required() {
        getPredicates().add(new RequiredNumberPredicate());
        return this;
    }

    public BaseSchema positive() {
        getPredicates().add(new PositivePredicate());
        return this;
    }

    public BaseSchema range(Integer fromNumber, Integer toNumber) {
        getPredicates().add(new RangePredicate(fromNumber, toNumber));
        return this;
    }
}
