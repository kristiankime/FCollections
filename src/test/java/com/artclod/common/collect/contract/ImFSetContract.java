package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FSet;
import com.artclod.common.collect.ImFMap;
import com.artclod.common.collect.ImFSet;

public abstract class ImFSetContract extends FSetContract {

	public abstract <T> ImFSet<T> fSet(@SuppressWarnings("unchecked") T... elements);
	
	@Test(expected=UnsupportedOperationException.class)
	public void add(){
		FSet<String> set = fSet("a", "b");
		set.add("c");
	}

	@Test(expected=UnsupportedOperationException.class)
	public void remove(){
		FSet<String> set = fSet("a", "b");
		set.remove("b");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void addAll(){
		FSet<String> set = fSet("a", "b");
		set.addAll(newHashSet("c", "d"));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void removeAll(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.removeAll(newHashSet("a", "d"));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void retainAll(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.retainAll(newHashSet("a", "d", "f"));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void clear(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.clear();
	}
	   
	// Copy methods
	
	@Test
	public void addCp(){
		FSet<String> set = fSet("a", "b").addCp("c");
		assertEquals(newHashSet("a", "b", "c"), set);
	}

	@Test
	public void removeCp(){
		FSet<String> set = fSet("a", "b").removeCp("b");
		assertEquals(newHashSet("a"), set);
	}
	
	@Test
	public void addAllCp(){
		FSet<String> set = fSet("a", "b").addAllCp(newHashSet("c", "d"));
		assertEquals(newHashSet("a", "b", "c", "d"), set);
	}
	
	@Test
	public void removeAllCp(){
		FSet<String> set = fSet("a", "b", "c", "d").removeAllCp(newHashSet("a", "d"));
		assertEquals(newHashSet("b", "c"), set);
	}
	
	@Test
	public void retainAllCp(){
		FSet<String> set = fSet("a", "b", "c", "d").retainAllCp(newHashSet("a", "d", "f"));
		assertEquals(newHashSet("a", "d"), set);
	}
	
	// group
	@Test
	public void groupByIS_empty_map_for_empty_collection() throws Exception {
		ImFMap<Integer, ImFSet<Integer>> actual = this.<Integer> fSet().groupByIS(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupByIS_groups_as_specified() throws Exception {
		ImFMap<Integer, ImFSet<Integer>> actual = this.<Integer> fSet(0, 1, 2, 3).groupByIS(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), containsInAnyOrder(0, 2));
		assertThat(actual.get(1), containsInAnyOrder(1, 3));
	}
	
}
