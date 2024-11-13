class Solution {
public:
    int strStr(string haystack, string needle) {

        int tl=haystack.size();  
        int pl=needle.size();   //Pattern Length
        int ans=-1;
        if(pl==0) return 0;
        for(int i=0;i<=tl-pl;i++){
            int j;
            for(j=0;j<pl;j++){
                if(haystack[i+j]!=needle[j]) break;    
            }
            if(j==pl) {
                ans=i;
                break;
            }
        }
        return ans;    
    }
};
