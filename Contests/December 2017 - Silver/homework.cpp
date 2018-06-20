#include <bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(0); cin.tie(0);
#define println(x) cout << x << '\n'
#define FOR(i, a) for(int i=0;i<a;i++)
#define F0R(i, a, b) for(int i=a;i<b;i++)

int n;

int main() { FAST
    freopen("homework.in", "r", stdin);
    freopen("homework.out", "w", stdout);
    cin >> n;
    int x;
    int total = 0;
    vector<int> nums;
    FOR(i, n) {
        cin >> x;
        total += x;
        nums.push_back(x);
    }
    double max = 0;
    double ave;
    vector<int> poss;
    for (int i = 1; i <= n - 2; i++) {
        total -= nums[i - 1];
        ave = (total + 0.0) / (n - i);
        if (ave > max) {
            poss.clear();
            poss.push_back(i);
            max = ave;
        } else if (ave == max) {
            poss.push_back(i);
        }
    }
    FOR(i, poss.size()) {
        println(poss[i]);
    }
}
