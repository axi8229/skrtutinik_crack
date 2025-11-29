package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class ToneDescVector extends AbstractList<ToneDesc> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ToneDescVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDescVector toneDescVector) {
        if (toneDescVector == null) {
            return 0L;
        }
        return toneDescVector.swigCPtr;
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
                    pjsua2JNI.delete_ToneDescVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public ToneDescVector(ToneDesc[] toneDescArr) {
        this();
        reserve(toneDescArr.length);
        for (ToneDesc toneDesc : toneDescArr) {
            add(toneDesc);
        }
    }

    public ToneDescVector(Iterable<ToneDesc> iterable) {
        this();
        Iterator<ToneDesc> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDesc get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDesc set(int i, ToneDesc toneDesc) {
        return doSet(i, toneDesc);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(ToneDesc toneDesc) {
        ((AbstractList) this).modCount++;
        doAdd(toneDesc);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, ToneDesc toneDesc) {
        ((AbstractList) this).modCount++;
        doAdd(i, toneDesc);
    }

    @Override // java.util.AbstractList, java.util.List
    public ToneDesc remove(int i) {
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

    public ToneDescVector() {
        this(pjsua2JNI.new_ToneDescVector__SWIG_0(), true);
    }

    public ToneDescVector(ToneDescVector toneDescVector) {
        this(pjsua2JNI.new_ToneDescVector__SWIG_1(getCPtr(toneDescVector), toneDescVector), true);
    }

    public long capacity() {
        return pjsua2JNI.ToneDescVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.ToneDescVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.ToneDescVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.ToneDescVector_clear(this.swigCPtr, this);
    }

    public ToneDescVector(int i, ToneDesc toneDesc) {
        this(pjsua2JNI.new_ToneDescVector__SWIG_2(i, ToneDesc.getCPtr(toneDesc), toneDesc), true);
    }

    private int doSize() {
        return pjsua2JNI.ToneDescVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(ToneDesc toneDesc) {
        pjsua2JNI.ToneDescVector_doAdd__SWIG_0(this.swigCPtr, this, ToneDesc.getCPtr(toneDesc), toneDesc);
    }

    private void doAdd(int i, ToneDesc toneDesc) {
        pjsua2JNI.ToneDescVector_doAdd__SWIG_1(this.swigCPtr, this, i, ToneDesc.getCPtr(toneDesc), toneDesc);
    }

    private ToneDesc doRemove(int i) {
        return new ToneDesc(pjsua2JNI.ToneDescVector_doRemove(this.swigCPtr, this, i), true);
    }

    private ToneDesc doGet(int i) {
        return new ToneDesc(pjsua2JNI.ToneDescVector_doGet(this.swigCPtr, this, i), false);
    }

    private ToneDesc doSet(int i, ToneDesc toneDesc) {
        return new ToneDesc(pjsua2JNI.ToneDescVector_doSet(this.swigCPtr, this, i, ToneDesc.getCPtr(toneDesc), toneDesc), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.ToneDescVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
