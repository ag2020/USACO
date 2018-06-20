#include <bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(0); cin.tie(0);
#define println(x) cout << x << '\n'
#define FOR(i, a) for(int i=0;i<a;i++)
#define F0R(i, a, b) for(int i=a;i<b;i++)

int n;

bool cmp (pair<int, int> p1, pair<int, int> p2) {
    if (p1.second == p2.second) {
        return p1.first < p2.first;
    }
    return p1.second < p2.second;
}

int main() { FAST
    freopen("split.in", "r", stdin);
    freopen("split.out", "w", stdout);
    cin >> n;
    pair<int, int> locs[n];
    int x, y;
    int minx = -1; int maxx = -1; int miny = -1; int maxy = -1;
    FOR (i, n) {
        cin >> x >> y;
        if (minx == -1 || x < minx) {minx = x;}
        if (miny == -1 || y < miny) {miny = y;}
        if (x > maxx) {maxx = x;}
        if (y > maxy) {maxy = y;}
        locs[i] = make_pair(x, y);
    }
    sort(locs, locs + n);
    long long int aleft[n];
    aleft[0] = 0;
    int max = locs[0].second;
    int min = locs[0].second;
    F0R (i, 1, n) {
        if (locs[i].second > max) {
            max = locs[i].second;
        }
        if (locs[i].second < min) {
            min = locs[i].second;
        }
        aleft[i] = (long long int)(max - min) * (long long int)(locs[i].first - minx);
    }
    long long int aright[n];
    aright[n - 1] = 0;
    max = locs[n - 1].second;
    min = locs[n - 1].second;
    for (int i = n - 2; i >= 0; i--) {
        if (locs[i].second > max) {
            max = locs[i].second;
        }
        if (locs[i].second < min) {
            min = locs[i].second;
        }
        aright[i] = (long long int)(max - min) * (long long int)(maxx - locs[i].first);
    }
    long long int minTot = -1;
    long long int a;
    for (int i = 0; i < n - 1; i++) {
        a = aleft[i] + aright[i + 1];
        if (minTot == -1 || a < minTot) {
            minTot = a;
        }
    }
    sort(locs, locs + n, cmp);
    long long int abot[n];
    abot[0] = 0;
    max = locs[0].first;
    min = max;
    F0R(i, 1, n) {
        if (locs[i].first > max) {
            max = locs[i].first;
        }
        if (locs[i].first < min) {
            min = locs[i].first;
        }
        abot[i] = (long long int)(max - min) * (long long int)(locs[i].second - miny);
    }
    long long int atop[n];
    atop[n - 1] = 0;
    max = locs[n - 1].first;
    min = max;
    for (int i = n - 2; i >= 0; i--) {
        if (locs[i].first > max) {
            max = locs[i].first;
        }
        if (locs[i].first < min) {
            min = locs[i].first;
        }
        atop[i] = (long long int)(max - min) * (long long int)(maxy - locs[i].second);
    }
    FOR (i, n - 1) {
        a = abot[i] + atop[i + 1];
        if (a < minTot) {
            minTot = a;
        }
    }
    println((long long int)(maxx - minx) * (long long int)(maxy - miny) - minTot);
}
