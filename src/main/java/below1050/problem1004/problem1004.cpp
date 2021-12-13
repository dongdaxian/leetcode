#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<stack>
#include<map>
#include<algorithm>

using namespace std;


class Solution {
public:
    int longestOnes(vector<int>& A, int K) {
        int left = 0, right = 0;
        int count = 0;
        for (right = 0; right < A.size(); right++) {
            if(A[right] == 0) {
                count++;
            }
            if(count > K) {
                if(A[left] == 0)
                    count--;
                left++;
            }
        }
        return right - left;
    }
};