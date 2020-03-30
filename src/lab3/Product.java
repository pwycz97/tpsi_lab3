package lab3;

public class Product {

	int id;
	String name, category;
	Double price;
	
    public Product(int id, String name, String category, Double price) {
	        this.id = id;
	        this.name = name;
	        this.category = category;
	        this.price = price;
	    }
	
    public String get() {
		return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
