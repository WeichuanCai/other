import java.util.*;

public class heap{
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
            

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { return a[0] - b[0]; }
        });
        

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { return a[1] - b[1]; }
        });
        

        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {

            int[] interval = heap.poll();
            
            if (intervals[i][0] >= interval[1]) {

                interval[1] = intervals[i][1];
            } else {

                heap.offer(intervals[i]);
            }


            heap.offer(interval);
        }
        
        return heap.size();
    }
    public static void main(String[] args){
        int[][] test = {{0,30}, {15, 20}, {5, 10}};
        int res = minMeetingRooms(test);
        System.out.println(res);
        // start: 0  5  15
        // end  : 10 20 30
    }
}