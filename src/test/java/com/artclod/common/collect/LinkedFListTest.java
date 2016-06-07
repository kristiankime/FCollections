package com.artclod.common.collect;

import java.util.Arrays;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFListContract;


public class LinkedFListTest extends MutableFListContract {

	@Override
	public <T> LinkedFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return LinkedFList.create(Arrays.asList(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(LinkedFList.create("a"));
	}
	
}
