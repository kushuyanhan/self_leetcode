package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumIndexSumofTwoLists {
	
	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Piatti", "The Grill at Torrey Pines", "Shogun"};
		
		String[] res = findRestaurant(list1, list2);
		System.out.println(Arrays.toString(res));
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		int min = Integer.MAX_VALUE;
		List<String> res = new ArrayList<>();
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int sum = map.get(list2[i]) + i;
				if (sum == min) {
					res.add(list2[i]);
				} else if (sum < min) {
					min = sum;
					res.clear();
					res.add(list2[i]);
				}
			}
		}
		return (String[]) res.toArray(new String[res.size()]);
	}
}

//list to String array: (String[]) list.toArray(new String[list.size()]);
//String array to list: Arrays.asList(arr);
