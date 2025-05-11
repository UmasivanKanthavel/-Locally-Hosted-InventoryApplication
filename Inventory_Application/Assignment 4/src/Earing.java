//Class representing a single type of Fridge
public class Earing extends Jewlery {
    private boolean hasStones;

    public Earing(double initPrice, int initQuantity, String initSize, String initColor, String initStyle, boolean initStones) {
        super(initPrice, initQuantity, initSize, initColor, initStyle);
        hasStones = initStones;
    }

    public String toString() {
        String result = getStyle() + " Earing ";
        if (hasStones) {
            result += "with Stones ";
        }

        result += "(" + getColor() + ", " + getSize() + ")";

        return result;
    }
}