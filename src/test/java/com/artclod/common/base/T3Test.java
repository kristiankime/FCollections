package com.artclod.common.base;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import org.junit.Test;

public class T3Test {

	@Test
	public void productArity() throws Exception {
		assertEquals(3, Tuples.t(0, 1, 2).productArity());
	}
	
	@Test
	public void iterator() throws Exception {
		assertThat(Tuples.t(0, 1, 2), contains(0, 1, 2));
	}
	
	@Test
	public void append() throws Exception {
		assertEquals(Tuples.t(0, 1, 2, 3), Tuples.t(0, 1, 2).append(3));
	}
	
	@Test
	public void productElement_gets_correct_value() throws Exception {
		assertEquals(Tuples.t(0, 1, 2).productElement(0), 0);
		assertEquals(Tuples.t(0, 1, 2).productElement(1), 1);
		assertEquals(Tuples.t(0, 1, 2).productElement(2), 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_below_0() throws Exception {
		Tuples.t(0, 1, 2).productElement(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_too_large() throws Exception {
		Tuples.t(0, 1, 2).productElement(3);
	}
	
}
