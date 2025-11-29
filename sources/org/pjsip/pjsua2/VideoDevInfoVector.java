package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class VideoDevInfoVector extends AbstractList<VideoDevInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoDevInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoDevInfoVector videoDevInfoVector) {
        if (videoDevInfoVector == null) {
            return 0L;
        }
        return videoDevInfoVector.swigCPtr;
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
                    pjsua2JNI.delete_VideoDevInfoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoDevInfoVector(VideoDevInfo[] videoDevInfoArr) {
        this();
        reserve(videoDevInfoArr.length);
        for (VideoDevInfo videoDevInfo : videoDevInfoArr) {
            add(videoDevInfo);
        }
    }

    public VideoDevInfoVector(Iterable<VideoDevInfo> iterable) {
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

    public VideoDevInfoVector() {
        this(pjsua2JNI.new_VideoDevInfoVector__SWIG_0(), true);
    }

    public VideoDevInfoVector(VideoDevInfoVector videoDevInfoVector) {
        this(pjsua2JNI.new_VideoDevInfoVector__SWIG_1(getCPtr(videoDevInfoVector), videoDevInfoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.VideoDevInfoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.VideoDevInfoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.VideoDevInfoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.VideoDevInfoVector_clear(this.swigCPtr, this);
    }

    public VideoDevInfoVector(int i, VideoDevInfo videoDevInfo) {
        this(pjsua2JNI.new_VideoDevInfoVector__SWIG_2(i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.VideoDevInfoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(VideoDevInfo videoDevInfo) {
        pjsua2JNI.VideoDevInfoVector_doAdd__SWIG_0(this.swigCPtr, this, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo);
    }

    private void doAdd(int i, VideoDevInfo videoDevInfo) {
        pjsua2JNI.VideoDevInfoVector_doAdd__SWIG_1(this.swigCPtr, this, i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo);
    }

    private VideoDevInfo doRemove(int i) {
        long jVideoDevInfoVector_doRemove = pjsua2JNI.VideoDevInfoVector_doRemove(this.swigCPtr, this, i);
        if (jVideoDevInfoVector_doRemove == 0) {
            return null;
        }
        return new VideoDevInfo(jVideoDevInfoVector_doRemove, false);
    }

    private VideoDevInfo doGet(int i) {
        long jVideoDevInfoVector_doGet = pjsua2JNI.VideoDevInfoVector_doGet(this.swigCPtr, this, i);
        if (jVideoDevInfoVector_doGet == 0) {
            return null;
        }
        return new VideoDevInfo(jVideoDevInfoVector_doGet, false);
    }

    private VideoDevInfo doSet(int i, VideoDevInfo videoDevInfo) {
        long jVideoDevInfoVector_doSet = pjsua2JNI.VideoDevInfoVector_doSet(this.swigCPtr, this, i, VideoDevInfo.getCPtr(videoDevInfo), videoDevInfo);
        if (jVideoDevInfoVector_doSet == 0) {
            return null;
        }
        return new VideoDevInfo(jVideoDevInfoVector_doSet, false);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.VideoDevInfoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
