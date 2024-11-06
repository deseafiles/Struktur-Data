package group2.Tree;

class Node {
    private char key;
    private Node right;
    public Node left;
    public Node parent;
    public boolean red;

    public Node (char key) {
        this.key = key;
    }

    public void setRight (Node right) {
        this.right = right;
    }

    public void setLeft (Node left) {
        this.left = left;
    }

    public void setParent (Node parent) {
        this.parent = parent;
    }

    public void setRed (boolean red) {
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

class rbTree {
    private Node root;

    public rbTree() {
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

        if(root == null) {
            this.root =newNode;
        } else {
            Node currentNode =root;
            while (true) {
                if (key < currentNode.getKey()){
                    currentNode.setLeft(newNode);
                    break;
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
   }
   
   public static void main(String[] args) {
    
   }
}
