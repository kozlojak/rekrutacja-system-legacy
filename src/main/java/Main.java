import shared.Message;
import to.AMG_TO;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static shared.StatementType.AMG;

public class Main {
    public static void main(String[]args) throws IOException, TimeoutException {
        AMG_TO amg_to=new AMG_TO();
        amg_to.setColumn1("test1");
        amg_to.setColumn2("test2");
        Message<AMG_TO> message= new Message<>(AMG, amg_to);
        for(int i=0; i<3; i++){

        Producer.produce(message);
        Receiver.receive();

        }
    }
}
