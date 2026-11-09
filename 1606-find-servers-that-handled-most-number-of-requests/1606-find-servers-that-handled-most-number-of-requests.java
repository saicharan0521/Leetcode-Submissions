class Solution 
{
    class Pair
    {
        int i;
        int time;

        Pair(int i, int time)
        {
            this.i = i;
            this.time = time;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));

        TreeSet<Integer> avail = new TreeSet<>();

        for(int i = 0; i < k; i++)
            avail.add(i);

        int[] res = new int[k];
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < arrival.length; i++)
        {
            while(!pq.isEmpty() && pq.peek().time <= arrival[i])
            {
                avail.add(pq.poll().i);
            }

            if(avail.isEmpty())
                continue;

            int server = i % k;

            Integer next = avail.ceiling(server);

            if(next == null)
                next = avail.first();

            res[next]++;
            avail.remove(next);

            pq.offer(new Pair(next, arrival[i] + load[i]));
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++)
            max = Math.max(max, res[i]);

        for(int i = 0; i < k; i++)
        {
            if(res[i] == max)
                lst.add(i);
        }

        return lst;
    }
}