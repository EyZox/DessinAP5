package dessin;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class ListenedList<E> extends ArrayList<E> {
	
	private Runnable r;
	/**
	 * Definit un Runnable pour la ListenedList
	 * @param r
	 */
	public ListenedList(Runnable r) {
		this.r = r;
	}
	/**
	 * Ajoute un Objet a la liste et renvoie un booleen.
	 * @param e
	 */
	@Override
	public boolean add(E e) {
		boolean b = super.add(e);
		r.run();
		return b;
	}

	/**
	 * Ajoute l'element E a l'index choisit.
	 * @param index
	 * @param element
	 */
	@Override
	public void add(int index, E element) {
		r.run();
		super.add(index, element);
	}

	/**
	 * Ajoute une collection d'Objet E a la liste.
	 * @param c
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return super.addAll(c);
	}
	/**
	 * Ajoute a un index une Collection d'objet E à la liste.
	 * @param index
	 * @param c
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		boolean b = super.addAll(index, c);
		r.run();
		return b;
	}

	/**
	 * @see ListenedList#clear()
	 */
	@Override
	public void clear() {
		super.clear();
		r.run();
	}
	/**
	 * Retire un element E à un index donne.
	 * @param index
	 * @return e
	 */
	@Override
	public E remove(int index) {
		E e = super.remove(index);
		r.run();
		return e;
	}
	/**
	 * Retire l'objet O de la liste et renvoie un booleen.
	 * @param o
	 * return un booleen
	 */
	@Override
	public boolean remove(Object o) {
		boolean b = super.remove(o);
		r.run();
		return b;
	}
	/**
	 * Retire une collection de la liste et renvoie un booleen.
	 * @param c
	 * @return un booleen
	 */
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
	/**
	 * Definit un Element E à l'index donne.
	 * @param index
	 * @param element
	 * @return l'element concerne.
	 */
	@Override
	public E set(int index, E element) {
		E e = super.set(index, element);
		r.run();
		return e;
	}
	
	
	
}
