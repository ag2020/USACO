#include <bits/stdc++.h>
using namespace std;
#define FOR(i, a) for(int i=0;i<a;i++)

int main() { ios::sync_with_stdio(0); cin.tie(0);
    freopen("cowdate.in", "r", stdin);
    freopen("cowdate.out", "w", stdout);
    int n;
    cin >> n;
    long double arr[n];
    FOR(i, n) {
        cin >> arr[i];
        arr[i] /= 1000000.0;
    }
    long double product[n + 1];
    product[0] = 1.0;
    FOR(i, n) product[i + 1] = product[i] * (1 - arr[i]);
    long double sum[n + 1];
    sum[0] = 0.0;
    FOR(i, n) sum[i + 1] = sum[i] + (arr[i] / (1 - arr[i]));
    int lo, high, mid;
    long double maximum = 0.0;
    long double d;
    for (int i = 1; i <= n; i++) {
        lo = i;
        high = n;
        while (lo != high) {
            mid = lo + (high - lo + 1) / 2;
            if (sum[mid] - sum[i - 1] < 1) lo = mid;
            else high = mid - 1;
        }
        if (lo == n || lo == i && arr[i - 1] >= 0.5) lo--;
        d = (product[lo + 1]) * (sum[lo + 1] - sum[i - 1]) / product[i - 1];
        maximum = max(maximum, d);
    }
    cout << int(1000000.0 * maximum) << '\n';
}
