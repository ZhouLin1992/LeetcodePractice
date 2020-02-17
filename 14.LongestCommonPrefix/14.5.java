class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 初始化的是trie tree
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        
        String result = "";
        TrieNode curr = trie.root;
        // 循环条件是是否为一个单词的终结
        while (!curr.hasWord) {
            // count用于判断下一层是不是有多个分支
            int count = 0;
            int index = 0;
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                    index = i;
                }
            }
            // 如果有多个分支 直接返回结果
            if (count != 1) {
                return result;
            }
            // 继续下一层
            curr = curr.children[index];
            result += curr.ch;
        }
        
        return result;
    }
    
    class TrieNode {
        final int numAlpha = 26;
        TrieNode[] children;
        boolean hasWord;
        char ch;

        public TrieNode(char ch) {
            children = new TrieNode[numAlpha];
            this.ch = ch;
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode[] currChildren = curr.children;
                int index = word.charAt(i) - 'a';

                if (currChildren[index] == null) {
                    currChildren[index] = new TrieNode(word.charAt(i));
                }
                
                curr = currChildren[index];
            }
            curr.hasWord = true;
        }
    }
}