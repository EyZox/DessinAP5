package dessin;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class ListenedList<E> extends ArrayList<E> {
	
	private Runnable r;
	
	public ListenedList(Runnable r) {
		this.r = r;
	}

	@Override
	public boolean add(E e) {
		boolean b = super.add(e);
		r.run();
		return b;
	}

	@Override
	public void add(int index, E element) {
		r.run();
		super.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		boolean b = super.addAll(index, c);
		r.run();
		return b;
	}

	@Override
	public void clear() {
		super.clear();
		r.run();
	}

	@Override
	public E remove(int index) {
		E e = super.remove(index);
		r.run();
		return e;
	}

	@Override
	public boolean remove(Object o) {
		boolean b = super.remove(o);
		r.run();
		return b;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean b = super.removeAll(c);
		r.run();
		return b;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean b = super.retainAll(c);
		r.run();
		return b;
	}

	@Override
	public E set(int index, E element) {
		E e = super.set(index, element);
		r.run();
		return e;
	}
	
	
	
}
