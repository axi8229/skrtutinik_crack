package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class SslCertNameVector extends AbstractList<SslCertName> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SslCertNameVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SslCertNameVector sslCertNameVector) {
        if (sslCertNameVector == null) {
            return 0L;
        }
        return sslCertNameVector.swigCPtr;
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
                    pjsua2JNI.delete_SslCertNameVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SslCertNameVector(SslCertName[] sslCertNameArr) {
        this();
        reserve(sslCertNameArr.length);
        for (SslCertName sslCertName : sslCertNameArr) {
            add(sslCertName);
        }
    }

    public SslCertNameVector(Iterable<SslCertName> iterable) {
        this();
        Iterator<SslCertName> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public SslCertName get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public SslCertName set(int i, SslCertName sslCertName) {
        return doSet(i, sslCertName);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(SslCertName sslCertName) {
        ((AbstractList) this).modCount++;
        doAdd(sslCertName);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, SslCertName sslCertName) {
        ((AbstractList) this).modCount++;
        doAdd(i, sslCertName);
    }

    @Override // java.util.AbstractList, java.util.List
    public SslCertName remove(int i) {
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

    public SslCertNameVector() {
        this(pjsua2JNI.new_SslCertNameVector__SWIG_0(), true);
    }

    public SslCertNameVector(SslCertNameVector sslCertNameVector) {
        this(pjsua2JNI.new_SslCertNameVector__SWIG_1(getCPtr(sslCertNameVector), sslCertNameVector), true);
    }

    public long capacity() {
        return pjsua2JNI.SslCertNameVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.SslCertNameVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.SslCertNameVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.SslCertNameVector_clear(this.swigCPtr, this);
    }

    public SslCertNameVector(int i, SslCertName sslCertName) {
        this(pjsua2JNI.new_SslCertNameVector__SWIG_2(i, SslCertName.getCPtr(sslCertName), sslCertName), true);
    }

    private int doSize() {
        return pjsua2JNI.SslCertNameVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(SslCertName sslCertName) {
        pjsua2JNI.SslCertNameVector_doAdd__SWIG_0(this.swigCPtr, this, SslCertName.getCPtr(sslCertName), sslCertName);
    }

    private void doAdd(int i, SslCertName sslCertName) {
        pjsua2JNI.SslCertNameVector_doAdd__SWIG_1(this.swigCPtr, this, i, SslCertName.getCPtr(sslCertName), sslCertName);
    }

    private SslCertName doRemove(int i) {
        return new SslCertName(pjsua2JNI.SslCertNameVector_doRemove(this.swigCPtr, this, i), true);
    }

    private SslCertName doGet(int i) {
        return new SslCertName(pjsua2JNI.SslCertNameVector_doGet(this.swigCPtr, this, i), false);
    }

    private SslCertName doSet(int i, SslCertName sslCertName) {
        return new SslCertName(pjsua2JNI.SslCertNameVector_doSet(this.swigCPtr, this, i, SslCertName.getCPtr(sslCertName), sslCertName), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.SslCertNameVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
