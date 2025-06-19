class Foo {

    Semaphore firstSemaphore;
    Semaphore secondSemaphore;
    Semaphore thirdSemaphore;
    public Foo() {
        firstSemaphore = new Semaphore(1);
        secondSemaphore = new Semaphore(0);
        thirdSemaphore = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        firstSemaphore.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        secondSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        thirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        thirdSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

        
    }
}