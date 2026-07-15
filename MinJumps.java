class Solution {
    public static int minJumps(int[] nums) {
        int n = nums.length;

        // If array has only one element
        if (n <= 1) {
            return 0;
        }

        // Cannot move anywhere
        if (nums[0] == 0) {
            return -1;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // End of current jump range
            if (i == currentEnd) {

                // Cannot move further
                if (farthest == currentEnd) {
                    return -1;
                }

                jumps++;
                currentEnd = farthest;

                // Destination reached
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }

        return -1;
    }
}