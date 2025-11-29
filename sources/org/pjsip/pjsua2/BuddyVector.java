package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class BuddyVector extends AbstractList<Buddy> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BuddyVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BuddyVector buddyVector) {
        if (buddyVector == null) {
            return 0L;
        }
        return buddyVector.swigCPtr;
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
                    pjsua2JNI.delete_BuddyVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public BuddyVector(Buddy[] buddyArr) {
        this();
        reserve(buddyArr.length);
        for (Buddy buddy : buddyArr) {
            add(buddy);
        }
    }

    public BuddyVector(Iterable<Buddy> iterable) {
        this();
        Iterator<Buddy> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Buddy get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Buddy set(int i, Buddy buddy) {
        return doSet(i, buddy);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Buddy buddy) {
        ((AbstractList) this).modCount++;
        doAdd(buddy);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Buddy buddy) {
        ((AbstractList) this).modCount++;
        doAdd(i, buddy);
    }

    @Override // java.util.AbstractList, java.util.List
    public Buddy remove(int i) {
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

    public BuddyVector() {
        this(pjsua2JNI.new_BuddyVector__SWIG_0(), true);
    }

    public BuddyVector(BuddyVector buddyVector) {
        this(pjsua2JNI.new_BuddyVector__SWIG_1(getCPtr(buddyVector), buddyVector), true);
    }

    public long capacity() {
        return pjsua2JNI.BuddyVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.BuddyVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.BuddyVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.BuddyVector_clear(this.swigCPtr, this);
    }

    public BuddyVector(int i, Buddy buddy) {
        this(pjsua2JNI.new_BuddyVector__SWIG_2(i, Buddy.getCPtr(buddy), buddy), true);
    }

    private int doSize() {
        return pjsua2JNI.BuddyVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(Buddy buddy) {
        pjsua2JNI.BuddyVector_doAdd__SWIG_0(this.swigCPtr, this, Buddy.getCPtr(buddy), buddy);
    }

    private void doAdd(int i, Buddy buddy) {
        pjsua2JNI.BuddyVector_doAdd__SWIG_1(this.swigCPtr, this, i, Buddy.getCPtr(buddy), buddy);
    }

    private Buddy doRemove(int i) {
        long jBuddyVector_doRemove = pjsua2JNI.BuddyVector_doRemove(this.swigCPtr, this, i);
        if (jBuddyVector_doRemove == 0) {
            return null;
        }
        return new Buddy(jBuddyVector_doRemove, false);
    }

    private Buddy doGet(int i) {
        long jBuddyVector_doGet = pjsua2JNI.BuddyVector_doGet(this.swigCPtr, this, i);
        if (jBuddyVector_doGet == 0) {
            return null;
        }
        return new Buddy(jBuddyVector_doGet, false);
    }

    private Buddy doSet(int i, Buddy buddy) {
        long jBuddyVector_doSet = pjsua2JNI.BuddyVector_doSet(this.swigCPtr, this, i, Buddy.getCPtr(buddy), buddy);
        if (jBuddyVector_doSet == 0) {
            return null;
        }
        return new Buddy(jBuddyVector_doSet, false);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.BuddyVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
