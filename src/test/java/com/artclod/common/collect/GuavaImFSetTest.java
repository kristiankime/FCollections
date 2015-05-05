package com.artclod.common.collect;

import com.artclod.common.collect.contract.ImmutableFSetContract;
import com.google.common.collect.ImmutableSet;


public class GuavaImFSetTest extends ImmutableFSetContract {

	@Override
	public <T> FSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new GauvaImFSet<T>(ImmutableSet.copyOf(elements));
	}

}
