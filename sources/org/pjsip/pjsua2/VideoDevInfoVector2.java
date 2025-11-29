package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class VideoDevInfoVector2 extends AbstractList<VideoDevInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoDevInfoVector2(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoDevInfoVector2 videoDevInfoVector2) {
        if (videoDevInfoVector2 == null) {
            return 0L;
        }
        return videoDevInfoVector2.swigCPtr;
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
                    pjsua2JNI.delete_VideoDevInfoVector2(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoDevInfoVector2(VideoDevInfo[] videoDevInfoArr) {
        this();
        reserve(videoDevInfoArr.length);
        for (VideoDevInfo videoDevInfo : videoDevInfoArr) {
            add(videoDevInfo);
        }
    }

    public VideoDevInfoVector2(Iterable<VideoDevInfo> iterable) {
        this();
        Iterator<VideoDevInfo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoDevInfo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoDevInfo set(int i, VideoDevInfo videoDevInfo) {
        return doSet(i, videoDevInfo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(VideoDevInfo videoDevInfo) {
        ((AbstractList) this).modCount++;
        doAdd(videoDevInfo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, VideoDevInfo videoDevInfo) {
        ((AbstractList) this).modCount++;
        doAdd(i, videoDevInfo);
    }

    @Override // java.util.AbstractList, java.util.List
    public VideoDevInfo remove(int i) {
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

    public VideoDevInfoVector2() {
        this(pjsua2JNI.new_VideoDevInfoVector2__SWIG_0(), true);
    }

    public VideoDevInfoVector2(VideoDevInfoVector2 videoDevInfoVector2) {
        this(pjsua2JNI.new_VideoDevInfoVector2__SWIG_1(getCPtr(videoDevInfoVector2), videoDevInfoVector2), true);
    }

    public long capacity() {
        return pjsua2JNI.VideoDevInfoVector2_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.VideoDevInfoVector2_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.VideoDevInfoVector2_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.VideoDevInfoVector2_clear(this.swigCPtr, this);
    }

    public VideoDevInfoVector2(int i, VideoDevInfo videoDevInfo) {
        this(pjsua2JNI.new_VideoDevInfoVector2__SWIG_2(i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.VideoDevInfoVector2_doSize(this.swigCPtr, this);
    }

    private void doAdd(VideoDevInfo videoDevInfo) {
        pjsua2JNI.VideoDevInfoVector2_doAdd__SWIG_0(this.swigCPtr, this, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo);
    }

    private void doAdd(int i, VideoDevInfo videoDevInfo) {
        pjsua2JNI.VideoDevInfoVector2_doAdd__SWIG_1(this.swigCPtr, this, i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo);
    }

    private VideoDevInfo doRemove(int i) {
        return new VideoDevInfo(pjsua2JNI.VideoDevInfoVector2_doRemove(this.swigCPtr, this, i), true);
    }

    private VideoDevInfo doGet(int i) {
        return new VideoDevInfo(pjsua2JNI.VideoDevInfoVector2_doGet(this.swigCPtr, this, i), false);
    }

    private VideoDevInfo doSet(int i, VideoDevInfo videoDevInfo) {
        return new VideoDevInfo(pjsua2JNI.VideoDevInfoVector2_doSet(this.swigCPtr, this, i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.VideoDevInfoVector2_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
