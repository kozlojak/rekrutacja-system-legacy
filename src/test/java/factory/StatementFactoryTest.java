package factory;


import org.junit.Test;
import parser.AMGParser;
import parser.DefaultParser;
import parser.Parser;
import shared.StatementType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatementFactoryTest {

    @Test
    public void whenCallGetParserFunctionWithStatementTypeAMG_thenCreateAMGParser() {
        //when
        Parser actual=StatementFactory.getParser(StatementType.AMG);
        //then
        assertThat(actual).isInstanceOf(AMGParser.class);
    }

    @Test
    public void whenCallGetParserFunctionWitRandomArgument_thenCreateDefaultParser() {
        //when
        Parser actual=StatementFactory.getParser(null);
        //then
        assertThat(actual).isInstanceOf(DefaultParser.class);
    }
}