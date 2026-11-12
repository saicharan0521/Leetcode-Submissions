class Solution {
    public int longestMonotonicSubarray(int[] nums) 
    {
        int max = 0;
        int cnt = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                cnt++;
            }
            else
            {
                max = Math.max(cnt,max);
                cnt = 1;
            }
        }
        max = Math.max(max,cnt);
        cnt = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
            {
                cnt++;
            }
            else
            {
                max = Math.max(cnt,max);
                cnt = 1;
            }
        }
        max = Math.max(max,cnt);
        return max;
    }
}