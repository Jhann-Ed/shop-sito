package order;

import interfaces.Observable;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Order implements Observable {
    protected Details details;
    private List<Observer> observers = new ArrayList<>();

    public Order(Details details) {
        this.details = details;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public abstract void processOrder();
    public abstract double calculateShippingCost();
}

