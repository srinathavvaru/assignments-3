import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

public class productserialization {
    public static void main(String[] args) {
        // Asking for input from the user
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter product ID:");
            int id = Integer.parseInt(reader.readLine());

            System.out.println("Enter product name:");
            String name = reader.readLine();

            System.out.println("Enter product category:");
            String category = reader.readLine();

            System.out.println("Enter product price:");
            double price = Double.parseDouble(reader.readLine());

            // Creating the Product object
            Product product = new Product(id, name, category, price);

            // Serializing the Product object
            try (FileOutputStream fileOut = new FileOutputStream("product.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(product);
                System.out.println("Serialized data is saved in product.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }

            // Deserializing the Product object
            Product deserializedProduct = null;
            try (FileInputStream fileIn = new FileInputStream("product.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                deserializedProduct = (Product) in.readObject();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
                return;
            }

            // Printing the deserialized Product object
            System.out.println("Deserialized Product:");
            System.out.println(deserializedProduct);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
