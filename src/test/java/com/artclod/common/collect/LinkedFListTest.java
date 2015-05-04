package com.artclod.common.collect;

import java.util.Arrays;

import com.artclod.common.collect.contract.MutableFListContract;


public class LinkedFListTest extends MutableFListContract {

	@Override
	public <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new LinkedFList<T>(Arrays.asList(elements));
	}

}
