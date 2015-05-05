package com.artclod.common.collect.builder;

import java.util.Collection;

public interface CollectionBuilder<E, C extends Collection<E>> extends Collection<E> {

	public C build();
	
}
