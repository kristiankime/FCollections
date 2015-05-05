package com.artclod.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GauvaImFSetBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;

public class GauvaImFSet<E> extends BaseFSet<E, GauvaImFSet<E>> implements BaseImFCollection<E, GauvaImFSet<E>>, ImFSet<E>, Serializable {
	private static final long serialVersionUID = 1L;

	public GauvaImFSet(ImmutableSet<E> inner) {
		super(inner);
	}

	@Override
	CollectionBuilder<E, GauvaImFSet<E>> builder() {
		return new GauvaImFSetBuilder<E>(ImmutableSet.<E> builder());
	}

	@Override
	Iterator<E> reverseIterator() {
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
	public <O> GauvaImFSet<O> map(Function<E, O> f) {
		Builder<O> builder = ImmutableSet.<O> builder();
		for (E e : this) {
			builder.add(f.apply(e));
		}
		return new GauvaImFSet<O>(builder.build());
	}

}
