//Abstract class capturing shared state between Desktop and Laptop
public abstract class Clothing extends Product {
    private String material;
    private String color;
    private boolean border;
    private int size;

    public Clothing(double initPrice, int initQuantity, String initMaterial, String initColor, boolean initBorder, int initSize) {
        super(initPrice, initQuantity);
        material = initMaterial;
        color = initColor;
        border = initBorder;
        size = initSize;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public boolean getBorder() {
        return border;
    }

    public int getSize() {
        return size;
    }
}