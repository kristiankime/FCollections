package com.artclod.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ArrayFList<E> extends BaseFList<E, ArrayFList<E>> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static <E> ArrayFList<E> create(ArrayList<E> inner) {
		return new ArrayFList<E>(inner);
	}

	public static <E> ArrayFList<E> create() {
		return new ArrayFList<E>();
	}

	public static <E> ArrayFList<E> create(@SuppressWarnings("unchecked") E... elements) {
		return new ArrayFList<E>(elements);
	}

	public static <E> ArrayFList<E> create(Iterable<? extends E> elements) {
		return new ArrayFList<E>(elements);
	}

	public static <E> ArrayFList<E> create(Iterator<? extends E> elements) {
		return new ArrayFList<E>(elements);
	}

	public ArrayFList(ArrayList<E> inner) {
		super(inner);
	}

	public ArrayFList() {
		super(Lists.newArrayList());
	}

	public ArrayFList(@SuppressWarnings("unchecked") E... elements) {
		super(Lists.newArrayList(elements));
	}

	public ArrayFList(Iterable<? extends E> elements) {
		super(Lists.newArrayList(elements));
	}

	public ArrayFList(Iterator<? extends E> elements) {
		super(Lists.newArrayList(elements));
	}

	// This exist so we can create a CollectionBuilder of the right type 
	static class ArrayFListBuilder<E> extends ArrayFList<E> implements CollectionBuilder<E, ArrayFList<E>> {
		private static final long serialVersionUID = 1L;

		public ArrayFListBuilder(ArrayList<E> inner) {
			super(inner);
		}
		
		@Override
		public ArrayFList<E> build() {
			return this;
		}
	}
	
	@Override
	CollectionBuilder<E, ArrayFList<E>> builder() {
		return new ArrayFListBuilder<E>(new ArrayList<E>());
	}

	@Override
	public <O> ArrayFList<O> map(Function<E, O> f) {
		ArrayList<O> create = Lists.newArrayListWithCapacity(inner.size());
		for (int i = 0; i < inner.size(); i++) {
			create.add(f.apply(inner.get(i)));
		}
		return new ArrayFList<O>(create);
	}

	// === Looping Methods
	// Looping without creating in iterator is faster so we reimplement some methods for speed
	public String mkString(String start, String sep, String end) {
		StringBuilder ret = new StringBuilder(start);
		for (int i = 0; i < inner.size(); i++) {
			ret.append(inner.get(i));
			if (i != (inner.size() - 1)) {
				ret.append(sep);
			}
		}
		return ret.append(end).toString();
	}

}
