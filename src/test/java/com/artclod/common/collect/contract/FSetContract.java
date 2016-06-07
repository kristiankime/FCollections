package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FSet;

abstract public class FSetContract extends FCollectionContract{

	public abstract <T> FSet<T> fSet(@SuppressWarnings("unchecked") T... elements);

	public <T> FSet<T> fCollection(@SuppressWarnings("unchecked") T... elements){
		return fSet(elements);
	}

	@Test
	public void map_transforms_all_elements() throws Exception {
		FSet<String> actual = fSet(1, 2, 3).map((a) -> a.toString());
		assertEquals(newHashSet("1", "2", "3"), actual);
	}

	@Test
	public void map_no_elements_returns_empty_list() throws Exception {
		FSet<String> actual = this.<Integer> fSet().map((a) -> a.toString());
		assertTrue(actual.isEmpty());
	}

	@Test
	public void filter_keeps_elements_that_pass_filter() throws Exception {
		FSet<Integer> actual = fSet(0, 2, 5, 3, 1, 4, 2).filter((a) -> a > 2);
		assertEquals(newHashSet(5, 3, 4), actual);
	}

	@Test
	public void filterNot_keeps_elements_that_do_not_pass_filter() throws Exception {
		FSet<Integer> actual = fSet(0, 2, 5, 3, 1, 4, 2).filterNot((a) -> a > 2);
		assertEquals(newHashSet(0, 2, 1, 2), actual);
	}
	
	@Test
	public void flatMap_transforms_all_elements() throws Exception {
		FSet<String> actual = fSet(1, 2, 3).flatMap((a) -> asList(a.toString(), a.toString()));
		assertEquals(newHashSet("1", "1", "2", "2", "3", "3"), actual);
	}
	
}
