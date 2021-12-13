#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double maxAvg = 0;
        double tmpSum = 0;
        for (int i = 0; i < k; i++) {
            tmpSum += nums[i];
        }
        maxAvg = tmpSum / k;
        for (int i = k; i < nums.size(); i++) {
            tmpSum -= nums[i - k];
            tmpSum += nums[i];
            maxAvg = max(maxAvg, tmpSum / k);
        }
        return maxAvg;
    }


    double findMaxAverage2(vector<int>& nums, int k) {
        int sum = 0;
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = max(maxSum, sum);
        }
        return static_cast<double> (maxSum) / k;
    }
};