//Class representing a single laptop product
public class Blouse extends Clothing {
    private String locktype;

    public Blouse(double initPrice, int initQuantity, String initMaterial, String initColor, boolean initBorder, int initSize, String initLockType) {
        super(initPrice, initQuantity, initMaterial, initColor, initBorder, initSize);
        locktype = initLockType;
    }

    public String toString() {
        String result = locktype + " lock " + getMaterial() + " Blouse, " + getColor() + ", " + getSize();
        if (getBorder()) {
            result += " , with border.";
        } else {
            result += " , plain.";
        }
        return result;
    }
}