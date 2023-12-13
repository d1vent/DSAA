package vebo.startup;
import java.io.*;
import java.util.*;

class Event {
    int value;
    int index;

    public Event(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int startup = 0;
        PriorityQueue<Event> minHeap = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event evt1, Event evt2) {
                return Integer.compare(evt1.value, evt2.value);
            }
        });

        for (int i = 1; i <= n; ++i) {
            int u = input.nextInt();
            int v = input.nextInt();
            if(i == n){
                startup = v;
                break;
            }
            if (u == 1) {
                minHeap.offer(new Event(v, i));
            } else {
                while (minHeap.size() >= v && !minHeap.isEmpty()) {
                    minHeap.poll();
                }
            }
        }

        if (startup > minHeap.size()) {
            System.out.println(-1);
        } else {
            long maxSum = 0;
            ArrayList<Integer> res = new ArrayList<>();

            while (!minHeap.isEmpty()) {
                Event event = minHeap.poll();
                maxSum += event.value;
                res.add(event.index);
            }

            Collections.sort(res);

            System.out.println(maxSum);
            for (int x : res) {
                System.out.print(x + " ");
            }
        }

        input.close();
    }
}
