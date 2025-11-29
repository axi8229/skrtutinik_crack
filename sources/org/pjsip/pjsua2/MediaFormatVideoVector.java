package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class MediaFormatVideoVector extends AbstractList<MediaFormatVideo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaFormatVideoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaFormatVideoVector mediaFormatVideoVector) {
        if (mediaFormatVideoVector == null) {
            return 0L;
        }
        return mediaFormatVideoVector.swigCPtr;
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
                    pjsua2JNI.delete_MediaFormatVideoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public MediaFormatVideoVector(MediaFormatVideo[] mediaFormatVideoArr) {
        this();
        reserve(mediaFormatVideoArr.length);
        for (MediaFormatVideo mediaFormatVideo : mediaFormatVideoArr) {
            add(mediaFormatVideo);
        }
    }

    public MediaFormatVideoVector(Iterable<MediaFormatVideo> iterable) {
        this();
        Iterator<MediaFormatVideo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatVideo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatVideo set(int i, MediaFormatVideo mediaFormatVideo) {
        return doSet(i, mediaFormatVideo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(MediaFormatVideo mediaFormatVideo) {
        ((AbstractList) this).modCount++;
        doAdd(mediaFormatVideo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, MediaFormatVideo mediaFormatVideo) {
        ((AbstractList) this).modCount++;
        doAdd(i, mediaFormatVideo);
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatVideo remove(int i) {
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

    public MediaFormatVideoVector() {
        this(pjsua2JNI.new_MediaFormatVideoVector__SWIG_0(), true);
    }

    public MediaFormatVideoVector(MediaFormatVideoVector mediaFormatVideoVector) {
        this(pjsua2JNI.new_MediaFormatVideoVector__SWIG_1(getCPtr(mediaFormatVideoVector), mediaFormatVideoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.MediaFormatVideoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.MediaFormatVideoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.MediaFormatVideoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.MediaFormatVideoVector_clear(this.swigCPtr, this);
    }

    public MediaFormatVideoVector(int i, MediaFormatVideo mediaFormatVideo) {
        this(pjsua2JNI.new_MediaFormatVideoVector__SWIG_2(i, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo), true);
    }

    private int doSize() {
        return pjsua2JNI.MediaFormatVideoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(MediaFormatVideo mediaFormatVideo) {
        pjsua2JNI.MediaFormatVideoVector_doAdd__SWIG_0(this.swigCPtr, this, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo);
    }

    private void doAdd(int i, MediaFormatVideo mediaFormatVideo) {
        pjsua2JNI.MediaFormatVideoVector_doAdd__SWIG_1(this.swigCPtr, this, i, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo);
    }

    private MediaFormatVideo doRemove(int i) {
        return new MediaFormatVideo(pjsua2JNI.MediaFormatVideoVector_doRemove(this.swigCPtr, this, i), true);
    }

    private MediaFormatVideo doGet(int i) {
        return new MediaFormatVideo(pjsua2JNI.MediaFormatVideoVector_doGet(this.swigCPtr, this, i), false);
    }

    private MediaFormatVideo doSet(int i, MediaFormatVideo mediaFormatVideo) {
        return new MediaFormatVideo(pjsua2JNI.MediaFormatVideoVector_doSet(this.swigCPtr, this, i, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.MediaFormatVideoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
