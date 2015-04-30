package com.artclod.common.collect;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.base.Function;

public interface FList<E> extends List<E> {

	public <O> FList<O> map(Function<E, O> f);
	
	public FList<E> filter(Predicate<? super E> filter);
	
}
