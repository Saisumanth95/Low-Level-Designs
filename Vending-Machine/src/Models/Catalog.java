package Models;

import java.util.List;

public class Catalog {

    private static Catalog catalog = null;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    private Catalog(){
    }

    public static Catalog getInstance(){
        if(catalog == null){
            synchronized (Catalog.class){
                if(catalog == null){
                    catalog = new Catalog();
                }
            }
        }
        return catalog;
    }

    public void loadProducts(List<Product> productList){
        this.productList = productList;
    }

    public void removeProduct(int productId, int qty){
        for(int i=0;i<productList.size();i++){
            if(productId == productList.get(i).getProductId()){
                Product product = productList.get(i);
                if(product.getQuantity() >= qty){
                    product.setQuantity(product.getQuantity()-qty);
                }
                if(product.getQuantity() == 0){
                    productList.remove(i);
                }
                break;
            }
        }
    }


    public void addProduct(Product product){
        productList.add(product);
    }

}
