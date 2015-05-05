package com.artclod.common.collect;

import java.util.HashSet;
import java.util.Iterator;

import com.google.common.base.Function;

public class HashFSet<E> extends BaseFSet<E, HashFSet<E>> {

	public HashFSet(HashSet<E> inner) {
		super(inner);
	}

	@Override
	HashFSet<E> empty() {
		return new HashFSet<E>(new HashSet<E>());
	}
	
	@Override
	public <O> FSet<O> map(Function<E, O> f) {
		HashFSet<O> ret = new HashFSet<O>(new HashSet<O>());
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
