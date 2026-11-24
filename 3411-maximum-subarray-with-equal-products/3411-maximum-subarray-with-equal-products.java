class Solution {
    int GCD(int a,int b)
    {
        while(b!=0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int maxLength(int[] nums) 
    {
        int max = 1;
        for(int i=0;i<nums.length;i++)
        {
            long lcm = nums[i];
            int gcd = nums[i];
            long prod = nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                gcd = GCD(gcd,nums[j]);
                lcm = (lcm/GCD((int)lcm,nums[j]))*nums[j];
                prod = prod*nums[j];
                if(prod==gcd*lcm)
                {
                    max =  Math.max(max,j-i+1);
                }
            }
        }

        return max;
    }
}