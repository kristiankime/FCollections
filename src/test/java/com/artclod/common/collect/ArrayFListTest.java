package com.artclod.common.collect;

import com.artclod.common.collect.contract.MutableFListContract;


public class ArrayFListTest extends MutableFListContract {

	@Override
	public <T> ArrayFList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return ArrayFList.create(elements);
	}

}
