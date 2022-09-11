import java.util.*;

public class Tree implements TreeSerializer {
    public String serialize(Node root) {
        String s = "";
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node == null) {
                s += "n,";
            } else {
                s += node.num + ",";
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return s;
    }

    public Node deserialize(String str) {
        if(str == null || str.equals("") || str.equals("n,")) {
            return null;
        }
        String[] arr = str.split(",");
        int i = 0;
        Node root = new Node(Integer.parseInt(arr[i]));
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            i++;
            String val = arr[i];
            if(!val.equals("n")) {
                node.left = new Node(Integer.parseInt(val));
                queue.add(node.left);
            }
            i++;
            val = arr[i];
            if(!val.equals("n")) {
                node.right = new Node(Integer.parseInt(val));
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(7);
        root.left.right = new Node(5);
        root.right.right = new Node(28);
        root.left.left.left = new Node(4);

        Tree tree = new Tree();

        String s = tree.serialize(root);
        System.out.println(s);

        Node n = tree.deserialize(s);
        System.out.println(tree.serialize(n));
    }
}

