class ZeroEvenOdd {
    private int n;
    Semaphore zeroSem;
    Semaphore evenSem;
    Semaphore oddSem;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSem = new Semaphore(1);
        this.evenSem = new Semaphore(0);
        this.oddSem = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= this.n; i++){
            zeroSem.acquire();
            printNumber.accept(0);

            if(i%2 == 0){
                evenSem.release();
            }else{
                oddSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= this.n; i+=2){
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= this.n; i+=2){
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
}