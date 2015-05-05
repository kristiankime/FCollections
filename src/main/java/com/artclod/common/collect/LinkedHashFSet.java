package com.artclod.common.collect;

import java.util.Iterator;
import java.util.LinkedHashSet;

import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.base.Function;

public class LinkedHashFSet<E> extends BaseFSet<E, LinkedHashFSet<E>> {

	public LinkedHashFSet(LinkedHashSet<E> inner) {
		super(inner);
	}

	// This exist so we can create a CollectionBuilder of the right type 
	static class LinkedHashFSetBuilder<E> extends LinkedHashFSet<E> implements CollectionBuilder<E, LinkedHashFSet<E>> {
		public LinkedHashFSetBuilder(LinkedHashSet<E> inner) {
			super(inner);
		}
		
		@Override
		public LinkedHashFSet<E> build() {
			return this;
		}
	}
	
	@Override
	CollectionBuilder<E, LinkedHashFSet<E>> empty() {
		return new LinkedHashFSetBuilder<E>(new LinkedHashSet<E>());
	}
	
	@Override
	public <O> FSet<O> map(Function<E, O> f) {
		LinkedHashFSet<O> ret = new LinkedHashFSet<O>(new LinkedHashSet<O>());
		for(E e: this){
			ret.add(f.apply(e));
		}
		return ret;
	}


	@Override
	Iterator<E> reverseIterator() {
		return iterator(); // There is no sensible reverse of a HashSet
	}

}
