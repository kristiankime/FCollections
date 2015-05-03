package com.artclod.common.base;

import static com.artclod.common.base.Tuples.t;
import static org.junit.Assert.*;

import org.junit.Test;


public class TuplesTest {

	@Test
	public void equals_T2() throws Exception {
		assertEquals(t(1, 2), t(1, 2));
	}
	
	@Test
	public void notEquals_T2() throws Exception {
		assertNotEquals(t(1, 2), t(1, 3));
		assertNotEquals(t(1, 2), t(0, 2));
	}
}
