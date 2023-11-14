package SeftBalanceTree;

 class Solution {
     static class Node{
        int val;
        int ht;
        Node left;
        Node right;
    }
     private static int height(Node root)
     {
         if (root == null) {
             return -1;
         }
         return root.ht;
     }
     private static int updateHeight(Node root)
     {
         if(root == null) {
             return -1;
         }
         return Math.max(height(root.left), height(root.right)) +1;
     }

     static Node rotateRight(Node root)
     {
         Node current = root.left;
         root.left = current.right;
         current.right = root;

         root.ht = updateHeight(root);
         current.ht = updateHeight(current);
         return current;
     }
     static Node rotateLeft(Node root)
     {
         Node current = root.right;
         root.right = current.left;
         current.left = root;

         root.ht = updateHeight(root);
         current.ht = updateHeight(current);
         return current;
     }
     static int getBanlance(Node root)
     {
         if(root == null) return 0;
         return height(root.left) - height(root.right);
     }
     static Node insert(Node root, int val)
     {
         if(root == null)
         {
             root = new Node();
             root.val = val;
             root.ht = 0;
             return root;
         }

         if(val < root.val)
         {
             root.left = insert(root.left, val);
         }
         else if(val > root.val)
         {
             root.right = insert(root.right, val);
         }
         else return root;

         //update height
         root.ht = updateHeight(root);

         int balance = getBanlance(root);
         if(balance > 1) // rotate right
         {
             if(val > root.left.val)
             {
                 root.left = rotateLeft(root.left);
             }
             return rotateRight(root);
         }
         else if(balance < -1) // rotate left
         {
             if(val < root.right.val)
             {
                 root.right = rotateRight(root.right);
             }
             return rotateLeft(root);
         }
         return root;
     }
}
