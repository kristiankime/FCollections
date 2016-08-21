package com.artclod.common.collect;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFListContract;


public class ArrayFListTest extends MutableFListContract {

	@Test
	public void wrap_constructs() throws Exception {
		assertThat(ArrayFList.wrap(new ArrayList<>(Arrays.asList(1, 2, 3))), contains(1, 2, 3));
		assertTrue(ArrayFList.wrap(new ArrayList<>()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(ArrayFList.create().isEmpty());
	}
	
	@Test
	public void createWithCapacity_empty() throws Exception {
		assertTrue(ArrayFList.createWithCapacity(10).isEmpty());
	}

	@Test
	public void create_iterable() throws Exception {
		assertThat(ArrayFList.create(Arrays.asList(1, 2, 3)), contains(1, 2, 3));
	}
	
	@Test
	public void create_iterator() throws Exception {
		assertThat(ArrayFList.create(Arrays.asList(1, 2, 3).iterator()), contains(1, 2, 3));
	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(ArrayFList.create(1, 2, 3), contains(1, 2, 3));
	}
	
	@Override
	public <T> ArrayFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return ArrayFList.create(elements);
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(ArrayFList.create("a"));
	}
	
}
