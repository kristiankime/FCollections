package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.artclod.common.collect.ImFList;

public interface ImFListMixin<E> extends ImFList<E> {

	@Deprecated
	public default boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void replaceAll(UnaryOperator<E> operator) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void sort(Comparator<? super E> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void clear() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean removeIf(Predicate<? super E> filter) {
		throw new UnsupportedOperationException();
	}
}
