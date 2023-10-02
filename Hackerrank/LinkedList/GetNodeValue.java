package LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GetNodeValue {

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }



        /*
         * Complete the 'getNode' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER positionFromTail
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

        public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
            // Write your code here
//            SinglyLinkedListNode temp = llist;
//            int length = 0;
//            while (temp != null) {
//                temp = temp.next;
//                length++;
//            }
//
//            int positionFromHead = length - (positionFromTail + 1);
//
//            while (positionFromHead > 0) {
//                llist = llist.next;
//                positionFromHead--;
//            }
//            return llist.data;

            // recursive
            int result = 0;
            SinglyLinkedListNode tmp = llist;
            int length = 0;
            while (tmp != null) {
                tmp = tmp.next;
                length++;
            }
            if (length - positionFromTail - 1 > 0) result = getNode(llist.next, positionFromTail);
            if (length - positionFromTail - 1 == 0) result = llist.data;
            return result;
        }



        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int tests = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int testsItr = 0; testsItr < tests; testsItr++) {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llistCount; i++) {
                    int llistItem = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist.insertNode(llistItem);
                }

                int position = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int result = getNode(llist.head, position);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }}

