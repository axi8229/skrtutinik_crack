package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class CallMediaInfoVector extends AbstractList<CallMediaInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallMediaInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallMediaInfoVector callMediaInfoVector) {
        if (callMediaInfoVector == null) {
            return 0L;
        }
        return callMediaInfoVector.swigCPtr;
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
                    pjsua2JNI.delete_CallMediaInfoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public CallMediaInfoVector(CallMediaInfo[] callMediaInfoArr) {
        this();
        reserve(callMediaInfoArr.length);
        for (CallMediaInfo callMediaInfo : callMediaInfoArr) {
            add(callMediaInfo);
        }
    }

    public CallMediaInfoVector(Iterable<CallMediaInfo> iterable) {
        this();
        Iterator<CallMediaInfo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public CallMediaInfo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public CallMediaInfo set(int i, CallMediaInfo callMediaInfo) {
        return doSet(i, callMediaInfo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(CallMediaInfo callMediaInfo) {
        ((AbstractList) this).modCount++;
        doAdd(callMediaInfo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, CallMediaInfo callMediaInfo) {
        ((AbstractList) this).modCount++;
        doAdd(i, callMediaInfo);
    }

    @Override // java.util.AbstractList, java.util.List
    public CallMediaInfo remove(int i) {
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

    public CallMediaInfoVector() {
        this(pjsua2JNI.new_CallMediaInfoVector__SWIG_0(), true);
    }

    public CallMediaInfoVector(CallMediaInfoVector callMediaInfoVector) {
        this(pjsua2JNI.new_CallMediaInfoVector__SWIG_1(getCPtr(callMediaInfoVector), callMediaInfoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.CallMediaInfoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.CallMediaInfoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.CallMediaInfoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.CallMediaInfoVector_clear(this.swigCPtr, this);
    }

    public CallMediaInfoVector(int i, CallMediaInfo callMediaInfo) {
        this(pjsua2JNI.new_CallMediaInfoVector__SWIG_2(i, CallMediaInfo.getCPtr(callMediaInfo), callMediaInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.CallMediaInfoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(CallMediaInfo callMediaInfo) {
        pjsua2JNI.CallMediaInfoVector_doAdd__SWIG_0(this.swigCPtr, this, CallMediaInfo.getCPtr(callMediaInfo), callMediaInfo);
    }

    private void doAdd(int i, CallMediaInfo callMediaInfo) {
        pjsua2JNI.CallMediaInfoVector_doAdd__SWIG_1(this.swigCPtr, this, i, CallMediaInfo.getCPtr(callMediaInfo), callMediaInfo);
    }

    private CallMediaInfo doRemove(int i) {
        return new CallMediaInfo(pjsua2JNI.CallMediaInfoVector_doRemove(this.swigCPtr, this, i), true);
    }

    private CallMediaInfo doGet(int i) {
        return new CallMediaInfo(pjsua2JNI.CallMediaInfoVector_doGet(this.swigCPtr, this, i), false);
    }

    private CallMediaInfo doSet(int i, CallMediaInfo callMediaInfo) {
        return new CallMediaInfo(pjsua2JNI.CallMediaInfoVector_doSet(this.swigCPtr, this, i, CallMediaInfo.getCPtr(callMediaInfo), callMediaInfo), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.CallMediaInfoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
