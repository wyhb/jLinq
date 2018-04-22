package com.github.wyhb.joe.jLinq.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.github.wyhb.joe.jLinq.linq.IEnumerable;

/**
 *
 */
public class Set<TSource> implements IEnumerable<TSource>, java.util.Set<TSource> {
// ------------------------------ FIELDS ------------------------------

    private java.util.Set<TSource> set = new LinkedHashSet<>();

// --------------------------- CONSTRUCTORS ---------------------------

    public Set() {
    }

    @SafeVarargs
    public Set(TSource... items) {
        if (items != null) {
            Collections.addAll(this, items);
        }
    }

    public Set(IEnumerable<TSource> items) {
        for (TSource item : items) this.add(item);
    }

    @Override
    public boolean add(final TSource t) {
        return set.add(t);
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override
    public boolean equals(Object o) {
        return set.equals(o);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Collection ---------------------

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @SuppressWarnings("hiding")
	@Override
    public <TSource> TSource[] toArray(TSource[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends TSource> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }

// --------------------- Interface Iterable ---------------------

    @Override
    public Iterator<TSource> iterator() {
        return set.iterator();
    }
}
