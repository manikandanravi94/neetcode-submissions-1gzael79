/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // 1. Sort the List using the custom object fields
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 2. Check for overlaps using .get(i)
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);

            // If current meeting ends after the next one starts
            if (current.end > next.start) {
                return false;
            }
        }

        return true;
    }
}
