/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xuemaomao
 * design a two Sum class, implement 2 operations
 * add(input)
 * find(value)
 * add(1), add(3), add(5), find(4)-true
 */
public class TwoSumDesign {
	public static void main(String[] args) {
		TwoSumiii2 obj = new TwoSumiii2();
		obj.add(1);
		obj.add(3);
		obj.add(6);
		obj.add(3);
		boolean p = obj.find(8);
		System.out.println(p);
	}
}

class TwoSumiii {
	//quick add
	//add time: O(1), find time: O(n), space: O(n)
	Map<Integer, Integer> map;
	
	public TwoSumiii() {
		map = new HashMap<>();
	}
	//Add the number to an internal data structure
	public void add(int number) {
		if (!map.containsKey(number)) {
			map.put(number, 1);
		} else {
			map.put(number, map.get(number) + 1);
		}
	}
	
	//find if there exists any pair of numbers which sum is equal to the value
	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int i = entry.getKey();
			int j = value - i;
			if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
				return true;
			}
		}
		return false;
	}	
}
//quick find, find: O(1), add: O(n), space: O(n)
class TwoSumiii2 {
	Set<Integer> sum;
	Set<Integer> num;
	
	TwoSumiii2() {
		sum = new HashSet<>();
		num = new HashSet<>();
	}
	//Add
	public void add(int number) {
		if (num.contains(number)) {
			sum.add(number * 2);
		} else {
//			Iterator<Integer> iter = num.iterator();
//			while (iter.hasNext()) {
//				sum.add(iter.next() + number);
//			}
			for (Integer i : num) {
				sum.add(i + number);
			}
			num.add(number);
		}
	}
	
	//Find
	public boolean find(int value) {
		return sum.contains(value);
	}
}
