#include<iostream>
#include<string>
#include<cctype>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
public:
    bool isToeplitz(vector<vector<int>>& matrix, int i, int j, int m, int n) {
        while(i + 1 < m && j + 1 < n) {
            if(matrix[i + 1][j + 1] != matrix[i][j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        cout << isToeplitz(matrix, 0, 0, m, n) << endl;
        for(int i = 0; i < n; i++) {
            if(!isToeplitz(matrix, 0, i, m, n))
                return false;
        }
        for (int i = 1; i < m; i++) {
            if(!isToeplitz(matrix, i, 0, m, n))
                return false;
        }
        return true;
    }
};

int main() {
    vector<vector<int>> matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
    Solution sl;
    cout << sl.isToeplitzMatrix(matrix) << endl;
}