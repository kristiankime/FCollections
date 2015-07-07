package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.collect.FCollection;

abstract public class FCollectionContract {

	public abstract <T> FCollection<T> fCollection(@SuppressWarnings("unchecked") T... elements);

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
		assertTrue(fCollection(1, 2, 3).containsAll(asList(2, 3)));
	}
	
	@Test
	public void isEmpty_for_empty() throws Exception {
		assertTrue(this.<Integer> fCollection().isEmpty());
	}
	
	@Test
	public void isEmpty_with_values() throws Exception {
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

	// ---- Reduce ----
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
	public void reduce_with_identity_returns_identity() throws Exception {
		int actual = this.<Integer> fCollection().reduce(4, (a, b) -> a + b).intValue();
		assertEquals(actual, 4);
	}

	@Test
	public void reduce_with_identity_includes_identity() throws Exception {
		int actual = fCollection(1, 2, 3).reduce(4, (a, b) -> a + b);
		assertEquals(10, actual);
	}
	
	// ---- Fold ----
	@Test
	public void fold_works() throws Exception {
		int actual = fCollection(1, 2, 3).fold(10, (a, b) -> a + b);
		assertEquals(16, actual);
	}

	@Test
	public void fold_empty_list_returns_initial() throws Exception {
		int actual = this.<Integer> fCollection().fold(10, (a, b) -> a + b);
		assertEquals(10, actual);
	}

	@Test
	public void foldLeft_works() throws Exception {
		int actual = fCollection(1, 2, 3).foldLeft(10, (a, b) -> a + b);
		assertEquals(16, actual);
	}

	@Test
	public void foldLeft_empty_list_returns_initial() throws Exception {
		int actual = this.<Integer> fCollection().foldRight(10, (a, b) -> a + b);
		assertEquals(10, actual);
	}

	@Test
	public void foldRight_works() throws Exception {
		int actual = fCollection(1, 2, 3).foldRight(10, (a, b) -> a + b);
		assertEquals(16, actual);
	}

	@Test
	public void foldRight_empty_list_returns_initial() throws Exception {
		int actual = this.<Integer> fCollection().foldRight(10, (a, b) -> a + b);
		assertEquals(10, actual);
	}
	
}
