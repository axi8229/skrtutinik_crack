package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class StringVector extends AbstractList<String> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StringVector stringVector) {
        if (stringVector == null) {
            return 0L;
        }
        return stringVector.swigCPtr;
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
                    pjsua2JNI.delete_StringVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public StringVector(String[] strArr) {
        this();
        reserve(strArr.length);
        for (String str : strArr) {
            add(str);
        }
    }

    public StringVector(Iterable<String> iterable) {
        this();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        return doSet(i, str);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(String str) {
        ((AbstractList) this).modCount++;
        doAdd(str);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        ((AbstractList) this).modCount++;
        doAdd(i, str);
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
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

    public StringVector() {
        this(pjsua2JNI.new_StringVector__SWIG_0(), true);
    }

    public StringVector(StringVector stringVector) {
        this(pjsua2JNI.new_StringVector__SWIG_1(getCPtr(stringVector), stringVector), true);
    }

    public long capacity() {
        return pjsua2JNI.StringVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.StringVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.StringVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.StringVector_clear(this.swigCPtr, this);
    }

    public StringVector(int i, String str) {
        this(pjsua2JNI.new_StringVector__SWIG_2(i, str), true);
    }

    private int doSize() {
        return pjsua2JNI.StringVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(String str) {
        pjsua2JNI.StringVector_doAdd__SWIG_0(this.swigCPtr, this, str);
    }

    private void doAdd(int i, String str) {
        pjsua2JNI.StringVector_doAdd__SWIG_1(this.swigCPtr, this, i, str);
    }

    private String doRemove(int i) {
        return pjsua2JNI.StringVector_doRemove(this.swigCPtr, this, i);
    }

    private String doGet(int i) {
        return pjsua2JNI.StringVector_doGet(this.swigCPtr, this, i);
    }

    private String doSet(int i, String str) {
        return pjsua2JNI.StringVector_doSet(this.swigCPtr, this, i, str);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.StringVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
