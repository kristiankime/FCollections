package com.artclod.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Function;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.base.ImFCollectionMixIn;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GauvaImFSetBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;

public class GauvaImFSet<E> extends BaseFSet<E, GauvaImFSet<E>> implements ImFCollectionMixIn<E>, ImFSet<E>, Serializable {
	private static final long serialVersionUID = 1L;

	public static <E> GauvaImFSet<E> wrap(ImmutableSet<E> inner) {
		return new GauvaImFSet<E>(inner);
	}

	public static <E> GauvaImFSet<E> create() {
		return new GauvaImFSet<E>(ImmutableSet.of());
	}

	public static <E> GauvaImFSet<E> create(@SuppressWarnings("unchecked") E... elements) {
		return new GauvaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public static <E> GauvaImFSet<E> create(Collection<E> c) {
		return new GauvaImFSet<E>(ImmutableSet.copyOf(c));
	}

	public static <E> GauvaImFSet<E> create(Iterable<? extends E> elements) {
		return new GauvaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public static <E> GauvaImFSet<E> create(Iterator<? extends E> elements) {
		return new GauvaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public GauvaImFSet(ImmutableSet<E> inner) {
		super(inner);
	}

	@Override
	protected CollectionBuilder<E, GauvaImFSet<E>> builder() {
		return new GauvaImFSetBuilder<E>(ImmutableSet.<E> builder());
	}

	@Override
	protected Iterator<E> reverseIterator() {
		return iterator(); // No sensible reverse
	}

	@Override
	public GauvaImFSet<E> addCp(E e) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.add(e);
		return new GauvaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GauvaImFSet<E> addAllCp(Collection<? extends E> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.addAll(c);
		return new GauvaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GauvaImFSet<E> removeCp(Object o) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.remove(o);
		return new GauvaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GauvaImFSet<E> removeAllCp(Collection<?> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.removeAll(c);
		return new GauvaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GauvaImFSet<E> retainAllCp(Collection<?> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.retainAll(c);
		return new GauvaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public <O> GauvaImFSet<O> map(Function<? super E, ? extends O> f) {
		Builder<O> builder = ImmutableSet.<O> builder();
		for (E e : this) {
			builder.add(f.apply(e));
		}
		return new GauvaImFSet<O>(builder.build());
	}

	@Override
	public <O> GauvaImFSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		Builder<O> builder = ImmutableSet.<O> builder();
		for (E e : this) {
			builder.addAll(mapper.apply(e));
		}
		return new GauvaImFSet<O>(builder.build());
	}
	
}
