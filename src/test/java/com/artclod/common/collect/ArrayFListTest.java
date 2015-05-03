package com.artclod.common.collect;


public class ArrayFListTest extends FListContract {

	@Override
	public <T> FList<T> fList(@SuppressWarnings("unchecked") T... elements) {
		return new ArrayFList<T>(elements);
	}

}
