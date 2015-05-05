package com.artclod.common.collect.builder;

import java.util.List;

public interface ListBuilder<E, L extends List<E>> extends List<E> {

	public L build();
	
}
