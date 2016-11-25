package com.artclod.common.collect;

public interface ImFCollection<E> extends ViewFCollection<E> {
		
    default ImFList<E> toList() {
    	return GuavaImFList.create(this);
    }
    
    default ImFSet<E> toSet() {
    	return GuavaImFSet.create(this);
    }
    
}
