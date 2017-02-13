package com.artclod.common.base;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import org.junit.Test;

public class T9Test {

	@Test
	public void productArity() throws Exception {
		assertEquals(9, Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productArity());
	}
	
	@Test
	public void iterator() throws Exception {
		assertThat(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8), contains(0, 1, 2, 3, 4, 5, 6, 7, 8));
	}
	
	@Test
	public void append() throws Exception {
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).append(9));
	}
	
	@Test
	public void productElement_gets_correct_value() throws Exception {
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(0), 0);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(1), 1);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(2), 2);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(3), 3);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(4), 4);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(5), 5);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(6), 6);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(7), 7);
		assertEquals(Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(8), 8);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_below_0() throws Exception {
		Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_too_large() throws Exception {
		Tuples.t(0, 1, 2, 3, 4, 5, 6, 7, 8).productElement(9);
	}
	
}
