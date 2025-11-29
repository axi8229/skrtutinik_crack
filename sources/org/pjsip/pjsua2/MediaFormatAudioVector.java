package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class MediaFormatAudioVector extends AbstractList<MediaFormatAudio> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaFormatAudioVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaFormatAudioVector mediaFormatAudioVector) {
        if (mediaFormatAudioVector == null) {
            return 0L;
        }
        return mediaFormatAudioVector.swigCPtr;
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
                    pjsua2JNI.delete_MediaFormatAudioVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public MediaFormatAudioVector(MediaFormatAudio[] mediaFormatAudioArr) {
        this();
        reserve(mediaFormatAudioArr.length);
        for (MediaFormatAudio mediaFormatAudio : mediaFormatAudioArr) {
            add(mediaFormatAudio);
        }
    }

    public MediaFormatAudioVector(Iterable<MediaFormatAudio> iterable) {
        this();
        Iterator<MediaFormatAudio> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatAudio get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatAudio set(int i, MediaFormatAudio mediaFormatAudio) {
        return doSet(i, mediaFormatAudio);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(MediaFormatAudio mediaFormatAudio) {
        ((AbstractList) this).modCount++;
        doAdd(mediaFormatAudio);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, MediaFormatAudio mediaFormatAudio) {
        ((AbstractList) this).modCount++;
        doAdd(i, mediaFormatAudio);
    }

    @Override // java.util.AbstractList, java.util.List
    public MediaFormatAudio remove(int i) {
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

    public MediaFormatAudioVector() {
        this(pjsua2JNI.new_MediaFormatAudioVector__SWIG_0(), true);
    }

    public MediaFormatAudioVector(MediaFormatAudioVector mediaFormatAudioVector) {
        this(pjsua2JNI.new_MediaFormatAudioVector__SWIG_1(getCPtr(mediaFormatAudioVector), mediaFormatAudioVector), true);
    }

    public long capacity() {
        return pjsua2JNI.MediaFormatAudioVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.MediaFormatAudioVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.MediaFormatAudioVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.MediaFormatAudioVector_clear(this.swigCPtr, this);
    }

    public MediaFormatAudioVector(int i, MediaFormatAudio mediaFormatAudio) {
        this(pjsua2JNI.new_MediaFormatAudioVector__SWIG_2(i, MediaFormatAudio.getCPtr(mediaFormatAudio), mediaFormatAudio), true);
    }

    private int doSize() {
        return pjsua2JNI.MediaFormatAudioVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(MediaFormatAudio mediaFormatAudio) {
        pjsua2JNI.MediaFormatAudioVector_doAdd__SWIG_0(this.swigCPtr, this, MediaFormatAudio.getCPtr(mediaFormatAudio), mediaFormatAudio);
    }

    private void doAdd(int i, MediaFormatAudio mediaFormatAudio) {
        pjsua2JNI.MediaFormatAudioVector_doAdd__SWIG_1(this.swigCPtr, this, i, MediaFormatAudio.getCPtr(mediaFormatAudio), mediaFormatAudio);
    }

    private MediaFormatAudio doRemove(int i) {
        return new MediaFormatAudio(pjsua2JNI.MediaFormatAudioVector_doRemove(this.swigCPtr, this, i), true);
    }

    private MediaFormatAudio doGet(int i) {
        return new MediaFormatAudio(pjsua2JNI.MediaFormatAudioVector_doGet(this.swigCPtr, this, i), false);
    }

    private MediaFormatAudio doSet(int i, MediaFormatAudio mediaFormatAudio) {
        return new MediaFormatAudio(pjsua2JNI.MediaFormatAudioVector_doSet(this.swigCPtr, this, i, MediaFormatAudio.getCPtr(mediaFormatAudio), mediaFormatAudio), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.MediaFormatAudioVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
