import Models.Catalog;
import Models.Product;
import Services.PaymentService;
import Services.ProductService;
import Services.payments.PaymentType;
import States.IdleState;
import States.ProductSelectState;
import States.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {


    private Catalog catalog = Catalog.getInstance();

    List<PaymentType> paymentTypes = new ArrayList<>();

    IdleState idleState;

    ProductSelectState productSelectState;


    public void loadSystem(){
        catalog.loadProducts(new ArrayList<>());
        catalog.addProduct(new Product(1,"Oats", "Quicker oats", 2.00, 6));
        catalog.addProduct(new Product(2,"Protein bar", "Super you protein bar", 4.00, 10));
        catalog.addProduct(new Product(3,"Milk", "Low fat milk", 5.00, 9));
        paymentTypes.add(PaymentType.UPI);
        paymentTypes.add(PaymentType.CARD);
        idleState = new IdleState();
        productSelectState = new ProductSelectState(new ProductService(), new PaymentService(paymentTypes));
    }

    public void request(State state){
       state.handleRequest();
    }

    public void start(){
        while(true){
            request(idleState);
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            request(productSelectState);
        }
    }

}
