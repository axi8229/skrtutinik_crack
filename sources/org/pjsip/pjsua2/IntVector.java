package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class IntVector extends AbstractList<Integer> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected IntVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IntVector intVector) {
        if (intVector == null) {
            return 0L;
        }
        return intVector.swigCPtr;
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
                    pjsua2JNI.delete_IntVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public IntVector(int[] iArr) {
        this();
        reserve(iArr.length);
        for (int i : iArr) {
            add(Integer.valueOf(i));
        }
    }

    public IntVector(Iterable<Integer> iterable) {
        this();
        for (Integer num : iterable) {
            num.intValue();
            add(num);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(doGet(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer set(int i, Integer num) {
        return Integer.valueOf(doSet(i, num.intValue()));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        ((AbstractList) this).modCount++;
        doAdd(num.intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Integer num) {
        ((AbstractList) this).modCount++;
        doAdd(i, num.intValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        ((AbstractList) this).modCount++;
        return Integer.valueOf(doRemove(i));
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

    public IntVector() {
        this(pjsua2JNI.new_IntVector__SWIG_0(), true);
    }

    public IntVector(IntVector intVector) {
        this(pjsua2JNI.new_IntVector__SWIG_1(getCPtr(intVector), intVector), true);
    }

    public long capacity() {
        return pjsua2JNI.IntVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.IntVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.IntVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.IntVector_clear(this.swigCPtr, this);
    }

    public IntVector(int i, int i2) {
        this(pjsua2JNI.new_IntVector__SWIG_2(i, i2), true);
    }

    private int doSize() {
        return pjsua2JNI.IntVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(int i) {
        pjsua2JNI.IntVector_doAdd__SWIG_0(this.swigCPtr, this, i);
    }

    private void doAdd(int i, int i2) {
        pjsua2JNI.IntVector_doAdd__SWIG_1(this.swigCPtr, this, i, i2);
    }

    private int doRemove(int i) {
        return pjsua2JNI.IntVector_doRemove(this.swigCPtr, this, i);
    }

    private int doGet(int i) {
        return pjsua2JNI.IntVector_doGet(this.swigCPtr, this, i);
    }

    private int doSet(int i, int i2) {
        return pjsua2JNI.IntVector_doSet(this.swigCPtr, this, i, i2);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.IntVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
