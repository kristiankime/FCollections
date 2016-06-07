package com.artclod.common.collect;

import java.util.Arrays;

import org.junit.Test;

import com.artclod.common.SerializeDeserialize;
import com.artclod.common.collect.contract.MutableFSetContract;
import com.google.common.collect.Sets;


public class LinkedHashFSetTest extends MutableFSetContract {

	@Override
	public <T> LinkedHashFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new LinkedHashFSet<T>(Sets.newLinkedHashSet(Arrays.asList(elements)));
	}

	@Test
	public void serialializing_then_deserializing_produces_equal_object() throws Exception {
		SerializeDeserialize.serializeDeserializeEqual(LinkedHashFSet.create("a"));
	}
}
