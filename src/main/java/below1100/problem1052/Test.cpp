#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int X) {
        int n = grumpy.size();
        int avoid_angry = 0;
        int max_avoid = 0;
        for (int i = 0; i < X; i++) {
            avoid_angry += customers[i] * grumpy[i];
        }
        max_avoid = avoid_angry;
        for (int i = X; i < n; i++) {
            avoid_angry -= customers[i - X] * grumpy[i - X];
            avoid_angry += customers[i] * grumpy[i];
            max_avoid = max(avoid_angry, max_avoid);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += customers[i] * (1 - grumpy[i]);
        }
        return res + max_avoid;
    }
};