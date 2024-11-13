class Solution {
public:
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        int target=subRoot->val;
        queue<TreeNode*> q;
        if(root){
            q.push(root);
        }
        while(!q.empty()){
            TreeNode* cur=q.front();
            q.pop();
            if(cur->left)
                q.push(cur->left);
            if(cur->right)
                q.push(cur->right);
            if(cur->val==target && isSameTree(cur,subRoot))
                return true;
        }
        return false;
    }
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == NULL && q == NULL) {
            return true;
        }
        if (p == NULL || q == NULL || p->val != q->val) {
            return false;
        }
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};
