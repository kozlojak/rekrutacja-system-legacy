package factory;

import parser.*;
import shared.StatementType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static shared.StatementType.*;

/**
 *Class represents Factory Design Pattern to create instances of specified statements.
 *
 * See:
 * @StatementType
 *
 * @author kozlojak
 */

public class StatementFactory {
    private final static Map<StatementType, Supplier<Parser>> map;

    static {
        map = new HashMap<>();
        map.put(AMG, AMGParser::new);
        map.put(ASL, ASLParser::new);
        map.put(AST, ASTParser::new);
        map.put(OMG, OMGParser::new);
        map.put(null, DefaultParser::new);
    }

    public static Parser getParser(StatementType statementTypeValue) {
       return map.getOrDefault(statementTypeValue,null).get();

    }
}
