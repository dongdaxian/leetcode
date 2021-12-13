#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    int subarraysWithKDistinct(vector<int>& A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    // 返回以A中每一个元素为右边界，含有1到K个不同数字的子区间的个数的和
    int atMostKDistinct(vector<int>& A, int K) {
        map<int, int> record;
        int n = A.size();
        int left = 0, right = 0;
        int times = 0;
        for (; right < n; right++) {
            if(record.count(A[right]))
                record[A[right]]++;
            else {
                record.insert(pair<int, int>(A[right], 1));
                while (record.size() > K) {
                    record[A[left]]--;
                    if(record[A[left]] == 0) {
                        record.erase(A[left]);
                    }
                    left++;
                }
            }
            right++;
            times += right - left;
        }
        return times;
    }
};