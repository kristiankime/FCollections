package com.artclod.common.base;

public class Tuples {

	public static <E1, E2> T2<E1, E2> t(E1 e1, E2 e2){
		return new T2<E1, E2>(e1, e2);
	}
	
}
