package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class RtcpFbCapVector extends AbstractList<RtcpFbCap> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RtcpFbCapVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RtcpFbCapVector rtcpFbCapVector) {
        if (rtcpFbCapVector == null) {
            return 0L;
        }
        return rtcpFbCapVector.swigCPtr;
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
                    pjsua2JNI.delete_RtcpFbCapVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public RtcpFbCapVector(RtcpFbCap[] rtcpFbCapArr) {
        this();
        reserve(rtcpFbCapArr.length);
        for (RtcpFbCap rtcpFbCap : rtcpFbCapArr) {
            add(rtcpFbCap);
        }
    }

    public RtcpFbCapVector(Iterable<RtcpFbCap> iterable) {
        this();
        Iterator<RtcpFbCap> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public RtcpFbCap get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public RtcpFbCap set(int i, RtcpFbCap rtcpFbCap) {
        return doSet(i, rtcpFbCap);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(RtcpFbCap rtcpFbCap) {
        ((AbstractList) this).modCount++;
        doAdd(rtcpFbCap);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, RtcpFbCap rtcpFbCap) {
        ((AbstractList) this).modCount++;
        doAdd(i, rtcpFbCap);
    }

    @Override // java.util.AbstractList, java.util.List
    public RtcpFbCap remove(int i) {
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

    public RtcpFbCapVector() {
        this(pjsua2JNI.new_RtcpFbCapVector__SWIG_0(), true);
    }

    public RtcpFbCapVector(RtcpFbCapVector rtcpFbCapVector) {
        this(pjsua2JNI.new_RtcpFbCapVector__SWIG_1(getCPtr(rtcpFbCapVector), rtcpFbCapVector), true);
    }

    public long capacity() {
        return pjsua2JNI.RtcpFbCapVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.RtcpFbCapVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.RtcpFbCapVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.RtcpFbCapVector_clear(this.swigCPtr, this);
    }

    public RtcpFbCapVector(int i, RtcpFbCap rtcpFbCap) {
        this(pjsua2JNI.new_RtcpFbCapVector__SWIG_2(i, RtcpFbCap.getCPtr(rtcpFbCap), rtcpFbCap), true);
    }

    private int doSize() {
        return pjsua2JNI.RtcpFbCapVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(RtcpFbCap rtcpFbCap) {
        pjsua2JNI.RtcpFbCapVector_doAdd__SWIG_0(this.swigCPtr, this, RtcpFbCap.getCPtr(rtcpFbCap), rtcpFbCap);
    }

    private void doAdd(int i, RtcpFbCap rtcpFbCap) {
        pjsua2JNI.RtcpFbCapVector_doAdd__SWIG_1(this.swigCPtr, this, i, RtcpFbCap.getCPtr(rtcpFbCap), rtcpFbCap);
    }

    private RtcpFbCap doRemove(int i) {
        return new RtcpFbCap(pjsua2JNI.RtcpFbCapVector_doRemove(this.swigCPtr, this, i), true);
    }

    private RtcpFbCap doGet(int i) {
        return new RtcpFbCap(pjsua2JNI.RtcpFbCapVector_doGet(this.swigCPtr, this, i), false);
    }

    private RtcpFbCap doSet(int i, RtcpFbCap rtcpFbCap) {
        return new RtcpFbCap(pjsua2JNI.RtcpFbCapVector_doSet(this.swigCPtr, this, i, RtcpFbCap.getCPtr(rtcpFbCap), rtcpFbCap), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.RtcpFbCapVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
