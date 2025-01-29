
import java.util.*;

class Product {
    int productId;
    String productName;
    int productPrice;
    int categoryId;

    Product(int productId, String productName, int productPrice, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;

    }

}

class Category {
    int categoryId;
    String categoryName;

    Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;

    }

}

public class ProductInventory {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        Map<Integer, String> catMap = new HashMap<>();
        List<Product> categoricalProducts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no of categories");
        int catsize = sc.nextInt();

        for (int i = 0; i < catsize; i++) {
            System.out.println("Enter the category Id");
            int catid = sc.nextInt();

            System.out.println("Enter the category Name");
            String categoryName = sc.next();

            catMap.put(catid, categoryName);
        }

        System.out.println("Enter the number of Products:");

        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the Product Id");
            int productId = sc.nextInt();

            System.out.println("Enter the Product Name");
            String productName = sc.next();

            System.out.println("Enter the Product Price");
            int Price = sc.nextInt();

            System.out.println("1- Groceries 2- Clothing 3- Eletronics 4- Utilities");
            System.out.println("Enter the Category Id");
            int categoryId = sc.nextInt();

            products.add(new Product(productId, productName, Price, categoryId));

        }

        for (Map.Entry<Integer, String> category : catMap.entrySet()) {
            System.out.println("Category ID : " + category.getKey() + "Category Name :" + category.getValue());

            for (Product product : products) {
                if (product.categoryId == category.getKey()) {

                    System.out.println("Category " + category.getKey() + " Product name: " + product.productName
                            + " Price :" + product.productPrice);

                    categoricalProducts.add(new Product(product.productId, product.productName, product.productPrice,
                            product.categoryId));
                }
            }
        }

        System.out.println("Descending order using Category id with lambda Sort method");

        categoricalProducts.sort((p1, p2) -> Integer.compare(p2.productPrice, p1.productPrice));

        for (Map.Entry<Integer, String> category : catMap.entrySet()) {
            System.out.println("Category ID : " + category.getKey() + "Category Name :" + category.getValue());

            for (Product product : categoricalProducts) {
                if (product.categoryId == category.getKey()) {

                    System.out.println("Category " + category.getKey() + " Product name: " + product.productName
                            + " Price :" + product.productPrice);

                }
            }
        }
        // int i = 0;
        // for (Product product : products) {

        // System.out.println("Product Id - " + product.productId + " Product Name - " +
        // product.productName
        // + " Product Price - " + product.productPrice);
        // i++;
        // }

        // products.sort((p1, p2) -> Integer.compare(p2.productPrice, p1.productPrice));

        // System.out.println("Prices in sorted order");
        // for (Product product : products) {

        // System.out.println("Product Id - " + product.productId + " Product Name - " +
        // product.productName
        // + " Product Price - " + product.productPrice);
        // i++;
        // }

    }
}
