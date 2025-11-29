package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class SipMultipartPartVector extends AbstractList<SipMultipartPart> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipMultipartPartVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipMultipartPartVector sipMultipartPartVector) {
        if (sipMultipartPartVector == null) {
            return 0L;
        }
        return sipMultipartPartVector.swigCPtr;
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
                    pjsua2JNI.delete_SipMultipartPartVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SipMultipartPartVector(SipMultipartPart[] sipMultipartPartArr) {
        this();
        reserve(sipMultipartPartArr.length);
        for (SipMultipartPart sipMultipartPart : sipMultipartPartArr) {
            add(sipMultipartPart);
        }
    }

    public SipMultipartPartVector(Iterable<SipMultipartPart> iterable) {
        this();
        Iterator<SipMultipartPart> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public SipMultipartPart get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public SipMultipartPart set(int i, SipMultipartPart sipMultipartPart) {
        return doSet(i, sipMultipartPart);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(SipMultipartPart sipMultipartPart) {
        ((AbstractList) this).modCount++;
        doAdd(sipMultipartPart);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, SipMultipartPart sipMultipartPart) {
        ((AbstractList) this).modCount++;
        doAdd(i, sipMultipartPart);
    }

    @Override // java.util.AbstractList, java.util.List
    public SipMultipartPart remove(int i) {
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

    public SipMultipartPartVector() {
        this(pjsua2JNI.new_SipMultipartPartVector__SWIG_0(), true);
    }

    public SipMultipartPartVector(SipMultipartPartVector sipMultipartPartVector) {
        this(pjsua2JNI.new_SipMultipartPartVector__SWIG_1(getCPtr(sipMultipartPartVector), sipMultipartPartVector), true);
    }

    public long capacity() {
        return pjsua2JNI.SipMultipartPartVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.SipMultipartPartVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.SipMultipartPartVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.SipMultipartPartVector_clear(this.swigCPtr, this);
    }

    public SipMultipartPartVector(int i, SipMultipartPart sipMultipartPart) {
        this(pjsua2JNI.new_SipMultipartPartVector__SWIG_2(i, SipMultipartPart.getCPtr(sipMultipartPart), sipMultipartPart), true);
    }

    private int doSize() {
        return pjsua2JNI.SipMultipartPartVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(SipMultipartPart sipMultipartPart) {
        pjsua2JNI.SipMultipartPartVector_doAdd__SWIG_0(this.swigCPtr, this, SipMultipartPart.getCPtr(sipMultipartPart), sipMultipartPart);
    }

    private void doAdd(int i, SipMultipartPart sipMultipartPart) {
        pjsua2JNI.SipMultipartPartVector_doAdd__SWIG_1(this.swigCPtr, this, i, SipMultipartPart.getCPtr(sipMultipartPart), sipMultipartPart);
    }

    private SipMultipartPart doRemove(int i) {
        return new SipMultipartPart(pjsua2JNI.SipMultipartPartVector_doRemove(this.swigCPtr, this, i), true);
    }

    private SipMultipartPart doGet(int i) {
        return new SipMultipartPart(pjsua2JNI.SipMultipartPartVector_doGet(this.swigCPtr, this, i), false);
    }

    private SipMultipartPart doSet(int i, SipMultipartPart sipMultipartPart) {
        return new SipMultipartPart(pjsua2JNI.SipMultipartPartVector_doSet(this.swigCPtr, this, i, SipMultipartPart.getCPtr(sipMultipartPart), sipMultipartPart), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.SipMultipartPartVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
