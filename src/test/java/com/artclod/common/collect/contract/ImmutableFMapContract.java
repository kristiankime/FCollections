package com.artclod.common.collect.contract;

import static com.artclod.common.base.Tuples.t;

import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FMap;
import com.artclod.common.collect.ImFMap;
import com.google.common.collect.ImmutableMap;

@SuppressWarnings("unchecked")
public abstract class ImmutableFMapContract extends FMapContract {

	public abstract <K, V> ImFMap<K, V> fMap(Map.Entry<K, V>... elements);

	@Test(expected=UnsupportedOperationException.class)
	public void put_throws() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		fMap.put(3,  "c");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void remove_throws() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		fMap.remove(2);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void putAll_throws() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "2") );
		fMap.putAll(ImmutableMap.<Integer, String> builder().put(2, "b").put(3, "c").build());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void clear_throws() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "2") );
		fMap.clear();
	}
	
}
