package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public abstract class MutableFListContract extends FListContract {

	@Test
	public void add(){
		List<Integer> list = fList(1, 2);
		list.add(3);
		assertEquals(asList(1, 2, 3), list);
	}
	
	@Test
	public void add_indexed(){
		List<Integer> list = fList(1, 2);
		list.add(1, 3);
		assertEquals(asList(1, 3, 2), list);
	}
	
	@Test
	public void remove(){
		List<String> list = fList("1", "2", "3", "5");
		list.remove("3");
		assertEquals(asList("1", "2", "5"), list);
	}

	@Test
	public void remove_indexed(){
		List<String> list = fList("1", "2", "3", "5");
		list.remove(3);
		assertEquals(asList("1", "2", "3"), list);
	}
	
	@Test
	public void addAll(){
		List<Integer> list = fList(1, 2, 5);
		list.addAll(asList(3, 4));
		assertEquals(asList(1, 2, 5, 3, 4), list);
	}
	
	@Test
	public void addAll_indexed(){
		List<Integer> list = fList(1, 2, 5);
		list.addAll(1, asList(3, 4));
		assertEquals(asList(1, 3, 4, 2, 5), list);
	}
	
	@Test
	public void removeAll(){
		List<Integer> list = fList(1, 7, 6, 2, 5);
		list.removeAll(asList(3, 7, 6));
		assertEquals(asList(1, 2, 5), list);
	}
	
	@Test
	public void retainAll(){
		List<Integer> list = fList(1, 7, 6, 2, 5);
		list.retainAll(asList(3, 6, 7));
		assertEquals(asList(7, 6), list);
	}
	
	@Test
	public void replaceAll(){
		List<Integer> list = fList(1, 7, 6);
		list.replaceAll((v) -> v + 1);
		assertEquals(asList(2, 8, 7), list);
	}
	
	@Test
	public void sort(){
		List<Integer> list = fList(1, 5, 7, 6, 2);
		list.sort((a, b) -> Integer.valueOf(a).compareTo(b));
		assertEquals(asList(1, 2, 5, 6, 7), list);
	}

	@Test
	public void clear(){
		List<Integer> list = fList(1, 6, 2);
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void set(){
		List<Integer> list = fList(1, 2, 6, 7);
		list.set(2, 3);
		assertEquals(asList(1, 2, 3, 7), list);
	}
	
	@Test
	public void removeIf(){
		List<Integer> list = fList(1, 7, 3, 6, 2);
		list.removeIf((v) -> v > 3);
		assertEquals(asList(1, 3, 2), list);
	}

}
