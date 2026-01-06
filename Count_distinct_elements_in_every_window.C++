// PROBLEM : Count distinct elements in every window

// SOLUTION :

class Solution {
  public:
    vector<int> countDistinct(vector<int> &arr, int k) {
        // code here
        vector<int> result;
        unordered_map<int, int> freq;
        
        for(int i = 0; i<k; i++){
            freq[arr[i]]++;
        }
        
        result.push_back(freq.size());
        
        for(int i=k ; i<arr.size(); i++){
            int out = arr[i-k];
            freq[out]--;
            if(freq[out] == 0){
                freq.erase(out);
            }
            freq[arr[i]]++;
            
            result.push_back(freq.size());
        }
        return result;
    }
};
