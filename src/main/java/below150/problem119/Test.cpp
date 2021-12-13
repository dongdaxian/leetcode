#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> vc(rowIndex + 1);
        vc[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i + 1; j > 0; j--) {
                vc[j] += vc[j - 1];
            }
        }
        return vc;
    }

    vector<int> getRow2(int rowIndex) {
        vector<int> vc(rowIndex + 1);
        vc[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            vc[i] = (long)vc[i - 1] * (rowIndex - i + 1) / i;
        }
        return vc;
    }
};