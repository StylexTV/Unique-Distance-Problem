package de.stylextv.udp.main;

import java.util.ArrayList;
import java.util.HashSet;

import de.stylextv.udp.board.Board;
import de.stylextv.udp.board.DistanceTable;
import de.stylextv.udp.board.Hash;

public class Main {
	
	public static final int MAX_N = 15;
	
	public static void main(String[] args) {
		for(int n = 1; n <= MAX_N; n++) {
			
			long time = System.currentTimeMillis();
			
			ArrayList<Board> solutions = startSimulation(n);
			
			long now = System.currentTimeMillis();
			
			int l = solutions.size();
			
			System.out.println("n = " + n + ", solutions = " + l + ", time = " + (now - time) + "\n");
			
			int width = (int) Math.min(5, Math.sqrt(l));
			
			int height = (int) Math.ceil((float) l / width);
			
			int step = n + 1;
			
			String[] arr = new String[height * step];
			
			for(int i = 0; i < l; i++) {
				Board b = solutions.get(i);
				
				int y = i / width;
				
				b.print(arr, step * y);
			}
			
			for(String s : arr) System.out.println(s == null ? "" : s);
		}
	}
	
	private static ArrayList<Board> startSimulation(int n) {
		ArrayList<Hash> solutions = new ArrayList<>();
		
		Board b = new Board(n);
		
		int length = n * n;
		
		runSimulation(solutions, b, length, 0);
		
		return removeSymmetries(solutions, n);
	}
	
	private static void runSimulation(ArrayList<Hash> solutions, Board b, int length, int start) {
		if(b.isFull()) {
			
			solutions.add(b.getHash().clone());
			
			return;
		}
		
		if(start >= length) return;
		
		int half = length / 2;
		
		int halfCount = b.getN() / 2;
		
		if(start == half && b.getCount() < halfCount) {
			return;
		}
		
		runSimulation(solutions, b, length, start + 1);
		
		HashSet<Integer> distances = DistanceTable.getDistances(start, b);
		
		if(distances != null && !b.hasUsedDistance(distances)) {
			
			b.setFlipped(start, true);
			
			b.addUsedDistances(distances);
			
			runSimulation(solutions, b, length, start + 1);
			
			b.setFlipped(start, false);
			
			b.removeUsedDistances(distances);
		}
	}
	
	private static ArrayList<Board> removeSymmetries(ArrayList<Hash> list, int n) {
		ArrayList<Board> solutions = new ArrayList<>();
		
		for(Hash hash : list) {
			
			Board b = new Board(n, hash);
			
			b.updateSymmetries();
			
			boolean included = false;
			
			for(Board b2 : solutions) {
				if(b.isSymmetricalTo(b2)) {
					included = true;
					
					break;
				}
			}
			
			if(!included) {
				b.orientate();
				
				solutions.add(b);
			}
		}
		
		solutions.sort((b1, b2) -> b2.getHash().compareTo(b1.getHash()));
		
		return solutions;
	}
	
}
