#include <bits/stdc++.h>
using namespace std;
#define FOR(i, a) for(int i=0;i<a;i++)

int n;

int query(int tree[], int ind) {
    int sum = 0;
    ind++;
    while (ind > 0) {
        sum += tree[ind];
        ind -= ind & (-ind);
    }
    return sum;
}

void update(int tree[], int n, int ind, int val) {
    ind++;
    while (ind <= n) {
        tree[ind] += val;
        ind += ind & (-ind);
    }
}

int* construct(int arr[], int n) {
    int* tree = new int[n + 1];
    FOR(i, n) {
        tree[i + 1] = 0;
    }
    FOR(i, n) {
        update(tree, n, i, arr[i]);
    }
    return tree;
}

int main() { ios::sync_with_stdio(0); cin.tie(0);
    freopen("bphoto.in", "r", stdin);
    freopen("bphoto.out", "w", stdout);
    cin >> n;
    int arr[n]; int arrsort[n];
    FOR(i, n) {
        cin >> arr[i];
        arrsort[i] = arr[i];
    }
    sort(arrsort, arrsort + n); 
    unordered_map<int, int> ind;
    FOR(i, n) {
        ind[arrsort[i]] = i;
    }
    int bitarr[n];
    FOR(i, n) {
        bitarr[i] = 0;
    }
    int* bit = construct(bitarr, n);
    int count = 0;
    FOR(i, n) {
        int pos = ind[arr[i]];
        update(bit, n, pos, 1);
        int greater = i + 1 - query(bit, pos);
        int total = n - pos - 1;
        if (greater > (total - greater) * 2 || (total - greater) > greater * 2) count++;
    }
    cout << count << '\n';
}
