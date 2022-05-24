package Queue;

public class Customer implements Runnable{

    private int enterTime; //time stamp of Customer entry into store
    private int shopTime; //randomly generated (time spent shopping)
    private int leaveTime; //time stamp of the Customer exit
    private int enterQTime; //time stamp the Customer enters the Queue
    private int beginProcessTime; //time stamp they begin checking out (no longer in line)
    private int processTime; //randomly generated: time spent in processing
    private int cashierIndex;
    private boolean inQueue;
    private int queueWaitTime;

    public int getQueueWaitTime() {
        return queueWaitTime;
    }

    public void setQueueWaitTime(int queueWaitTime) {
        this.queueWaitTime = queueWaitTime;
    }

    public int getShopTime() {
        return shopTime;
    }

    public void setShopTime(int shopTime) {
        this.shopTime = shopTime;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getEnterQTime() {
        return enterQTime;
    }

    public void setEnterQTime(int enterQTime) {
        this.enterQTime = enterQTime;
    }

    public int getBeginProcessTime() {
        return beginProcessTime;
    }

    public void setBeginProcessTime(int beginProcessTime) {
        this.beginProcessTime = beginProcessTime;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    //So when they begin process time, they leave the queue????

    Thread t;
    private static int rollingID = 1;
    private int customerID;

    public Customer (int enterTime) {
        this.enterTime = enterTime;
        shopTime = (int)(1 + Math.random()*15);
        Main.totalTimeShopping += shopTime;
        processTime = (int)(1 + Math.random()*15);
        Main.totalProcessTime += processTime;
        leaveTime = enterTime + shopTime;
        customerID = rollingID;
        rollingID++;

        t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        System.out.println(toString() + " entering at " + Main.simTime);
        while(leaveTime >= Main.simTime) {
            System.out.print("");
        }
        System.out.println(toString() + " done shopping at " + Main.simTime);
        Main.customerQueue.enqueue(this);
        enterQTime = Main.simTime;
        inQueue = true;
        addToNextCashier();
        removeFromCashier();
    }

    public void addToNextCashier() {
        while (inQueue) {
            for (int i = 0; i < Main.cashiers.length; i++) {
                if (Main.cashiers[i] == null) {
                    Main.cashiers[i] = this;
                    cashierIndex = i;
                    inQueue = false;
                    Main.customerQueue.dequeue();
                    beginProcessTime = Main.simTime;
                    queueWaitTime = beginProcessTime - enterQTime;
                    Main.totalQueueWaitTime += queueWaitTime;
                    break;
                }
            }
        }
    }

    public String toString() {
        return "Customer " + customerID + " (" + shopTime + ")";
    }

    public void removeFromCashier() {
        while(Main.simTime-beginProcessTime < processTime) {
            System.out.print("");
        }
        Main.cashiers[cashierIndex] = null;
        Main.servedCustomers += 1;
    }
}
