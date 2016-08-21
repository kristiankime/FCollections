package com.artclod.common.collect;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFListContract;


public class LinkedFListTest extends MutableFListContract {

	@Test
	public void wrap_constructs() throws Exception {
		assertThat(LinkedFList.wrap(new LinkedList<>(Arrays.asList(1, 2, 3))), contains(1, 2, 3));
		assertTrue(LinkedFList.wrap(new LinkedList<>()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(LinkedFList.create().isEmpty());
	}

	@Test
	public void create_iterable() throws Exception {
		assertThat(LinkedFList.create(Arrays.asList(1, 2, 3)), contains(1, 2, 3));
	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(LinkedFList.create(1, 2, 3), contains(1, 2, 3));
	}
	
	@Override
	public <T> LinkedFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return LinkedFList.create(Arrays.asList(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(LinkedFList.create("a"));
	}
	
}
