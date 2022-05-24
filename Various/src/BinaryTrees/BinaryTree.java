package BinaryTrees;

/*
*Insert (DONE)
* Delete (IN PROGRESS)
* printInOrder (DONE)
* getMin (DONE)
* getMax (DONE)
* search (DONE)
* size (DONE)
 */

public class BinaryTree<T extends Comparable<T>> {

    TreeNode<T> root = null;
    private int size = 0;
    final int RIGHT = 2, LEFT = 1, NONE = 0;


    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<T>(data, null, null);
        if(root == null) {
            root = newNode;
            size++;
        }
        else {
            rootLeafRecur(newNode, root);
        }
    }

    public void remove(T data) {
        find(root,null, data, RIGHT);
    }

    public int size() {
        return size;
    }

    public boolean contains(T data) {
        return containsRecur(root, data);
    }

    public void printInOrder() {
       printRecur(root);
    }

    public T getMin() {
        return getMinRecur(root);
    }

    public T getMax() {
        return getMaxRecur(root);
    }


    public T getMaxRecur(TreeNode<T> branch) {
        if(branch.getRight() == null) {
            return branch.getData();
        }
        return getMaxRecur(branch.getRight());
    }

    public T getMinRecur(TreeNode<T> branch) {
        if(branch.getLeft() == null) {
            return branch.getData();
        }
        return getMinRecur(branch.getLeft());
    }

    public TreeNode<T> getOneBeforeMin(TreeNode<T> branch) {
        if(branch.getLeft() != null) {
            if (branch.getLeft().getLeft() == null) {
                return branch;
            }
            else {
                return getOneBeforeMin(branch.getLeft());
            }
        }
        else {
            return branch;
        }
    }

    public void printRecur(TreeNode<T> branch) {
        if(branch.getLeft() != null) {
            printRecur(branch.getLeft());
        }
        System.out.println(branch.getData());
        if(branch.getRight() != null) {
            printRecur(branch.getRight());
        }
    }


    public void rootLeafRecur(TreeNode<T> leaf, TreeNode<T> branch) {
        if(leaf.getData().compareTo(branch.getData()) > 0 && branch.getRight() == null) {
            branch.setRight(leaf);
            size++;
        }
        else if(leaf.getData().compareTo(branch.getData()) <= 0 && branch.getLeft() == null) {
            branch.setLeft(leaf);
            size++;
        }
        else {
            if(leaf.getData().compareTo(branch.getData()) > 0) {
                rootLeafRecur(leaf,branch.getRight());
            }
            else if(leaf.getData().compareTo(branch.getData()) <= 0) {
                rootLeafRecur(leaf,branch.getLeft());
            }
        }
    }

    public boolean find(TreeNode<T> leaf, TreeNode<T> prev, T data, int direction) {
        if(leaf.getData().compareTo(data) == 0) {
            removeRecur2(leaf,prev, direction);
            return true;
        }
        else if(leaf.getData().compareTo(data) < 0 && leaf.getRight() != null) {
            prev = leaf;
            return find(leaf.getRight(), prev, data, RIGHT);
        }
        else if(leaf.getData().compareTo(data) > 0 && leaf.getLeft() != null) {
            prev = leaf;
            return find(leaf.getLeft(), prev, data, LEFT);
        }
        else {
            return false;
        }
    }

    private void removeRecur2(TreeNode<T> leaf, TreeNode<T> prev, int direction) {
        System.out.println("Direction: " + direction);
        System.out.println("Leaf:" + leaf.getData());
        System.out.println("Prev: " + prev.getData());
        TreeNode<T> newBranchRoot = null;
        TreeNode<T> newBranch;
        if(leaf.getRight() != null) {
            newBranchRoot = getOneBeforeMin(leaf.getRight());
            if(newBranchRoot.getLeft() == null)
                newBranch = newBranchRoot;
            else {
                newBranch = newBranchRoot.getLeft();
            }
        }
        else {
            newBranch = leaf.getLeft();
        }
        //System.out.println("New Branch Root: " + newBranchRoot.getData());
        //System.out.println("New Branch:" + newBranch.getData());
        if(newBranch != null) {
            if(prev == null) {
                root = newBranch;
            }
            else if(direction == RIGHT) {
                prev.setRight(newBranch);
            }
            else if(direction == LEFT) {
                prev.setLeft(newBranch);
            }
            if(leaf.getRight() != null && leaf.getRight().getLeft() != null) {
                newBranch.setRight(leaf.getRight());
                if(newBranchRoot != null) {
                    newBranchRoot.setLeft(null);
                }
            }
            if(leaf.getLeft() != null) {
                newBranch.setLeft(leaf.getLeft());
            }
        }
        leaf = null;
    }

    private void removeRecur(TreeNode<T> root, TreeNode<T> branch, int direction) {
        System.out.println(branch.getData());
        System.out.println(direction);
        if(branch.getLeft() == null && branch.getRight() == null) {
            if(direction == RIGHT) {
                root.setRight(null);
            }
            else if(direction == LEFT) {
                root.setLeft(null);
            }
        }
        else {
            if (branch.getRight() != null) {
                if (direction == LEFT) {
                    root.setLeft(branch.getRight());
                } else if (direction == RIGHT) {
                    root.setRight(branch.getRight());
                }
                if (branch.getLeft() != null) {
                    branch.getRight().setLeft(branch.getLeft());
                }
            }
            else if (branch.getLeft() != null) {
                if (direction == LEFT)
                    root.setLeft(branch.getLeft());
                else if (direction == RIGHT)
                    root.setRight(branch.getLeft());
            }
        }
        branch = null;
    }


    public boolean containsRecur(TreeNode<T> leaf, T data) {
        if(leaf.getData().compareTo(data) == 0) {
            return true;
        }
        else if(leaf.getData().compareTo(data) < 0 && leaf.getRight() != null) {
            return containsRecur(leaf.getRight(), data);
        }
        else if(leaf.getData().compareTo(data) > 0 && leaf.getLeft() != null) {
            return containsRecur(leaf.getLeft(), data);
        }
        else {
            return false;
        }
    }







}
