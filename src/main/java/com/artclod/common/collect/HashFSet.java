package com.artclod.common.collect;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.base.Function;
import com.google.common.collect.Sets;

public class HashFSet<E> extends BaseFSet<E, HashFSet<E>> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static <E> HashFSet<E> create() {
		return new HashFSet<E>(Sets.newHashSet());
	}

	public static <E> HashFSet<E> create(@SuppressWarnings("unchecked") E... elements) {
		return new HashFSet<E>(Sets.newHashSet(elements));
	}

	public static <E> HashFSet<E> create(Iterable<? extends E> elements) {
		return new HashFSet<E>(Sets.newHashSet(elements));
	}

	public static <E> HashFSet<E> create(Iterator<? extends E> elements) {
		return new HashFSet<E>(Sets.newHashSet(elements));
	}

	public static <E> HashFSet<E> createWithExpectedSize(int expectedSize) {
		return new HashFSet<E>(Sets.newHashSetWithExpectedSize(expectedSize));
	}

	public HashFSet(HashSet<E> inner) {
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
	protected Iterator<E> reverseIterator() {
		return iterator(); // There is no sensible reverse of a HashSet
	}

	@Override
	public <O> FSet<O> map(Function<E, O> f) {
		HashFSet<O> ret = new HashFSet<O>(new HashSet<O>());
		for (E e : this) {
			ret.add(f.apply(e));
		}
		return ret;
	}

}
