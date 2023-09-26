package LinkedList;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class DeleteANode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    class Result {

        /*
         * Complete the 'deleteNode' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER position
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            // Write your code here
            if (position == 0)
            {
                SinglyLinkedListNode tmphead = llist;
                llist = llist.next;
                tmphead = null;
                return llist;
            }


            SinglyLinkedListNode head = llist;
            int count = 1;
            while (count < position) {
                llist = llist.next;
                count++;
            }
            SinglyLinkedListNode tmp = llist.next;
            llist.next = tmp.next;
            tmp = null;
            return head;

            //recursive
//            if(position == 0)
//            {
//                SinglyLinkedListNode tempNode = llist;
//                llist = llist.next;
//                tempNode = null;
//                return llist;
//            }
//
//            if(position > 1)
//            {
//                return deleteNode(llist.next,position-1);
//            }
//            if(position == 1)
//            {
//                SinglyLinkedListNode tempNode = llist.next;
//                llist.next = tempNode.next;
//                tempNode = null;
//            }
//            return llist;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, llistCount).forEach(i -> {
                try {
                    int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                    llist.insertNode(llistItem);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int position = Integer.parseInt(bufferedReader.readLine().trim());

            SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

            SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
