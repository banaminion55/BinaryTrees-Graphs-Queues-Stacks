package BinaryTrees;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        int[] test = {49, 50, 79, 34, 8, 90, 63, 81, 100, 20, 50, 45, 1, 2, 96, 7, 17, 24, 97, 69, 42, 12, 58, 3, 5, 37, 82, 73, 88, 10, 14, 40, 47};
        /*bt.add(10);
        bt.add(4);
        bt.add(2);
        bt.add(13);
        bt.add(11);
        bt.add(6);
        bt.add(8);
        bt.add(15);
        bt.add(14);
        System.out.println(bt.contains(11));
        System.out.println(bt.contains(1));
        bt.printInOrder();
        System.out.println(bt.getMax());
        System.out.println(bt.getMin());
        System.out.println(bt.size());
        System.out.println();
        bt.remove(10);*/
        for(int i: test) {
            bt.add(i);
        }
        bt.printInOrder();
        bt.remove(101);
        System.out.println("--DONE--");
        bt.printInOrder();
        bt.remove(1);
        System.out.println("--DONE--");
        bt.printInOrder();
        System.out.println("Hello");
    }
}
