#include <bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(false); cin.tie(NULL);
#define println(x) cout << x << '\n'
#define FOR(i, a) for(int i=0;i<a;i++)
#define F0R(i, a, b) for(int i=a;i<b;i++)

struct Line {
    public:
        int val;
        bool horiz;
        bool operator==(const Line &other) const {
            return val == other.val && horiz == other.horiz;
        }
};

namespace std {
    template <>
    struct hash<Line>
    {
        std::size_t operator()(const Line& k) const
        {
            using std::size_t;
            using std::hash;
            using std::string;
            
            return 2 * k.val + ((k.horiz) ? 0 : 1);
        }
    };
    
}

int n, xl, yl, xb, yb;
unordered_map<Line, int> dist;
unordered_map<int, vector<int>* > xtoy;
unordered_map<int, vector<int>* > ytox;
queue<Line> q;

int main() { FAST
    freopen("lasers.in", "r", stdin);
    freopen("lasers.out", "w", stdout);
    cin >> n >> xl >> yl >> xb >> yb;
    Line l; l.val = xl; l.horiz = false;
    Line l2; l2.val = yl; l2.horiz = true;
    q.push(l);
    q.push(l2);
    dist[l] = 0;
    dist[l2] = 0;
    FOR(i, n) {
        int x, y;
        cin >> x >> y;
        vector<int>* vec;
        if (xtoy.find(x) != xtoy.end()) {
            vec = xtoy.at(x);
        } else {
            vec = new vector<int>();
        }
        vec->push_back(y);
        xtoy[x] = vec;
        vector<int>* vec2;
        if (ytox.find(y) != ytox.end()) {
            vec2 = ytox.at(y);
        } else {
            vec2 = new vector<int>();
        }
        vec2->push_back(x);
        ytox[y] = vec2;
    }
    while (q.size() > 0) {
        Line lin = q.front();
        q.pop();
        if ((lin.val == xb && !lin.horiz) || (lin.val == yb && lin.horiz)) {
            println(dist.at(lin));
            return 0;
        }
        unordered_map<int, vector<int>* >* src;
        if (lin.horiz) {
            src = &ytox;
        } else {
            src = &xtoy;
        }
        if (src->find(lin.val) != src->end()) {
            vector<int> vect = *src->at(lin.val);
            FOR(i, vect.size()) {
                int next = vect[i];
                Line li; li.val = next; li.horiz = !lin.horiz;
                if (dist.find(li) == dist.end()) {
                    dist[li] = dist.at(lin) + 1;
                    q.push(li);
                }
            }
        }
    }
    println(-1);
}
