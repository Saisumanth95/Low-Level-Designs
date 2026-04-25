import Models.Catalog;
import Models.Product;
import States.IdleState;
import States.ProductSelectState;
import States.State;

import java.util.ArrayList;

public class VendingMachine {


    private Catalog catalog = Catalog.getInstance();

    public void loadSystem(){
        catalog.loadProducts(new ArrayList<>());
        catalog.addProduct(new Product(1,"Oats", "Quicker oats", 2.00, 6));
        catalog.addProduct(new Product(1,"Protein bar", "Super you protein bar", 4.00, 10));
        catalog.addProduct(new Product(1,"Milk", "Low fat milk", 5.00, 9));
    }

    public void request(State state){
       state.handleRequest();
    }

}
