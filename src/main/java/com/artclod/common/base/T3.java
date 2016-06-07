package com.artclod.common.base;

public class T3<E1, E2, E3> extends T2<E1, E2> {
	private static final long serialVersionUID = 1L;

	public final E3 _3;

	public T3(E1 _1, E2 _2, E3 _3) {
		super(_1, _2);
		this._3 = _3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
		result = prime * result + ((_3 == null) ? 0 : _3.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		T3 other = (T3) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "(" + _1 + ", " + _2 + "," + _3 + ")";
	}
}
