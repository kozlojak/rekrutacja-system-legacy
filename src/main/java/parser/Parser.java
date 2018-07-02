package parser;

/**
 *@author kozlojak
 */

public interface Parser<T> {
    void parseMessage(T message);
}
