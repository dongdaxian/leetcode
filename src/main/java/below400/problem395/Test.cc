#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    int dfs(const string &s, int l, int r, int k) {
        int count[26] = {0};
        for (int i = l; i <= r;  i++) {
            count[s[i] - 'a']++;
        }
        int lack = -1;
        for (int i = 0; i < 26; i++) {
            if(count[i] > 0 && count[i] < k) {
                lack = i;
                break;
            }
        }
        if(lack == -1)
            return r - l + 1;
        int i = l;
        int maxLen = 0;
        while(i <= r) {
            while(i <= r && s[i] - 'a' == lack)
                i++;
            if(i > r)
                break;
            int record = i;
            while(i <= r && s[i] - 'a' != lack)
                i++;
            maxLen = max(maxLen, dfs(s, record, i - 1, k));
        }
        return maxLen;
    }

    int longestSubstring(string s, int k) {
        return dfs(s, 0, s.size() - 1, k);
    }
};

int main() {
    Solution sl;
    cout << sl.longestSubstring("aaabb", 3);
    return 0;
}