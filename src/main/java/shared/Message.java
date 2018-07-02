package shared;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author kozlojak
 */

@NoArgsConstructor
@Data
public class Message<T> {
    public StatementType type;
    public T content;

    public Message(StatementType type, T content){
        this.type=type;
        this.content=content;
    }
}