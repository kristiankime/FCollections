package com.artclod.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GauvaImFListBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;

public class GuavaImFList<E> extends BaseFList<E, GuavaImFList<E>> implements ImFList<E>, Serializable {
	private static final long serialVersionUID = 1L;

	final ImmutableList<E> inner;

	public static <E> GuavaImFList<E> of(){
		return new GuavaImFList<E>();
	}
	
	public static <E> GuavaImFList<E> of(ImmutableList<E> inner){
		return new GuavaImFList<E>(inner);
	}
	
	public static <E> GuavaImFList<E> copyOf(Iterable<? extends E> elements){
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}
	
	public static <E> GuavaImFList<E> copyOf(Collection<? extends E> elements){
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}
	
	public static <E> GuavaImFList<E> copyOf(Iterator<? extends E> elements){
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}
	
	public static <E> GuavaImFList<E> copyOf(E[] elements){
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}
	
	public GuavaImFList() {
		this(ImmutableList.<E> of());
	}

	public GuavaImFList(ImmutableList<E> inner) {
		super(inner);
		this.inner = inner;
	}

	@Override
	CollectionBuilder<E, GuavaImFList<E>> builder() {
		return new GauvaImFListBuilder<E>(ImmutableList.builder());
	}
	
	public ImmutableList<E> toGuava() {
		return inner;
	}

	public Builder<E> toBuilder() {
		return ImmutableList.<E> builder().addAll(inner);
	}

	public ArrayList<E> toArrayList() {
		return Lists.newArrayList(this);
	}

	// ==== ImFList methods ====
	public ArrayFList<E> toMu() {
		return new ArrayFList<E>(this);
	}
	
	public GuavaImFList<E> toIm() {
		return this;
	}

	@Override
	public <O> GuavaImFList<O> map(Function<E, O> f) {
		Builder<O> builder = ImmutableList.<O> builder();
		for (E e : this) {
			builder.add(f.apply(e));
		}
		return new GuavaImFList<O>(builder.build());
	}

	@Override
	public GuavaImFList<E> filter(Predicate<? super E> filter) {
		Builder<E> builder = ImmutableList.<E> builder();
		for (E e : this) {
			if (filter.test(e)) {
				builder.add(e);
			}
		}
		return new GuavaImFList<E>(builder.build());
	}

	// ==== Copy modifiers ====

	@Override
	public GuavaImFList<E> addCp(E e) {
		ArrayList<E> list = toArrayList();
		list.add(e);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> removeCp(Object o) {
		ArrayList<E> list = toArrayList();
		list.remove(o);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> addAllCp(Collection<? extends E> c) {
		ArrayList<E> list = toArrayList();
		list.addAll(c);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> addAllCp(int index, Collection<? extends E> c) {
		ArrayList<E> list = toArrayList();
		list.addAll(index, c);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> removeAllCp(Collection<?> c) {
		ArrayList<E> list = toArrayList();
		list.removeAll(c);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> retainAllCp(Collection<?> c) {
		ArrayList<E> list = toArrayList();
		list.retainAll(c);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> replaceAllCp(UnaryOperator<E> operator) {
		ArrayList<E> list = toArrayList();
		list.replaceAll(operator);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> sortCp(Comparator<? super E> c) {
		ArrayList<E> list = toArrayList();
		list.sort(c);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> setCp(int index, E element) {
		ArrayList<E> list = toArrayList();
		list.set(index, element);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> addCp(int index, E element) {
		ArrayList<E> list = toArrayList();
		list.add(index, element);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> removeCp(int index) {
		ArrayList<E> list = toArrayList();
		list.remove(index);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	@Override
	public GuavaImFList<E> removeIfCp(Predicate<? super E> filter) {
		ArrayList<E> list = toArrayList();
		list.removeIf(filter);
		return new GuavaImFList<E>(ImmutableList.copyOf(list));
	}

	// ==== Identity defined by inner ====
	public String toString() {
		return inner.toString();
	}

	public boolean equals(Object obj) {
		return inner.equals(obj);
	}

	public int hashCode() {
		return inner.hashCode();
	}

	// ==== Delegate Methods ====
	public final Object[] toArray() {
		return inner.toArray();
	}

	public int size() {
		return inner.size();
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public final <T> T[] toArray(T[] other) {
		return inner.toArray(other);
	}

	public boolean containsAll(Collection<?> c) {
		return inner.containsAll(c);
	}

	public UnmodifiableIterator<E> iterator() {
		return inner.iterator();
	}

	public UnmodifiableListIterator<E> listIterator() {
		return inner.listIterator();
	}

	public UnmodifiableListIterator<E> listIterator(int index) {
		return inner.listIterator(index);
	}

	public int indexOf(Object object) {
		return inner.indexOf(object);
	}

	public int lastIndexOf(Object object) {
		return inner.lastIndexOf(object);
	}

	public boolean contains(Object object) {
		return inner.contains(object);
	}

	public ImmutableList<E> subList(int fromIndex, int toIndex) {
		return inner.subList(fromIndex, toIndex);
	}

	public final ImmutableList<E> asList() {
		return inner.asList();
	}

	public ImmutableList<E> reverse() {
		return inner.reverse();
	}

	public E get(int index) {
		return inner.get(index);
	}

	// ==== Delegate Add Methods (all throw) ====
	@Deprecated
	public final E remove(int index) {
		return inner.remove(index);
	}

	@Deprecated
	public final boolean addAll(int index, Collection<? extends E> newElements) {
		return inner.addAll(index, newElements);
	}

	@Deprecated
	public final E set(int index, E element) {
		return inner.set(index, element);
	}

	@Deprecated
	public final void add(int index, E element) {
		inner.add(index, element);
	}

	@Deprecated
	public final boolean add(E e) {
		return inner.add(e);
	}

	@Deprecated
	public final boolean remove(Object object) {
		return inner.remove(object);
	}

	@Deprecated
	public final boolean addAll(Collection<? extends E> newElements) {
		return inner.addAll(newElements);
	}

	@Deprecated
	public final boolean removeAll(Collection<?> oldElements) {
		return inner.removeAll(oldElements);
	}

	@Deprecated
	public final boolean retainAll(Collection<?> elementsToKeep) {
		return inner.retainAll(elementsToKeep);
	}

	@Deprecated
	public final void clear() {
		inner.clear();
	}

	@Deprecated
	public void replaceAll(UnaryOperator<E> operator) {
		inner.replaceAll(operator);
	}

}
