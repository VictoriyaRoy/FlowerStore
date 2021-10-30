import delivery.Delivery;
import flower.Item;
import lombok.Getter;
import lombok.Setter;
import payment.Payment;

import java.util.LinkedList;

@Getter @Setter
public class Order {
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public Order() {
        this.items = new LinkedList<>();
    }

    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (Item orderItem : items) {
            totalPrice += orderItem.price();
        }
        return totalPrice;
    }

    public boolean processOrder(){
        if(payment == null || delivery == null){
            System.out.println("Error. Set payment and delivery to process order");
            return false;
        }
        payment.pay(calculateTotalPrice());
        delivery.deliver(items);
        return true;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }
}
