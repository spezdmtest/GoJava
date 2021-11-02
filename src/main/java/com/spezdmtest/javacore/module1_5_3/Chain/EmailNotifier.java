package com.spezdmtest.javacore.module1_5_3.Chain;

public class EmailNotifier extends Notifier{

    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
