class Solution {
    public int scheduleCourse(int[][] courses) {
        
        // sort on the basis of last day (deadline)
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);

        // max heap on the basis of duration
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        int totalTime = 0;

        for(int[] course: courses){
            int duration = course[0];
            int lastDay = course[1];

            pq.add(duration);
            totalTime += duration;

            if(totalTime > lastDay){
                totalTime -= pq.poll();
            }
        }
        return pq.size();
    }
}