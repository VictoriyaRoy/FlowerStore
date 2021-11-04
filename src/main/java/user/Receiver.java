package user;

public class Receiver implements User{
    private int id;

    public Receiver() {
        this.id = hashCode();
    }

    @Override
    public void update(boolean status) {
        if(status){
            System.out.printf("User #%d: Your order was sent", id);
        } else{
            System.out.printf("User #%d: Your order wasn't sent", id);
        }
    }
}
