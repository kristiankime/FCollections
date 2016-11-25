package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FCollection;
import com.artclod.common.collect.FList;
import com.artclod.common.collect.FSet;
import com.artclod.common.collect.ImFList;
import com.artclod.common.collect.ImFSet;
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
	
	// ---- Copy Methods ----
	@Test
	public void cp_copies() throws Exception {
		FList<Integer> before = this.<Integer> fList(0, 1, 2);
		FList<Integer> after = before.cp();

		assertEquals(asList(0, 1, 2), before);
		assertEquals(asList(0, 1, 2), after);
	}
	
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
	public void replaceAllCp_copies_and_replaces_elements() {
		FList<Integer> before = fList(1, 7, 6);
		FList<Integer> after = before.replaceAllCp((v) -> v + 1);
		
		assertEquals(asList(1, 7, 6), before);
		assertEquals(asList(2, 8, 7), after);
	}
	
	@Test
	public void setCp_copies_and_sets_element(){
		FList<Integer> before = fList(1, 2, 6, 7);
		FList<Integer> after = before.setCp(2, 3);
		
		assertEquals(asList(1, 2, 6, 7), before);
		assertEquals(asList(1, 2, 3, 7), after);
	}
	
	@Test
	public void removeIfCp_copies_and_removes(){
		FList<Integer> before = fList(1, 7, 3, 6, 2);
		FList<Integer> after = before.removeIfCp((v) -> v > 3);
		
		assertEquals(asList(1, 7, 3, 6, 2), before);
		assertEquals(asList(1, 3, 2), after);
	}
	
	// --- group
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
	
	// --- sort
	@Test
    public void sortWith() throws Exception {
	    FList<Integer> sorted = fList(3, 1, 2).sortWith(Ordering.<Integer> natural());
	    assertEquals(asList(1, 2, 3), sorted);
    }

	@Test
    public void sorted() throws Exception {
        FList<Integer> sorted = fList(3, 1, 2).sorted();
        assertEquals(asList(1, 2, 3), sorted);
    }
	
	@Test
    public void sortWithCp() throws Exception {
	    FList<Integer> original = fList(3, 1, 2);
		FList<Integer> sorted = original.sortWithCp(Ordering.<Integer> natural());
		
	    assertEquals(asList(3, 1, 2), original);
	    assertEquals(asList(1, 2, 3), sorted);
    }

	@Test
    public void sortedCp() throws Exception {
        FList<Integer> original = fList(3, 1, 2);
		FList<Integer> sorted = original.sortedCp();
		
		assertEquals(asList(3, 1, 2), original);
        assertEquals(asList(1, 2, 3), sorted);
    }
	
	// --- to 
	@Test
	public void toSet_returns_set_with_same_values() throws Exception {
		FList<Integer> fList = fList(1, 2, 3);
		assertThat(fList.toSet(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void copyToSet_returns_set_with_same_values() throws Exception {
		FList<Integer> fList = fList(1, 2, 3);
		assertThat(fList.copyToSet(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
    public void toSet_return_is_mutable() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		FSet<Integer> mu = original.toSet();
		
		mu.add(4);
		assertThat(original, containsInAnyOrder(3, 2, 1)); // Here mutating new does not change the original
		assertThat(mu, containsInAnyOrder(3, 2, 1, 4));
	}

	@Test
    public void toImSet_lists_have_same_contents() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		ImFSet<Integer> im = original.toImSet();
		assertThat(im, containsInAnyOrder(3, 2, 1));
	}
	
	@Test
	public void toList_returns_list_with_same_values() throws Exception {
		FList<Integer> fCollection = fList(1, 2, 3);
		assertThat(fCollection.toList(), contains(1, 2, 3));
	}
	
	@Test
	public void copyToList_returns_list_with_same_values() throws Exception {
		FList<Integer> fCollection = fList(1, 2, 3);
		assertThat(fCollection.copyToList(), contains(1, 2, 3));
	}
	
	@Test
    public void toList_return_is_mutable() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		FList<Integer> mu = original.toList();
		assertEquals(original, mu);
		
		mu.add(4);
		assertThat(original, contains(3, 1, 2, 4)); // Here mutating new changes the original
		assertThat(mu, contains(3, 1, 2, 4));
	}
	
	@Test
    public void toImList_lists_have_same_contents() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		ImFList<Integer> im = original.toImList();
		assertThat(im, contains(3, 1, 2));
	}
	
}
