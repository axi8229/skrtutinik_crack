package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class SipHeaderVector extends AbstractList<SipHeader> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipHeaderVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipHeaderVector sipHeaderVector) {
        if (sipHeaderVector == null) {
            return 0L;
        }
        return sipHeaderVector.swigCPtr;
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
                    pjsua2JNI.delete_SipHeaderVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SipHeaderVector(SipHeader[] sipHeaderArr) {
        this();
        reserve(sipHeaderArr.length);
        for (SipHeader sipHeader : sipHeaderArr) {
            add(sipHeader);
        }
    }

    public SipHeaderVector(Iterable<SipHeader> iterable) {
        this();
        Iterator<SipHeader> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public SipHeader get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public SipHeader set(int i, SipHeader sipHeader) {
        return doSet(i, sipHeader);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(SipHeader sipHeader) {
        ((AbstractList) this).modCount++;
        doAdd(sipHeader);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, SipHeader sipHeader) {
        ((AbstractList) this).modCount++;
        doAdd(i, sipHeader);
    }

    @Override // java.util.AbstractList, java.util.List
    public SipHeader remove(int i) {
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

    public SipHeaderVector() {
        this(pjsua2JNI.new_SipHeaderVector__SWIG_0(), true);
    }

    public SipHeaderVector(SipHeaderVector sipHeaderVector) {
        this(pjsua2JNI.new_SipHeaderVector__SWIG_1(getCPtr(sipHeaderVector), sipHeaderVector), true);
    }

    public long capacity() {
        return pjsua2JNI.SipHeaderVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.SipHeaderVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.SipHeaderVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.SipHeaderVector_clear(this.swigCPtr, this);
    }

    public SipHeaderVector(int i, SipHeader sipHeader) {
        this(pjsua2JNI.new_SipHeaderVector__SWIG_2(i, SipHeader.getCPtr(sipHeader), sipHeader), true);
    }

    private int doSize() {
        return pjsua2JNI.SipHeaderVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(SipHeader sipHeader) {
        pjsua2JNI.SipHeaderVector_doAdd__SWIG_0(this.swigCPtr, this, SipHeader.getCPtr(sipHeader), sipHeader);
    }

    private void doAdd(int i, SipHeader sipHeader) {
        pjsua2JNI.SipHeaderVector_doAdd__SWIG_1(this.swigCPtr, this, i, SipHeader.getCPtr(sipHeader), sipHeader);
    }

    private SipHeader doRemove(int i) {
        return new SipHeader(pjsua2JNI.SipHeaderVector_doRemove(this.swigCPtr, this, i), true);
    }

    private SipHeader doGet(int i) {
        return new SipHeader(pjsua2JNI.SipHeaderVector_doGet(this.swigCPtr, this, i), false);
    }

    private SipHeader doSet(int i, SipHeader sipHeader) {
        return new SipHeader(pjsua2JNI.SipHeaderVector_doSet(this.swigCPtr, this, i, SipHeader.getCPtr(sipHeader), sipHeader), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.SipHeaderVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
