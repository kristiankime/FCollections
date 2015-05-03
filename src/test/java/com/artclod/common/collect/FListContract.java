package com.artclod.common.collect;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


abstract public class FListContract {

	public abstract <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements);
	
	@Test
	public void nonEmpty_true_with_elements() throws Exception {
		assertTrue(fList(1).nonEmpty());
	}
	
	@Test
	public void nonEmpty_false_without_elements() throws Exception {
		assertFalse(fList().nonEmpty());
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
	public void mkString_with_sep() throws Exception {
		String actual = fList(1, 2, 3).mkString(", ");
		assertEquals("1, 2, 3", actual);
	}
	
	@Test
	public void mkString_with_sep_no_elements_returns_empty_string() throws Exception {
		String actual = fList().mkString(", ");
		assertEquals("", actual);
	}
	
	@Test
	public void mkString_with_start_sep_end() throws Exception {
		String actual = fList(1, 2, 3).mkString("[", ", ", "]");
		assertEquals("[1, 2, 3]", actual);
	}
	
	@Test
	public void mkString_with_start_sep_end_no_elements_returns_start_plus_end() throws Exception {
		String actual = fList().mkString("[", ", ", "]");
		assertEquals("[]", actual);
	}
	
	
	// ---- Reduce 1 ----
	@Test(expected=UnsupportedOperationException.class)
	public void reduce_no_elements_throws() throws Exception {
		this.<Integer> fList().reduce((a) -> a._1 + a._2);
	}
	
	@Test
	public void reduce_works() throws Exception {
		int actual = fList(1, 2, 3).reduce((a) -> a._1 + a._2);
		assertEquals(6, actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void reduceLeft_no_elements_throws() throws Exception {
		this.<Integer> fList().reduceLeft((a) -> a._1 + a._2);
	}
	
	@Test
	public void reduceLeft_works() throws Exception {
		int actual = fList(1, 2, 3).reduceLeft((a) -> a._1 + a._2);
		assertEquals(6, actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void reduceRight_no_elements_throws() throws Exception {
		this.<Integer> fList().reduceRight((a) -> a._1 + a._2);
	}
	
	@Test
	public void reduceRight_works() throws Exception {
		int actual = fList(1, 2, 3).reduceRight((a) -> a._1 + a._2);
		assertEquals(6, actual);
	}
	
	// ---- Reduce 2 ----
	@Test(expected=UnsupportedOperationException.class)
	public void reduce2_no_elements_throws() throws Exception {
		this.<Integer> fList().reduce((a, b) -> a + b);
	}
	
	@Test
	public void reduce2_works() throws Exception {
		int actual = fList(1, 2, 3).reduce((a, b) -> a + b);
		assertEquals(6, actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void reduceLeft2_no_elements_throws() throws Exception {
		this.<Integer> fList().reduceLeft((a, b) -> a + b);
	}
	
	@Test
	public void reduceLeft2_works() throws Exception {
		int actual = fList(1, 2, 3).reduceLeft((a, b) -> a + b);
		assertEquals(6, actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void reduceRight2_no_elements_throws() throws Exception {
		this.<Integer> fList().reduceRight((a, b) -> a + b);
	}
	
	@Test
	public void reduceRight2_works() throws Exception {
		int actual = fList(1, 2, 3).reduceRight((a, b) -> a + b);
		assertEquals(6, actual);
	}
}
