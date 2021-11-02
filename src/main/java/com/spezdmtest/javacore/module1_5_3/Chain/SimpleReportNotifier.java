package com.spezdmtest.javacore.module1_5_3.Chain;

public class SimpleReportNotifier extends Notifier {

    public SimpleReportNotifier(int priority) {
        super(priority);
    }
    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report: " + message);
    }
}
