package com.artclod.common.collect;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;

public abstract class BaseFList<E, L extends FList<E>> extends BaseFColletion<E, L> implements FList<E> {
	final List<E> inner;

	public BaseFList(List<E> inner) {
		super(inner);
		this.inner = checkNotNull(inner);
	}
	
	Iterator<E> reverseIterator() {
		return new ReverseListIterator<E>(this);
	}

	// ============ FLIST METHODS (or support) =========
	public GuavaImFList<E> toIm(){
		return new GuavaImFList<E>(ImmutableList.copyOf(this));
	}
	
	public boolean addAll(int index, Collection<? extends E> c) {
		return inner.addAll(index, c);
	}

	public void sort(Comparator<? super E> c) {
		inner.sort(c);
	}

	public void clear() {
		inner.clear();
	}

	public E get(int index) {
		return inner.get(index);
	}

	public E set(int index, E element) {
		return inner.set(index, element);
	}

	public void add(int index, E element) {
		inner.add(index, element);
	}

	public Stream<E> stream() {
		return inner.stream();
	}

	public E remove(int index) {
		return inner.remove(index);
	}

	public int indexOf(Object o) {
		return inner.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return inner.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		return inner.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		return inner.listIterator(index);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return inner.subList(fromIndex, toIndex);
	}

}
