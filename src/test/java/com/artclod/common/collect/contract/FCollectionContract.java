package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FCollection;

abstract public class FCollectionContract {

	public abstract <T> FCollection<T> fCollection(@SuppressWarnings("unchecked") T... elements);

	@Test
	public void allMatch_everything_matches_returns_true() throws Exception {
		assertTrue(fCollection(1, 2).allMatch(n -> n > 0));
	}
	
	@Test
	public void allMatch_empty_returns_true() throws Exception {
		assertTrue(this.<Integer> fCollection().allMatch(n -> n > 0));
	}

	@Test
	public void allMatch_not_everything_matches_returns_false() throws Exception {
		assertFalse(fCollection(1, 2, -1).allMatch(n -> n > 0));
	}
	
	@Test
	public void anyMatch_some_things_match_returns_true() throws Exception {
		assertTrue(fCollection(1, 2, -1).anyMatch(n -> n > 0));
	}
	
	@Test
	public void anyMatch_empty_returns_false() throws Exception {
		assertFalse(this.<Integer> fCollection().anyMatch(n -> n > 0));
	}

	@Test
	public void anyMatch_nothing_matches_returns_false() throws Exception {
		assertFalse(fCollection(-1, -2, -1).anyMatch(n -> n > 0));
	}
	
	@Test
	public void noneMatch_some_things_match_returns_false() throws Exception {
		assertFalse(fCollection(1, 2, -1).noneMatch(n -> n > 0));
	}
	
	@Test
	public void noneMatch_empty_returns_true() throws Exception {
		assertTrue(this.<Integer> fCollection().noneMatch(n -> n > 0));
	}

	@Test
	public void noneMatch_nothing_matches_returns_true() throws Exception {
		assertTrue(fCollection(-1, -2, -1).noneMatch(n -> n > 0));
	}
	
	@Test
	public void size() throws Exception {
		assertEquals(2, fCollection(1, 2).size());
	}
	
	@Test
	public void contains_true() throws Exception {
		assertTrue(fCollection(1, 2).contains(2));
	}
	
	@Test
	public void contains_false() throws Exception {
		assertFalse(fCollection(1, 2).contains(3));
	}
	
	@Test
	public void containsAll_true() throws Exception {
		assertTrue(fCollection(1, 2, 3).containsAll(asList(2, 3)));
	}
	
	@Test
	public void containsAll_false() throws Exception {
		assertFalse(fCollection(1, 2, 3).containsAll(asList(3, 4)));
	}
	
	@Test
	public void isEmpty_true_for_empty() throws Exception {
		assertTrue(this.<Integer> fCollection().isEmpty());
	}
	
	@Test
	public void isEmpty_false_with_values() throws Exception {
		assertFalse(fCollection(5, 6).isEmpty());
	}
	
	@Test
	public void nonEmpty_true_with_elements() throws Exception {
		assertTrue(fCollection(1).nonEmpty());
	}

	@Test
	public void nonEmpty_false_without_elements() throws Exception {
		assertFalse(fCollection().nonEmpty());
	}

	@Test
	public void map_no_elements_returns_empty_list() throws Exception {
		FCollection<String> actual = this.<Integer> fCollection().map((a) -> a.toString());
		assertTrue(actual.isEmpty());
	}

	// -- mkString
	@Test
	public void mkString_no_sep() throws Exception {
		String actual = fCollection(1, 2, 3).mkString();
		assertEquals("123", actual);
	}
	
	@Test
	public void mkString_with_sep() throws Exception {
		String actual = fCollection(1, 2, 3).mkString(", ");
		assertEquals("1, 2, 3", actual);
	}

	@Test
	public void mkString_with_sep_no_elements_returns_empty_string() throws Exception {
		String actual = fCollection().mkString(", ");
		assertEquals("", actual);
	}

	@Test
	public void mkString_with_start_sep_end() throws Exception {
		String actual = fCollection(1, 2, 3).mkString("[", ", ", "]");
		assertEquals("[1, 2, 3]", actual);
	}

	@Test
	public void mkString_with_start_sep_end_no_elements_returns_start_plus_end() throws Exception {
		String actual = fCollection().mkString("[", ", ", "]");
		assertEquals("[]", actual);
	}
	
	// -- reduce
	@Test
	public void reduce_no_elements_returns_empty() throws Exception {
		assertFalse(this.<Integer> fCollection().reduce((a, b) -> a + b).isPresent());
	}

	@Test
	public void reduce_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduce((a, b) -> a + b).get();
		assertEquals(6, actual);
	}

	@Test
	public void reduce_with_only_identity_returns_identity() throws Exception {
		int actual = this.<Integer> fCollection().reduce(0, (a, b) -> a + b);
		assertEquals(actual, 0);
	}
	
	@Test
	public void reduce_with_identity_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduce(0, (a, b) -> a + b);
		assertEquals(actual, 6);
	}
	
	@Test
	public void reduceRight_no_elements_returns_empty() throws Exception {
		assertFalse(this.<Integer> fCollection().reduceRight((a, b) -> a + b).isPresent());
	}

	@Test
	public void reduceRight_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduceRight((a, b) -> a + b).get();
		assertEquals(6, actual);
	}

	@Test
	public void reduceRight_with_only_identity_returns_identity() throws Exception {
		int actual = this.<Integer> fCollection().reduceRight(0, (a, b) -> a + b);
		assertEquals(actual, 0);
	}
	
	@Test
	public void reduceRight_with_identity_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduceRight(0, (a, b) -> a + b);
		assertEquals(actual, 6);
	}

	@Test
	public void reduceLeft_no_elements_returns_empty() throws Exception {
		assertFalse(this.<Integer> fCollection().reduceLeft((a, b) -> a + b).isPresent());
	}

	@Test
	public void reduceLeft_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduceLeft((a, b) -> a + b).get();
		assertEquals(6, actual);
	}

	@Test
	public void reduceLeft_with_only_identity_returns_identity() throws Exception {
		int actual = this.<Integer> fCollection().reduceLeft(0, (a, b) -> a + b);
		assertEquals(actual, 0);
	}

	@Test
	public void reduceLeft_with_identity_works() throws Exception {
		int actual = fCollection(1, 2, 3).reduceLeft(0, (a, b) -> a + b);
		assertEquals(actual, 6);
	}

	// -- fold
	@Test
	public void fold_no_elements_returns_identity() throws Exception {
		assertEquals("", this.<String> fCollection().fold("", (a, b) -> a + b));
	}

	@Test
	public void fold_works() throws Exception {
		int actual = fCollection(1, 2, 3).fold(0, (a, b) -> a + b);
		assertEquals(6, actual);
	}

	@Test
	public void foldLeft_no_elements_returns_identity() throws Exception {
		assertEquals("", this.<String> fCollection().foldLeft("", (a, b) -> a + b));
	}

	@Test
	public void foldLeft_works() throws Exception {
		int actual = fCollection(1, 2, 3).foldLeft(0, (a, b) -> a + b);
		assertEquals(6, actual);
	}

	@Test
	public void foldRight_no_elements_returns_identity() throws Exception {
		assertEquals("", this.<String> fCollection().foldRight("", (a, b) -> a + b));
	}

	@Test
	public void foldRight_works() throws Exception {
		int actual = fCollection(1, 2, 3).foldRight(0, (a, b) -> a + b);
		assertEquals(6, actual);
	}
	
	// -- groupBy
	@Test
	public void groupBy_groups_as_specified() throws Exception {
		Map<Integer, FCollection<Integer>> actual = this.<Integer> fCollection(0, 1, 2, 3).groupBy(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), containsInAnyOrder(0, 2));
		assertThat(actual.get(1), containsInAnyOrder(1, 3));
	}
	
	@Test
	public void groupBy_empty_returns_empy() throws Exception {
		Map<Integer, FCollection<Integer>> actual = this.<Integer> fCollection().groupBy(i -> i % 2);
		assertTrue(actual.isEmpty());
	}
}
