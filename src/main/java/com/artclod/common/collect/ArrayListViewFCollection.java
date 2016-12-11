package com.artclod.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import com.artclod.common.collect.base.Option;

public class ArrayListViewFCollection<E> implements ViewFCollection<E> {

	private final Collection<E> inner;

	public ArrayListViewFCollection(Collection<E> inner) {
		this.inner = Objects.requireNonNull(inner);
	} 
	
	// ======= Unsupported 
	@Deprecated
	@Override
	public boolean add(E e) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public boolean addAll(Collection<? extends E> c) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public boolean remove(Object o) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public boolean removeIf(Predicate<? super E> filter) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }

	@Deprecated
	@Override
	public void clear() { throw new UnsupportedOperationException(); }

	// ======= Delegate 
	
//	public default void forEach(Consumer<? super E> action) {
//		inner.forEach(action);
//	}

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

	public boolean containsAll(Collection<?> c) {
		return inner.containsAll(c);
	}

	public boolean equals(Object o) {
		return inner.equals(o);
	}

	public int hashCode() {
		return inner.hashCode();
	}

//	public default Spliterator<E> spliterator() {
//		return inner.spliterator();
//	}
//
//	public default Stream<E> stream() {
//		return inner.stream();
//	}
//
//	public default Stream<E> parallelStream() {
//		return inner.parallelStream();
//	}

	// ======= 
	
	@Override
	public ArrayFList<E> filter(Predicate<? super E> filter) {
		return ArrayFList.create(inner).filter(filter);
	}

	@Override
	public FCollection<E> filterNot(Predicate<? super E> filter) {
		return ArrayFList.create(inner).filterNot(filter);
	}

	@Override
	public <O> ArrayFList<O> map(Function<? super E, ? extends O> f) {
		return ArrayFList.create(inner).map(f);
	}

	@Override
	public <O> ArrayFList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		return ArrayFList.create(inner).flatMap(mapper);
	}

	@Override
	public ArrayFList<E> cp() {
		return ArrayFList.create(inner);
	}

	@Override
	public ArrayFList<E> addCp(E e) {
		return ArrayFList.create(inner).addCp(e);
	}

	@Override
	public ArrayFList<E> addAllCp(Collection<? extends E> c) {
		return ArrayFList.create(inner).addAllCp(c);
	}

	@Override
	public ArrayFList<E> removeCp(Object o) {
		return ArrayFList.create(inner).removeCp(o);
	}

	@Override
	public ArrayFList<E> removeAllCp(Collection<?> c) {
		return ArrayFList.create(inner).removeAllCp(c);
	}

	@Override
	public ArrayFList<E> retainAllCp(Collection<?> c) {
		return ArrayFList.create(inner).retainAllCp(c);
	}

	@Override
	public Option<E> reduce(BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduce(accumulator);
	}

	@Override
	public Option<E> reduceLeft(BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduceLeft(accumulator);
	}

	@Override
	public Option<E> reduceRight(BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduceRight(accumulator);
	}

	@Override
	public E reduce(E identity, BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduce(identity, accumulator);
	}

	@Override
	public E reduceLeft(E identity, BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduceLeft(identity, accumulator);
	}

	@Override
	public E reduceRight(E identity, BinaryOperator<E> accumulator) {
		return ArrayFList.create(inner).reduceRight(identity, accumulator);
	}

	@Override
	public <K> FMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f) {
		return ArrayFList.create(inner).groupBy(f);
	}
	
	public <K> FMap<K, FList<E>> groupByL(Function<? super E, ? extends K> f) {
		return ArrayFList.create(inner).groupByL(f);
	}
	
}
