package user;

public class Receiver implements User{
    @Override
    public void update(boolean status) {
        if(status){
            System.out.println("User #id: Your order was sent");
        } else{
            System.out.println("User #id: Your order wasn't sent");
        }
    }
}
