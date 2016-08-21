package com.artclod.common.collect;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFSetContract;
import com.google.common.collect.Sets;


public class LinkedHashFSetTest extends MutableFSetContract {

	@Test
	public void wrap_constructs() throws Exception {
		assertThat(LinkedHashFSet.wrap(new LinkedHashSet<>(Arrays.asList(1, 2, 3))), contains(1, 2, 3));
		assertTrue(LinkedHashFSet.wrap(new LinkedHashSet<>()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(LinkedHashFSet.create().isEmpty());
	}

	@Test
	public void createWithExpectedSize_empty() throws Exception {
		assertTrue(LinkedHashFSet.createWithExpectedSize(10).isEmpty());
	}
	
	@Test
	public void create_iterable() throws Exception {
		assertThat(LinkedHashFSet.create(Arrays.asList(1, 2, 3)), contains(1, 2, 3));
	}
	
//	@Test
//	public void create_iterator() throws Exception {
//		assertThat(LinkedHashFSet.create(Arrays.asList(1, 2, 3).iterator()), contains(1, 2, 3));
//	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(LinkedHashFSet.create(1, 2, 3), contains(1, 2, 3));
	}
	
	@Override
	public <T> LinkedHashFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new LinkedHashFSet<T>(Sets.newLinkedHashSet(Arrays.asList(elements)));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(LinkedHashFSet.create("a"));
	}
	
}
