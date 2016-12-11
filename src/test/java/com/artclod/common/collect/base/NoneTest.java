package com.artclod.common.collect.base;

import static org.junit.Assert.*;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.google.common.collect.Sets;

public class NoneTest {

	// Gets
	@Test(expected=IllegalStateException.class)
	public void get_throws() throws Exception {
		Option.none().get();
	}
	
	@Test
	public void or_returns_or_value() throws Exception {
		assertEquals(Option.<String> none().or("or"), "or");
	}
	
	@Test
		public void orElse_returns_or_value() throws Exception {
			assertEquals(Option.<String> none().getOrElse("or"), "or");
		}
	
	
	@Test
		public void orElse_option_returns_or_value() throws Exception {
			assertEquals(Option.<String> none().orElse(Option.some("or")), Option.some("or"));
		}
	
	@Test
		public void orElse_supplier_returns_or_value() throws Exception {
			assertEquals(Option.<String> none().getOrElse(() -> "or"), "or");
		}

	// Has Values
	@Test
	public void nonEmpty_returns_false() throws Exception {
		assertFalse(Option.none().nonEmpty());
	}
	
	@Test
	public void isEmpty_returns_true() throws Exception {
		assertTrue(Option.none().isEmpty());
	}
	
	// Collection Methods
	@Test
	public void size_returns_0() throws Exception {
		assertEquals(0, Option.none().size());
	}

	@Test
	public void contains_false() throws Exception {
		assertFalse(Option.none().contains("Can't be in there"));
	}
	
	@Test
	public void iterator_returns_empty_iterator() throws Exception {
		String test = "Unchanged";
		for(String value :  Option.<String> none()) {
			test = value;
		}
		assertEquals("Unchanged", test);
	}
	
	@Test
	public void toArray_returns_emptyArray() throws Exception {
		assertArrayEquals(new Object[]{}, Option.<String> none().toArray());
	}
	
	@Test
	public void toArray_with_input_array_sets_first_value_to_null() throws Exception {
		assertArrayEquals(new Object[]{null, "b"}, Option.<String> none().toArray(new Object[]{"a", "b"}));
	}
	
	@Test
	public void containsAll_false_if_there_are_values_specified() throws Exception {
		assertFalse(Option.none().containsAll(Sets.newHashSet("A", "B")));
	}
	
	@Test
	public void containsAll_true_if_there_are_no_values_specified() throws Exception {
		assertTrue(Option.none().containsAll(Sets.newHashSet()));
	}
	
	// Functional Methods
	@Test
	public void map_returns_None() throws Exception {
		assertEquals(Option.none(), Option.<String> none().map(a -> a + "+"));
	}
	
	@Test
	public void flatMap_returns_None() throws Exception {
		assertEquals(Option.none(), Option.<String> none().flatMap(a -> Option.some(a + "+")));
	}
	
	@Test
	public void filter_returns_None() throws Exception {
		assertEquals(Option.none(), Option.<String> none().filter(a -> a.length() >= 0));
	}
	
	@Test
	public void fold_returns_ifEmpty_value() throws Exception {
		assertEquals(Option.some("ifempty"), Option.<String> none().fold("ifempty", a -> a + "+"));
	}
	
	// Serialize
	@Test
	public void serialize_deserialize() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(Option.<String> none());
	}
	
}
