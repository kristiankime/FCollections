package com.artclod.common.base;

import java.util.Iterator;

import com.google.common.collect.Iterators;

public interface Product7<E1, E2, E3, E4, E5, E6, E7> extends Product6<E1, E2, E3, E4, E5, E6> {

	public E7 get7();

	public default int productArity() {
		return 7;
	}
	
	public default Object productElement(int n) {
		switch (n) {
			case 0: return get1();
			case 1: return get2();
			case 2: return get3();
			case 3: return get4();
			case 4: return get5();
			case 5: return get6();
			case 6: return get7();
			default: throw new IndexOutOfBoundsException("range [0," +productArity() +"] index requested: " + n);
		}
	}
		
	public default Iterator<Object> iterator() {
		return Iterators.forArray(get1(), get2(), get3(), get4(), get5(), get6(), get7());
	}
}
