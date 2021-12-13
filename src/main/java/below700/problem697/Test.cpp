#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        map<int, vector<int>> records;
        int maxNum = 0;
        int minLen = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            if(!records.count(nums[i])) {
                records[nums[i]] = {0, i};
            }
            int tmp = ++records[nums[i]][0];
            if(tmp > maxNum) {
                minLen = i - records[nums[i]][1] + 1;
                maxNum = tmp;
            } else if(tmp == maxNum) {
                minLen = min(minLen, i - records[nums[i]][1] + 1);
            }
        }
        return minLen;
    }
};

int main() {
    Solution sl;
    vector<int> vc = {1,2,2,3,1,4,2};
    cout << sl.findShortestSubArray(vc);
}