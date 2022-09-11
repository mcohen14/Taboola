public class Node {
    Node left;
    Node right;
    int num;

    public Node(int num) {
        this.num = num;
    }
}

// In order to support any data type we can use an object/wrapper class instead of a primitive data type so we can use null to represent a when a node does not exist.
