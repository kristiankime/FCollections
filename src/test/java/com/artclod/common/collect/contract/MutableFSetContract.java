package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FSet;

public abstract class MutableFSetContract extends FSetContract {

	@Test
	public void add(){
		FSet<String> set = fSet("a", "b");
		set.add("c");
		assertEquals(newHashSet("a", "b", "c"), set);
	}

	@Test
	public void remove(){
		FSet<String> set = fSet("a", "b");
		set.remove("b");
		assertEquals(newHashSet("a"), set);
	}
	
	@Test
	public void addAll(){
		FSet<String> set = fSet("a", "b");
		set.addAll(newHashSet("c", "d"));
		assertEquals(newHashSet("a", "b", "c", "d"), set);
	}
	
	@Test
	public void removeAll(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.removeAll(newHashSet("a", "d"));
		assertEquals(newHashSet("b", "c"), set);
	}
	
	@Test
	public void retainAll(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.retainAll(newHashSet("a", "d", "f"));
		assertEquals(newHashSet("a", "d"), set);
	}
	
	@Test
	public void clear(){
		FSet<String> set = fSet("a", "b", "c", "d");
		set.clear();
		assertTrue(set.isEmpty());
	}
	   
}
