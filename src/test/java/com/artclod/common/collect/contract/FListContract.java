package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FList;
import com.google.common.collect.Ordering;

abstract public class FListContract extends FCollectionContract {

	public abstract <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements);

	public <T> FList<T> fCollection(@SuppressWarnings("unchecked") T... elements){
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
	
	@Test
	public void flatMap_transforms_all_elements() throws Exception {
		FList<String> actual = fList(1, 2, 3).flatMap((a) -> asList(a.toString(), a.toString()));
		assertEquals(asList("1", "1", "2", "2", "3", "3"), actual);
	}
	
	@Test
    public void sortBy() throws Exception {
	    FList<Integer> sorted = fList(3, 1, 2).sortBy(Ordering.<Integer> natural());
	    assertEquals(asList(1, 2, 3), sorted);
    }

	@Test
    public void sort_natural() throws Exception {
        FList<Integer> sorted = fList(3, 1, 2).sort();
        assertEquals(asList(1, 2, 3), sorted);
    }
	
	// ---- Copy Methods ----
	@Test
	public void addCp_copies_and_adds_element() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2);
		FList<Integer> after = before.addCp(3);

		assertEquals(asList(0, 1, 2), before);
		assertEquals(asList(0, 1, 2, 3), after);
	}
	
	@Test
	public void addAllCp_copies_and_adds_all_elements() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2);
		FList<Integer> after = before.addAllCp(asList(3, 4, 5));

		assertEquals(asList(0, 1, 2), before);
		assertEquals(asList(0, 1, 2, 3, 4, 5), after);
	}
	
	@Test
	public void removeCp_copies_and_removes_element() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2);
		FList<Integer> after = before.removeCp(1);

		assertEquals(asList(0, 1, 2), before);
		assertEquals(asList(0, 2), after);
	}
	
	@Test
	public void removeAllCp_copies_and_removes_elements() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2, 3, 4);
		FList<Integer> after = before.removeAllCp(asList(1, 3));

		assertEquals(asList(0, 1, 2, 3, 4), before);
		assertEquals(asList(0, 2, 4), after);
	}
	
	@Test
	public void retainAllCp_copies_and_retains_elements() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2, 3, 4);
		FList<Integer> after = before.retainAllCp(asList(1, 3, 5));

		assertEquals(asList(0, 1, 2, 3, 4), before);
		assertEquals(asList(1, 3), after);
	}
	
	@Test
	public void groupByL_empty_map_for_empty_collection() throws Exception {
		Map<Integer, FList<Integer>> actual = this.<Integer> fCollection().groupByL(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupByL_groups_as_specified() throws Exception {
		Map<Integer, FList<Integer>> actual = this.<Integer> fCollection(0, 1, 2, 3).groupByL(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), contains(0, 2));
		assertThat(actual.get(1), contains(1, 3));
	}
	
}
