package com.artclod.common.collect;

import com.artclod.common.collect.contract.FSetContract;
import com.google.common.collect.Sets;


public class HashFSetTest extends FSetContract {

	@Override
	public <T> FSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new HashFSet<T>(Sets.newHashSet(elements));
	}

}
