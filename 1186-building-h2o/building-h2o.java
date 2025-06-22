class H2O {

    int count = 0;
    Semaphore hSem;
    Semaphore oSem;

    public H2O() {
        hSem = new Semaphore(2);
        oSem = new Semaphore(0);    
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hSem.acquire();
        releaseHydrogen.run();
        count++;
        if(count == 2){
            oSem.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oSem.acquire();
		releaseOxygen.run();
        count = 0;
        hSem.release();
        hSem.release();
    }
}