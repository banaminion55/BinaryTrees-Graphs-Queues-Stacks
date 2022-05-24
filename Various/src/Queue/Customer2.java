package Queue;

public class Customer2 implements Runnable{

    private int enterTime; //time stamp of Customer entry into store
    private int shopTime; //randomly generated (time spent shopping)
    private int leaveTime; //time stamp of the Customer exit
    private int enterQTime; //time stamp the Customer enters the Queue
    private int beginProcessTime; //time stamp they begin checking out (no longer in line)
    private int processTime; //randomly generated: time spent in processing
    private int cashierIndex;
    private boolean inQueue;
    private int queueWaitTime;

    public boolean isInQueue() {
        return inQueue;
    }

    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

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

    public Customer2 (int enterTime) {
        this.enterTime = enterTime;
        shopTime = (int)(1 + Math.random()*15);
        Main2.totalTimeShopping += shopTime;
        processTime = (int)(1 + Math.random()*15);
        Main2.totalProcessTime += processTime;
        leaveTime = enterTime + shopTime;
        customerID = rollingID;
        rollingID++;

        t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        System.out.println(toString() + " entering at " + Main2.simTime);
        while(leaveTime >= Main2.simTime) {
            System.out.print("");
        }
        System.out.println(toString() + " done shopping at " + Main2.simTime);
        Main2.customer2Queue.enqueue(this);
        enterQTime = Main2.simTime;
        while(Main2.simTime-beginProcessTime < processTime) {
            System.out.print("");
        }
        //addToNextCashier();
        //removeFromCashier();
    }

    public void addToNextCashier() {
        while (inQueue) {
            for (int i = 0; i < Main2.cashiers.length; i++) {
                if (Main2.cashiers[i] == null) {
                    Main2.cashiers[i] = this;
                    cashierIndex = i;
                    inQueue = false;
                    Main2.customer2Queue.dequeue();
                    beginProcessTime = Main2.simTime;
                    queueWaitTime = beginProcessTime - enterQTime;
                    Main2.totalQueueWaitTime += queueWaitTime;
                    break;
                }
            }
        }
    }

    public String toString() {
        return "Customer " + customerID + " (" + shopTime + ")";
    }

    public void removeFromCashier() {
        while(Main2.simTime-beginProcessTime < processTime) {
            System.out.print("");
        }
        Main2.cashiers[cashierIndex] = null;
        Main2.servedCustomers += 1;
    }
}
