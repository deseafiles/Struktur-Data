package group2.Tree;

import java.util.EmptyStackException;
import java.util.Scanner;

class Node {
    private char key;
    private Node right;
    private Node left;
    private Node parent;
    private boolean red;

    public Node() {
        // Default constructor for TNULL
    }

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

    public void setKey(char key) {
        this.key = key;
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

class RBTree {
    private Node root;
    private Node TNULL;

    public RBTree() {
        TNULL = new Node();
        TNULL.setRed(false);
        TNULL.setLeft(TNULL);
        TNULL.setRight(TNULL);
        root = TNULL;
    }

    private void fixInsert(Node node) {
        Node uncle;
        while (node.getParent() != null && node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rightRotate(node.getParent().getParent());
                }
            } else {
                uncle = node.getParent().getParent().getLeft();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    leftRotate(node.getParent().getParent());
                }
            }
            if (node == root) {
                break;
            }
        }
        root.setRed(false);
    }

    public void insert(char key) {
        Node node = new Node();
        node.setParent(null);
        node.setKey(key);
        node.setLeft(TNULL);
        node.setRight(TNULL);
        node.setRed(true);

        Node y = null;
        Node x = root;

        while (x != TNULL) {
            y = x;
            if (node.getKey() < x.getKey()) {
                x = x.getLeft();
            } else if (node.getKey() > x.getKey()) {
                x = x.getRight();
            } else {
                System.out.println("Duplicate key: " + key);
                return;
            }
        }

        node.setParent(y);
        if (y == null) {
            root = node;
        } else if (node.getKey() < y.getKey()) {
            y.setLeft(node);
        } else {
            y.setRight(node);
        }
        System.out.println("Key " + node.getKey() + " berhasil ditambahkan!");
        fixInsert(node);
    }

    private void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != TNULL) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(Node y) {
        Node x = y.getLeft();
        y.setLeft(x.getRight());
        if (x.getRight() != TNULL) {
            x.getRight().setParent(y);
        }
        x.setParent(y.getParent());
        if (y.getParent() == null) {
            root = x;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }
        x.setRight(y);
        y.setParent(x);
    }

    private void fixDelete(Node x) {
        Node s;
        while (x != root && !x.isRed()) {
            if (x == x.getParent().getLeft()) {
                s = x.getParent().getRight();
                if (s.isRed()) {
                    s.setRed(false);
                    x.getParent().setRed(true);
                    leftRotate(x.getParent());
                    s = x.getParent().getRight();
                }

                if (!s.getLeft().isRed() && !s.getRight().isRed()) {
                    s.setRed(true);
                    x = x.getParent();
                } else {
                    if (!s.getRight().isRed()) {
                        s.getLeft().setRed(false);
                        s.setRed(true);
                        rightRotate(s);
                        s = x.getParent().getRight();
                    }

                    s.setRed(x.getParent().isRed());
                    x.getParent().setRed(false);
                    s.getRight().setRed(false);
                    leftRotate(x.getParent());
                    x = root;
                }
            } else {
                s = x.getParent().getLeft();
                if (s.isRed()) {
                    s.setRed(false);
                    x.getParent().setRed(true);
                    rightRotate(x.getParent());
                    s = x.getParent().getLeft();
                }

                if (!s.getRight().isRed() && !s.getLeft().isRed()) {
                    s.setRed(true);
                    x = x.getParent();
                } else {
                    if (!s.getLeft().isRed()) {
                        s.getRight().setRed(false);
                        s.setRed(true);
                        leftRotate(s);
                        s = x.getParent().getLeft();
                    }

                    s.setRed(x.getParent().isRed());
                    x.getParent().setRed(false);
                    s.getLeft().setRed(false);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setRed(false);
    }

    private void rbTransplant(Node u, Node v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        v.setParent(u.getParent());
    }

    private Node minimum(Node node) {
        while (node.getLeft() != TNULL) {
            node = node.getLeft();
        }
        return node;
    }

    public void deleteNode(char key) {
        Node z = TNULL;
        Node x, y;
        Node node = root;

        while (node != TNULL) {
            if (node.getKey() == key) {
                z = node;
            }
            if (node.getKey() <= key) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }

        if (z == TNULL) {
            System.out.println("Key tidak ditemukan dalam tree");
            return;
        }

        y = z;
        boolean yOriginalColor = y.isRed();
        if (z.getLeft() == TNULL) {
            x = z.getRight();
            rbTransplant(z, z.getRight());
        } else if (z.getRight() == TNULL) {
            x = z.getLeft();
            rbTransplant(z, z.getLeft());
        } else {
            y = minimum(z.getRight());
            yOriginalColor = y.isRed();
            x = y.getRight();
            if (y.getParent() == z) {
                x.setParent(y);
            } else {
                rbTransplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            rbTransplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setRed(z.isRed());
        }
        if (!yOriginalColor) {
            fixDelete(x);
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == TNULL) return;
    
        level += 4;
        printTree(node.getRight(), level + 1);
        System.out.println();
    
        for (int i = 4; i < level; i++) {
            System.out.print(" ");
        }
    
        if (node.isRed()) {
            System.out.print("\033[38;2;255;0;0m" + node.getKey() + "\033[0m"); // Merah untuk node merah
        } else {
            System.out.print(node.getKey()); // Default warna untuk node hitam
        }
    
        printTree(node.getLeft(), level + 1);
    }
    

    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.getKey() + " ");
            preOrderHelper(node.getLeft());
            preOrderHelper(node.getRight());
        }
    }

    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderHelper(node.getRight());
        }
    }

    private void postOrderHelper(Node node) {
        if (node != TNULL) {
            postOrderHelper(node.getLeft());
            postOrderHelper(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public void preorder() {
        System.out.print("Pre Order: ");
        preOrderHelper(this.root);
        System.out.println();
    }

    public void inorder() {
        System.out.print("In Order: ");
        inOrderHelper(this.root);
        System.out.println();
    }

    public void postorder() {
        System.out.print("Post Order: ");
        postOrderHelper(this.root);
        System.out.println();
    }

    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(Node node) {
        if (node == TNULL) {
            return 0;
        } else {
            int leftHeight = heightHelper(node.getLeft());
            int rightHeight = heightHelper(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean search(char key) {
        Node result = searchHelper(this.root, key);
        return result != TNULL;
    }

    private Node searchHelper(Node node, char key) {
        if (node == TNULL || key == node.getKey()) {
            return node;
        }

        if (key < node.getKey()) {
            return searchHelper(node.getLeft(), key);
        }
        return searchHelper(node.getRight(), key);
    }
}

public class Main {
    public static void main(String[] args) {
        RBTree tree = new RBTree();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n\n-------- Red Black Tree ----------");
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
                    tree.insert('j');
                    tree.insert('s');
                    tree.insert('k');
                    tree.insert('d');
                    tree.insert('h');
                    tree.insert('a');
                    tree.insert('f');
                    tree.insert('g');
                    tree.insert('l');
                    tree.insert('c');
                    tree.insert('c');
                    
                    break;
                case 2:
                    try {
                        System.out.print("Masukkan huruf: ");
                        char hurufRem = input.next().charAt(0);
                        System.out.println("Nilai yang dihapus: " + hurufRem);
                        tree.deleteNode(hurufRem);
                    } catch (EmptyStackException e) {
                        System.out.println("Tree kosong!");
                    }
                    break;
                case 3:
                    System.out.print("Masukan Key : ");
                    char key = input.next().charAt(0);
                    if (tree.search(key)) {
                        System.out.println("\nKey " + key + " ditemukan!");
                    } else {
                        System.out.println("\nKey " + key + " tidak ditemukan!");
                    }
                    break;
                case 4:
                    tree.preorder();
                    break;
                case 5:
                    tree.inorder();
                    break;
                case 6:
                    tree.postorder();
                    break;
                case 7:
                    System.out.println("Visualisasi Tree : ");
                    tree.printTree();
                    System.out.println("\n\nTinggi Tree : " + tree.height());
                    break;
                case 0:
                    running = false;
                    System.out.println("Keluar dari menu.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
