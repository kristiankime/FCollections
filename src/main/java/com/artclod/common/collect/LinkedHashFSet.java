package com.artclod.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.base.Function;

public class LinkedHashFSet<E> extends BaseFSet<E, LinkedHashFSet<E>> implements Serializable {
	private static final long serialVersionUID = 1L;

	public LinkedHashFSet(LinkedHashSet<E> inner) {
		super(inner);
	}

	// This exist so we can create a CollectionBuilder of the right type 
	private static class LinkedHashFSetBuilder<E> extends LinkedHashFSet<E> implements CollectionBuilder<E, LinkedHashFSet<E>> {
		private static final long serialVersionUID = 1L;

		public LinkedHashFSetBuilder(LinkedHashSet<E> inner) {
			super(inner);
		}
		
		@Override
		public LinkedHashFSet<E> build() {
			return this;
		}
	}
	
	@Override
	protected CollectionBuilder<E, LinkedHashFSet<E>> builder() {
		return new LinkedHashFSetBuilder<E>(new LinkedHashSet<E>());
	}
	
	@Override
	protected Iterator<E> reverseIterator() {
		return iterator(); // There is no sensible reverse of a HashSet
	}
	
	@Override
	public <O> FSet<O> map(Function<E, O> f) {
		LinkedHashFSet<O> ret = new LinkedHashFSet<O>(new LinkedHashSet<O>());
		for(E e: this){
			ret.add(f.apply(e));
		}
		return ret;
	}

}
