package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class ToneDigitMapVector extends AbstractList<ToneDigitMapDigit> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ToneDigitMapVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDigitMapVector toneDigitMapVector) {
        if (toneDigitMapVector == null) {
            return 0L;
        }
        return toneDigitMapVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_ToneDigitMapVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public ToneDigitMapVector(ToneDigitMapDigit[] toneDigitMapDigitArr) {
        this();
        reserve(toneDigitMapDigitArr.length);
        for (ToneDigitMapDigit toneDigitMapDigit : toneDigitMapDigitArr) {
            add(toneDigitMapDigit);
        }
    }

    public ToneDigitMapVector(Iterable<ToneDigitMapDigit> iterable) {
        this();
        Iterator<ToneDigitMapDigit> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigitMapDigit get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigitMapDigit set(int i, ToneDigitMapDigit toneDigitMapDigit) {
        return doSet(i, toneDigitMapDigit);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(ToneDigitMapDigit toneDigitMapDigit) {
        ((AbstractList) this).modCount++;
        doAdd(toneDigitMapDigit);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, ToneDigitMapDigit toneDigitMapDigit) {
        ((AbstractList) this).modCount++;
        doAdd(i, toneDigitMapDigit);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigitMapDigit remove(int i) {
        ((AbstractList) this).modCount++;
        return doRemove(i);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        ((AbstractList) this).modCount++;
        doRemoveRange(i, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return doSize();
    }

    public ToneDigitMapVector() {
        this(pjsua2JNI.new_ToneDigitMapVector__SWIG_0(), true);
    }

    public ToneDigitMapVector(ToneDigitMapVector toneDigitMapVector) {
        this(pjsua2JNI.new_ToneDigitMapVector__SWIG_1(getCPtr(toneDigitMapVector), toneDigitMapVector), true);
    }

    public long capacity() {
        return pjsua2JNI.ToneDigitMapVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.ToneDigitMapVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.ToneDigitMapVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.ToneDigitMapVector_clear(this.swigCPtr, this);
    }

    public ToneDigitMapVector(int i, ToneDigitMapDigit toneDigitMapDigit) {
        this(pjsua2JNI.new_ToneDigitMapVector__SWIG_2(i, ToneDigitMapDigit.getCPtr(toneDigitMapDigit), toneDigitMapDigit), true);
    }

    private int doSize() {
        return pjsua2JNI.ToneDigitMapVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(ToneDigitMapDigit toneDigitMapDigit) {
        pjsua2JNI.ToneDigitMapVector_doAdd__SWIG_0(this.swigCPtr, this, ToneDigitMapDigit.getCPtr(toneDigitMapDigit), toneDigitMapDigit);
    }

    private void doAdd(int i, ToneDigitMapDigit toneDigitMapDigit) {
        pjsua2JNI.ToneDigitMapVector_doAdd__SWIG_1(this.swigCPtr, this, i, ToneDigitMapDigit.getCPtr(toneDigitMapDigit), toneDigitMapDigit);
    }

    private ToneDigitMapDigit doRemove(int i) {
        return new ToneDigitMapDigit(pjsua2JNI.ToneDigitMapVector_doRemove(this.swigCPtr, this, i), true);
    }

    private ToneDigitMapDigit doGet(int i) {
        return new ToneDigitMapDigit(pjsua2JNI.ToneDigitMapVector_doGet(this.swigCPtr, this, i), false);
    }

    private ToneDigitMapDigit doSet(int i, ToneDigitMapDigit toneDigitMapDigit) {
        return new ToneDigitMapDigit(pjsua2JNI.ToneDigitMapVector_doSet(this.swigCPtr, this, i, ToneDigitMapDigit.getCPtr(toneDigitMapDigit), toneDigitMapDigit), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.ToneDigitMapVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
