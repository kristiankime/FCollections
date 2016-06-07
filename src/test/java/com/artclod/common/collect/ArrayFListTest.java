package com.artclod.common.collect;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFListContract;


public class ArrayFListTest extends MutableFListContract {

	@Override
	public <T> ArrayFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return ArrayFList.create(elements);
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(ArrayFList.create("a"));
	}
	
}
