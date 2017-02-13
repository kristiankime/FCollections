package com.artclod.common.base;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import org.junit.Test;

public class T2Test {

	@Test
	public void productArity() throws Exception {
		assertEquals(2, Tuples.t(0, 1).productArity());
	}
	
	@Test
	public void iterator() throws Exception {
		assertThat(Tuples.t(0, 1), contains(0, 1));
	}
	
	@Test
	public void append() throws Exception {
		assertEquals(Tuples.t(0, 1, 2), Tuples.t(0, 1).append(2));
	}
	
	@Test
	public void productElement_gets_correct_value() throws Exception {
		T2<Integer, Integer> t = Tuples.t(0, 1);
		assertEquals(t.productElement(0), 0);
		assertEquals(t.productElement(1), 1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_below_0() throws Exception {
		Tuples.t(0, 1).productElement(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void productElement_throws_if_too_large() throws Exception {
		Tuples.t(0, 1).productElement(2);
	}
	
}
