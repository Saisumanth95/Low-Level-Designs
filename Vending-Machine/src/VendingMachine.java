import Models.Catalog;
import Models.Product;
import States.IdleState;
import States.ProductSelectState;
import States.State;

import java.util.ArrayList;

public class VendingMachine {

    public void request(State state){
       state.handleRequest();
    }

}
