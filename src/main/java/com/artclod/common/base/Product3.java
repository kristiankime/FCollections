package com.artclod.common.base;

import java.util.Iterator;

import com.google.common.collect.Iterators;

public interface Product3<E1, E2, E3> extends Product2<E1, E2> {

	public E3 get3();
	
	public default int productArity() {
		return 3;
	}
	
	public default Object productElement(int n) {
		switch (n) {
			case 0: return get1();
			case 1: return get2();
			case 2: return get3();
			default: throw new IndexOutOfBoundsException("range [0," +productArity() +"] index requested: " + n);
		}
	}
	
	public default Iterator<Object> iterator() {
		return Iterators.forArray(get1(), get2(), get3());
	}
	
}
