package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Predicate;

public interface BaseImFCollection<E, C extends FCollection<E>> extends ImFCollection<E>{

	@Deprecated
	@Override
	public default boolean add(E e) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	@Override
	public default boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	@Override
	public default boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	@Override
	public default boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	@Override
	public default boolean removeIf(Predicate<? super E> filter) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public default boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Deprecated
	@Override
	public default void clear() {
		throw new UnsupportedOperationException();
	}
}
