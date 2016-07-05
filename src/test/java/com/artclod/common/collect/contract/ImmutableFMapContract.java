package com.artclod.common.collect.contract;

import java.util.Map;

import com.artclod.common.collect.ImFMap;

@SuppressWarnings("unchecked")
public abstract class ImmutableFMapContract extends FMapContract {

	public abstract <K, V> ImFMap<K, V> fMap(Map.Entry<K, V>... elements);
	
//	@Test(expected=UnsupportedOperationException.class)
//	public void add(){
//		List<Integer> list = fList(1, 2);
//		list.add(3);
//	}
	
	
}
