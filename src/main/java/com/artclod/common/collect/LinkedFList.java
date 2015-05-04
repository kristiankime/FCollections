package com.artclod.common.collect;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.function.Predicate;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class LinkedFList<E> extends BaseFList<E> implements Serializable {
	private static final long serialVersionUID = 0L;

	public static <E> LinkedFList<E> create(LinkedList<E> inner) {
		return new LinkedFList<E>(inner);
	}

	public static <E> LinkedFList<E> create() {
		return new LinkedFList<E>();
	}

	public static <E> LinkedFList<E> create(Iterable<? extends E> elements) {
		return new LinkedFList<E>(elements);
	}

	public LinkedFList(LinkedList<E> inner) {
		super(inner);
	}

	public LinkedFList() {
		super(Lists.newLinkedList());
	}

	public LinkedFList(Iterable<? extends E> elements) {
		super(Lists.newLinkedList(elements));
	}

	// ============ FLIST METHODS =========
	public LinkedFList<E> filter(Predicate<? super E> filter) {
		LinkedList<E> create = Lists.newLinkedList();
		for (E e : this) {
			if (filter.test(e)) {
				create.add(e);
			}
		}
		return new LinkedFList<E>(create);
	}

	@Override
	public <O> LinkedFList<O> map(Function<E, O> f) {
		LinkedList<O> create = Lists.newLinkedList();
		for (E e : this) {
			create.add(f.apply(e));
		}
		return new LinkedFList<O>(create);
	}

}
