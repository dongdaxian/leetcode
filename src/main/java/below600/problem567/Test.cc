#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    bool isArrSame(const int * const arr1, const int * const arr2) {
        for (int i = 0; i < 26; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size())
            return false;
        int times[26] = {0};
        int tmpRecords[26] = {0};
        for (int i = 0; i < s1.size(); i++) {
            times[s1[i] - 'a']++;
            tmpRecords[s2[i] - 'a']++;
        }
        // Java中用Arrays.equals()比较int数组，C++中vector重载了=
        if(isArrSame(times, tmpRecords))
            return true;
        for (int i = s1.size(); i < s2.size(); i++) {
            tmpRecords[s2[i - s1.size()] - 'a']--;
            tmpRecords[s2[i] - 'a']++;
            if(isArrSame(times, tmpRecords)) {
                return true;
            }
        }
        return false;
    }
};