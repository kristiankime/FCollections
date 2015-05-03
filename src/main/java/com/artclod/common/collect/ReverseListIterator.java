package com.artclod.common.collect;

import java.util.List;
import java.util.ListIterator;

public class ReverseListIterator<E> implements ListIterator<E> {
	private final ListIterator<E> regular;

	public ReverseListIterator(List<E> list) {
		this.regular = list.listIterator(list.size());
	}
	
	public ReverseListIterator(ListIterator<E> regular) {
		this.regular = regular;
	}

	public boolean hasNext() {
		return regular.hasPrevious();
	}

	public E next() {
		return regular.previous();
	}

	public boolean hasPrevious() {
		return regular.hasNext();
	}

	public E previous() {
		return regular.next();
	}

	public int nextIndex() {
		return regular.previousIndex();
	}

	public int previousIndex() {
		return regular.nextIndex();
	}

	public void remove() {
		regular.remove();
	}

	public void set(E e) {
		regular.set(e);
	}

	public void add(E e) {
		regular.add(e);
	}	

}
