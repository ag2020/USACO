#include <bits/stdc++.h>
using namespace std;
#define FOR(i, a) for(int i=0;i<a;i++)

int n;
long m;
int lookup[100000][17];

long queryBIT(long tree[], int ind) {
    if (ind == -1) return 0;
    long sum = 0;
    ind++;
    while (ind > 0) {
        sum += tree[ind];
        ind -= ind & (-ind);
    }
    return sum;
}

void update(long tree[], int ind, int val) {
    ind++;
    while (ind <= n) {
        tree[ind] += val;
        ind += ind & (-ind);
    }
}

long* construct(int arr[]) {
    long* tree = new long[n + 1];
    FOR(i, n) {
        tree[i + 1] = 0;
    }
    FOR(i, n) {
        update(tree, i, arr[i]);
    }
    return tree;
}

void preprocess(int arr[]) {
    FOR(i, n) lookup[i][0] = i;
    for (int i = 1; (1 << i) <= n; i++) {
        for (int j = 0; (j + (1 << i) - 1) < n; j++) {
            if (arr[lookup[j][i - 1]] > arr[lookup[j + (1 << (i - 1))][i - 1]]) {
                lookup[j][i] = lookup[j][i - 1];
            } else {
                lookup[j][i] = lookup[j + (1 << (i - 1))][i - 1];
            }
        }
    }
}

int querySparse(int arr[], int left, int right) {
    int i = (int)log2(right - left + 1);
    if (arr[lookup[left][i]] >= arr[lookup[right - (1 << i) + 1][i]]) {
        return arr[lookup[left][i]];
    }
    return arr[lookup[right - (1 << i) + 1][i]];
}

int main() { ios::sync_with_stdio(0); cin.tie(0);
    freopen("hayfeast.in", "r", stdin);
    freopen("hayfeast.out", "w", stdout);
    cin >> n >> m;
    int flav[n]; int spice[n];
    FOR(i, n) cin >> flav[i] >> spice[i];
    long* bit = construct(flav);
    preprocess(spice);
    int minSpice = INT_MAX;
    FOR(i, n) {
        int min = i; int max = n - 1; int mid;
        if (queryBIT(bit, max) - queryBIT(bit, i - 1) < m) {
            cout << minSpice << '\n';
            return 0;
        }
        while (min != max) {
            mid = (min + max) / 2;
            long x = queryBIT(bit, mid) - queryBIT(bit, i - 1);
            if (x == m) {
                min = mid;
                break;
            }
            else if (x > m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        int spi = querySparse(spice, i, min);
        if (spi < minSpice) minSpice = spi;
    }
    cout << minSpice << '\n';
}
