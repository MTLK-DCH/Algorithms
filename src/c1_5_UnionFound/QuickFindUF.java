package c1_5_UnionFound;

public class QuickFindUF {
    //以数组来保存并查集所需要的树
    private int[] id;
    //记录每棵树的大小
    //目的是为了在合并两棵树的时候将小树合并到大树
    //减少过深的树的出现以提高效率
    private int[] sz;

    public QuickFindUF(int N) {
        //生成树
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;  //每棵树暂时只有一个节点
        }
    }

    public int root(int i) {
        //寻根溯源
        while (i != id[i]) {
            //优化！
            id[i] = id[id[i]];
            //这里多加的一行代码可以在搜索的时候以很小的代价将树几乎展平，进一步提高效率
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        //由于使用了树这种数据结构，判断两元素是否链接就可以采用判断二者的根是否相同来实现
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        //链接两元素，意味着被两元素链接的所有元素都被链接
        //因此可以通过合并两棵树来实现
        int i = root(p);
        int j = root(q);
        //将小树合并到大树上去，提高搜索效率
        if (sz[i] < sz[j]) {
            id[i] = id[j];
            sz[j] += sz[i];
        } else {
            id[j] = id[i];
            sz[i] += sz[j];
        }
    }
}