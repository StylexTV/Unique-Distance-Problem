package de.stylextv.udp.board;

public class Hash {
	
	private static final long[] BIT_SET = new long[64];
	
	static {
		for(int i = 0; i < BIT_SET.length; i++) {
			BIT_SET[i] = 1l << i;
		}
	}
	
	private long[] values;
	
	public Hash(int maxLength) {
		this.values = new long[(int) Math.ceil(maxLength / 64f)];
	}
	
	public Hash(long[] values) {
		this.values = new long[values.length];
		
		for(int i = 0; i < values.length; i++) {
			this.values[i] = values[i];
		}
	}
	
	public void add(Hash hash) {
		int l = Math.min(values.length, hash.getValues().length);
		
		for(int i = 0; i < l; i++) {
			values[i] |= hash.getValues()[i];
		}
	}
	
	public boolean equals(Hash hash) {
		return compareTo(hash) == 0;
	}
	
	public boolean includes(Hash hash) {
		int l = Math.min(values.length, hash.getValues().length);
		
		for(int i = 0; i < l; i++) {
			
			long mask = hash.getValues()[i];
			
			if(mask != 0 && (values[i] & mask) == 0) return false;
		}
		
		return true;
	}
	
	public void flip(Hash hash) {
		int l = Math.min(values.length, hash.getValues().length);
		
		for(int i = 0; i < l; i++) {
			values[i] ^= hash.getValues()[i];
		}
	}
	
	public void flipBit(int index) {
		int i = index / 64;
		int j = index % 64;
		
		values[i] ^= BIT_SET[j];
	}
	
	public int bitCount() {
		int count = 0;
		
		for(long l : values) {
			count += Long.bitCount(l);
		}
		
		return count;
	}
	
	public Hash getLowestBit() {
		long[] arr = new long[values.length];
		
		for(int i = 0; i < values.length; i++) {
			
			long l = values[i];
			
			if(l != 0) {
				arr[i] = Long.lowestOneBit(l);
				
				break;
			}
		}
		
		return new Hash(arr);
	}
	
	public int compareTo(Hash hash) {
		for(int i = values.length - 1; i >= 0; i--) {
			
			int result = Long.compare(values[i], hash.getValues()[i]);
			
			if(result != 0) return result;
		}
		
		return 0;
	}
	
	public Hash clone() {
		return new Hash(values);
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(int i = values.length - 1; i >= 0; i--) {
			s += Long.toBinaryString(values[i]) + " ";
		}
		
		return s;
	}
	
	public int getMaxLength() {
		return values.length * 64;
	}
	
	public long[] getValues() {
		return values;
	}
	
	public static Hash xor(Hash hash1, Hash hash2) {
		if(hash1.getMaxLength() != hash2.getMaxLength()) return null;
		
		int l = hash1.getValues().length;
		
		long[] values = new long[l];
		
		for(int i = 0; i < l; i++) {
			values[i] = hash1.getValues()[i] ^ hash2.getValues()[i];
		}
		
		return new Hash(values);
	}
	
}
