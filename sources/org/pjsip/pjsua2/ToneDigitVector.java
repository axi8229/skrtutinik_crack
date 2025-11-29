package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class ToneDigitVector extends AbstractList<ToneDigit> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ToneDigitVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDigitVector toneDigitVector) {
        if (toneDigitVector == null) {
            return 0L;
        }
        return toneDigitVector.swigCPtr;
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
                    pjsua2JNI.delete_ToneDigitVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public ToneDigitVector(ToneDigit[] toneDigitArr) {
        this();
        reserve(toneDigitArr.length);
        for (ToneDigit toneDigit : toneDigitArr) {
            add(toneDigit);
        }
    }

    public ToneDigitVector(Iterable<ToneDigit> iterable) {
        this();
        Iterator<ToneDigit> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigit get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigit set(int i, ToneDigit toneDigit) {
        return doSet(i, toneDigit);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(ToneDigit toneDigit) {
        ((AbstractList) this).modCount++;
        doAdd(toneDigit);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, ToneDigit toneDigit) {
        ((AbstractList) this).modCount++;
        doAdd(i, toneDigit);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDigit remove(int i) {
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

    public ToneDigitVector() {
        this(pjsua2JNI.new_ToneDigitVector__SWIG_0(), true);
    }

    public ToneDigitVector(ToneDigitVector toneDigitVector) {
        this(pjsua2JNI.new_ToneDigitVector__SWIG_1(getCPtr(toneDigitVector), toneDigitVector), true);
    }

    public long capacity() {
        return pjsua2JNI.ToneDigitVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.ToneDigitVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.ToneDigitVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.ToneDigitVector_clear(this.swigCPtr, this);
    }

    public ToneDigitVector(int i, ToneDigit toneDigit) {
        this(pjsua2JNI.new_ToneDigitVector__SWIG_2(i, ToneDigit.getCPtr(toneDigit), toneDigit), true);
    }

    private int doSize() {
        return pjsua2JNI.ToneDigitVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(ToneDigit toneDigit) {
        pjsua2JNI.ToneDigitVector_doAdd__SWIG_0(this.swigCPtr, this, ToneDigit.getCPtr(toneDigit), toneDigit);
    }

    private void doAdd(int i, ToneDigit toneDigit) {
        pjsua2JNI.ToneDigitVector_doAdd__SWIG_1(this.swigCPtr, this, i, ToneDigit.getCPtr(toneDigit), toneDigit);
    }

    private ToneDigit doRemove(int i) {
        return new ToneDigit(pjsua2JNI.ToneDigitVector_doRemove(this.swigCPtr, this, i), true);
    }

    private ToneDigit doGet(int i) {
        return new ToneDigit(pjsua2JNI.ToneDigitVector_doGet(this.swigCPtr, this, i), false);
    }

    private ToneDigit doSet(int i, ToneDigit toneDigit) {
        return new ToneDigit(pjsua2JNI.ToneDigitVector_doSet(this.swigCPtr, this, i, ToneDigit.getCPtr(toneDigit), toneDigit), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.ToneDigitVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
