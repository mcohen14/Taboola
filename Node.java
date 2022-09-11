public class Node {
    Node left;
    Node right;
    int num;

    public Node(int num) {
        this.num = num;
    }
}

// In order to support any data type we can use a class instead of a primitive data type so we can use null to represent a null node.
