package com.artclod.common.collect.builder;

import java.util.Set;

public interface SetBuilder<E, S extends Set<E>> extends Set<E> {

	public S build();
	
}
