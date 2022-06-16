package hexlet.code;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidator {
    private static final int POSITIVE_TEN = 10;
    private static final int POSITIVE_FIVE = 5;
    private static final int NEGATIVE_FIVE = -5;
    private static final int NEGATIVE_TEN = -10;

    @Test
    public void stringSchema() {

        Validator v = new Validator();

        StringSchema schema = v.string();

        assertEquals(schema.isValid(""), true); // true
        assertEquals(schema.isValid(null), true); // true

        schema.required();

        assertEquals(schema.isValid("what does the fox say"), true); // true
        assertEquals(schema.isValid("hexlet"), true); // true
        assertEquals(schema.isValid(null), false); // false
        assertEquals(schema.isValid(""), false); // false

        assertEquals(schema.contains("what").isValid("what does the fox say"), true); // true
        assertEquals(schema.contains("whatthe").isValid("what does the fox say"), false); // false

        assertEquals(schema.isValid("what does the fox say"), false); // false
    }

    @Test
    public void mapSchema() {

        Validator v = new Validator();

        MapSchema schema = v.map();

        assertEquals(schema.isValid(null), true); // true

        schema.required();

        assertEquals(schema.isValid(null), false); // false
        assertEquals(schema.isValid(new HashMap()), true); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertEquals(schema.isValid(data), true); // true

        schema.sizeof(2);

        assertEquals(schema.isValid(data), false);  // false
        data.put("key2", "value2");
        assertEquals(schema.isValid(data), true); // true
    }

    @Test
    public void numberSchema() {

        Validator v = new Validator();

        NumberSchema schema = v.number();

        assertEquals(schema.isValid(null), true); // true

        schema.required();

        assertEquals(schema.isValid(null), false); // false
        assertEquals(schema.isValid(POSITIVE_TEN), true); // true
        assertEquals(schema.isValid("5"), false); // false

        assertEquals(schema.positive().isValid(POSITIVE_TEN), true); // true
        assertEquals(schema.isValid(NEGATIVE_TEN), false); // false

        schema.range(POSITIVE_FIVE, POSITIVE_TEN);

        assertEquals(schema.isValid(POSITIVE_FIVE), true); // true
        assertEquals(schema.isValid(POSITIVE_TEN), true); // true
        assertEquals(schema.isValid(0), false); // false
    }

    @Test
    public void shapeSchema() {

        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", POSITIVE_TEN);
        assertEquals(schema.isValid(human1), true); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Mayaa");
        human2.put("age", null);
        assertEquals(schema.isValid(human2), true); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertEquals(schema.isValid(human3), false); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", NEGATIVE_FIVE);
        assertEquals(schema.isValid(human4), false); // false

    }

}
