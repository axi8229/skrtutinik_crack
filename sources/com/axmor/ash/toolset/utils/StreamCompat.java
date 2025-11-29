package com.axmor.ash.toolset.utils;

import java.util.ArrayList;
import java.util.Iterator;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class StreamCompat {

    private static class SelectIterator<W, T> implements Iterator<W> {

        @NonNull
        private final Lambda$FactoryCode1<W, T> select;

        @NonNull
        private final Iterator<? extends T> source;

        public SelectIterator(@NonNull Iterator<? extends T> it, @NonNull Lambda$FactoryCode1<W, T> lambda$FactoryCode1) {
            if (it == null) {
                throw new NullPointerException("source is marked non-null but is null");
            }
            if (lambda$FactoryCode1 == null) {
                throw new NullPointerException("select is marked non-null but is null");
            }
            this.source = it;
            this.select = lambda$FactoryCode1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.source.hasNext();
        }

        @Override // java.util.Iterator
        public W next() {
            return (W) this.select.produce(this.source.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> void forEach(@NonNull Iterable<? extends T> iterable, @NonNull Lambda$Code1<T> lambda$Code1) {
        if (iterable == null) {
            throw new NullPointerException("source is marked non-null but is null");
        }
        if (lambda$Code1 == null) {
            throw new NullPointerException("action is marked non-null but is null");
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            lambda$Code1.invoke(it.next());
        }
    }

    public static <W, T> Iterable<W> select(@NonNull final Iterable<? extends T> iterable, @NonNull final Lambda$FactoryCode1<W, T> lambda$FactoryCode1) {
        if (iterable == null) {
            throw new NullPointerException("source is marked non-null but is null");
        }
        if (lambda$FactoryCode1 != null) {
            return new Iterable<W>() { // from class: com.axmor.ash.toolset.utils.StreamCompat.2
                @Override // java.lang.Iterable
                public Iterator<W> iterator() {
                    return new SelectIterator(iterable.iterator(), lambda$FactoryCode1);
                }
            };
        }
        throw new NullPointerException("select is marked non-null but is null");
    }

    public static <T> ArrayList<T> toList(@NonNull Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("source is marked non-null but is null");
        }
        ArrayList<T> arrayList = new ArrayList<>();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
