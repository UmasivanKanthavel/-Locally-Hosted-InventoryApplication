//Class representing an electronic store
//Has an array of products that represent the items the store can sell

import java.util.*;

public class Store {
    private String name;
    private boolean StoreHasBeenInitialized;
    private ArrayList<Product> Top3Items,stock;
    ArrayList<String> CurrentCartList;
    HashMap<Product,Integer> CartHashMap;
    HashSet<Product> ProductVariety;
    TreeSet<Product> MostPopularItems;
    private double revenue,cartvalue;
    private int sales;


    public Store(String initName) {
        StoreHasBeenInitialized=false;
        revenue = 0.0;
        sales=0;
        cartvalue=0;
        name = initName;

        // An array to hold all stock
        stock = new ArrayList<Product>();

        // To list everything in the cart as strings
        CurrentCartList = new ArrayList<String>();

        // to keep track of everything in the cart list
        CartHashMap = new HashMap<Product,Integer>();

        // to keep track of different product varieties ( only because my code removes stock products when it runs out and so i can't use stock to track items)
        ProductVariety = new HashSet<Product>();

        // This is used to sort the items by popularity
        MostPopularItems = new TreeSet<Product>();

        // This is to display the top 3 items
        Top3Items = new ArrayList<>();

    }


    public void addProduct(Product newProduct) {
        ProductVariety.add(newProduct);
        stock.add(newProduct);
    }

    public boolean addToCart(Product p){

        if (CartHashMap.containsKey(p)){
            CartHashMap.replace(p,CartHashMap.get(p)+1);
        }
        else{
            CartHashMap.put(p,1);
        }

        if(p.MovetoCart() && p.getStockQuantity()==0){
            stock.remove(p);
            return false;
        }
        return true;


    }

    public boolean addToStock(String ToString){
        Product p=null;
        for (Product product : ProductVariety){
            if(ToString.contains(product.toString())){
                p = product;
            }
        }

        if(stock.contains(p)){
            p.MovetoStock();
        }else{p.setstockquantity();stock.add(p);}

        if (CartHashMap.containsKey(p) && CartHashMap.get(p)>1){
            CartHashMap.replace(p,CartHashMap.get(p)-1);
        }else{CartHashMap.remove(p); return false;}

        return true;

    }

    public ArrayList<String> getCurrentCartList(){
        CurrentCartList.clear();
        cartvalue=0;
        for (Product product : CartHashMap.keySet()){
            cartvalue+=product.getPrice()*CartHashMap.get(product);
            String temporary_item_toString = CartHashMap.get(product) + " x " + product.toString();
            CurrentCartList.add(temporary_item_toString);
        }
        return CurrentCartList;
    }

    public void CompleteSale(){
        for (Product product : CartHashMap.keySet()){
            revenue+=product.getPrice()*CartHashMap.get(product);
            product.setSoldQuantity(product);
        }
        sales+=1;
       CartHashMap.clear();
    }

    public ArrayList<Product> getMostpopularitems(){
        Top3Items.clear();
        MostPopularItems.clear();
        MostPopularItems.addAll(ProductVariety);

        while(Top3Items.size() < 3){
            Top3Items.add(MostPopularItems.first());
            MostPopularItems.removeFirst();
        }
        return Top3Items;
    }

    public static Store createStore() {
        Store store1 = new Store("Sakthi Silk");
        Saree d1 = new Saree(100, 10, "Silk", "Pink", false, 36, true);
        Saree d2 = new Saree(150, 10, "Cotton", "Green", true, 40, false);
        Blouse l1 = new Blouse(60, 10, "Cotton", "Dark Purple", true, 38, "Hook");
        Blouse l2 = new Blouse(90, 10, "Cotton", "Red", true, 34, "String");
        Earing f1 = new Earing(15, 10, "Small", "White", "Indian", false);
        Earing f2 = new Earing(50, 10, "Large", "Black", "Sri Lankan", true);
        Bracelet t1 = new Bracelet(15, 10, "Medium", "Gold", "Indian", false);
        Bracelet t2 = new Bracelet(25, 10, "Large", "Silver", "Indian", true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

    public double getRevenue(){return revenue;}
    public int getSales(){return sales;}
    public double getPersale(){if (sales==0){return 0;}return revenue/sales;}
    public double getCartvalue(){return cartvalue;}
    public boolean getStoreHasBeenInitialized(){return StoreHasBeenInitialized;}

    public void SetStoreHasBeenInitialized(){StoreHasBeenInitialized=true;}

    public String getName() {return name;}
    public ArrayList<Product> getStock(){return stock;}
} 