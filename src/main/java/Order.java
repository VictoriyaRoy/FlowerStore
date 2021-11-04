import delivery.Delivery;
import flower.Item;
import lombok.Getter;
import lombok.Setter;
import payment.Payment;
import user.User;

import java.util.LinkedList;

@Getter @Setter
public class Order {
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;
    private LinkedList<User> users;

    public Order() {
        this.items = new LinkedList<>();
        this.users = new LinkedList<>();
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
            notifyUsers(false);
            return false;
        }
        if(items.isEmpty()){
            System.out.println("Error. Items list is empty");
            notifyUsers(false);
            return false;
        }
        payment.pay(calculateTotalPrice());
        delivery.deliver(items);
        notifyUsers(true);
        return true;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    private void notifyUsers(boolean status){
        for (User user : users) {
            user.update(status);
        }
    }

}
