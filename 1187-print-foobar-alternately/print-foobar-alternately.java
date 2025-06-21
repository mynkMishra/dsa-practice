class FooBar {
    private int n;

    Semaphore fooSem;
    Semaphore barSem;
    public FooBar(int n) {
        this.n = n;
        fooSem = new Semaphore(1);
        barSem = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            fooSem.acquire();
        	printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            barSem.acquire();
        	printBar.run();
            fooSem.release();
        }
    }
}