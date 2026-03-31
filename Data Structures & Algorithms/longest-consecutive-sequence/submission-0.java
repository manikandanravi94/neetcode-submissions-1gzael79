class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount=0;

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }

        for(int i=0;i<nums.length;i++){
            int count=0;
            if(set.contains(nums[i])){
                int num=nums[i];
                while(set.contains(num-1)){
                  count=count+1;
                  num=num-1;
                  set.remove(num);
                }
                num=nums[i];
                while(set.contains(num+1)){
                    count=count+1;
                    num=num+1;
                    set.remove(num);
                }
                count=count+1;
                set.remove(nums[i]);
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
