/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */

class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;
	public TrieNode() {
		children = new TrieNode[26];
		isEndOfWord = false;
		for (int i = 0; i < 26; i++){
			children[i] = null;
		}
	}
}
public class ImplementTrie {
	public static void main(String[] args) {
		System.out.println();
		Trie root = new Trie();
		root.insert("good");
		root.search("good");
	}
}

class Trie {
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isEndOfWord = true;
	}
	
	public boolean search(String word) {
		TrieNode node = root; 
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
	}
	
	public boolean startWith(String prefix) {
		return false;
	}
}
