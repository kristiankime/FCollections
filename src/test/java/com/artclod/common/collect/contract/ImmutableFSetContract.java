package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;

import org.junit.Test;

import com.artclod.common.collect.FSet;

public abstract class ImmutableFSetContract extends FSetContract {

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
	   
}
