package user;

public class Sender implements User{
    private int id;

    public Sender() {
        this.id = hashCode();
    }

    @Override
    public void update(boolean status) {
        if(status){
            System.out.printf("User #%d: Send order\n", id);
        } else{
            System.out.printf("User #%d: Can't send order\n", id);
        }
    }
}
