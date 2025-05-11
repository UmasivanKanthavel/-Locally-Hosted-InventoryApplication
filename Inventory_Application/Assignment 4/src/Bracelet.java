//Class representing a single toaster oven product
public class Bracelet extends Jewlery {
    private boolean packages;

    public Bracelet(double initPrice, int initQuantity, String initSize, String initColor, String initStyle, boolean initPackage) {
        super(initPrice, initQuantity, initSize, initColor, initStyle);
        packages = initPackage;
    }

    public String toString() {
        String result = getStyle() + " Bracelet ";
        if (packages) {
            result += "with free Ring ";
        }

        result += "(" + getColor() + ", " + getSize() + ")";

        return result;
    }
}