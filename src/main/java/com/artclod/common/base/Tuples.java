package com.artclod.common.base;

public class Tuples {

	public static <E1, E2> T2<E1, E2> t(E1 e1, E2 e2){
		return new T2<E1, E2>(e1, e2);
	}
	
	public static <E1, E2, E3> T3<E1, E2, E3> t(E1 e1, E2 e2, E3 e3){
		return new T3<E1, E2, E3>(e1, e2, e3);
	}
	
}
