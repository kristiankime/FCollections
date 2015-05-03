package com.artclod.common.collect;

import java.util.Arrays;


public class LinkedFListTest extends FListContract {

	@Override
	public <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new LinkedFList<T>(Arrays.asList(elements));
	}

}
