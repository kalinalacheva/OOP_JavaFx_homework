package zad1;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

enum Category{
    A,
    B,
    C,
    D
}

class Sequence {

    private static final AtomicInteger counter = new AtomicInteger();

    public static int nextValue() {
        return counter.getAndIncrement();
    }
}

public class Product extends ArrayList<Product> {
    int INV_NUMBER ;
    String invDescription;
    Category category;
    double price;

    public Product() {
        INV_NUMBER = Sequence.nextValue();
    }

    public Product(String invDescription, Category category, double price) {
        this.INV_NUMBER = Sequence.nextValue();
        this.invDescription = invDescription;
        this.category = category;
        this.price = price;
    }

    public Product(Product p){
        this.INV_NUMBER = p.getINV_NUMBER();
        this.invDescription = p.getInvDescription();
        this.category = Category.valueOf(p.getCategory());
        this.price = p.getPrice();
    }

    public int getINV_NUMBER() {
        return INV_NUMBER;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = invDescription;
    }

    public String getCategory() {
        return String.valueOf(category);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCategory(String category) {this.category = Category.valueOf(category);}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Inv number: %d, Inv Description: %s, Price: %.2f\n",
                INV_NUMBER, invDescription, price);
    }
}
