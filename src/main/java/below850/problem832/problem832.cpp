#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        int m = image.size();
        int n = image[0].size();
        int len = (n + 1) / 2;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < len; j++) {
                int tmp = 1 - image[i][j];
                image[i][j] = 1 - image[i][n - 1 - j];
                image[i][n - 1 - j] = tmp;
            }
        return image;
    }
};