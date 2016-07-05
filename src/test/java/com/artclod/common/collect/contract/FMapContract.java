package com.artclod.common.collect.contract;

import static com.artclod.common.base.Tuples.t;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FMap;
import com.google.common.collect.ImmutableMap;

@SuppressWarnings("unchecked")
abstract public class FMapContract {

	public abstract <K, V> FMap<K, V> fMap(Map.Entry<K, V>... elements);

	@Test
	public void size() throws Exception {
		assertEquals(2, fMap( t(1, "a"), t(2, "b") ).size());
	}
	
	@Test
	public void isEmpty_true() throws Exception {
		FMap<Integer, String> fMap = this.<Integer, String>fMap();
		assertTrue(fMap.isEmpty());
	}

	@Test
	public void isEmpty_false() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertFalse(fMap.isEmpty());
	}

	@Test
	public void constainsKey_true() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertTrue(fMap.containsKey(2));
	}
	
	@Test
	public void constainsKey_false() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertFalse(fMap.containsKey(Integer.MAX_VALUE));
	}
	
	@Test
	public void constainsValue_true() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertTrue(fMap.containsValue("a"));
	}
	
	@Test
	public void constainsValue_false() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertFalse(fMap.containsValue("Should not be found"));
	}
	
	@Test
	public void get_finds_a_value() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertEquals(fMap.get(1), "a");
	}
	
	@Test
	public void get_doesnt_find_a_value() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertNull(fMap.get(Integer.MAX_VALUE));
	}
	
	@Test
	public void keySet_is_set_of_keys() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.keySet(), containsInAnyOrder(1, 2));
	}
	
	@Test
	public void values_is_set_of_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.values(), containsInAnyOrder("a", "b"));
	}
	
	@Test
	public void entrySet_is_set_of_keys_and_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.entrySet(), containsInAnyOrder(t(1, "a"), t(2, "b")));
	}
	
	@Test
	public void map_changes_keys_and_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		FMap<Integer, String> mapped = fMap.map((k, v) -> t(k+1, v + v));
		assertEquals(ImmutableMap.<Integer, String> builder().put(2, "aa").put(3, "bb").build(), mapped);		
	}
	
	@Test
	public void mapValues_changes_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		FMap<Integer, String> mapped = fMap.mapValues((v) -> v + v);
		assertEquals(ImmutableMap.<Integer, String> builder().put(1, "aa").put(2, "bb").build(), mapped);		
	}
	
	@Test
	public void filter_removes_if_predicate_doesnt_match() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b"), t(3, "c")  );
		FMap<Integer, String> filtered = fMap.filter((k, v) -> k > 1);
		assertEquals(ImmutableMap.<Integer, String> builder().put(2, "b").put(3, "c").build(), filtered);		
	}
	
	@Test
	public void filterKeys_removes_if_key_doesnt_match() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b"), t(3, "c")  );
		FMap<Integer, String> filtered = fMap.filterKeys((k) -> k > 1);
		assertEquals(ImmutableMap.<Integer, String> builder().put(2, "b").put(3, "c").build(), filtered);		
	}
}
