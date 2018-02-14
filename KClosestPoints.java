/**
 * 
 */
package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xuemaomao
 * Given points =[[4,6],[4,7],[4,4],[2,5],[1,1]], origin =[0, 0], k =3
return[[1,1],[2,5],[4,4]] 返回距离origin最近的k个点。
用maxheap, 求得k个最近的点
 */

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
public class KClosestPoints {
	public static void main(String[] args) {
		System.out.println();
		Point origin = new Point(0, 0);
		Point[] points = new Point[5];
		Point p1 = new Point(4,6);
		Point p2 = new Point(4,7);
	
		
		int k = 1;
		Point[] res = findKClosestPoints(points, k, origin);
		System.out.println(res);
	}
	 //private Point global_origin;
	public static Point[] findKClosestPoints(Point[] points, int k, Point target) {
		if (points == null || points.length == 0 || k < 1 || k > points.length)   return points;
	    PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
	        public int compare(Point p1, Point p2) {
	            int d1 = (p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y);
	            int d2 = (p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y);
	            return d2 - d1;
	        }
	    });
	    for (Point p : points) {
	        pq.offer(p);
	        if (pq.size() > k)
	            pq.poll();
	    }
	    Point[] res = new Point[k];
	    for (int i = k - 1; i >= 0; i--) 
	        res[i] = pq.poll();
	    return res;
	}

}