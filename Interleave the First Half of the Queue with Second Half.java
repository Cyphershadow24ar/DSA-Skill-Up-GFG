// PROBLEM : Interleave the First Half of the Queue with Second Half

// SOLUTION :

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
       
        int k = q.size();
        Queue<Integer> temp = new LinkedList<>();
        k= k/2;
        for(int i=0 ;i<k ;i++){
            temp.add(q.poll());
        }
        for(int i=0 ; i<k ;i++){
            q.add(temp.poll());
            q.add(q.poll());
        }
        return ;
    }
}
