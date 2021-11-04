package user;

public class Sender implements User{
    @Override
    public void update(boolean status) {
        if(status){
            System.out.println("User #id: Send order");
        } else{
            System.out.println("User #id: Can't send order");
        }
    }
}
