#include <bits/stdc++.h>
using namespace std;
#define FOR(i, a) for(int i=0;i<a;i++)

int n, m, fx, fy, bx, by;
string sf, sb;

struct Location {
    int x;
    int y;
};

int dist(Location* l1, Location* l2) {
    return (l1->x - l2->x) * (l1->x - l2->x) + (l1->y - l2->y) * (l1->y - l2->y);
}

int main() { ios::sync_with_stdio(0); cin.tie(0);
    freopen("radio.in", "r", stdin);
    freopen("radio.out", "w", stdout);
    cin >> n >> m >> fx >> fy >> bx >> by >> sf >> sb;
    Location* flocs[n + 1];
    int x = fx, y = fy;
    Location* loc2 = new Location; loc2->x = fx; loc2->y = fy;
    flocs[0] = loc2;
    for (int i = 1; i <= n; i++) {
        if (sf[i - 1] == 'N') {y++;}
        else if (sf[i - 1] == 'S') {y--;}
        else if (sf[i - 1] == 'E') {x++;}
        else {x--;}
        Location* loc = new Location; loc->x = x; loc->y = y;
        flocs[i] = loc;
    }
    Location* blocs[m + 1];
    x = bx; y = by;
    Location* loc3 = new Location; loc3->x = bx; loc3->y = by;
    blocs[0] = loc3;
    for (int i = 1; i <= m; i++) {
        if (sb[i - 1] == 'N') {y++;}
        else if (sb[i - 1] == 'S') {y--;}
        else if (sb[i - 1] == 'E') {x++;}
        else {x--;}
        Location* loc = new Location; loc->x = x; loc->y = y;
        blocs[i] = loc;
    }
    int dp[n + 1][m + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
        dp[i][0] = dp[i - 1][0] + dist(blocs[0], flocs[i]);
    }
    for (int i = 1; i <= m; i++) {
        dp[0][i] = dp[0][i - 1] + dist(flocs[0], blocs[i]);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            dp[i][j] = min(min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + dist(flocs[i], blocs[j]);
        }
    }
    cout << dp[n][m] << '\n';
}
