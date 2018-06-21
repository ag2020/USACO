#include <bits/stdc++.h>
using namespace std;
#define FOR(i, a) for(int i=0;i<a;i++)

int n, k;

int works (int guess, int actual) {
    if ((guess + 2) % 3 == actual) return 1;
    return 0;
}

int main() { ios::sync_with_stdio(0); cin.tie(0);
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    cin >> n >> k;
    if (k >= n - 1) {
        cout << n << '\n';
        return 0;
    }
    int dp[n + 1][k + 1][3];
    FOR(m, n + 1) {
        FOR(s, k + 1) {
            FOR(i, 3) {
                dp[m][s][i] = 0;
            }
        }
    }
    int arr[n];
    FOR(i, n) {
        char ch;
        cin >> ch;
        int num;
        if (ch == 'H') num = 0;
        else if (ch == 'P') num = 1;
        else num = 2;
        arr[i] = num;
        dp[i + 1][0][num] = dp[i][0][num];
        dp[i + 1][0][(num + 1) % 3] = dp[i][0][(num + 1) % 3] + 1;
        dp[i + 1][0][(num + 2) % 3] = dp[i][0][(num + 2) % 3];
    }
    for (int m = 1; m <= n; m++) {
        for (int s = 1; s <= k; s++) {
            for (int i = 0; i < 3; i++) {
                dp[m][s][i] = max(dp[m - 1][s][i], max(dp[m - 1][s - 1][(i + 1) % 3], dp[m - 1][s - 1][(i + 2) % 3])) + works(i, arr[m - 1]);
            }
        }
    }
    cout << max(dp[n][k][0], max(dp[n][k][1], dp[n][k][2])) << '\n';
}
