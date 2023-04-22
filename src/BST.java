import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val)
    {
        // TODO: Complete the search function
        return hasVal(val, this.root);
    }

    public boolean hasVal(int val, BSTNode node)
    {
        //if the value of the node is greater than the target value run has val again on the subtree to the left of the node
        if (val < node.getVal())
        {
            if (node.getLeft() == null)
            {
                return false;
            }
            return hasVal(val, node.getLeft());
        }
        //if the value of the node is less than the target value run has val again on the subtree to the right of the node
        else if(val > node.getVal())
        {
            if (node.getRight() == null)
            {
                return false;
            }
            return hasVal(val, node.getRight());
        }
        //if the value of the node is not greater than or less than the node then it must be equal so we should return that node
        return true;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder()
    {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        inOrder(this.root, arr);
        return arr;
    }

    public void inOrder(BSTNode node, ArrayList<BSTNode> arr)
    {
        //if there are more nodes down the tree to the left then rerun the method on the subtree to the left
        if(node.getLeft() != null)
        {
            inOrder(node.getLeft(), arr);
        }
        //add this node to the arraylist
        arr.add(node);
        //if there are more nodes down the tree to the right then rerun the method on the subtree to the right
        if (node.getRight() != null)
        {
            inOrder(node.getRight(), arr);
        }
        return;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        preOrder(this.root, arr);
        return arr;
    }

    public void preOrder(BSTNode node, ArrayList<BSTNode> arr)
    {
        //add this node to the arraylist
        arr.add(node);
        //if there are more nodes down the tree to the left then rerun the method on the subtree to the left
        if(node.getLeft() != null)
        {
            preOrder(node.getLeft(), arr);
        }
        //if there are more nodes down the tree to the right then rerun the method on the subtree to the right
        if (node.getRight() != null)
        {
            preOrder(node.getRight(), arr);
        }
        return;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        postOrder(this.root, arr);
        return arr;
    }

    public void postOrder(BSTNode node, ArrayList<BSTNode> arr)
    {
        //if there are more nodes down the tree to the left then rerun the method on the subtree to the left
        if(node.getLeft() != null)
        {
            postOrder(node.getLeft(), arr);
        }
        //if there are more nodes down the tree to the right then rerun the method on the subtree to the right
        if (node.getRight() != null)
        {
            postOrder(node.getRight(), arr);
        }
        //add this node
        arr.add(node);
        return;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val)
    {
        // TODO: Complete insert
        insertion(val, this.root);
        return;
    }

    public void insertion (int val, BSTNode node)
    {
        if (val < node.getVal())
        {
            //if there are no further subtrees then insert the value and exit the function
            if (node.getLeft() == null)
            {
                node.setLeft(new BSTNode(val));
                return;
            }
            //rerun the method on the subtree to the left
            insertion(val, node.getLeft());
        }
        else if (val > node.getVal() && node.getRight() != null)
        {
            //if there are no further subtrees then insert the value and exit the function
            if (node.getRight() == null)
            {
                node.setRight(new BSTNode(val));
                return;
            }
            //rerun the method on the subtree to the left
            insertion(val, node.getRight());
        }

    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

       System.out.println("\nPostorder traversal of binary tree is");
       sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
