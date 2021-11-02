package com.spezdmtest.javacore.module1_5_3.Chain;

public class SMSNotifier extends Notifier {

    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending SMS to manager:" + message);
    }
}
