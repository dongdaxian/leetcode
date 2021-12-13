#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class NumArray {
public:
    vector<int> vc;

    NumArray(vector<int>& nums) {
        vc.resize(nums.size() + 1);
        for (int i = 0; i < nums.size(); i++) {
            vc[i + 1] = vc[i] + nums[i];
        }
    }
    
    int sumRange(int i, int j) {
        return vc[j + 1] - vc[i];
    }
};