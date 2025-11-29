package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class CodecFmtpVector extends AbstractList<CodecFmtp> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecFmtpVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecFmtpVector codecFmtpVector) {
        if (codecFmtpVector == null) {
            return 0L;
        }
        return codecFmtpVector.swigCPtr;
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
                    pjsua2JNI.delete_CodecFmtpVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public CodecFmtpVector(CodecFmtp[] codecFmtpArr) {
        this();
        reserve(codecFmtpArr.length);
        for (CodecFmtp codecFmtp : codecFmtpArr) {
            add(codecFmtp);
        }
    }

    public CodecFmtpVector(Iterable<CodecFmtp> iterable) {
        this();
        Iterator<CodecFmtp> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecFmtp get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecFmtp set(int i, CodecFmtp codecFmtp) {
        return doSet(i, codecFmtp);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(CodecFmtp codecFmtp) {
        ((AbstractList) this).modCount++;
        doAdd(codecFmtp);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, CodecFmtp codecFmtp) {
        ((AbstractList) this).modCount++;
        doAdd(i, codecFmtp);
    }

    @Override // java.util.AbstractList, java.util.List
    public CodecFmtp remove(int i) {
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

    public CodecFmtpVector() {
        this(pjsua2JNI.new_CodecFmtpVector__SWIG_0(), true);
    }

    public CodecFmtpVector(CodecFmtpVector codecFmtpVector) {
        this(pjsua2JNI.new_CodecFmtpVector__SWIG_1(getCPtr(codecFmtpVector), codecFmtpVector), true);
    }

    public long capacity() {
        return pjsua2JNI.CodecFmtpVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.CodecFmtpVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.CodecFmtpVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.CodecFmtpVector_clear(this.swigCPtr, this);
    }

    public CodecFmtpVector(int i, CodecFmtp codecFmtp) {
        this(pjsua2JNI.new_CodecFmtpVector__SWIG_2(i, CodecFmtp.getCPtr(codecFmtp), codecFmtp), true);
    }

    private int doSize() {
        return pjsua2JNI.CodecFmtpVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(CodecFmtp codecFmtp) {
        pjsua2JNI.CodecFmtpVector_doAdd__SWIG_0(this.swigCPtr, this, CodecFmtp.getCPtr(codecFmtp), codecFmtp);
    }

    private void doAdd(int i, CodecFmtp codecFmtp) {
        pjsua2JNI.CodecFmtpVector_doAdd__SWIG_1(this.swigCPtr, this, i, CodecFmtp.getCPtr(codecFmtp), codecFmtp);
    }

    private CodecFmtp doRemove(int i) {
        return new CodecFmtp(pjsua2JNI.CodecFmtpVector_doRemove(this.swigCPtr, this, i), true);
    }

    private CodecFmtp doGet(int i) {
        return new CodecFmtp(pjsua2JNI.CodecFmtpVector_doGet(this.swigCPtr, this, i), false);
    }

    private CodecFmtp doSet(int i, CodecFmtp codecFmtp) {
        return new CodecFmtp(pjsua2JNI.CodecFmtpVector_doSet(this.swigCPtr, this, i, CodecFmtp.getCPtr(codecFmtp), codecFmtp), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.CodecFmtpVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
