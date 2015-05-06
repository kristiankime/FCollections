package com.artclod.common.collect;

import java.io.Serializable;
import java.util.LinkedList;

import com.artclod.common.collect.base.BaseFList;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class LinkedFList<E> extends BaseFList<E, LinkedFList<E>> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static <E> LinkedFList<E> createInner(LinkedList<E> inner) {
		return new LinkedFList<E>(inner);
	}

	public static <E> LinkedFList<E> create() {
		return new LinkedFList<E>(Lists.newLinkedList());
	}

	public static <E> LinkedFList<E> create(Iterable<? extends E> elements) {
		return new LinkedFList<E>(Lists.newLinkedList(elements));
	}

	public LinkedFList(LinkedList<E> inner) {
		super(inner);
	}

	// This exist so we can create a CollectionBuilder of the right type 
	static class LinkedFListBuilder<E> extends LinkedFList<E> implements CollectionBuilder<E, LinkedFList<E>> {
		private static final long serialVersionUID = 1L;

		public LinkedFListBuilder(LinkedList<E> inner) {
			super(inner);
		}
		
		@Override
		public LinkedFList<E> build() {
			return this;
		}
	}
	
	@Override
	protected CollectionBuilder<E, LinkedFList<E>> builder() {
		return new LinkedFListBuilder<E>(new LinkedList<E>());
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
