import delivery.Delivery;
import flower.*;
import payment.Payment;

public enum QuickOrder {
    ROSE_BUCKET(new Flower(5, FlowerColor.RED, 15, FlowerType.ROSE)),
    TULIP_BUCKET(new Flower(9, FlowerColor.PINK, 10, FlowerType.TULIP)),
    CHAMOMILE_BUCKET(new Flower(3, FlowerColor.WHITE, 5, FlowerType.CHAMOMILE));

    private Flower flower;
    QuickOrder(Flower flower){
        this.flower = flower;
    }

    public Order createOrder(int amount, Payment payment, Delivery delivery){
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowerPack(new FlowerPack(flower, amount));

        Order order = new Order();
        order.addItem(bucket);
        order.setPayment(payment);
        order.setDelivery(delivery);
        return order;
    }
}
