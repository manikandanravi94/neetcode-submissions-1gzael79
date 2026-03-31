

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer,Integer> map =new HashMap<>();
        // int opSize=0;
        // for(int i=0;i<nums.length;i++){
        //     map.compute(nums[i],(key,value)->{
        //         int total = value==null?1:value+1;
        //         if(total==k){
        //             opSize=opSize+1;
        //         }
        //         return value;
        //     });
        // }
        // int[] op = new int[opSize];
        // int j=0;
        // map.entrySet().stream().forEach(entry->{
        //     if(entry.getValue()>=k){
        //       op[j]=entry.getValue();
        //       j++;
        //     }
        // });
        // return op;

        Map<Integer, Long> map = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

    // Step 2: Filter and Convert to int[]
   return map.entrySet().stream()
        .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort descending
        .limit(k)                                              // Take top k
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
