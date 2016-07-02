package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FSet;

abstract public class FSetContract extends FCollectionContract {

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
	
	// ---- Copy Methods ----
	@Test
	public void addCp_copies_and_adds_element() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2);
		FSet<Integer> after = before.addCp(3);

		assertEquals(newHashSet(0, 1, 2), before);
		assertEquals(newHashSet(0, 1, 2, 3), after);
	}
	
	@Test
	public void addAllCp_copies_and_adds_all_elements() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2);
		FSet<Integer> after = before.addAllCp(asList(3, 4, 5));

		assertEquals(newHashSet(0, 1, 2), before);
		assertEquals(newHashSet(0, 1, 2, 3, 4, 5), after);
	}
	
	@Test
	public void removeCp_copies_and_removes_element() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2);
		FSet<Integer> after = before.removeCp(1);

		assertEquals(newHashSet(0, 1, 2), before);
		assertEquals(newHashSet(0, 2), after);
	}
	
	@Test
	public void removeAllCp_copies_and_removes_elements() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2, 3, 4);
		FSet<Integer> after = before.removeAllCp(asList(1, 3));

		assertEquals(newHashSet(0, 1, 2, 3, 4), before);
		assertEquals(newHashSet(0, 2, 4), after);
	}
	
	@Test
	public void retainAllCp_copies_and_retains_elements() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2, 3, 4);
		FSet<Integer> after = before.retainAllCp(asList(1, 3, 5));

		assertEquals(newHashSet(0, 1, 2, 3, 4), before);
		assertEquals(newHashSet(1, 3), after);
	}
}
