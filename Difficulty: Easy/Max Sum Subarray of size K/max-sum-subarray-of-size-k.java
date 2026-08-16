class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int sum=0;
        int low =0,high=k-1;
        int res=Integer.MIN_VALUE;
        
        for(int i=0;i<k;i++){
            sum = sum + arr[i];
        }
        
        while(high<arr.length){
                res = Math.max(sum,res);
                low++;high++;
                
                if(high==arr.length)
                    break;

                sum = sum+arr[high];
                sum = sum-arr[low-1];

        }
        return res;
    }
}