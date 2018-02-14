/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuemaomao
 *
 */
class Coordinate {
	int x, y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println();
		char[][] grid = {{'1','1','0'},{'0','0','1'},{'0','1','1'}};
		//System.out.println(numIsIslands1(grid));
		System.out.println(numIslands2(grid));
	}
	//method1 dfs
	static int n;
	static int m;
	public static int numIsIslands1(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		n = grid.length;
		if (n == 0) return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					dfsmaking(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private static void dfsmaking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
		grid[i][j] = '0';
		dfsmaking(grid, i + 1, j);
		dfsmaking(grid, i - 1, j);
		dfsmaking(grid, i, j + 1);
		dfsmaking(grid, i, j - 1);
	}
//	
	//method2 bfs
//    private int m, n;
    public static int numIslands2(char[][] grid) {
        //BFS 
        //corner case
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void bfs(char[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            Coordinate cor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate obj = new Coordinate(cor.x + dx[i], cor.y + dy[i]);
                if (!inBound(obj, grid)) {
                    continue;
                }
                if (grid[obj.x][obj.y] == '1') {
                    queue.offer(obj);
                    grid[obj.x][obj.y] = '0';
                }
            }  
        }
    }
    private static boolean inBound(Coordinate obj, char[][] grid) {
        return obj.x >= 0 && obj.x < m && obj.y >= 0 && obj.y < n;
    }
}

//time: O(mn), space: O(max(m,n))
//java stack 是类，Stack<> s = new Stack<>();
//Queue 是接口，能实现Queue的有e. g linkedlist, 还有些不常用的数据结构，但是没有arraylist
