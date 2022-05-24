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

public class Main2 {

    public static int simTime = 0;
    public static MyQueue customer2Queue = new MyQueue<Customer2>();
    public static Customer2[] cashiers = new Customer2[20];
    public static ArrayList<Customer2> customers = new ArrayList(1000);
    public static int servedCustomers = 0;
    public static int totalQueueWaitTime = 0;
    public static int totalTimeShopping = 0;
    public static int totalProcessTime = 0;

    public static void main(String[] args) throws InterruptedException {

        while(simTime < 100) {
            simTime++;
            int randNum = (int)(1 + Math.random() *100);
            if(randNum <= 50) {
                customers.add(new Customer2(simTime));
            }
            while(customer2Queue.peek() != null && spotOpen()) {
                removeCustomerFromCashier();
                addCustomerToCashier((Customer2) customer2Queue.dequeue()); //Why do you have to cast??
            }
            removeCustomerFromCashier();
            Thread.sleep(50);
        }
        System.out.println("DONE");
        while(!isEmpty()) {
            simTime++;
            if(customer2Queue.peek() != null && spotOpen()) {
                addCustomerToCashier((Customer2) customer2Queue.dequeue()); //Why do you have to cast??
            }
            removeCustomerFromCashier();
            Thread.sleep(10);
        }
        System.out.println("Processing Data...");
        Thread.sleep(2000);
        printCashiers();
        printData();
    }

    public static void printCashiers() {
        for(int i = 0; i < cashiers.length; i++) {
            System.out.println("Cashier " + i + ": " + cashiers[i]);
        }
    }

    public static void printData() {
        System.out.println("Total customers served: " + servedCustomers);
        System.out.println("Total cashiers used: " + cashiers.length);
        System.out.println("Total time spent in line: " + totalQueueWaitTime);
        System.out.println("Average customer wait time in line: " + totalQueueWaitTime/(double)customers.size());
        int max = customers.get(1).getQueueWaitTime();
        for(Customer2 c: customers) {
            if(c.getQueueWaitTime() > max)
                max = c.getQueueWaitTime();
        }
        System.out.println("Longest wait time in line: " + max);
        System.out.println("Average time shopping: " + totalTimeShopping/(double)customers.size());
        System.out.println("Average time in checkout: " + totalProcessTime/(double)customers.size());
    }

    public static boolean isEmpty() {
        for(Customer2 c: cashiers) {
            if(c != null)
                return false;
        }
        return true;
    }

    public static void addCustomerToCashier(Customer2 c) {
            for (int i = 0; i < cashiers.length; i++) {
                if (cashiers[i] == null) {
                    cashiers[i] = c;
                    cashiers[i].setBeginProcessTime(simTime);
                    servedCustomers++;
                    cashiers[i].setQueueWaitTime(cashiers[i].getBeginProcessTime() - cashiers[i].getEnterQTime());
                    //System.out.println(cashiers[i] + " wait time: " + cashiers[i].getQueueWaitTime());
                    totalQueueWaitTime += cashiers[i].getQueueWaitTime();
                    break;
                }
        }
    }

    public static void removeCustomerFromCashier() {
        for(int i = 0; i < cashiers.length; i++) {
            if(cashiers[i] == null)
                continue;
            else if(simTime - cashiers[i].getBeginProcessTime() > cashiers[i].getProcessTime()) {
                System.out.println(cashiers[i] + " leaving at " + simTime);
                cashiers[i] = null;
            }
        }
    }

    public static boolean spotOpen() {
        for(int i = 0; i < cashiers.length; i++) {
            if(cashiers[i] == null)
                return true;
        }
        return false;
    }

}
