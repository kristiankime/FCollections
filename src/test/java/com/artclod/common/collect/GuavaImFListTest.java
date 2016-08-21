package com.artclod.common.collect;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.ImFListContract;
import com.google.common.collect.ImmutableList;


public class GuavaImFListTest extends ImFListContract {

	@Override
	public <T> GuavaImFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFList<T>(ImmutableList.copyOf(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(GuavaImFList.create("a"));
	}
	
}
