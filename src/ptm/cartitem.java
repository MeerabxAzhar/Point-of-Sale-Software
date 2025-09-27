
package ptm;
import java.util.ArrayList;
import java.util.List;
public class cartitem {
     String itemName;
    double price;
    cartitem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
    cartitem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private List<cartitem> items = new ArrayList<>();

    public void addItemToCart(cartitem item) {
        items.add(item);
    }

    public void removeItemFromCart(cartitem item) {
        items.remove(item);
    }

    public double getTotal() {
        double total = 0;
        for (cartitem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<cartitem> getItems() {
        return items;
    
}
}
