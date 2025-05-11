//Base class for all products the store will sell
public abstract class Product implements Comparable<Product> {
    private double price;
    private int stockQuantity,CartQuantity,soldQuantity;


    public Product(double initPrice, int initQuantity) {
        price = initPrice;
        stockQuantity = initQuantity;
        soldQuantity=0;
        CartQuantity=0;
    }

    public boolean MovetoCart() {
        if (stockQuantity>0){
            stockQuantity --;
            CartQuantity ++;
            return true;
        }
        return false;
    }

    public boolean MovetoStock() {
        if (CartQuantity>0){
            stockQuantity ++;
            CartQuantity --;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Product p) {
        if(this.soldQuantity == p.soldQuantity){return -1;}
        return  p.soldQuantity - this.soldQuantity;
    }

    public void setstockquantity(){stockQuantity=1;}


    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setSoldQuantity(Product p) {
        soldQuantity += p.CartQuantity;
    }

    public double getPrice() {
        return price;
    }
}