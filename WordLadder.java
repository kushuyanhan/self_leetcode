/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

/**
 * @author xuemaomao
 * find the shortest transformation sequence from begin word to end word. Each transformed word must 
 * be in the dict.
 */
public class WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> dict = new ArrayList<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		System.out.println(ladderLength(beginWord, endWord, dict));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList);
		if (set.contains(beginWord)) {
			set.remove(beginWord);
		}
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		map.put(beginWord, 1);
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int curLevel = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] wordUnit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordUnit[i] = j;
					String temp = new String(wordUnit);
					if (set.contains(temp)) {
						if (temp.equals(endWord)) {
							return curLevel + 1;
						}
						map.put(temp, curLevel + 1);
						queue.offer(temp);
						set.remove(temp); //一旦找到一个dic 中的单词，就要从dic 中删去，如果不删，就会以后别的又转到这个单词，走来走去，重复了，路径就变长了，不是最短的路径
					}
				}
			}
		}
		return 0;
	}	
}
//time: O(n*average length of word) 近似于O(n), space: O(n) due to queue
