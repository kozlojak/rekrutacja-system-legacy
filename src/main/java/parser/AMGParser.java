package parser;

import converter.AMGConverter;
import converter.AMGConverterImpl;

import service.AMGEntityParser;
import to.AMG_TO;

/**
 *@author kozlojak
 */

public class AMGParser implements Parser<AMG_TO> {

    private AMGConverter aMGConverter=new AMGConverterImpl();
    private AMGEntityParser aMGService=new AMGEntityParser();

    @Override
    public void parseMessage(AMG_TO message) {
        aMGService.someMethod(aMGConverter.convertTO(message));
    }
}
