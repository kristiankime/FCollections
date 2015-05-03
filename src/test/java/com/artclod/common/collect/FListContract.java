package com.artclod.common.collect;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


abstract public class FListContract {

	public abstract <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements);
	
	@Test
	public void nonEmpty_with_elements() throws Exception {
		assertTrue(fList(1).nonEmpty());
	}
	
	@Test
	public void nonEmpty_without_elements() throws Exception {
		assertFalse(fList().nonEmpty());
	}
	
	@Test
	public void map_works() throws Exception {
		FList<String> actual = fList(1, 2, 3).map((a) -> a.toString());
		assertEquals(asList("1", "2", "3"), actual);
	}
	
	@Test
	public void filter_works() throws Exception {
		FList<Integer> actual = fList(5, 3, 1, 4, 2).filter((a) -> a > 2);
		assertEquals(asList(1, 2), actual);
	}
	
	@Test
	public void mkString_with_sep() throws Exception {
		String actual = fList(1, 2, 3).mkString(", ");
		assertEquals("1, 2, 3", actual);
	}
	
	@Test
	public void mkString_with_start_sep_end() throws Exception {
		String actual = fList(1, 2, 3).mkString("[", ", ", "]");
		assertEquals("[1, 2, 3]", actual);
	}
}
