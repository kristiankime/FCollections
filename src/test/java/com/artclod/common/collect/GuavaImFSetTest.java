package com.artclod.common.collect;

import com.artclod.common.collect.contract.ImmutableFSetContract;
import com.google.common.collect.ImmutableSet;


public class GuavaImFSetTest extends ImmutableFSetContract {

	@Override
	public <T> GuavaImFSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFSet<T>(ImmutableSet.copyOf(elements));
	}

}
