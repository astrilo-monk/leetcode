class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int j=0;

        for(int i=0;i<n;i++){
            if(nums[i]<0)
                j++;
        }

        int pos[] = new int[n-j];
        int neg[] = new int[j];

        for(int i=0;i<j;i++)
            neg[i]=nums[i];

        for(int i=j;i<n;i++)
            pos[i-j]=nums[i];

        //case 1 all positive
        if(neg.length==0){
            for(int i=0;i<n;i++)
                nums[i]=nums[i]*nums[i];
            return nums;
        }

        //case 2 all negative
        if(pos.length==0){
            for(int i=0;i<j;i++)
                neg[i]=neg[i]*neg[i];

            int start=0,end=neg.length-1;
            while(start<end){
                int t = neg[start];
                neg[start] = neg[end];
                neg[end] = t;
                start++;
                end--;
            }

            return neg;
        }

        //case 3 some -ve some +ve
        for(int i=0;i<pos.length;i++)
            pos[i]=pos[i]*pos[i];

        for(int i=0;i<neg.length;i++)
            neg[i]=neg[i]*neg[i];

        int start=0,end=neg.length-1;
        while(start<end){
            int t = neg[start];
            neg[start] = neg[end];
            neg[end] = t;
            start++;
            end--;
        }

        int p=0,q=0,k=0;

        int[] res = new int[neg.length + pos.length];

        while(p<neg.length && q<pos.length){
            if(neg[p]<=pos[q]){
                res[k]=neg[p];
                k++;p++;
            }
            else{
                res[k]=pos[q];
                k++;q++;
            }
        }

        while(p<neg.length){
            res[k]=neg[p];
            k++;p++;
        }

        while(q<pos.length){
            res[k]=pos[q];
            k++;q++;
        }

        return res;
    }
}