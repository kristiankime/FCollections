package com.artclod.common.collect.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.artclod.common.collect.ArrayFList;
import com.artclod.common.collect.FList;
import com.artclod.common.collect.FMap;
import com.artclod.common.collect.GuavaImFList;
import com.artclod.common.collect.ReverseListIterator;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public abstract class BaseFList<E, L extends FList<E>> extends BaseFColletion<E, L> implements FList<E> {
	private static final long serialVersionUID = 1L;

	protected final List<E> inner;

	public BaseFList(List<E> inner) {
		super(inner);
		this.inner = inner;
	}
		
	protected Iterator<E> reverseIterator() {
		return new ReverseListIterator<E>(this);
	}
	
	// ============ FLIST METHODS (or support) =========	
	@SuppressWarnings("unchecked")
	public <K> FMap<K, FList<E>> groupByL(Function<? super E, ? extends K> f) {
		return (FMap<K, FList<E>>) groupByInternal(f);
	}
	
	public GuavaImFList<E> toIm(){
		return new GuavaImFList<E>(ImmutableList.copyOf(this));
	}
	
	public ArrayFList<E> toMu(){
		return new ArrayFList<E>(this);
	}
	
    public L toList() {
    	return builder(this).build();
    }
	
	@SuppressWarnings("unchecked")
	public L sortWith(Comparator<? super E> c) {
	    sort(c);
	    return (L) (Object) this;
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public L sorted() {
    	Comparator natural = Comparator.naturalOrder();
		return (L) (Object) sortWith(natural);
    }
    
	public L sortWithCp(Comparator<? super E> c) {
		ArrayList<E> data = Lists.newArrayList(inner);
		data.sort(c);
		CollectionBuilder<E,L> builder = builder(data);
		return builder.build();
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public L sortedCp() {
    	Comparator natural = Comparator.naturalOrder();
    	ArrayList data = Lists.newArrayList(inner);
		data.sort(natural);
		CollectionBuilder<E,L> builder = builder(data);
		return builder.build();
    }
    
	public L addAllCp(int index, Collection<? extends E> c) {
		ArrayList<E> data = Lists.newArrayList(inner);
		data.addAll(index, c);
		return builder(inner).build();
	}
		
	public L replaceAllCp(UnaryOperator<E> operator) {
		Objects.requireNonNull(operator);
		CollectionBuilder<E,L> builder = builder();
		inner.forEach(e -> builder.add(operator.apply(e)));
		return builder.build();
	}
	
	@Override
	public FList<E> setCp(int index, E e) {
		ArrayList<E> data = Lists.newArrayList(inner);
		data.set(index, e);
		return builder(data).build();
	}

	@Override
	public FList<E> removeIfCp(Predicate<? super E> filter) {
		ArrayList<E> data = Lists.newArrayList(inner);
		data.removeIf(filter);
		return builder(data).build();
	}
	
	// ============ DELEGATE METHODS (or support) =========
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
