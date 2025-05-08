import java.util.Arrays;
import java.util.Comparator;

public class Weighted_Interval_Scheduling {
    
    public static int bottom_up(Interval intervals[]) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.f));
        int m[] = new int[intervals.length];
        m[0] = intervals[0].w;
        for(int j=1; j<intervals.length; j++) {
            int p = find_p(intervals, j);
            int w_j = intervals[j].w + (p==-1 ? 0:m[p]);
            m[j] = Math.max(w_j, m[j-1]);
        }
        return m[intervals.length-1];
    }

    public static int find_p(Interval[] intervals, int j) {
        for(int i=j-1; i>=0; i--) {
            if(intervals[i].f <= intervals[j].s)
                return i;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        Interval intervals[] = {
            new Interval(1, 4, 1),
            new Interval(3, 5, 2),
            new Interval(0, 6, 3),
            new Interval(4, 7, 4),
            new Interval(3, 8, 5),
            new Interval(5, 9, 6),
            new Interval(6, 10, 7),
            new Interval(4, 11, 8)
        };
        System.out.println("Maximum weighted sum of non overlapping intervals: " + bottom_up(intervals));
    }
}

class Interval {
    int s,f,w;
    Interval(int s, int f, int w) {
        this.s = s;
        this.f= f;
        this.w = w;
    }
}
