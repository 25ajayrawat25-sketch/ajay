/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node
        Node leftmost = root;

        // Loop until there are no more levels below
        while (leftmost.left != null) {
            Node curr = leftmost;

            // Traverse the current level using 'next' pointers
            while (curr != null) {
                // Connection 1: Connect left child -> right child
                curr.left.next = curr.right;

                // Connection 2: Connect right child -> next subtree's left child
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                // Move to the next node on the current level
                curr = curr.next;
            }

            // Move to the first node of the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}
