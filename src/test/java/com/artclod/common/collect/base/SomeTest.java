package com.artclod.common.collect.base;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.google.common.collect.Sets;

public class SomeTest {

	// Gets
	public void get_returns_value() throws Exception {
		assertEquals("value", Option.some("value").get());
	}
	
	@Test
	public void or_returns_value() throws Exception {
		assertEquals("value", Option.some("value").or("or"));
	}
	
	@Test
	public void getOrElse_returns_value() throws Exception {
		assertEquals("value", Option.some("value").getOrElse("or"));
	}
	
	@Test
	public void getOrElse_option_returns_value() throws Exception {
		assertEquals(Option.some("value"), Option.some("value").getOrElse(Option.some("or")));
	}
	
	@Test
	public void getOrElse_supplier_returns_value() throws Exception {
		assertEquals("value", Option.some("value").getOrElse(() -> "or"));
	}

	// Has Values
	@Test
	public void nonEmpty_returns_true() throws Exception {
		assertTrue(Option.some("value").nonEmpty());
	}
	
	@Test
	public void isEmpty_returns_false() throws Exception {
		assertFalse(Option.some("value").isEmpty());
	}
	
	// Collection Methods
	@Test
	public void size_returns_1() throws Exception {
		assertEquals(1, Option.some("value").size());
	}

	@Test
	public void contains_false() throws Exception {
		assertFalse(Option.some("value").contains("Not in there"));
	}
	
	@Test
	public void contains_true() throws Exception {
		assertTrue(Option.some("value").contains("value"));
	}
	
	@Test
	public void iterator_returns_singleton_iterator() throws Exception {
		int count = 0;
		String test = "Unchanged";
		for(String value :  Option.some("value")) {
			test = value;
			count += 1;
		}
		assertEquals("value", test);
		assertEquals(1, count);
	}
	
	@Test
	public void toArray_returns_singleEntryArray() throws Exception {
		assertArrayEquals(new Object[]{"value"}, Option.some("value").toArray());
	}
	
	@Test
	public void toArray_with_input_array_sets_next_value_to_null() throws Exception {
		assertArrayEquals(new Object[]{"value", null, "c"}, Option.some("value").toArray(new Object[]{"a", "b", "c"}));
	}
	
	@Test
	public void toArray_with_zero_size_input_creates_size_one_array() throws Exception {
		assertArrayEquals(new Object[]{"value"}, Option.some("value").toArray(new Object[]{}));
	}
	
	@Test
	public void containsAll_false_if_not_all_values_are_containted() throws Exception {
		assertFalse(Option.some("value").containsAll(Sets.newHashSet("A", "B")));
	}
	
	@Test
	public void containsAll_true_if_all_values_are_contained() throws Exception {
		assertTrue(Option.some("value").containsAll(Sets.newHashSet("value")));
	}
	
	@Test
	public void containsAll_true_if_there_are_no_values_specified() throws Exception {
		assertTrue(Option.some("value").containsAll(Sets.newHashSet()));
	}
	
	// Functional Methods
	@Test
	public void map_returns_changed_value() throws Exception {
		assertEquals(Option.some("value+"), Option.some("value").map(a -> a + "+"));
	}
	
	@Test
	public void flatMap_returns_changed_value() throws Exception {
		assertEquals(Option.some("value+"), Option.some("value").flatMap(a -> Option.some(a + "+")));
	}
	
	@Test
	public void filter_returns_None_if_filter_fails() throws Exception {
		assertEquals(Option.none(), Option.some("value").filter(a -> a.length() > Integer.MAX_VALUE));
	}
	
	@Test
	public void filter_returns_value_if_filter_passes() throws Exception {
		assertEquals(Option.some("value"), Option.some("value").filter(a -> a.length() >= 0));
	}
	
	@Test
	public void fold_returns_fold_value() throws Exception {
		assertEquals(Option.some("value+"), Option.some("value").fold("ifempty", a -> a + "+"));
	}
	
	// Serialize
	@Test
	public void serialize_deserialize() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(Option.some("value"));
	}
	
}
