#include <bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(0); cin.tie(0);
#define println(x) cout << x << '\n'
#define FOR(i, a) for(int i=0;i<a;i++)
#define F0R(i, a, b) for(int i=a;i<b;i++)

int h, g;
vector<pair<int, int> > hol;
vector<pair<int, int> > gur;

int dist(pair<int, int> p1, pair<int, int> p2) {
    return ((p1.first - p2.first) * (p1.first - p2.first)) + ((p1.second - p2.second) * (p1.second - p2.second));
}

int main() { FAST
    freopen("checklist.in", "r", stdin);
    freopen("checklist.out", "w", stdout);
    cin >> h >> g;
    int x, y;
    FOR (i, h) {
        cin >> x >> y;
        pair<int, int> p;
        p.first = x;
        p.second = y;
        hol.push_back(p);
    }
    FOR (i, g) {
        cin >> x >> y;
        pair<int, int> p;
        p.first = x;
        p.second = y;
        gur.push_back(p);
    }
    
    int dp[h][g + 1][2];
    FOR(i, g + 1) {
        dp[0][i][0] = -1;
    }
    FOR(i, h) {
        dp[i][0][1] = -1;
    }
    int tot = 0;
    for (int i = 1; i < h; i++) {
        tot += dist(hol[i - 1], hol[i]);
        dp[i][0][0] = tot;
    }
    dp[0][1][1] = dist(hol[0], gur[0]);
    for (int i = 2; i < g + 1; i++) {
        dp[0][i][1] = dp[0][i - 1][1] + dist(gur[i - 2], gur[i - 1]);
    }
    for (int i = 1; i < h; i++) {
        for (int j = 1; j < g + 1; j++) {
            x = dp[i - 1][j][0];
            y = dp[i - 1][j][1];
            if (x == -1) {
                dp[i][j][0] = y + dist(gur[j - 1], hol[i]);
            } else if (y == -1) {
                dp[i][j][0] = x + dist(hol[i - 1], hol[i]);
            } else {
                dp[i][j][0] = min(x + dist(hol[i - 1], hol[i]), y + dist(gur[j - 1], hol[i]));
            }
            x = dp[i][j - 1][0];
            y = dp[i][j - 1][1];
            if (x == -1) {
                dp[i][j][1] = y + dist(gur[j - 1], gur[j - 2]);
            } else if (y == -1) {
                dp[i][j][1] = x + dist(hol[i], gur[j - 1]);
            } else {
                dp[i][j][1] = min(x + dist(hol[i], gur[j - 1]), y + dist(gur[j - 1], gur[j - 2]));
            }
        }
    }
    println(dp[h - 1][g][0]);
}
