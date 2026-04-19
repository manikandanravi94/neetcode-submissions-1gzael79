class Solution {
    public int[] sortArray(int[] nums) {
        return split(nums);
    }

    public int[] split(int[] nums){
        if(nums.length<=1){
            return nums;
        }
        int mid=nums.length/2;
       int[] leftArr=build(nums,0,mid);
       int[] rightArr=build(nums,mid,nums.length);
       int[] left=split(leftArr);
       int[] right =split(rightArr);
       return merge(left,right);
    }

    public int[] merge(int[] left,int[] right){
        int[] op = new int[left.length+right.length];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
              if(left[i]<=right[j]){
                op[k]=left[i];
                i++;k++;
              }else{
                op[k]=right[j];
                j++;k++;
              }
        }
        while(i<left.length){
            op[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            op[k]=right[j];
            j++;
            k++;
        }
        return op;
    }



    public int[] build(int[] nums,int start,int end){
            int[] op = new int[end-start];
            int index=0;
              while(start<end){
                    op[index]=nums[start];
                    index++;
                    start++;
              }
              return op;
    }
}