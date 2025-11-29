package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class BuddyVector2 extends AbstractList<Buddy> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BuddyVector2(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BuddyVector2 buddyVector2) {
        if (buddyVector2 == null) {
            return 0L;
        }
        return buddyVector2.swigCPtr;
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
                    pjsua2JNI.delete_BuddyVector2(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public BuddyVector2(Buddy[] buddyArr) {
        this();
        reserve(buddyArr.length);
        for (Buddy buddy : buddyArr) {
            add(buddy);
        }
    }

    public BuddyVector2(Iterable<Buddy> iterable) {
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

    public BuddyVector2() {
        this(pjsua2JNI.new_BuddyVector2__SWIG_0(), true);
    }

    public BuddyVector2(BuddyVector2 buddyVector2) {
        this(pjsua2JNI.new_BuddyVector2__SWIG_1(getCPtr(buddyVector2), buddyVector2), true);
    }

    public long capacity() {
        return pjsua2JNI.BuddyVector2_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.BuddyVector2_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.BuddyVector2_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.BuddyVector2_clear(this.swigCPtr, this);
    }

    public BuddyVector2(int i, Buddy buddy) {
        this(pjsua2JNI.new_BuddyVector2__SWIG_2(i, Buddy.getCPtr(buddy), buddy), true);
    }

    private int doSize() {
        return pjsua2JNI.BuddyVector2_doSize(this.swigCPtr, this);
    }

    private void doAdd(Buddy buddy) {
        pjsua2JNI.BuddyVector2_doAdd__SWIG_0(this.swigCPtr, this, Buddy.getCPtr(buddy), buddy);
    }

    private void doAdd(int i, Buddy buddy) {
        pjsua2JNI.BuddyVector2_doAdd__SWIG_1(this.swigCPtr, this, i, Buddy.getCPtr(buddy), buddy);
    }

    private Buddy doRemove(int i) {
        return new Buddy(pjsua2JNI.BuddyVector2_doRemove(this.swigCPtr, this, i), true);
    }

    private Buddy doGet(int i) {
        return new Buddy(pjsua2JNI.BuddyVector2_doGet(this.swigCPtr, this, i), false);
    }

    private Buddy doSet(int i, Buddy buddy) {
        return new Buddy(pjsua2JNI.BuddyVector2_doSet(this.swigCPtr, this, i, Buddy.getCPtr(buddy), buddy), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.BuddyVector2_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
