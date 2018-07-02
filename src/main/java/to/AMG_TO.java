package to;

import lombok.Data;

/**
 * The name of the class is not according to convention to improve its readability.
 *@author kozlojak
 */

@Data
public class AMG_TO {

    private String column1;
    private String column2;

    public void setPatameters(String column1, String column2){
        setColumn1(column1);
        setColumn2(column2);
    }
}
