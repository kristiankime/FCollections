package com.artclod.common.collect;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.ImmutableFSetContract;
import com.google.common.collect.ImmutableSet;


public class GuavaImFSetTest extends ImmutableFSetContract {

	@Override
	public <T> GuavaImFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFSet<T>(ImmutableSet.copyOf(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(GuavaImFSet.create("a"));
	}
	
}
