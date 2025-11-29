package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class CodecInfoVector extends AbstractList<CodecInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecInfoVector codecInfoVector) {
        if (codecInfoVector == null) {
            return 0L;
        }
        return codecInfoVector.swigCPtr;
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
                    pjsua2JNI.delete_CodecInfoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public CodecInfoVector(CodecInfo[] codecInfoArr) {
        this();
        reserve(codecInfoArr.length);
        for (CodecInfo codecInfo : codecInfoArr) {
            add(codecInfo);
        }
    }

    public CodecInfoVector(Iterable<CodecInfo> iterable) {
        this();
        Iterator<CodecInfo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecInfo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecInfo set(int i, CodecInfo codecInfo) {
        return doSet(i, codecInfo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(CodecInfo codecInfo) {
        ((AbstractList) this).modCount++;
        doAdd(codecInfo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, CodecInfo codecInfo) {
        ((AbstractList) this).modCount++;
        doAdd(i, codecInfo);
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecInfo remove(int i) {
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

    public CodecInfoVector() {
        this(pjsua2JNI.new_CodecInfoVector__SWIG_0(), true);
    }

    public CodecInfoVector(CodecInfoVector codecInfoVector) {
        this(pjsua2JNI.new_CodecInfoVector__SWIG_1(getCPtr(codecInfoVector), codecInfoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.CodecInfoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.CodecInfoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.CodecInfoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.CodecInfoVector_clear(this.swigCPtr, this);
    }

    public CodecInfoVector(int i, CodecInfo codecInfo) {
        this(pjsua2JNI.new_CodecInfoVector__SWIG_2(i, CodecInfo.getCPtr(codecInfo), codecInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.CodecInfoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(CodecInfo codecInfo) {
        pjsua2JNI.CodecInfoVector_doAdd__SWIG_0(this.swigCPtr, this, CodecInfo.getCPtr(codecInfo), codecInfo);
    }

    private void doAdd(int i, CodecInfo codecInfo) {
        pjsua2JNI.CodecInfoVector_doAdd__SWIG_1(this.swigCPtr, this, i, CodecInfo.getCPtr(codecInfo), codecInfo);
    }

    private CodecInfo doRemove(int i) {
        long jCodecInfoVector_doRemove = pjsua2JNI.CodecInfoVector_doRemove(this.swigCPtr, this, i);
        if (jCodecInfoVector_doRemove == 0) {
            return null;
        }
        return new CodecInfo(jCodecInfoVector_doRemove, false);
    }

    private CodecInfo doGet(int i) {
        long jCodecInfoVector_doGet = pjsua2JNI.CodecInfoVector_doGet(this.swigCPtr, this, i);
        if (jCodecInfoVector_doGet == 0) {
            return null;
        }
        return new CodecInfo(jCodecInfoVector_doGet, false);
    }

    private CodecInfo doSet(int i, CodecInfo codecInfo) {
        long jCodecInfoVector_doSet = pjsua2JNI.CodecInfoVector_doSet(this.swigCPtr, this, i, CodecInfo.getCPtr(codecInfo), codecInfo);
        if (jCodecInfoVector_doSet == 0) {
            return null;
        }
        return new CodecInfo(jCodecInfoVector_doSet, false);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.CodecInfoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
