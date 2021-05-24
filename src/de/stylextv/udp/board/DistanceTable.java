package de.stylextv.udp.board;

public class DistanceTable {
	
	private static final DistanceTable[] TABLES = new DistanceTable[15];
	
	private int[][] table;
	
	public DistanceTable(int n) {
		int length = n * n;
		
		this.table = new int[length][length];
		
		computeTable(n, length - 1);
	}
	
	private void computeTable(int n, int max) {
		for(int index1 = 0; index1 <= max; index1++) {
			for(int index2 = 0; index2 <= max; index2++) {
				
				int x1 = index1 % n;
				int y1 = index1 / n;
				
				int x2 = index2 % n;
				int y2 = index2 / n;
				
				int dx = x2 - x1;
				int dy = y2 - y1;
				
				int dis = dx * dx + dy * dy;
				
				table[index1][index2] = dis;
			}
		}
	}
	
	public int getDistance(int index1, int index2) {
		return table[index1][index2];
	}
	
	public static final int getDistance(int n, int index1, int index2) {
		DistanceTable t = TABLES[n];
		
		if(t == null) {
			t = new DistanceTable(n);
			
			TABLES[n] = t;
		}
		
		return t.getDistance(index1, index2);
	}
	
}
