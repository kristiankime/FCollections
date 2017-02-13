package com.artclod.common.base;

import java.util.Iterator;

import com.google.common.collect.Iterators;

public interface Product5<E1, E2, E3, E4, E5> extends Product4<E1, E2, E3, E4> {

	public E5 get5();

	public default int productArity() {
		return 5;
	}
	
	public default Object productElement(int n) {
		switch (n) {
			case 0: return get1();
			case 1: return get2();
			case 2: return get3();
			case 3: return get4();
			case 4: return get5();
			default: throw new IndexOutOfBoundsException("range [0," +productArity() +"] index requested: " + n);
		}
	}
		
	public default Iterator<Object> iterator() {
		return Iterators.forArray(get1(), get2(), get3(), get4(), get5());
	}
}
