package de.stylextv.udp.board;

import java.util.HashSet;

import de.stylextv.udp.main.Main;

public class Board {
	
	private static final Hash[] INDEX_MASKS = new Hash[Main.MAX_N * Main.MAX_N];
	
	static {
		for(int i = 0; i < INDEX_MASKS.length; i++) {
			
			Hash h = new Hash(i + 1);
			
			h.flipBit(i);
			
			INDEX_MASKS[i] = h;
		}
	}
	
	private int n;
	
	private Hash hash;
	
	private int count;
	
	private int[] indices;
	
	private HashSet<Integer> usedDistances;
	
	private Hash[] symmetries;
	
	public Board(int n) {
		this.n = n;
		this.hash = new Hash(n * n);
		this.indices = new int[n];
		this.usedDistances = new HashSet<>();
		this.symmetries = new Hash[8];
	}
	
	public Board(int n, Hash hash) {
		this(n);
		
		this.count = hash.bitCount();
		
		this.hash = hash;
	}
	
	public boolean hasUsedDistance(HashSet<Integer> set) {
		for(int dis : set) {
			if(usedDistances.contains(dis)) return true;
		}
		
		return false;
	}
	
	public boolean isSymmetricalTo(Board b) {
		for(Hash hash : b.getSymmetries()) {
			if(isSymmetricalTo(hash)) return true;
		}
		
		return false;
	}
	
	private boolean isSymmetricalTo(Hash hash) {
		for(Hash h : symmetries) {
			if(h.equals(hash)) return true;
		}
		
		return false;
	}
	
	public void print() {
		String[] arr = new String[n];
		
		print(arr, 0);
		
		for(String s : arr) System.out.println(s);
		
		System.out.println();
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
			symmetries[j] = hash.clone();
			
			mirror();
			
			symmetries[j + 1] = hash.clone();
			
			mirror();
			
			rotate();
			
			j += 2;
		}
	}
	
	private void rotate() {
		Hash newHash = new Hash(hash.getMaxLength());
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				
				if(isFlipped(x, y)) {
					int newX = n - 1 - y;
					int newY = x;
					
					int index = newY * n + newX;
					
					newHash.add(INDEX_MASKS[index]);
				}
			}
		}
		
		hash = newHash;
	}
	
	private void mirror() {
		Hash newHash = new Hash(hash.getMaxLength());
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				
				if(isFlipped(x, y)) {
					int newX = x;
					int newY = n - 1 - y;
					
					int index = newY * n + newX;
					
					newHash.add(INDEX_MASKS[index]);
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
	
	public Hash getHash() {
		return hash;
	}
	
	public boolean isFlipped(int x, int y) {
		return isFlipped(y * n + x);
	}
	
	public boolean isFlipped(int index) {
		return hash.includes(INDEX_MASKS[index]);
	}
	
	public void setFlipped(int index, boolean b) {
		if(isFlipped(index) != b) {
			
			hash.flip(INDEX_MASKS[index]);
			
			if(b) {
				indices[count] = index;
			}
			
			count += b ? 1 : -1;
		}
	}
	
	public void addUsedDistances(HashSet<Integer> set) {
		usedDistances.addAll(set);
	}
	
	public void removeUsedDistances(HashSet<Integer> set) {
		usedDistances.removeAll(set);
	}
	
	public int getN() {
		return n;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getIndex(int i) {
		return indices[i];
	}
	
	public Hash[] getSymmetries() {
		return symmetries;
	}
	
	private static boolean compareHashes(Hash hash1, Hash hash2) {
		if(hash1.equals(hash2)) return false;
		
		Hash l1 = hash1.getLowestBit();
		Hash l2 = hash2.getLowestBit();
		
		if(!l1.equals(l2)) return l1.compareTo(l2) < 0;
		return compareHashes(Hash.xor(hash1, l1), Hash.xor(hash2, l2));
	}
	
}
