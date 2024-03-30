package customer;

import interfaces.Observer;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Customer " + name + " received update: " + message);
    }
}