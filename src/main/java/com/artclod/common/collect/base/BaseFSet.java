package com.artclod.common.collect.base;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import com.artclod.common.collect.FSet;
import com.artclod.common.collect.GauvaImFSet;
import com.google.common.collect.ImmutableSet;

public abstract class BaseFSet<E, S extends FSet<E>> extends BaseFColletion<E, S> implements FSet<E> {
	final Set<E> inner;

	public BaseFSet(Set<E> inner) {
		super(inner);
		this.inner = checkNotNull(inner);
	}

	// ============ FLIST METHODS (or support) =========	
	public GauvaImFSet<E> toIm(){
		return new GauvaImFSet<E>(ImmutableSet.copyOf(this));
	}
}
