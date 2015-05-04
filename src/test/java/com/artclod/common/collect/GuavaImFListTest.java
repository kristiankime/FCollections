package com.artclod.common.collect;

import com.artclod.common.collect.contract.FListContract;
import com.google.common.collect.ImmutableList;


public class GuavaImFListTest extends FListContract {

	@Override
	public <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new GuavaImFList<T>(ImmutableList.copyOf(elements));
	}

}
