package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Receiver receiver;
    Sender sender;

    @BeforeEach
    void setUp(){
        receiver = new Receiver();
        sender = new Sender();
    }

    @Test
    void checkId(){
        assertNotEquals(receiver.getId(), sender.getId());
    }

    @Test
    void checkInstance(){
        assertInstanceOf(User.class, receiver);
        assertInstanceOf(User.class, sender);
        assertInstanceOf(Receiver.class, receiver);
        assertInstanceOf(Sender.class, sender);
    }

}