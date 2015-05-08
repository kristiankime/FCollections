package com.artclod.common.collect;

import com.artclod.common.collect.contract.MutableFSetContract;
import com.google.common.collect.Sets;


public class HashFSetTest extends MutableFSetContract {

	@Override
	public <T> HashFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new HashFSet<T>(Sets.newHashSet(elements));
	}

}
