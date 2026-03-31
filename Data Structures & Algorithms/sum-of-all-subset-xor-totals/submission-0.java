class Solution {
    public int subsetXORSum(int[] nums) {
        return bt(nums,0,0, new ArrayList());
    }

    public int bt(int[] nums, int total, int start, List<Integer> lst){
      int sum=0;
      for(int num: lst){
         sum=sum^num;
      }
      total=total+sum;

       for(int i=start;i<nums.length;i++){
        lst.add(nums[i]);
        total =bt(nums,total,i+1,lst);
        lst.remove(lst.size()-1);
       }

       return total;
    }
}