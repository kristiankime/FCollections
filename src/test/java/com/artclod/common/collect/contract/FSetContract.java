package com.artclod.common.collect.contract;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FCollection;
import com.artclod.common.collect.FList;
import com.artclod.common.collect.FSet;
import com.artclod.common.collect.ImFList;
import com.artclod.common.collect.ImFSet;

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
	public void cp_copies() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2);
		FSet<Integer> after = before.cp();

		assertEquals(newHashSet(0, 1, 2), before);
		assertEquals(newHashSet(0, 1, 2), after);
	}
	
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
	public void addAllCp_adds_nothing_if_collection_empty() throws Exception {
		FSet<Integer> before = this.<Integer> fSet(0, 1, 2);
		FSet<Integer> after = before.addAllCp(Arrays.<Integer> asList());

		assertEquals(newHashSet(0, 1, 2), before);
		assertEquals(newHashSet(0, 1, 2), after);
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
	
	@Test
	public void groupByS_empty_map_for_empty_collection() throws Exception {
		Map<Integer, FSet<Integer>> actual = this.<Integer> fCollection().groupByS(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupByS_groups_as_specified() throws Exception {
		Map<Integer, FSet<Integer>> actual = this.<Integer> fCollection(0, 1, 2, 3).groupByS(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), containsInAnyOrder(0, 2));
		assertThat(actual.get(1), containsInAnyOrder(1, 3));
	}
	
	@Test
	public void intersection_keeps_only_elements_in_common() throws Exception {
		FSet<Integer> set1 = this.<Integer> fSet(0, 1, 2, 3);
		FSet<Integer> set2 = this.<Integer> fSet(1, 2, 3, 4);

		assertThat(set1.intersection(set2), containsInAnyOrder(1, 2, 3));
		assertThat(set2.intersection(set1), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void union_keeps_all_elements() throws Exception {
		FSet<Integer> set1 = this.<Integer> fSet(0, 1, 2, 3);
		FSet<Integer> set2 = this.<Integer> fSet(1, 2, 3, 4);

		assertThat(set1.union(set2), containsInAnyOrder(0, 1, 2, 3, 4));
		assertThat(set2.union(set1), containsInAnyOrder(0, 1, 2, 3, 4));
	}
	
	// --- to  
	@Test
	public void toSet_returns_set_with_same_values() throws Exception {
		FSet<Integer> fSet = fSet(1, 2, 3);
		assertThat(fSet.toSet(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void copyToSet_returns_set_with_same_values() throws Exception {
		FSet<Integer> fSet = fSet(1, 2, 3);
		assertThat(fSet.copyToSet(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
    public void toSet_return_is_mutable() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		FSet<Integer> mu = original.toSet();
		assertEquals(original, mu);
		
		mu.add(4);
		assertThat(original, containsInAnyOrder(3, 2, 1, 4)); // Here mutating new changes the original
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
		FSet<Integer> fSet = fSet(1, 2, 3);
		assertThat(fSet.toList(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void copyToList_returns_list_with_same_values() throws Exception {
		FSet<Integer> fSet = fSet(1, 2, 3);
		assertThat(fSet.copyToList(), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
    public void toList_return_is_mutable() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		FList<Integer> mu = original.toList();
		
		mu.add(4);
		assertThat(original, containsInAnyOrder(3, 1, 2)); // Here mutating new does not change the original
		assertThat(mu, containsInAnyOrder(3, 1, 2, 4));
	}
	
	@Test
    public void toImList_lists_have_same_contents() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		ImFList<Integer> im = original.toImList();
		assertThat(im, containsInAnyOrder(3, 1, 2));
	}
}
