package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class AuthCredInfoVector extends AbstractList<AuthCredInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AuthCredInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AuthCredInfoVector authCredInfoVector) {
        if (authCredInfoVector == null) {
            return 0L;
        }
        return authCredInfoVector.swigCPtr;
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
                    pjsua2JNI.delete_AuthCredInfoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public AuthCredInfoVector(AuthCredInfo[] authCredInfoArr) {
        this();
        reserve(authCredInfoArr.length);
        for (AuthCredInfo authCredInfo : authCredInfoArr) {
            add(authCredInfo);
        }
    }

    public AuthCredInfoVector(Iterable<AuthCredInfo> iterable) {
        this();
        Iterator<AuthCredInfo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public AuthCredInfo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public AuthCredInfo set(int i, AuthCredInfo authCredInfo) {
        return doSet(i, authCredInfo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(AuthCredInfo authCredInfo) {
        ((AbstractList) this).modCount++;
        doAdd(authCredInfo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, AuthCredInfo authCredInfo) {
        ((AbstractList) this).modCount++;
        doAdd(i, authCredInfo);
    }

    @Override // java.util.AbstractList, java.util.List
    public AuthCredInfo remove(int i) {
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

    public AuthCredInfoVector() {
        this(pjsua2JNI.new_AuthCredInfoVector__SWIG_0(), true);
    }

    public AuthCredInfoVector(AuthCredInfoVector authCredInfoVector) {
        this(pjsua2JNI.new_AuthCredInfoVector__SWIG_1(getCPtr(authCredInfoVector), authCredInfoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.AuthCredInfoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.AuthCredInfoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.AuthCredInfoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.AuthCredInfoVector_clear(this.swigCPtr, this);
    }

    public AuthCredInfoVector(int i, AuthCredInfo authCredInfo) {
        this(pjsua2JNI.new_AuthCredInfoVector__SWIG_2(i, AuthCredInfo.getCPtr(authCredInfo), authCredInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.AuthCredInfoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(AuthCredInfo authCredInfo) {
        pjsua2JNI.AuthCredInfoVector_doAdd__SWIG_0(this.swigCPtr, this, AuthCredInfo.getCPtr(authCredInfo), authCredInfo);
    }

    private void doAdd(int i, AuthCredInfo authCredInfo) {
        pjsua2JNI.AuthCredInfoVector_doAdd__SWIG_1(this.swigCPtr, this, i, AuthCredInfo.getCPtr(authCredInfo), authCredInfo);
    }

    private AuthCredInfo doRemove(int i) {
        return new AuthCredInfo(pjsua2JNI.AuthCredInfoVector_doRemove(this.swigCPtr, this, i), true);
    }

    private AuthCredInfo doGet(int i) {
        return new AuthCredInfo(pjsua2JNI.AuthCredInfoVector_doGet(this.swigCPtr, this, i), false);
    }

    private AuthCredInfo doSet(int i, AuthCredInfo authCredInfo) {
        return new AuthCredInfo(pjsua2JNI.AuthCredInfoVector_doSet(this.swigCPtr, this, i, AuthCredInfo.getCPtr(authCredInfo), authCredInfo), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.AuthCredInfoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
