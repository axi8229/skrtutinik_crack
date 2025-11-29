package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class VideoMediaVector extends AbstractList<VideoMedia> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoMediaVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoMediaVector videoMediaVector) {
        if (videoMediaVector == null) {
            return 0L;
        }
        return videoMediaVector.swigCPtr;
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
                    pjsua2JNI.delete_VideoMediaVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoMediaVector(VideoMedia[] videoMediaArr) {
        this();
        reserve(videoMediaArr.length);
        for (VideoMedia videoMedia : videoMediaArr) {
            add(videoMedia);
        }
    }

    public VideoMediaVector(Iterable<VideoMedia> iterable) {
        this();
        Iterator<VideoMedia> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoMedia get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoMedia set(int i, VideoMedia videoMedia) {
        return doSet(i, videoMedia);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(VideoMedia videoMedia) {
        ((AbstractList) this).modCount++;
        doAdd(videoMedia);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, VideoMedia videoMedia) {
        ((AbstractList) this).modCount++;
        doAdd(i, videoMedia);
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoMedia remove(int i) {
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

    public VideoMediaVector() {
        this(pjsua2JNI.new_VideoMediaVector__SWIG_0(), true);
    }

    public VideoMediaVector(VideoMediaVector videoMediaVector) {
        this(pjsua2JNI.new_VideoMediaVector__SWIG_1(getCPtr(videoMediaVector), videoMediaVector), true);
    }

    public long capacity() {
        return pjsua2JNI.VideoMediaVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.VideoMediaVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.VideoMediaVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.VideoMediaVector_clear(this.swigCPtr, this);
    }

    public VideoMediaVector(int i, VideoMedia videoMedia) {
        this(pjsua2JNI.new_VideoMediaVector__SWIG_2(i, VideoMedia.getCPtr(videoMedia), videoMedia), true);
    }

    private int doSize() {
        return pjsua2JNI.VideoMediaVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(VideoMedia videoMedia) {
        pjsua2JNI.VideoMediaVector_doAdd__SWIG_0(this.swigCPtr, this, VideoMedia.getCPtr(videoMedia), videoMedia);
    }

    private void doAdd(int i, VideoMedia videoMedia) {
        pjsua2JNI.VideoMediaVector_doAdd__SWIG_1(this.swigCPtr, this, i, VideoMedia.getCPtr(videoMedia), videoMedia);
    }

    private VideoMedia doRemove(int i) {
        return new VideoMedia(pjsua2JNI.VideoMediaVector_doRemove(this.swigCPtr, this, i), true);
    }

    private VideoMedia doGet(int i) {
        return new VideoMedia(pjsua2JNI.VideoMediaVector_doGet(this.swigCPtr, this, i), false);
    }

    private VideoMedia doSet(int i, VideoMedia videoMedia) {
        return new VideoMedia(pjsua2JNI.VideoMediaVector_doSet(this.swigCPtr, this, i, VideoMedia.getCPtr(videoMedia), videoMedia), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.VideoMediaVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
