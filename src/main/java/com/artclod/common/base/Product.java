package com.artclod.common.base;

public interface Product extends Iterable<Object> {

	public int productArity();
	
	public Object productElement(int n);
	
}
