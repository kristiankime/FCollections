package com.artclod.common.collect.builder;

import java.util.Collection;
import java.util.Iterator;

import com.artclod.common.collect.GuavaImFList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class GauvaImFListBuilder<E> implements CollectionBuilder<E, GuavaImFList<E>> {		
	private Builder<E> inner;

	public GauvaImFListBuilder(ImmutableList.Builder<E> inner) {
		this.inner = inner;
	}
	
	@Override
	public GuavaImFList<E> build() {
		return new GuavaImFList<E>(inner.build());
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