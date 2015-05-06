package com.artclod.common.collect.base;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.artclod.common.base.Function2;
import com.artclod.common.collect.FCollection;
import com.artclod.common.collect.builder.CollectionBuilder;

public abstract class BaseFColletion<E, C extends FCollection<E>> implements FCollection<E> {
	final Collection<E> inner;

	public BaseFColletion(Collection<E> inner) {
		this.inner = checkNotNull(inner);
	}

	/**
	 * Intended for internal use. 
	 * Creates an empty builder that can be used to create a collection of correct type.
	 */
	protected abstract CollectionBuilder<E, C> builder();
	
	/**
	 * Best effort to be able to iterator through this collection in reverse.
	 * Not that for collections that do not have a real reverse nothing is guaranteed (i.e. reverse and forward may even be the same).
	 */
	protected abstract Iterator<E> reverseIterator();
	
	// =========== Identity as inner ===========
	public boolean equals(Object o) {
		return inner.equals(o);
	}

	public int hashCode() {
		return inner.hashCode();
	}

	@Override
	public String toString() {
		return inner.toString();
	}

	// ============ FCollection Methods (or support) =========	
	public boolean nonEmpty() {
		return !isEmpty();
	}
	
	public String mkString(String sep) {
		return mkString("", sep, "");
	}

	public String mkString(String start, String sep, String end) {
		StringBuilder ret = new StringBuilder(start);
		Iterator<E> iterator = iterator();
		boolean first = true;
		while (iterator.hasNext()) {
			E e = iterator.next();
			if (first) {
				ret.append(e);
				first = false;
			} else {
				ret.append(sep).append(e);
			}
		}
		return ret.append(end).toString();
	}

	// --- Reduce ---
	public E reduce(Function2<E, E, E> f) {
		return reduceLeft(f);
	}

	public E reduceLeft(Function2<E, E, E> f) {
		if (isEmpty()) {
			throw new UnsupportedOperationException("FList was empty");
		}
		return reduceInner(f, iterator());
	}

	public E reduceRight(Function2<E, E, E> f) {
		if (isEmpty()) {
			throw new UnsupportedOperationException("FList was empty");
		}
		return reduceInner(f, reverseIterator());
	}

	private E reduceInner(Function2<E, E, E> f, Iterator<E> iterator) {
		boolean first = true;
		E ret = null;
		for(E e: this) {
			if (first) {
				ret = e;
				first = false;
			} else {
				ret = f.apply(ret, e);
			}
		}
		return ret;
	}

	// --- Fold ---
	public <O> O fold(O initial, Function2<O, E, O> f) {
		return foldLeft(initial, f);
	}

	public <O> O foldLeft(O initial, Function2<O, E, O> f) {
		return reduceInner(initial, f, iterator());
	}

	public <O> O foldRight(O initial, Function2<O, E, O> f) {
		return reduceInner(initial, f, reverseIterator());
	}

	private <O> O reduceInner(O i, Function2<O, E, O> f, Iterator<E> iterator) {
		O ret = i;
		for(E e: this) {
			ret = f.apply(ret, e);
		}
		return ret;
	}

	// --- Filter ---
	public C filterNot(Predicate<? super E> filter) {
		return filter(filter.negate());
	}

	public C filter(Predicate<? super E> filter) {
		CollectionBuilder<E, C> ret = builder();
		for(E e: this){
			if(filter.test(e)){
				ret.add(e);
			}
		}
		return ret.build();
	}
	
	// ============ DELEGATE METHODS =========
	public void forEach(Consumer<? super E> action) {
		inner.forEach(action);
	}

	public int size() {
		return inner.size();
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public boolean contains(Object o) {
		return inner.contains(o);
	}

	public Iterator<E> iterator() {
		return inner.iterator();
	}

	public Object[] toArray() {
		return inner.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return inner.toArray(a);
	}

	public boolean add(E e) {
		return inner.add(e);
	}

	public boolean remove(Object o) {
		return inner.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return inner.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		return inner.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return inner.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return inner.retainAll(c);
	}
	public boolean removeIf(Predicate<? super E> filter) {
		return inner.removeIf(filter);
	}

	public void clear() {
		inner.clear();
	}

	public Stream<E> stream() {
		return inner.stream();
	}

	public Stream<E> parallelStream() {
		return inner.parallelStream();
	}

	public Spliterator<E> spliterator() {
		return inner.spliterator();
	}

}
