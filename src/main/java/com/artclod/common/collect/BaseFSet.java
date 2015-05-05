package com.artclod.common.collect;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

public abstract class BaseFSet<E, S extends FSet<E>> extends BaseFColletion<E, S> implements FSet<E> {
	final Set<E> inner;

	public BaseFSet(Set<E> inner) {
		super(inner);
		this.inner = checkNotNull(inner);
	}

}