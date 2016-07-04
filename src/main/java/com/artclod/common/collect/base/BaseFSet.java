package com.artclod.common.collect.base;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;
import java.util.function.Function;

import com.artclod.common.collect.FMap;
import com.artclod.common.collect.FSet;
import com.artclod.common.collect.GuavaImFSet;
import com.google.common.collect.ImmutableSet;

public abstract class BaseFSet<E, S extends FSet<E>> extends BaseFColletion<E, S> implements FSet<E> {
	private static final long serialVersionUID = 1L;

	final Set<E> inner;

	public BaseFSet(Set<E> inner) {
		super(inner);
		this.inner = checkNotNull(inner);
	}
	
	@SuppressWarnings("unchecked")
	public <K> FMap<K, FSet<E>> groupByS(Function<? super E, ? extends K> f) {
		return (FMap<K, FSet<E>>) groupByInternal(f);
	}
	
	public GuavaImFSet<E> toIm() {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(this));
	}
}
