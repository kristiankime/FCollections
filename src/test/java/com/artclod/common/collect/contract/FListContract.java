package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FCollection;
import com.artclod.common.collect.FList;

abstract public class FListContract extends FCollectionContract {

	public abstract <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements);

	public <T> FCollection<T> fCollection(@SuppressWarnings("unchecked") T... elements){
		return fList(elements);
	}

	@Test
	public void map_transforms_all_elements() throws Exception {
		FList<String> actual = fList(1, 2, 3).map((a) -> a.toString());
		assertEquals(asList("1", "2", "3"), actual);
	}

	@Test
	public void map_no_elements_returns_empty_list() throws Exception {
		FList<String> actual = this.<Integer> fList().map((a) -> a.toString());
		assertTrue(actual.isEmpty());
	}

	@Test
	public void filter_keeps_elements_that_pass_filter() throws Exception {
		FList<Integer> actual = fList(0, 2, 5, 3, 1, 4, 2).filter((a) -> a > 2);
		assertEquals(asList(5, 3, 4), actual);
	}

	@Test
	public void filterNot_keeps_elements_that_do_not_pass_filter() throws Exception {
		FList<Integer> actual = fList(0, 2, 5, 3, 1, 4, 2).filterNot((a) -> a > 2);
		assertEquals(asList(0, 2, 1, 2), actual);
	}

}
