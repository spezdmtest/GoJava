package com.spezdmtest.javacore.chapter28.module1_4;
import java.util.concurrent.Semaphore;

public class FooDemo {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        new Thread(new Thread1(foo)).start();
        new Thread(new Thread2(foo)).start();
        new Thread(new Thread3(foo)).start();
    }
}
class Thread1 implements Runnable {
    private Foo foo;
    public Thread1(Foo foo) {
        this.foo = foo;
    }


    @Override
    public void run() {
        try {
            foo.first(this::run);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable {
    private Foo foo;
    public Thread2(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        try {
            foo.second(this::run);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3 implements Runnable {
    private Foo foo;
    public Thread3(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.third(this::run);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Foo {
    private Semaphore sem1;
    private Semaphore sem2;

    public Foo() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);

        try {
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void first(Runnable r) throws InterruptedException {
        print("first");
        r.run();
        sem1.release();
    }

    void second(Runnable r) throws InterruptedException {
        sem1.acquire();
        print("second");
        r.run();
        sem2.release();
    }

    void third(Runnable r) throws InterruptedException {
        sem2.acquire();
        print("third");
        r.run();
    }

    private void print(String str) {
        System.out.print(str);
    }
}

