package zad1;

import java.util.*;

public class ListOfProducts <E extends Product> {
    private ArrayList<E> products;

    public ListOfProducts() {
        products = new ArrayList<>();
    }

    public ArrayList<E> getProducts() {
        ArrayList<E> copy = new ArrayList<E>();
        copy = products;
        return copy;
    }

    public void setProducts(ArrayList<E> products) {
        if(products == null)
            this.products = new ArrayList<E>();
        else {
            this.products = products;
        }
    }

    public String[] toArray(){
        String[] res = new String[products.size()];
        for(int i = 0; i < products.size(); i++){
            res[i] = products.get(i).toString();
        }
        return res;
    }

    public void setup(){
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            Product p= new Product ();
            p.setPrice(rand.nextDouble()+ rand.nextInt(100));
            p.setInvDescription(UUID.randomUUID().toString().replace("-", ""));
            p.setCategory(randomValue(Category.values()));
            products.add((E) p);
        }

    }

    public void add(Product p){
        this.products.add((E) p);
    }

    private Category randomValue(Category[] values) {
        Random rand = new Random();
        return values[rand.nextInt(values.length)];
    }

    public double averagePrice(){
       OptionalDouble average =  products.stream().mapToDouble(p->p.getPrice()).average();
       return average.getAsDouble();
    }

    public String toString(){
        return Arrays.toString(toArray());
    }

}
