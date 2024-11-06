package group2.Tree;

import java.util.EmptyStackException;
import java.util.Scanner;

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

    public boolean isExist(char key) {
        return isExist(root, key);
    }

    public boolean isExist(Node root, char key) {
        if (root == null) {
            return false;
        } 
        if (key == root.getKey()) {
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
            this.root = newNode;
        } else {
            Node currentNode = root;
            while (true) {
                if (key < currentNode.getKey()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    } else {
                    currentNode = currentNode.getRight();
                    }
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
            return node; 
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
            Node temp = findMin(node.getRight());
            node.setRight(removeNode(node.getRight(), temp.getKey()));
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
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n-------- Binary Search Tree ----------");
            System.out.println("1. Add Key");
            System.out.println("2. Remove Key");
            System.out.println("3. Is Exist");
            System.out.println("4. Pre Order Transversal");
            System.out.println("5. In Order Transversal");
            System.out.println("6. Post Order Transversal");
            System.out.println("7. Visualize");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihanmu: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan huruf: ");
                    char huruf = input.next().charAt(0);
                    if (!tree.isExist(huruf)){
                        tree.add(huruf);
                        System.out.println("Key " + huruf + " berhasil ditambahkan!");
                    } else {
                        System.out.println("Key " + huruf + " sudah ada di tree!");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Masukkan huruf: ");
                        char hurufRem = input.next().charAt(0);
                        tree.remove(hurufRem);
                        System.out.println("Nilai yang dihapus: " + hurufRem);
                    } catch (EmptyStackException e) {
                        System.out.println("Tree kosong!");
                    }
                    break;
                case 3:
                    System.out.print("Masukan Key : ");
                    char key = input.next().charAt(0);
                    if (tree.isExist(key)) {
                        System.out.println("Key " + key + "ditemukan!");
                    } else {
                        System.out.println("Key " + key + "tidak ditemukan!");
                    }
                    break;
                case 4:
                    tree.displayKeysPreOrder();
                    break;
                case 5:
                    tree.displayKeysInOrder();
                    break;
                case 6:
                    tree.displayKeysPostOrder();
                    break;
                case 7:
                    System.out.println("Visualisasi Tree : ");
                    tree.printTree();
                    break;
                case 0:
                    running = false;
                    System.out.println("Keluar dari menu.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }
        }
    }
}
