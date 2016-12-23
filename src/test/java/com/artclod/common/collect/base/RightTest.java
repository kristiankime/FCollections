package com.artclod.common.collect.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.google.common.collect.Sets;

public class RightTest {

	@Test
	public void isLeft_false() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertFalse(either.isLeft());
	}

	@Test
	public void isRight_true() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertTrue(either.isRight());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void left_throws() {
		Right<Object, String> either = Either.right("value");
		either.left();
	}
	
	@Test
	public void right_returns_value() {
		Right<Object, String> either = Either.right("value");
		assertEquals("value", either.right());
	}
	
	@Test
	public void toOption_returns_some() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertEquals(Option.some("value"), either.toOption());
	}
	
	@Test
	public void fold_changes_value_with_right_function() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertEquals(Either.right("right value"), either.fold(e -> "left " + e, e -> "right " + e));
	}
	
	@Test
	public void map_changes_value() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertEquals(Either.right("right value"), either.map(e -> "right " + e));
	}
	
	@Test
	public void flatMap_with_left_returns_left() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertEquals(Either.left("another value"), either.flatMap(e -> Either.left("another value")));
	}
	
	@Test
	public void flatMap_with_right_returns_right() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertEquals(Either.right("another value"), either.flatMap(e -> Either.right("another value")));
	}
	
	@Test
	public void contains_false_for_non_null_incorrect_value() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertFalse(either.contains("another value"));
	}
	
	@Test
	public void contains_true_for_correct_value() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertTrue(either.contains("value"));
	}
	
	@Test
	public void contains_false_for_null() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertFalse(either.contains(null));
	}
	
	@Test
	public void containsAll_false_for_non_null_incorrect_value() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertFalse(either.containsAll(Sets.newHashSet("another value")));
	}
	
	@Test
	public void containsAll_true_for_correct_value() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertTrue(either.containsAll(Sets.newHashSet("value")));
	}
	
	@Test
	public void containsAll_false_for_null() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertFalse(either.containsAll(Sets.newHashSet((Object) null)));
	}
	
	@Test
	public void containsAll_false_for_empty() throws Exception {
		Right<Object, String> either = Either.right("value");
		assertTrue(either.containsAll(Sets.newHashSet()));
	}
}
