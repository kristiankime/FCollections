package com.artclod.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Function;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.base.UnsupportMutationSetMixIn;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.artclod.common.collect.builder.GuavaImFSetBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;

public class GuavaImFSet<E> extends BaseFSet<E, GuavaImFSet<E>> implements ImFSet<E>, UnsupportMutationSetMixIn<E> {
	private static final long serialVersionUID = 1L;

	public static <E> GuavaImFSet<E> wrap(ImmutableSet<E> inner) {
		return new GuavaImFSet<E>(inner);
	}

	public static <E> GuavaImFSet<E> create() {
		return new GuavaImFSet<E>(ImmutableSet.of());
	}

	@SafeVarargs
	public static <E> GuavaImFSet<E> create(E... elements) {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public static <E> GuavaImFSet<E> create(Collection<E> c) {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(c));
	}

	public static <E> GuavaImFSet<E> create(Iterable<? extends E> elements) {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public static <E> GuavaImFSet<E> create(Iterator<? extends E> elements) {
		return new GuavaImFSet<E>(ImmutableSet.copyOf(elements));
	}

	public GuavaImFSet(ImmutableSet<E> inner) {
		super(inner);
	}

	@Override
	protected CollectionBuilder<E, GuavaImFSet<E>> builder() {
		return new GuavaImFSetBuilder<E>(ImmutableSet.<E> builder());
	}
	
	@Override
	protected CollectionBuilder<E, GuavaImFSet<E>> builder(Collection<E> c) {
		return new GuavaImFSetBuilder<E>(ImmutableSet.<E> builder().addAll(c));
	}

	@Override
	protected Iterator<E> reverseIterator() {
		return iterator(); // No sensible reverse
	}

	@Override
	public GuavaImFSet<E> addCp(E e) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.add(e);
		return new GuavaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GuavaImFSet<E> addAllCp(Collection<? extends E> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.addAll(c);
		return new GuavaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GuavaImFSet<E> removeCp(Object o) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.remove(o);
		return new GuavaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GuavaImFSet<E> removeAllCp(Collection<?> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.removeAll(c);
		return new GuavaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public GuavaImFSet<E> retainAllCp(Collection<?> c) {
		LinkedHashSet<E> set = Sets.newLinkedHashSet(this);
		set.retainAll(c);
		return new GuavaImFSet<E>(ImmutableSet.copyOf(set));
	}

	@Override
	public <O> GuavaImFSet<O> map(Function<? super E, ? extends O> f) {
		Builder<O> builder = ImmutableSet.<O> builder();
		for (E e : this) {
			builder.add(f.apply(e));
		}
		return new GuavaImFSet<O>(builder.build());
	}

	@Override
	public <O> GuavaImFSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		Builder<O> builder = ImmutableSet.<O> builder();
		for (E e : this) {
			builder.addAll(mapper.apply(e));
		}
		return new GuavaImFSet<O>(builder.build());
	}
	
}
