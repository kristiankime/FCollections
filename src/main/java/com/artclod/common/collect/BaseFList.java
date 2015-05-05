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

//	// =========== Identity as inner ===========
//	public boolean equals(Object o) {
//		return inner.equals(o);
//	}
//
//	public int hashCode() {
//		return inner.hashCode();
//	}
//
//	@Override
//	public String toString() {
//		return inner.toString();
//	}

	// ============ FLIST METHODS (or support) =========
	public GuavaImFList<E> toIm(){
		return new GuavaImFList<E>(ImmutableList.copyOf(this));
	}
	
//	public boolean nonEmpty() {
//		return !isEmpty();
//	}
//
//	public String mkString(String sep) {
//		return mkString("", sep, "");
//	}
//
//	public String mkString(String start, String sep, String end) {
//		StringBuilder ret = new StringBuilder(start);
//		ListIterator<E> listIterator = listIterator();
//		boolean first = true;
//		while (listIterator.hasNext()) {
//			E e = listIterator.next();
//			if (first) {
//				ret.append(e);
//				first = false;
//			} else {
//				ret.append(sep).append(e);
//			}
//		}
//		return ret.append(end).toString();
//	}

	// --- Reduce ---
//	public E reduce(Function2<E, E, E> f) {
//		return reduceLeft(f);
//	}
//
//	public E reduceLeft(Function2<E, E, E> f) {
//		if (isEmpty()) {
//			throw new UnsupportedOperationException("FList was empty");
//		}
//		return reduceInner(f, listIterator());
//	}
//
//	public E reduceRight(Function2<E, E, E> f) {
//		if (isEmpty()) {
//			throw new UnsupportedOperationException("FList was empty");
//		}
//		return reduceInner(f, new ReverseListIterator<E>(this));
//	}
//
//	private E reduceInner(Function2<E, E, E> f, ListIterator<E> listIterator) {
//		boolean first = true;
//		E ret = null;
//		while (listIterator.hasNext()) {
//			E e = listIterator.next();
//			if (first) {
//				ret = e;
//				first = false;
//			} else {
//				ret = f.apply(ret, e);
//			}
//		}
//		return ret;
//	}

	// --- Fold ---
//	public <O> O fold(O initial, Function2<O, E, O> f) {
//		return foldLeft(initial, f);
//	}
//
//	public <O> O foldLeft(O initial, Function2<O, E, O> f) {
//		return reduceInner(initial, f, listIterator());
//	}
//
//	public <O> O foldRight(O initial, Function2<O, E, O> f) {
//		return reduceInner(initial, f, new ReverseListIterator<E>(this));
//	}
//
//	private <O> O reduceInner(O i, Function2<O, E, O> f, ListIterator<E> listIterator) {
//		O ret = i;
//		while (listIterator.hasNext()) {
//			E e = listIterator.next();
//			ret = f.apply(ret, e);
//		}
//		return ret;
//	}

//	public FList<E> filterNot(Predicate<? super E> filter) {
//		return filter(filter.negate());
//	}

	// ============ DELEGATE METHODS =========
//	public void forEach(Consumer<? super E> action) {
//		inner.forEach(action);
//	}
//
//	public int size() {
//		return inner.size();
//	}
//
//	public boolean isEmpty() {
//		return inner.isEmpty();
//	}
//
//	public boolean contains(Object o) {
//		return inner.contains(o);
//	}
//
//	public Iterator<E> iterator() {
//		return inner.iterator();
//	}
//
//	public Object[] toArray() {
//		return inner.toArray();
//	}
//
//	public <T> T[] toArray(T[] a) {
//		return inner.toArray(a);
//	}
//
//	public boolean add(E e) {
//		return inner.add(e);
//	}
//
//	public boolean remove(Object o) {
//		return inner.remove(o);
//	}
//
//	public boolean containsAll(Collection<?> c) {
//		return inner.containsAll(c);
//	}
//
//	public boolean addAll(Collection<? extends E> c) {
//		return inner.addAll(c);
//	}
//
	public boolean addAll(int index, Collection<? extends E> c) {
		return inner.addAll(index, c);
	}
//
//	public boolean removeAll(Collection<?> c) {
//		return inner.removeAll(c);
//	}
//
//	public boolean retainAll(Collection<?> c) {
//		return inner.retainAll(c);
//	}
//
//	public void replaceAll(UnaryOperator<E> operator) {
//		inner.replaceAll(operator);
//	}
//
//	public boolean removeIf(Predicate<? super E> filter) {
//		return inner.removeIf(filter);
//	}

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

//	public Stream<E> parallelStream() {
//		return inner.parallelStream();
//	}

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

//	public Spliterator<E> spliterator() {
//		return inner.spliterator();
//	}

}
