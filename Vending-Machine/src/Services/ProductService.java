package Services;

import Models.Catalog;
import Models.Product;

public class ProductService {

    private Catalog catalog = Catalog.getInstance();


    public void ListProduct(){

        System.out.println("******************** Please select the Product *****************************");

        for(int i=0; i<catalog.getProductList().size();i++){
            System.out.println((i+1) + " : "  + catalog.getProductList().get(i));
        }
    }

    public void selectedProduct(int productNo, int qty){

        Product product = catalog.getProductList().get(productNo);

        catalog.removeProduct(product.getProductId(), qty);

    }

    public Product getProduct(int productNo){
        return catalog.getProductList().get(productNo);
    }

}
