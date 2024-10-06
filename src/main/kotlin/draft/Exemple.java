package draft;

public class Exemple implements IExemple {
    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void augmenter(int i) {
        Price += i;
    }
}
