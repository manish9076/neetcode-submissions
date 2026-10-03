class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];

        if(n == 0){
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < k; i++){

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for(int i = 1; i < n-k+1; i++){

                if(!deque.isEmpty() && 
                  deque.peekFirst() <= i-1){
                    deque.pollFirst();
                }

                while(!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[i+k-1]){
                    deque.pollLast();
                }

                deque.offerLast(i+k-1);

                res[i] = nums[deque.peekFirst()];
            }
            return res;
    }
}
