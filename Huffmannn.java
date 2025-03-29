import java.util.PriorityQueue;
import java.util.Comparator;

public class Huffman {
   public static void main(String[] args) {
        int n = 6;
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {45, 13, 12, 16, 9, 5};

        PriorityQueue <Node> q = new PriorityQueue<Node>(n, new ImplementComparator());


        for(int i=0; i<n; i++) {
            Node node = new Node();
            node.c = chars[i];
            node.item = freq[i];
            node.left = null;
            node.right = null;
            q.add(node);
        }
        
        Node root = null;

        while(q.size() > 1) {
            Node x = q.peek();
            q.poll();
            Node y = q.peek();
            q.poll();
            Node z = new Node();
            z.item = x.item - y.item;
            z.c = '-';
            z.left = x;
            z.right = y;
            root = z;
            q.add(z);
        }

        System.out.println("Char : Huffmann Code");
        System.out.println("**************************");
        codes(root, " ");
   }

   public static void codes(Node root, String s) {
        if(root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " " + s);
            return;
        } 
        codes(root.left, s+"0");
        codes(root.right, s+"1");
   }
}

class Node {
    int item;
    char c;
    Node left, right;
}

class ImplementComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.item - y.item;
    }
}
