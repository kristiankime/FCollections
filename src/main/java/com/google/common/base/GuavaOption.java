package com.google.common.base;

import com.artclod.common.collect.base.Option;
import com.google.common.base.Optional;

/**
 * This class is both a Guava {@link com.google.common.base.Optional} and an {@link com.artclod.common.collect.base.Option}.
 * This can be used both FCollections and Guava functionality is desired.
 *
 * @param <T> Type of potential value in the option
 */
public abstract class GuavaOption<T> extends Optional<T> implements Option<T> {
	private static final long serialVersionUID = 1L;

	public GuavaOption() {
		super();
	}
	
}
