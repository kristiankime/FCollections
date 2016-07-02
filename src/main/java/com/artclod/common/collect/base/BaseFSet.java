package com.artclod.common.collect.base;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

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
	
	public GuavaImFSet<E> toIm() {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(this));
	}
}
