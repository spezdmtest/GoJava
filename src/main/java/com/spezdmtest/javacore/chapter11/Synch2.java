package com.spezdmtest.javacore.chapter11;

class Callme2 {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Caller2 implements Runnable {
    String msg;
    Callme2 target;
    Thread t;

    public Caller2(Callme2 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread((this));
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}

class SynchError2 {
    public static void main(String[] args) {
        Callme2 target = new Callme2();
        Caller2 ob1 = new Caller2(target, "Добро пожаловать");
        Caller2 ob2 = new Caller2(target,
                "в сихронизированный");
        Caller2 ob3 = new Caller2(target, "мир!");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}
