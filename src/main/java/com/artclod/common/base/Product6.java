package com.artclod.common.base;

import java.util.Iterator;

import com.google.common.collect.Iterators;

public interface Product6<E1, E2, E3, E4, E5, E6> extends Product5<E1, E2, E3, E4, E5> {

	public E6 get6();

	public default int productArity() {
		return 6;
	}
	
	public default Object productElement(int n) {
		switch (n) {
			case 0: return get1();
			case 1: return get2();
			case 2: return get3();
			case 3: return get4();
			case 4: return get5();
			case 5: return get6();
			default: throw new IndexOutOfBoundsException("range [0," +productArity() +"] index requested: " + n);
		}
	}
		
	public default Iterator<Object> iterator() {
		return Iterators.forArray(get1(), get2(), get3(), get4(), get5(), get6());
	}
}
