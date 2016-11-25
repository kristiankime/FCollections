package com.artclod.common.collect;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Function;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.collect.Sets;

public class HashFSet<E> extends BaseFSet<E, HashFSet<E>> {
	private static final long serialVersionUID = 1L;

	public static <E> HashFSet<E> wrap(HashSet<E> inner) {
		return new HashFSet<E>(inner);
	}
	
	public static <E> HashFSet<E> create() {
		return new HashFSet<E>();
	}

	@SafeVarargs
	public static <E> HashFSet<E> create(E... elements) {
		return new HashFSet<E>(elements);
	}

	public static <E> HashFSet<E> create(Iterable<? extends E> elements) {
		return new HashFSet<E>(elements);
	}

	public static <E> HashFSet<E> create(Iterator<? extends E> elements) {
		return new HashFSet<E>(elements);
	}

	public static <E> HashFSet<E> createWithExpectedSize(int expectedSize) {
		return new HashFSet<E>(Sets.newHashSetWithExpectedSize(expectedSize));
	}

	public HashFSet() {
		this(Sets.newHashSet());
	}
	
	@SafeVarargs
	public HashFSet(E... elements) {
		this(Sets.newHashSet(elements));
	}
	
	public HashFSet(Iterable<? extends E> elements) {
		this(Sets.newHashSet(elements));
	}
	
	public HashFSet(Iterator<? extends E> elements) {
		this(Sets.newHashSet(elements));
	}
	
	protected HashFSet(HashSet<E> inner) {
		super(inner);
	}

	// This exist so we can create a CollectionBuilder of the right type
	private static class HashFSetBuilder<E> extends HashFSet<E> implements CollectionBuilder<E, HashFSet<E>> {
		private static final long serialVersionUID = 1L;

		public HashFSetBuilder(HashSet<E> inner) {
			super(inner);
		}

		@Override
		public HashFSet<E> build() {
			return this;
		}
	}

	@Override
	protected CollectionBuilder<E, HashFSet<E>> builder() {
		return new HashFSetBuilder<E>(new HashSet<E>());
	}
		
	@Override
	protected CollectionBuilder<E, HashFSet<E>> builder(Collection<E> c) {
		return new HashFSetBuilder<E>(new HashSet<E>(c));
	}

	public HashFSet<E> toSet() {
    	return this;
    }
	
	@Override
	protected Iterator<E> reverseIterator() {
		return iterator(); // There is no sensible reverse of a HashSet
	}

	@Override
	public <O> FSet<O> map(Function<? super E, ? extends O> f) {
		HashFSet<O> ret = new HashFSet<O>(new HashSet<O>());
		for (E e : this) {
			ret.add(f.apply(e));
		}
		return ret;
	}

	@Override
	public <O> HashFSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		HashFSet<O> ret = new HashFSet<O>(new HashSet<O>());
		for (E e : this) {
			ret.addAll(mapper.apply(e));
		}
		return ret;
	}
	
}
