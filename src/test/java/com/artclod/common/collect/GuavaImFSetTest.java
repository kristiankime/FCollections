package com.artclod.common.collect;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.ImFSetContract;
import com.google.common.collect.ImmutableSet;


public class GuavaImFSetTest extends ImFSetContract {

	@Test
	public void wrap_constructs() throws Exception {
		assertThat(GuavaImFSet.wrap(ImmutableSet.of(1, 2, 3)), containsInAnyOrder(1, 2, 3));
		assertTrue(GuavaImFSet.wrap(ImmutableSet.of()).isEmpty());
	}

	@Test
	public void create_empty() throws Exception {
		assertTrue(GuavaImFSet.create().isEmpty());
	}

	@Test
	public void create_collection() throws Exception {
		assertThat(GuavaImFSet.create(Arrays.asList(1, 2, 3)), containsInAnyOrder(1, 2, 3));
	}

	@Test
	public void create_iterable() throws Exception {
		assertThat(GuavaImFSet.create((Iterable<Integer>) Arrays.asList(1, 2, 3)), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void create_iterator() throws Exception {
		assertThat(GuavaImFSet.create(Arrays.asList(1, 2, 3).iterator()), containsInAnyOrder(1, 2, 3));
	}
	
	@Test
	public void create_varargs() throws Exception {
		assertThat(GuavaImFSet.create(1, 2, 3), containsInAnyOrder(1, 2, 3));
	}
	
	// group
	@Test
	public void groupBT_empty_map_for_empty_collection() throws Exception {
		GuavaImFMap<Object, GuavaImFSet<Integer>> actual = this.<Integer> fSet().groupByT(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupBT_groups_as_specified() throws Exception {
		GuavaImFMap<Object, GuavaImFSet<Integer>> actual = this.<Integer> fSet(0, 1, 2, 3).groupByT(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), containsInAnyOrder(0, 2));
		assertThat(actual.get(1), containsInAnyOrder(1, 3));
	}
	
	@Override
	public <T> GuavaImFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFSet<T>(ImmutableSet.copyOf(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(GuavaImFSet.create("a"));
	}
	
}
