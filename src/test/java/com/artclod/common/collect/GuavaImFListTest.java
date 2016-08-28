package com.artclod.common.collect;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.ImFListContract;
import com.google.common.collect.ImmutableList;


public class GuavaImFListTest extends ImFListContract {
	
	@Test
	public void wrap_constructs() throws Exception {
		assertThat(GuavaImFList.wrap(ImmutableList.of(1, 2, 3)), containsInAnyOrder(1, 2, 3));
		assertTrue(GuavaImFList.wrap(ImmutableList.of()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(GuavaImFList.create().isEmpty());
	}

	@Test
	public void create_collection() throws Exception {
		assertThat(GuavaImFList.create(Arrays.asList(1, 2, 3)), containsInAnyOrder(1, 2, 3));
	}

	@Test
	public void create_iterable() throws Exception {
		assertThat(GuavaImFList.create((Iterable<Integer>) Arrays.asList(1, 2, 3)), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void create_iterator() throws Exception {
		assertThat(GuavaImFList.create(Arrays.asList(1, 2, 3).iterator()), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(GuavaImFList.create(1, 2, 3), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void create_builder() throws Exception {
		assertThat(GuavaImFList.create(ImmutableList.builder().add(1, 2, 3)), containsInAnyOrder(1, 2, 3));
	}
	
	// group
	@Test
	public void groupByT_empty_map_for_empty_collection() throws Exception {
		GuavaImFMap<Object, GuavaImFList<Integer>> actual = this.<Integer> fList().groupByT(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupByT_groups_as_specified() throws Exception {
		GuavaImFMap<Object, GuavaImFList<Integer>> actual = this.<Integer> fList(0, 1, 2, 3).groupByT(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), containsInAnyOrder(0, 2));
		assertThat(actual.get(1), containsInAnyOrder(1, 3));
	}
	
	@Override
	public <T> GuavaImFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFList<T>(ImmutableList.copyOf(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(GuavaImFList.create("a"));
	}
	
}
