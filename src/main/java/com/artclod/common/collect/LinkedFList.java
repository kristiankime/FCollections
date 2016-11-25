package com.artclod.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Function;

import com.artclod.common.collect.base.BaseFList;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.collect.Lists;

public class LinkedFList<E> extends BaseFList<E, LinkedFList<E>> {
	private static final long serialVersionUID = 1L;

	public static <E> LinkedFList<E> wrap(LinkedList<E> inner) {
		return new LinkedFList<E>(inner);
	}

	public static <E> LinkedFList<E> create() {
		return new LinkedFList<E>();
	}

	public static <E> LinkedFList<E> create(Iterable<? extends E> elements) {
		return new LinkedFList<E>(elements);
	}
	
	@SafeVarargs
	public static <E> LinkedFList<E> create(E... elements) {
		return new LinkedFList<E>(elements);
	}

	public LinkedFList() {
		this(new LinkedList<>());
	}
	
	public LinkedFList(Iterable<? extends E> elements) {
		this(Lists.newLinkedList(elements));
	}
	
	@SafeVarargs
	public LinkedFList(E... elements) {
		this(Lists.newLinkedList(Arrays.asList(elements)));
	}
	
	protected LinkedFList(LinkedList<E> inner) {
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
	protected CollectionBuilder<E, LinkedFList<E>> builder(Collection<E> c) {
		return new LinkedFListBuilder<E>(new LinkedList<E>(c));
	}
	
	public LinkedFList<E> toList() {
    	return this;
    }
	
	@Override
	public <O> LinkedFList<O> map(Function<? super E, ? extends O> f) {
		LinkedList<O> create = Lists.newLinkedList();
		for (E e : this) {
			create.add(f.apply(e));
		}
		return new LinkedFList<O>(create);
	}
	
	
	@Override
	public <O> LinkedFList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
		LinkedList<O> create = Lists.newLinkedList();
		for (E e : this) {
			create.addAll(mapper.apply(e));
		}
		return new LinkedFList<O>(create);
	}

}
