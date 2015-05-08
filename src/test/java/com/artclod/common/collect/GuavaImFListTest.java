package com.artclod.common.collect;

import com.artclod.common.collect.contract.ImmutableFListContract;
import com.google.common.collect.ImmutableList;


public class GuavaImFListTest extends ImmutableFListContract {

	@Override
	public <T> GuavaImFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFList<T>(ImmutableList.copyOf(elements));
	}

}
