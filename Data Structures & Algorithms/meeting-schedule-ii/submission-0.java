class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!ends.isEmpty() && ends.peek() <= interval.start) {
                ends.poll();           // reuse the room that's free
            }
            ends.offer(interval.end);  // this meeting occupies a room
        }
        return ends.size();
    }
}