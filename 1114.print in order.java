import java.util.concurrent.CountDownLatch;

class Foo {
    private final CountDownLatch firstDone;
    private final CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // Signal that first() has completed
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() finishes
        firstDone.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // Signal that second() has completed
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() finishes
        secondDone.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
