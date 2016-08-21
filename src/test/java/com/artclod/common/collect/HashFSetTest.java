package com.artclod.common.collect;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFSetContract;
import com.google.common.collect.Sets;


public class HashFSetTest extends MutableFSetContract {
	
	@Test
	public void wrap_constructs() throws Exception {
		assertThat(HashFSet.wrap(new HashSet<>(Arrays.asList(1, 2, 3))), contains(1, 2, 3));
		assertTrue(HashFSet.wrap(new HashSet<>()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(HashFSet.create().isEmpty());
	}

	@Test
	public void createWithExpectedSize_empty() throws Exception {
		assertTrue(HashFSet.createWithExpectedSize(10).isEmpty());
	}
	
	@Test
	public void create_iterable() throws Exception {
		assertThat(HashFSet.create(Arrays.asList(1, 2, 3)), contains(1, 2, 3));
	}
	
	@Test
	public void create_iterator() throws Exception {
		assertThat(HashFSet.create(Arrays.asList(1, 2, 3).iterator()), contains(1, 2, 3));
	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(HashFSet.create(1, 2, 3), contains(1, 2, 3));
	}
	
	@Override
	public <T> HashFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new HashFSet<T>(Sets.newHashSet(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(HashFSet.create("a"));
	}
	
}
