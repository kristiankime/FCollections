package com.artclod.common.base;

public class Tuples {

	public static <E1, E2> T2<E1, E2> t(E1 e1, E2 e2){
		return new T2<>(e1, e2);
	}
	
	public static <E1, E2, E3> T3<E1, E2, E3> t(E1 e1, E2 e2, E3 e3){
		return new T3<>(e1, e2, e3);
	}
	
	public static <E1, E2, E3, E4> T4<E1, E2, E3, E4> t(E1 e1, E2 e2, E3 e3, E4 e4){
		return new T4<>(e1, e2, e3, e4);
	}
	
	public static <E1, E2, E3, E4, E5> T5<E1, E2, E3, E4, E5> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5){
		return new T5<>(e1, e2, e3, e4, e5);
	}
	
	public static <E1, E2, E3, E4, E5, E6> T6<E1, E2, E3, E4, E5, E6> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6){
		return new T6<>(e1, e2, e3, e4, e5, e6);
	}
	
	public static <E1, E2, E3, E4, E5, E6, E7> T7<E1, E2, E3, E4, E5, E6, E7> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7){
		return new T7<>(e1, e2, e3, e4, e5, e6, e7);
	}
	
	public static <E1, E2, E3, E4, E5, E6, E7, E8> T8<E1, E2, E3, E4, E5, E6, E7, E8> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8){
		return new T8<>(e1, e2, e3, e4, e5, e6, e7, e8);
	}
	
	public static <E1, E2, E3, E4, E5, E6, E7, E8, E9> T9<E1, E2, E3, E4, E5, E6, E7, E8, E9> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8, E9 e9){
		return new T9<>(e1, e2, e3, e4, e5, e6, e7, e8, e9);
	}
	
	public static <E1, E2, E3, E4, E5, E6, E7, E8, E9, E10> T10<E1, E2, E3, E4, E5, E6, E7, E8, E9, E10> t(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8, E9 e9, E10 e10){
		return new T10<>(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}
}
