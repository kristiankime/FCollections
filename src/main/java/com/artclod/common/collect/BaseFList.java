package com.artclod.common.collect;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.artclod.common.base.Function2;

public abstract class BaseFList<E> implements FList<E> {
	final List<E> inner;
	
	public BaseFList(List<E> inner) {
		this.inner = checkNotNull(inner);
	}

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
	
	// ============ FLIST METHODS (or support) =========
	public boolean nonEmpty() {
		return !isEmpty();
	}

	public String mkString(String sep){
		return mkString("", sep, "");
	}
	
	// --- Reduce ---
	public E reduce(Function2<E, E, E> f) {
		return reduceLeft(f);
	}
	
	public E reduceLeft(Function2<E, E, E> f) {
		if(isEmpty()){
			throw new UnsupportedOperationException("FList was empty");
		}		
		return reduceInner(f, listIterator());
	}

	public E reduceRight(Function2<E, E, E> f) {
		if(isEmpty()){
			throw new UnsupportedOperationException("FList was empty");
		}		
		return reduceInner(f, new ReverseListIterator<E>(this));
	}
	
	private E reduceInner(Function2<E, E, E> f, ListIterator<E> listIterator) {
		boolean first = true;
		E ret = null;
		while(listIterator.hasNext()){
			E e = listIterator.next(); 
			if(first){
				ret = e;
				first = false;
			} else {
				ret = f.apply(ret, e);
			}
		}
		return ret;
	}
	
	// --- Fold ---

	
	public FList<E> filterNot(Predicate<? super E> filter){
		return filter(filter.negate());
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

	public boolean addAll(int index, Collection<? extends E> c) {
		return inner.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return inner.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return inner.retainAll(c);
	}

	public void replaceAll(UnaryOperator<E> operator) {
		inner.replaceAll(operator);
	}

	public boolean removeIf(Predicate<? super E> filter) {
		return inner.removeIf(filter);
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

	public Stream<E> parallelStream() {
		return inner.parallelStream();
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

	public Spliterator<E> spliterator() {
		return inner.spliterator();
	}
	
}
