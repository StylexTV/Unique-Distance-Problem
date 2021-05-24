package de.stylextv.udp.board;

import java.util.HashSet;

public class Board {
	
	private int n;
	
	private long hash;
	
	private int count;
	
	private int[] indices;
	
	private long[] symmetries;
	
	public Board(int n) {
		this.n = n;
		this.indices = new int[n];
		this.symmetries = new long[8];
	}
	
	public Board(int n, long hash) {
		this(n);
		
		this.count = Long.bitCount(hash);
		
		this.hash = hash;
	}
	
	public boolean isValid() {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < n - 1; i++) {
			if(!isValid(set, i, indices[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isValid(HashSet<Integer> set, int i, int index) {
		for(int j = i + 1; j < n; j++) {
			int index2 = indices[j];
			
			int dis = DistanceTable.getDistance(n, index, index2);
			
			if(set.contains(dis)) return false;
			
			set.add(dis);
		}
		
		return true;
	}
	
	public boolean isSymmetricalTo(Board b) {
		for(long hash : b.getSymmetries()) {
			if(isSymmetricalTo(hash)) return true;
		}
		
		return false;
	}
	
	private boolean isSymmetricalTo(long hash) {
		for(long l : symmetries) {
			if(l == hash) return true;
		}
		
		return false;
	}
	
	public void print(String[] arr, int offset) {
		for(int y = 0; y < n; y++) {
			String s = "";
			
			for(int x = 0; x < n; x++) {
				s += (isFlipped(x, y) ? "X" : ".") + (x < n - 1 ? " " : "");
			}
			
			String s2 = arr[offset + y];
			
			if(s2 != null) s2 += "   ";
			else s2 = "";
			
			arr[offset + y] = s2 + s;
		}
	}
	
	public boolean isFull() {
		return count == n;
	}
	
	public void updateSymmetries() {
		int j = 0;
		
		for(int i = 0; i < 4; i++) {
			symmetries[j] = getHash();
			
			mirror();
			
			symmetries[j + 1] = getHash();
			
			mirror();
			
			rotate();
			
			j += 2;
		}
	}
	
	private void rotate() {
		long newHash = 0;
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				
				if(isFlipped(x, y)) {
					int newX = n - 1 - y;
					int newY = x;
					
					int index = newY * n + newX;
					
					long key = 1l << index;
					
					newHash |= key;
				}
			}
		}
		
		hash = newHash;
	}
	
	private void mirror() {
		long newHash = 0;
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				
				if(isFlipped(x, y)) {
					int newX = x;
					int newY = n - 1 - y;
					
					int index = newY * n + newX;
					
					long key = 1l << index;
					
					newHash |= key;
				}
			}
		}
		
		hash = newHash;
	}
	
	public void orientate() {
		int i = 0;
		
		for(int j = 1; j < symmetries.length; j++) {
			if(compareHashes(symmetries[j], symmetries[i])) {
				i = j;
			}
		}
		
		int rotateAmount = i / 2;
		boolean mirror = i % 2 != 0;
		
		for(int j = 0; j < rotateAmount; j++) {
			rotate();
		}
		
		if(mirror) mirror();
	}
	
	public long getHash() {
		return hash;
	}
	
	public boolean isFlipped(int x, int y) {
		return isFlipped(y * n + x);
	}
	
	public boolean isFlipped(int index) {
		long key = 1l << index;
		
		return (hash & key) != 0;
	}
	
	public void setFlipped(int index, boolean b) {
		long key = 1l << index;
		
		if(((hash & key) != 0) != b) {
			
			hash ^= key;
			
			if(b) indices[count] = index;
			
			count += b ? 1 : -1;
		}
	}
	
	public int getN() {
		return n;
	}
	
	public int getCount() {
		return count;
	}
	
	public long[] getSymmetries() {
		return symmetries;
	}
	
	private static boolean compareHashes(long hash1, long hash2) {
		if(hash1 == hash2) return false;
		
		long l1 = Long.lowestOneBit(hash1);
		long l2 = Long.lowestOneBit(hash2);
		
		if(l1 != l2) return l1 < l2;
		return compareHashes(hash1 ^ l1, hash2 ^ l2);
	}
	
}
