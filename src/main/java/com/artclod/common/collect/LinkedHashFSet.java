package com.artclod.common.collect;

import java.util.Iterator;
import java.util.LinkedHashSet;

import com.google.common.base.Function;

public class LinkedHashFSet<E> extends BaseFSet<E, LinkedHashFSet<E>> {

	public LinkedHashFSet(LinkedHashSet<E> inner) {
		super(inner);
	}

	@Override
	LinkedHashFSet<E> empty() {
		return new LinkedHashFSet<E>(new LinkedHashSet<E>());
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
