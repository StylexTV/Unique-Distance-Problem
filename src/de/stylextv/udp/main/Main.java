package de.stylextv.udp.main;

import java.util.ArrayList;
import java.util.HashSet;

import de.stylextv.udp.board.Board;

public class Main {
	
	public static void main(String[] args) {
		for(int n = 1; n <= 15; n++) {
			
			ArrayList<Board> solutions = startSimulation(n);
			
			int l = solutions.size();
			
			System.out.println("n = " + n + ", solutions = " + l + "\n");
			
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
		HashSet<Long> solutions = new HashSet<>();
		
		Board b = new Board(n);
		
		int length = n * n;
		
		runSimulation(solutions, b, length, 0);
		
		return removeSymmetries(solutions, n);
	}
	
	private static void runSimulation(HashSet<Long> solutions, Board b, int length, int start) {
		if(b.isFull()) {
			
			if(b.isValid()) {
				solutions.add(b.getHash());
			}
			
			return;
		}
		
		if(start >= length || (start > length / 2 && b.getCount() == 0)) return;
		
		runSimulation(solutions, b, length, start + 1);
		
		b.setFlipped(start, true);
		
		runSimulation(solutions, b, length, start + 1);
		
		b.setFlipped(start, false);
	}
	
	private static ArrayList<Board> removeSymmetries(HashSet<Long> set, int n) {
		ArrayList<Board> solutions = new ArrayList<>();
		
		for(long hash : set) {
			
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
		
		solutions.sort((b1, b2) -> Long.compare(b2.getHash(), b1.getHash()));
		
		return solutions;
	}
	
}
