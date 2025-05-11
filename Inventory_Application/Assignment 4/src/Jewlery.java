//Abstract class capturing shared state between Fridge and ToasterOven
public abstract class Jewlery extends Product {
    private String size;
    private String color;
    private String style;

    public Jewlery(double initPrice, int initQuantity, String initSize, String initColor, String initStyle) {
        super(initPrice, initQuantity);
        size = initSize;
        color = initColor;
        style = initStyle;
    }

    public String getColor() {
        return color;
    }

    public String getStyle() {
        return style;
    }

    public String getSize() {
        return size;
    }
}