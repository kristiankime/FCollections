package com.artclod.common.collect;

import java.util.Arrays;

import com.artclod.common.collect.contract.FSetContract;
import com.google.common.collect.Sets;


public class LinkedHashFSetTest extends FSetContract {

	@Override
	public <T> FSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new LinkedHashFSet<T>(Sets.newLinkedHashSet(Arrays.asList(elements)));
	}

}
