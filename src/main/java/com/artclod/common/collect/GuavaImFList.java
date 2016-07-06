package com.artclod.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.artclod.common.collect.base.BaseFList;
import com.artclod.common.collect.base.UnsupportMutationListMixIn;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GuavaImFListBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

public class GuavaImFList<E> extends BaseFList<E, GuavaImFList<E>> implements UnsupportMutationListMixIn<E>, ImFList<E> {
	private static final long serialVersionUID = 1L;

	public static <E> GuavaImFList<E> wrap(ImmutableList<E> inner) {
		return new GuavaImFList<E>(inner);
	}
	
	public static <E> GuavaImFList<E> create() {
		return new GuavaImFList<E>(ImmutableList.of());
	}

	public static <E> GuavaImFList<E> create(Iterable<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public static <E> GuavaImFList<E> create(Collection<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public static <E> GuavaImFList<E> create(Iterator<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	@SafeVarargs
	public static <E> GuavaImFList<E> create(E... elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}
	
	public static <E> GuavaImFList<E> create(ImmutableList.Builder<E> builder) {
		return new GuavaImFList<E>(builder.build());
	}
	
	protected final ImmutableList<E> inner;

	public GuavaImFList(ImmutableList<E> inner) {
		super(inner);
		this.inner = inner;
	}

	@Override
	protected CollectionBuilder<E, GuavaImFList<E>> builder() {
		return new GuavaImFListBuilder<E>(ImmutableList.<E> builder());
	}

	@Override
	protected CollectionBuilder<E, GuavaImFList<E>> builder(Collection<E> c) {
		return new GuavaImFListBuilder<E>(ImmutableList.<E> builder().addAll(c));
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
		return ArrayFList.create(this);
	}

	public GuavaImFList<E> toIm() {
		return this;
	}

	@Override
	public <O> GuavaImFList<O> map(Function<? super E, ? extends O> f) {
		Builder<O> builder = ImmutableList.<O> builder();
		for (E e : this) {
			builder.add(f.apply(e));
		}
		return new GuavaImFList<O>(builder.build());
	}

	@Override
	public <O> GuavaImFList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		Builder<O> builder = ImmutableList.<O> builder();
		for (E e : this) {
			builder.addAll(mapper.apply(e));
		}
		return new GuavaImFList<O>(builder.build());
	}

	// ==== Group ====
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <K> GuavaImFMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f) {
		  return (GuavaImFMap<K, FCollection<E>>) (GuavaImFMap) groupByInternal(f);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <K> GuavaImFMap<K, FList<E>> groupByL(Function<? super E, ? extends K> f) {
		  return (GuavaImFMap<K, FList<E>>) (GuavaImFMap) groupByInternal(f);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <K> GuavaImFMap<K, ImFList<E>> groupByIL(Function<? super E, ? extends K> f) {
		  return (GuavaImFMap<K, ImFList<E>>) (GuavaImFMap) groupByInternal(f);
	}
	
	public <K> GuavaImFMap<K, GuavaImFList<E>> groupByT(Function<? super E, ? extends K> f) {
		  return groupByInternal(f);
	}
	
	protected <K> GuavaImFMap<K, GuavaImFList<E>> groupByInternal(Function<? super E, ? extends K> f) {
		return new GuavaImFMap<>(ImmutableMap.copyOf(super.groupByInternal(f)));
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

	// ==== Unsupported
	// TODO for some reason this is required on certain compilers
	@Deprecated
	public void replaceAll(UnaryOperator<E> operator) {
		throw new UnsupportedOperationException();
	}
}
