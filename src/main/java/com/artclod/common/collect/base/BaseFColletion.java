package com.artclod.common.collect.base;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
	public Optional<E> reduce(BinaryOperator<E> accumulator){
		return reduceLeft(accumulator);
	}
	
	public Optional<E> reduceLeft(BinaryOperator<E> accumulator){
		if(isEmpty()) { return Optional.empty(); }
		Iterator<E> iterator = iterator();
		E first = iterator.next();
		return Optional.of(reduceInner(first, accumulator, iterator));
	}
	
	public Optional<E> reduceRight(BinaryOperator<E> accumulator){
		if(isEmpty()) { return Optional.empty(); }
		Iterator<E> iterator = reverseIterator();
		E first = iterator.next();
		return Optional.of(reduceInner(first, accumulator, iterator));
	}
		
	public E reduce(E identity, BinaryOperator<E> accumulator){
		return reduceLeft(identity, accumulator);
	}	
	
	public E reduceLeft(E identity, BinaryOperator<E> accumulator){
		return reduceInner(identity, accumulator, iterator());
	}
	
	public E reduceRight(E identity, BinaryOperator<E> accumulator){
		return reduceInner(identity, accumulator, reverseIterator());
	}
	
	private E reduceInner(E first, BinaryOperator<E> f, Iterator<E> iterator) {
		E ret = first;
		while(iterator.hasNext()) {
			ret = f.apply(ret, iterator.next());
		}
		return ret;
	}

	// --- Fold ---
	public <O> O fold(O initial, BiFunction<O, E, O> f) {
		return foldLeft(initial, f);
	}

	public <O> O foldLeft(O initial, BiFunction<O, E, O> f) {
		return foldInner(initial, f, iterator());
	}

	public <O> O foldRight(O initial, BiFunction<O, E, O> f) {
		return foldInner(initial, f, reverseIterator());
	}

	private <O> O foldInner(O i, BiFunction<O, E, O> f, Iterator<E> iterator) {
		O ret = i;
		while(iterator.hasNext()) {
			ret = f.apply(ret, iterator.next());
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
