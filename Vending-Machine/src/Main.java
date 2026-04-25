import Models.Catalog;
import Models.Product;
import Services.PaymentService;
import Services.ProductService;
import Services.payments.PaymentType;
import Services.payments.UPI;
import States.IdleState;
import States.ProductSelectState;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    VendingMachine vendingMachine = new VendingMachine();

    vendingMachine.loadSystem();

    vendingMachine.start();


}
