package com.artclod.common.base;

import java.io.Serializable;
import java.util.Map;

public class T2<E1, E2> implements Product2<E1, E2>, Map.Entry<E1, E2>, Serializable {
	private static final long serialVersionUID = 1L;

	public final E1 _1;
	public final E2 _2;
	
	public T2(E1 _1, E2 _2) {
		this._1 = _1;
		this._2 = _2;
	}
	
	public E1 get1() {
		return _1;
	}

	public E2 get2() {
		return _2;
	}

	public <V> T3<E1, E2, V> append(V value) {
		return Tuples.t(_1, _2, value);
	}

	@Override
	public String toString() {
		return "(" + _1 + ", " + _2 + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T2 other = (T2) obj;
		if (_1 == null) {
			if (other._1 != null)
				return false;
		} else if (!_1.equals(other._1))
			return false;
		if (_2 == null) {
			if (other._2 != null)
				return false;
		} else if (!_2.equals(other._2))
			return false;
		return true;
	}

}
