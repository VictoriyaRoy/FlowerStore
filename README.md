# FlowerStore
_(Lab 5-7 for OOP course)_

## Description:
This program implements a simulation of a FlowerStore
#### Flower, FlowerPack, FlowerBucket
- **Flower** is the smallest unit in this program. Color and type of flower are chosen from appropriate enums
- **FlowerPack** is the set of identical flowers
- **FlowerBucket** is the set of different FLowerPacks
#### Store
- Contains all available buckets in store in this moment
- You can **add new buckets** and **search buckets** by needed parameters
#### Order
- Represent an order of flowers
- To process order, you need to specify **items, payment and delivery**. Items can be **flowers** and **buckets**
- Also you can **add users** to notify them, when order is processed
#### QuickOrder
- Enum for quick order
- You need to choose **type of order** from offered. Then call method **createOrder** with needed parameters
- Realised by **static factory** method
#### Decorators
- Any item (flower or bucket) can be decorated with **ribbon, paper or/and basket**. Changes price and description of item
- Realised as **Decorator** pattern
#### Payment/Delivery
- To specify the payment/delivery you need to pass instance of appropriate class as argument to **setPayment/setDelivery**
- Realised as **Strategy** pattern
#### Users
- Users can be associated with concrete orders, and **get notification** when order is processed
- Realised as **Observer** pattern
#### Connection
- Simulates **conection to database**
- Realised as **Singleton** pattern
#### Tests
- All packages are covered with tests

## Used design patterns:
* Strategy
* Decorator
* Observer
* Singleton
* Factory
