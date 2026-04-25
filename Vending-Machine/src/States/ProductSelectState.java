package States;

import Models.Product;
import Services.PaymentService;
import Services.ProductService;

import java.util.Scanner;

public class ProductSelectState implements State{

    private ProductService productService;
    private PaymentService paymentService;

    public ProductSelectState(ProductService productService, PaymentService paymentService) {
        this.productService = productService;
        this.paymentService = paymentService;
    }

    @Override
    public void handleRequest() {

        productService.ListProduct();

        Scanner scanner = new Scanner(System.in);
        int productNo = scanner.nextInt()-1;

        Product product = productService.getProduct(productNo);

        System.out.println("************** Select quantity *************");
        System.out.println("MAX quantity : " + product.getQuantity());
        int qty = scanner.nextInt();

        double amount = qty * product.getPrice();

        paymentService.processPayment(amount);

        productService.selectedProduct(productNo, qty);

    }
}
