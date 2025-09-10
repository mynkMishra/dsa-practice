class FizzBuzz {
    private int n;
    private int i;
    private Semaphore semaphore;

    public FizzBuzz(int n) {
        this.n = n;
        i = 1;
        semaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n){
            semaphore.acquire();
            if((i%3 == 0 && i%5 != 0) && i <= n){
                printFizz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n){
            semaphore.acquire();
            if((i%3 != 0 && i%5 == 0) && i <= n){
                printBuzz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n){
            semaphore.acquire();
            if((i%3 == 0 && i%5 == 0) && i <= n){
                printFizzBuzz.run();
                i++;
            }
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        while(i <= n){
            semaphore.acquire();
            if((i%3 != 0 && i%5 != 0) && i <= n){
                printNumber.accept(i);
                i++;
            }
            semaphore.release();
        }
        
    }
}