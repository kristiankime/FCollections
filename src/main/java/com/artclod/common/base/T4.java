package com.artclod.common.base;

import java.io.Serializable;

public class T4<E1, E2, E3, E4> implements Product4<E1, E2, E3, E4>, Serializable {
	private static final long serialVersionUID = 1L;
	
	public final E1 _1;
	public final E2 _2;
	public final E3 _3;
	public final E4 _4;

	public T4(E1 _1, E2 _2, E3 _3, E4 _4) {
		this._1 = _1;
		this._2 = _2;
		this._3 = _3;
		this._4 = _4;
	}

	public E1 get1() {
		return _1;
	}

	public E2 get2() {
		return _2;
	}
	
	public E3 get3() {
		return _3;
	}

	public E4 get4() {
		return _4;
	}

	public <V> T5<E1, E2, E3, E4, V> append(V value) {
		return Tuples.t(_1, _2, _3, _4, value);
	}

	@Override
	public String toString() {
		return "(" + _1 + ", " + _2 + ", " + _3 + ", " + _4 + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
		result = prime * result + ((_3 == null) ? 0 : _3.hashCode());
		result = prime * result + ((_4 == null) ? 0 : _4.hashCode());
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
		T4 other = (T4) obj;
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
		if (_3 == null) {
			if (other._3 != null)
				return false;
		} else if (!_3.equals(other._3))
			return false;
		if (_4 == null) {
			if (other._4 != null)
				return false;
		} else if (!_4.equals(other._4))
			return false;
		return true;
	}

}
