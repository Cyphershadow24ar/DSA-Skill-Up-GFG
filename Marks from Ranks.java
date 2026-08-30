// Problem : Marks from Ranks


// Solution :

class Solution {
    
    public int getMarksIndex(int[][] marksArr , int r){
        int left = 0;
        int right = marksArr.length;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(r >= marksArr[mid][0] && r <= marksArr[mid][1]){
                return mid;
            }else{
                if(marksArr[mid][1] > r){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here

        int n = l.length;

        int[][] rangeArr = new int[n][2];
        int[][] marksArr = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            int low = l[i];
            int high = r[i];
            rangeArr[i][0] = low;
            rangeArr[i][1] = high;
        }
        int marks = 1;
        for(int i = 0 ; i < n ; i++){
            int diff = rangeArr[i][1] - rangeArr[i][0];
            marksArr[i][0] = marks;
            marks += diff;
            marksArr[i][1] = marks;
            marks +=1;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int ran : rank){
            int idx = getMarksIndex(marksArr , ran);
            int diff = ran - marksArr[idx][0];
            int mark = rangeArr[idx][0] + diff;
            result.add(mark);
        }
        return result;
    }
}
