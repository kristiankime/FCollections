package com.artclod.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.artclod.common.collect.base.BaseFList;
import com.artclod.common.collect.base.IMFListMixin;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GauvaImFListBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;

public class GuavaImFList<E> extends BaseFList<E, GuavaImFList<E>> implements ImFList<E>, IMFListMixin<E>, Serializable {
	private static final long serialVersionUID = 1L;

	protected final ImmutableList<E> inner;

	public static <E> GuavaImFList<E> of() {
		return new GuavaImFList<E>(ImmutableList.of());
	}

	public static <E> GuavaImFList<E> ofInner(ImmutableList<E> inner) {
		return new GuavaImFList<E>(inner);
	}

	public static <E> GuavaImFList<E> copyOf(Iterable<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public static <E> GuavaImFList<E> copyOf(Collection<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public static <E> GuavaImFList<E> copyOf(Iterator<? extends E> elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public static <E> GuavaImFList<E> copyOf(E[] elements) {
		return new GuavaImFList<E>(ImmutableList.copyOf(elements));
	}

	public GuavaImFList(ImmutableList<E> inner) {
		super(inner);
		this.inner = inner;
	}

	@Override
	protected CollectionBuilder<E, GuavaImFList<E>> builder() {
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
		return ArrayFList.create(this);
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

}
