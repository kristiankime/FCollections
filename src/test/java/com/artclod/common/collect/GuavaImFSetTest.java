package com.artclod.common.collect;

import com.artclod.common.collect.contract.FSetContract;
import com.google.common.collect.ImmutableSet;


public class GuavaImFSetTest extends FSetContract {

	@Override
	public <T> FSet<T> fSet(@SuppressWarnings("unchecked") T... elements) {
		return new GauvaImFSet<T>(ImmutableSet.copyOf(elements));
	}

}
