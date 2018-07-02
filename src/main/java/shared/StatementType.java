package shared;

import to.*;

/**
 *@author kozlojak
 */

public enum StatementType {
    AST(AST_TO.class),
    ASL(ASL_TO.class),
    AMG(AMG_TO.class),
    OMG(OMG_TO.class);

    private final Class<?> clazz;

    StatementType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}