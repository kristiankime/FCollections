package com.artclod.common.collect.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.google.common.collect.Sets;

public class LeftTest {

	@Test
	public void isLeft_true() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertTrue(either.isLeft());
	}

	@Test
	public void isRight_false() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertFalse(either.isRight());
	}
	
	@Test
	public void left_returns_value() {
		Left<String, Object> either = Either.left("value");
		assertEquals("value", either.left());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void right_throws() {
		Left<String, Object> either = Either.left("value");
		either.right();
	}
	
	@Test
	public void toOption_returns_none() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertEquals(Option.none(), either.toOption());
	}

	@Test
	public void fold_changes_value_with_left_function() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertEquals("left value", either.fold(e -> "left " + e, e -> "right " + e));
	}
	
	@Test
	public void map_leaves_unchanged() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertEquals(either, either.map(e -> "right " + e));
	}
	
	@Test
	public void flatMap_leaves_unchanged() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertEquals(either, either.flatMap(e -> Either.left("another value")));
		assertEquals(either, either.flatMap(e -> Either.right("another value")));
	}
	
	@Test
	public void contains_false_for_non_null() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertFalse(either.contains("value"));
	}
	
	@Test
	public void contains_false_for_null() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertFalse(either.contains(null));
	}
	
	@Test
	public void containsAll_false_for_non_null() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertFalse(either.containsAll(Sets.newHashSet("value")));
	}
	
	@Test
	public void containsAll_false_for_null() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertFalse(either.containsAll(Sets.newHashSet((Object) null)));
	}
	
	@Test
	public void containsAll_true_for_empty() throws Exception {
		Left<String, Object> either = Either.left("value");
		assertTrue(either.containsAll(Sets.newHashSet()));
	}
}
