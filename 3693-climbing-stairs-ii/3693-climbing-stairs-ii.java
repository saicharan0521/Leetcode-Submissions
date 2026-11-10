class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) 
    {   
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,costs);
    }

    int solve(int steps,int n,int[] cost)
    {
        if(steps>=n)
            return 0;
        if(dp[steps]!=-1)
            return dp[steps];
        
        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        if(steps<n)
            i1 = cost[steps]+1+solve(steps+1,n,cost);
        if(steps+1<n)
            i2 = cost[steps+1]+4+solve(steps+2,n,cost);
        if(steps+2<n)
            i3 = cost[steps+2]+9+solve(steps+3,n,cost);
        return dp[steps] = Math.min(i1,Math.min(i2,i3));
    }
}