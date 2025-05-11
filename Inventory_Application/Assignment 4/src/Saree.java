//Class representing a single desktop computer
public class Saree extends Clothing {
    private boolean type;

    public Saree(double initPrice, int initQuantity, String initMaterial, String initColor, boolean initBorder, int initSize, boolean initType) {
        super(initPrice, initQuantity, initMaterial, initColor, initBorder, initSize);
        type = initType;
    }

    public String toString() {
        String Type;

        if(type){
            Type="Half-Saree, ";
        } else {
            Type="Saree, ";
        }

        String result = Type + getMaterial() + ", " + getColor() + ", " + getSize() + ", ";

        if (getBorder()) {
            result += "with border.";
        } else {
            result += "plain.";
        }

        return result;
    }
}