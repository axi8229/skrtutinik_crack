package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class SrtpCryptoVector extends AbstractList<SrtpCrypto> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SrtpCryptoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SrtpCryptoVector srtpCryptoVector) {
        if (srtpCryptoVector == null) {
            return 0L;
        }
        return srtpCryptoVector.swigCPtr;
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
                    pjsua2JNI.delete_SrtpCryptoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SrtpCryptoVector(SrtpCrypto[] srtpCryptoArr) {
        this();
        reserve(srtpCryptoArr.length);
        for (SrtpCrypto srtpCrypto : srtpCryptoArr) {
            add(srtpCrypto);
        }
    }

    public SrtpCryptoVector(Iterable<SrtpCrypto> iterable) {
        this();
        Iterator<SrtpCrypto> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public SrtpCrypto get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public SrtpCrypto set(int i, SrtpCrypto srtpCrypto) {
        return doSet(i, srtpCrypto);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(SrtpCrypto srtpCrypto) {
        ((AbstractList) this).modCount++;
        doAdd(srtpCrypto);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, SrtpCrypto srtpCrypto) {
        ((AbstractList) this).modCount++;
        doAdd(i, srtpCrypto);
    }

    @Override // java.util.AbstractList, java.util.List
    public SrtpCrypto remove(int i) {
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

    public SrtpCryptoVector() {
        this(pjsua2JNI.new_SrtpCryptoVector__SWIG_0(), true);
    }

    public SrtpCryptoVector(SrtpCryptoVector srtpCryptoVector) {
        this(pjsua2JNI.new_SrtpCryptoVector__SWIG_1(getCPtr(srtpCryptoVector), srtpCryptoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.SrtpCryptoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.SrtpCryptoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.SrtpCryptoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.SrtpCryptoVector_clear(this.swigCPtr, this);
    }

    public SrtpCryptoVector(int i, SrtpCrypto srtpCrypto) {
        this(pjsua2JNI.new_SrtpCryptoVector__SWIG_2(i, SrtpCrypto.getCPtr(srtpCrypto), srtpCrypto), true);
    }

    private int doSize() {
        return pjsua2JNI.SrtpCryptoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(SrtpCrypto srtpCrypto) {
        pjsua2JNI.SrtpCryptoVector_doAdd__SWIG_0(this.swigCPtr, this, SrtpCrypto.getCPtr(srtpCrypto), srtpCrypto);
    }

    private void doAdd(int i, SrtpCrypto srtpCrypto) {
        pjsua2JNI.SrtpCryptoVector_doAdd__SWIG_1(this.swigCPtr, this, i, SrtpCrypto.getCPtr(srtpCrypto), srtpCrypto);
    }

    private SrtpCrypto doRemove(int i) {
        return new SrtpCrypto(pjsua2JNI.SrtpCryptoVector_doRemove(this.swigCPtr, this, i), true);
    }

    private SrtpCrypto doGet(int i) {
        return new SrtpCrypto(pjsua2JNI.SrtpCryptoVector_doGet(this.swigCPtr, this, i), false);
    }

    private SrtpCrypto doSet(int i, SrtpCrypto srtpCrypto) {
        return new SrtpCrypto(pjsua2JNI.SrtpCryptoVector_doSet(this.swigCPtr, this, i, SrtpCrypto.getCPtr(srtpCrypto), srtpCrypto), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.SrtpCryptoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
