package BST_check;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;
}
public class Solution {
    List<Integer> list = new ArrayList<>();

    private void inOrder(Node root)
    {
        if(root == null) return;
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);
    }
    private boolean isAscendingArray ()
    {
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
    boolean checkBST(Node root) {

        inOrder(root);
        if(isAscendingArray()) return true;
        return false;
    }
}
