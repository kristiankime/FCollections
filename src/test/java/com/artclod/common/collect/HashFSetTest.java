package com.artclod.common.collect;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFSetContract;
import com.google.common.collect.Sets;


public class HashFSetTest extends MutableFSetContract {

	@Override
	public <T> HashFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new HashFSet<T>(Sets.newHashSet(elements));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(HashFSet.create("a"));
	}
}
