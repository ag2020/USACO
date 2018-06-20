#include <bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(0); cin.tie(0);
#define println(x) cout << x << '\n'
#define FOR(i, a) for(int i=0;i<a;i++)
#define F0R(i, a, b) for(int i=a;i<b;i++)

int n;

bool check(int cow, int jump[]) {
    int arr[n + 1];
    memset(arr, 0, sizeof(arr));
    FOR(i, cow) {
        arr[jump[i]]++;
    }
    int total = 0;
    for (int i = 1; i <= cow; i++) {
        total += arr[i];
        if (total >= i) {
            return true;
        }
    }
    return false;
}

int main() { FAST
    freopen("greedy.in", "r", stdin);
    freopen("greedy.out", "w", stdout);
    cin >> n;
    int jump[n];
    FOR(i, n) {
        cin >> jump[i];
        jump[i] = n - jump[i];
    }
    int min = 0; int max = n - 1; int mid;
    while (min != max) {
        mid = (min + max) / 2;
        if (check(mid, jump)) {
            max = mid;
        } else {
            min = mid + 1;
        }
    }
    println(n - min);
}
