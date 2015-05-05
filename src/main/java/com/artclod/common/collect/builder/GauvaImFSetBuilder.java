package com.artclod.common.collect.builder;

import java.util.Collection;
import java.util.Iterator;

import com.artclod.common.collect.GauvaImFSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public class GauvaImFSetBuilder<E> implements CollectionBuilder<E, GauvaImFSet<E>> {		
	private Builder<E> inner;

	public GauvaImFSetBuilder(ImmutableSet.Builder<E> inner) {
		this.inner = inner;
	}
	
	@Override
	public GauvaImFSet<E> build() {
		return new GauvaImFSet<E>(inner.build());
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(E e) {
		inner.add(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		inner.addAll(c);
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}
}