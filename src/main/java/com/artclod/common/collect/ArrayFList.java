package com.artclod.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ArrayFList<E> extends BaseFList<E> implements Serializable {
	private static final long serialVersionUID = 0L;

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

	// ============ FLIST METHODS =========
	public FList<E> filter(Predicate<? super E> filter) {
		ArrayList<E> create = Lists.newArrayList();
		for (int i = 0; i < inner.size(); i++) {
			if (filter.test(inner.get(i))) {
				create.add(inner.get(i));
			}
		}
		return new ArrayFList<E>(create);
	}

	@Override
	public <O> ArrayFList<O> map(Function<E, O> f) {
		ArrayList<O> create = Lists.newArrayListWithCapacity(inner.size());
		for (int i = 0; i < inner.size(); i++) {
			create.add(f.apply(inner.get(i)));
		}
		return new ArrayFList<O>(create);
	}

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
