package com.vidya.leetcode.fb;

import java.util.Locale;

/**
 * 211. Design Add and Search Words Data Structure
 * <p>
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * <p>
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search.
 */
public class DesignAddAndSearchWordsDataStructure {

    private TrieNode trieNode;

    public static void main(String[] args) {

        DesignAddAndSearchWordsDataStructure wordDictionary = new DesignAddAndSearchWordsDataStructure();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println( wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    /**
     * Initialize your data structure here.
     */
    public DesignAddAndSearchWordsDataStructure() {
        trieNode = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String string) {
        TrieNode node = trieNode;

        for (char c : string.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        return match(word.toCharArray(), 0, trieNode);
    }

    private boolean match(char[] chars, int i, TrieNode trieNode) {

        if(i == chars.length){
            return trieNode.isWord;
        }

        if(chars[i] == '.'){
                for(int k = 0;k<trieNode.children.length;k++){
                    if(trieNode.children[k] !=null &&match(chars,i+1, trieNode.children[k])){
                        return true;
                    }
                }
        }else{
            return trieNode.children[chars[i]-'a'] !=null && match(chars,i+1,trieNode.children[chars[i]-'a']);
        }

        return false;
    }

}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
}


