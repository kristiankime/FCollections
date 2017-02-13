package com.artclod.common.base;

import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Iterators;

public interface Product2<E1, E2> extends Product, Map.Entry<E1, E2> {

	public E1 get1();
	
	public E2 get2();
	
	public default int productArity() {
		return 2;
	}
	
	public default Object productElement(int n) {
		switch (n) {
			case 0: return get1();
			case 1: return get2();
			default: throw new IndexOutOfBoundsException("range [0," +productArity() +"] index requested: " + n);
		}
	}

	public default Iterator<Object> iterator() {
		return Iterators.forArray(get1(), get2());
	}
	
	@Override
	public default E1 getKey() {
		return get1();
	}

	@Override
	public default E2 getValue() {
		return get2();
	}

	@Override
	public default E2 setValue(E2 value) {
		throw new UnsupportedOperationException();
	}
}
