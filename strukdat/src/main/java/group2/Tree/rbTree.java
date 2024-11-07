package group2.Tree;

public class rbTree {
class Node {
    private char key;
    private Node right;
    private Node left;
    private Node parent;
    private boolean red;

    public Node(char key) {
        this.key = key;
        this.red = true;  
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public char getKey() {
        return key;
    }

    public boolean isRed() {
        return red;
    }
}

class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public boolean isExist(char key) {
        return isExist(root, key);
    }

    public boolean isExist(Node root, char key) {
        if (root == null) {
            return false;
        }
        if (key == root.getKey()) {
            System.out.println("Key ada");
            return true;
        } else if (key < root.getKey()) {
            return isExist(root.getLeft(), key);
        } else {
            return isExist(root.getRight(), key);
        }
    }

    public boolean add(char key) {
        Node newNode = new Node(key);

        if (isExist(root, key)) {
            return false; 
        }

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            while (true) {
                if (key < currentNode.getKey()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        newNode.setParent(currentNode);
                        break;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        newNode.setParent(currentNode);
                        break;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }

        newNode.setRed(true); 
        fixAfterInsertion(newNode);

        root.setRed(false); 
        return true;
    }

    private void fixAfterInsertion(Node newNode) {
        while (newNode != root && newNode.getParent() != null && newNode.getParent().isRed()) {
            Node parent = newNode.getParent();
            Node grandParent = parent.getParent();
            Node uncle = (grandParent.getLeft() == parent) ? grandParent.getRight() : grandParent.getLeft();

            if (parent == grandParent.getLeft()) {
                if (uncle != null && uncle.isRed()) {
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandParent.setRed(true);
                    newNode = grandParent;
                } else {
                    if (newNode == parent.getRight()) {
                        newNode = parent;
                        rotateLeft(newNode);
                    }
                    parent.setRed(false);
                    grandParent.setRed(true);
                    rotateRight(grandParent);
                }
            } else {
                if (uncle != null && uncle.isRed()) {
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandParent.setRed(true);
                    newNode = grandParent;
                } else {
                    if (newNode == parent.getLeft()) {
                        newNode = parent;
                        rotateRight(newNode);
                    }
                    parent.setRed(false);
                    grandParent.setRed(true);
                    rotateLeft(grandParent);
                }
            }
        }
    }

    private void rotateRight(Node node) {
        Node parent = node.getLeft();
        Node grandParent = node.getParent();

        if (grandParent != null) {
            if (node == grandParent.getLeft()) {
                grandParent.setLeft(parent);
            } else {
                grandParent.setRight(parent);
            }
        } else {
            root = parent;
        }

        parent.setParent(grandParent);
        node.setLeft(parent.getRight());
        if (parent.getRight() != null) {
            parent.getRight().setParent(node);
        }
        parent.setRight(node);
        node.setParent(parent);
    }

    private void rotateLeft(Node node) {
        Node parent = node.getRight();
        Node grandParent = node.getParent();

        if (grandParent != null) {
            if (node == grandParent.getLeft()) {
                grandParent.setLeft(parent);
            } else {
                grandParent.setRight(parent);
            }
        } else {
            root = parent;
        }

        parent.setParent(grandParent);
        node.setRight(parent.getLeft());
        if (parent.getLeft() != null) {
            parent.getLeft().setParent(node);
        }
        parent.setLeft(node);
        node.setParent(parent);
    }

    public void preOrderTraversal(Node node) {
        if (node!= null) {
            System.out.print(node.getKey() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void post0rderTraversal(Node node) {
        if (node != null) {
            post0rderTraversal(node.getLeft());
            post0rderTraversal(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public void displayKeysPreOrder() {
        System.out.print("Pre Order: ");
        preOrderTraversal(root);
        System.out.println();
    }

    public void displayKeysInOrder() {
        System.out.print("In Order: ");
        inOrderTraversal(root);
        System.out.println();
    }

    public void displayKeysPostOrder() {
        System.out.print("Post Order: ");
        post0rderTraversal(root);
        System.out.println();
    }



    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null) return;
    
        level += 4;
        printTree(node.getRight(), level+ 1);
        System.out.println();
        
        for (int i = 4; i < level; i++) {
            System.out.print(" ");
        }

        if (node.isRed()) {
            System.out.print("\033[1;31m" + node.getKey() + "\033[0m"); // Merah
        } else {
            System.out.print(node.getKey()); // Hitam 
        }
        
        printTree(node.getLeft(), level + 1);
    }   

}

    public static void main(String [] args) {
        rbTree rbTree = new rbTree();
        Tree tree = rbTree.new Tree();
        

        tree.add('k');
        tree.add('e');
        tree.add('c');
        tree.add('b');
        tree.add('f');
        tree.add('a');
        tree.add('d');

        tree.displayKeysInOrder();
        tree.displayKeysPostOrder();
        tree.displayKeysPreOrder();


     
        tree.printTree();
    }
}