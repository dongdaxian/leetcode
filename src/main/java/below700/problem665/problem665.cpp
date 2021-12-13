#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<stack>
#include<map>
#include<algorithm>
#include<cmath>

using namespace std;

class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int pre = INT_MIN;
        bool flag = false;
        for (int i = 0; i < nums.size() - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(flag)
                    return false;
                flag = true;
                // if(pre <= nums[i + 1])
                //     nums[i] = pre;    
                // else
                //     nums[i + 1] = nums[i];
                if(pre > nums[i + 1])
                    nums[i + 1] = nums[i];
            }
            pre = nums[i];
        }
        return true;
    }
    

};