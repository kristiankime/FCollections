package com.google.common.base;

import com.artclod.common.collect.base.Option;
import com.google.common.base.Optional;

public abstract class GuavaOption<T> extends Optional<T> implements Option<T> {
	private static final long serialVersionUID = 1L;

	public GuavaOption() {
		super();
	}
	
}
