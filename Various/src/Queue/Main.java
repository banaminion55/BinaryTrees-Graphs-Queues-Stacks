package Queue;

/*
- In main
* a queue customers join after done shopping (synchronized)
- # of cashiers, something we can change and analyze efficiency
- Customer[] cashiers = new Customer[3]
- When done, output total customers served, total cashiers used, total queue wait time, average queue wait time, longest queue wait time, average time shopping, average time in checkout line
- Validate sim (enter in the data that they already know)
 */

import java.util.ArrayList;

public class Main {

    public static int simTime = 0;
    public static MyQueue customerQueue = new MyQueue<Customer>();
    public static Customer[] cashiers = new Customer[3];
    public static ArrayList<Customer> customers = new ArrayList(1000);
    public static int servedCustomers = 0;
    public static int totalQueueWaitTime = 0;
    public static int totalTimeShopping = 0;
    public static int totalProcessTime = 0;

    public static void main(String[] args) throws InterruptedException {

        while(simTime < 100) {
            simTime++;
            int randNum = (int)(1 + Math.random() *100);
            if(randNum <= 50) {
                customers.add(new Customer(simTime));
            }
            Thread.sleep(100);
        }
        while(!isEmpty()) {
            simTime++;
            System.out.print("");
            Thread.sleep(100);
        }
        System.out.println("DONE");
        System.out.println("Processing Data...");
        Thread.sleep(2000);
        printCashiers();
        printData();
    }

    public static String printCustomerQueue() {
        /*System.out.println("Customer Queue:");
        for(int i = 0; i < customerQueue.size(); i++) {
            Customer currentCustomer = (Customer) customerQueue.peek();
            System.out.println(currentCustomer);
        } */
        return "";
    }

    public static void printCashiers() {
        for(int i = 0; i < cashiers.length; i++) {
            System.out.println("Cashier " + i + ": " + cashiers[i]);
        }
    }

    /*public static void getData() {
        for(int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            if(currentCustomer.getServed())
                servedCustomers += 1;
            totalQueueWaitTime += currentCustomer.getBeginProcessTime() - currentCustomer.getLeaveTime();
        }
    }*/

    public static void printData() {
        System.out.println("Total customers served: " + servedCustomers);
        System.out.println("Total cashiers used: " + cashiers.length);
        System.out.println("Total time spent in line: " + totalQueueWaitTime);
        System.out.println("Average customer wait time in line: " + totalQueueWaitTime/(double)customers.size());
        int max = customers.get(1).getQueueWaitTime();
        for(Customer c: customers) {
            if(c.getQueueWaitTime() > max)
                max = c.getQueueWaitTime();
        }
        System.out.println("Longest wait time in line: " + max);
        System.out.println("Average time shopping: " + totalTimeShopping/(double)customers.size());
        System.out.println("Average time in checkout: " + totalProcessTime/(double)customers.size());
    }

    public static boolean isEmpty() {
        for(Customer c: cashiers) {
            if(c != null)
                return false;
        }
        return true;
    }

}
