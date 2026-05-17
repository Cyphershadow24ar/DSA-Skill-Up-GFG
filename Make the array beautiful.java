// PROBLEM : Make the array beautiful

// SOLUTION :

class Solution {
    public ArrayList<Integer> makeBeautiful(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (ans.size() > 0) {

                int last = ans.get(ans.size() - 1);

                if ((last >= 0 && arr[i] < 0) ||
                    (last < 0 && arr[i] >= 0)) {

                    ans.remove(ans.size() - 1);
                    continue;
                }
            }

            ans.add(arr[i]);
        }

        return ans;
    }
}
