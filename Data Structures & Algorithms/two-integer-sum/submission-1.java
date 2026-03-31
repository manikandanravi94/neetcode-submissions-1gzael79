class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Look for the complement in what we've seen SO FAR
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // If not found, add current number to map and move on
            map.put(nums[i], i);
        }
        
        return new int[] {}; // Or th
    }
}
