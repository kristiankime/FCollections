package com.artclod.common.collect.contract;

import static com.artclod.common.base.Tuples.t;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

import org.junit.Test;

import com.artclod.common.collect.FMap;
import com.google.common.collect.ImmutableMap;

@SuppressWarnings("unchecked")
public abstract class MutableFMapContract extends FMapContract {

	@Test
	public void keySet_is_a_view_of_the_set_of_keys() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.keySet(), containsInAnyOrder(1, 2));
		fMap.put(3,  "c");
		assertThat(fMap.keySet(), containsInAnyOrder(1, 2, 3));		
	}
	
	@Test
	public void values_is_a_view_of_the_set_of_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.values(), containsInAnyOrder("a", "b"));
		fMap.put(3,  "c");
		assertThat(fMap.values(), containsInAnyOrder("a", "b", "c"));	
	}
	
	@Test
	public void entrySet_is_a_view_of_the_set_of_keys_and_values() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		assertThat(fMap.entrySet(), containsInAnyOrder(t(1, "a"), t(2, "b")));
		fMap.put(3,  "c");
		assertThat(fMap.entrySet(), containsInAnyOrder(t(1, "a"), t(2, "b"), t(3, "c")));		
	}
	
	@Test
	public void put_adds_entry() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		fMap.put(3,  "c");
		assertEquals(fMap.get(3), "c");		
	}

	@Test
	public void put_overrides_entry() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		fMap.put(2,  "c");
		assertEquals(fMap.get(2), "c");		
	}
	
	@Test
	public void remove_removes_entry() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "b") );
		fMap.remove(2);
		assertEquals(fMap, ImmutableMap.<Integer, String> builder().put(1, "a").build());		
	}

	
	@Test
	public void putAll_add_multiple_entries() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "2") );
		fMap.putAll(ImmutableMap.<Integer, String> builder().put(2, "b").put(3, "c").build());
		assertEquals(fMap, ImmutableMap.<Integer, String> builder().put(1, "a").put(2, "b").put(3, "c").build());		
	}
	
	@Test
	public void clear_removes_everything() throws Exception {
		FMap<Integer, String> fMap = fMap( t(1, "a"), t(2, "2") );
		fMap.clear();
		assertTrue(fMap.isEmpty());		
	}
	
}
