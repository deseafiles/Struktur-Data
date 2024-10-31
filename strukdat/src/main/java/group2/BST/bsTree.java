package group2.BST;

class Node {
    private Node left;
    private char key;
    private Node right;

    public Node(char key) {
        this.key = key;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public char getKey() {
        return key;
    }
}

public class bsTree {
    private Node root;

    public bsTree() {
        this.root = null;
    }

    public boolean add(char key) {
        Node newNode = new Node(key);
        if (root == null) {
            this.root = newNode;
            return true;
        } else {
            Node currentNode = root;
            while (true) {
                if (key < currentNode.getKey()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                    currentNode = currentNode.getLeft();
                } else if (key > currentNode.getKey()) {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                    currentNode = currentNode.getRight();
                } else {
                    return false; 
                }
            }
        }
        return true;
    }

  
    public boolean remove(char key) {
        root = removeNode(root, key);
        return root != null;
    }

    private Node removeNode(Node node, char key) {
        if (node == null) {
            return null; 
        }

        if (key < node.getKey()) {
            node.setLeft(removeNode(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(removeNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight(); 
            } else if (node.getRight() == null) {
                return node.getLeft(); 
            }
            node.setRight(findMin(node.getRight())); 
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
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
        if (node != null) {
            printTree(node.getRight(), level + 1);
            System.out.printf("%s%c%n", "    ".repeat(level), node.getKey());
            printTree(node.getLeft(), level + 1);
        }
    }

    public static void bsTreeMenu() {
        bsTree tree = new bsTree();
        tree.add('d');
        tree.add('b');
        tree.add('a');
        tree.add('c');
        tree.add('f');
        tree.add('e');
        
        tree.printTree();

        tree.displayKeysInOrder();
        tree.displayKeysPreOrder();
        tree.displayKeysPostOrder();
        
        tree.remove('f');
        tree.printTree();
    }
}
