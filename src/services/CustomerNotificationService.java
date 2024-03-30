package services;

import interfaces.Observer;

public class CustomerNotificationService implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notificación al cliente: " + message);
    }
}
