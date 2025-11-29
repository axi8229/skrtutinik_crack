package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class AudioMediaVector2 extends AbstractList<AudioMedia> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioMediaVector2(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMediaVector2 audioMediaVector2) {
        if (audioMediaVector2 == null) {
            return 0L;
        }
        return audioMediaVector2.swigCPtr;
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
                    pjsua2JNI.delete_AudioMediaVector2(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public AudioMediaVector2(AudioMedia[] audioMediaArr) {
        this();
        reserve(audioMediaArr.length);
        for (AudioMedia audioMedia : audioMediaArr) {
            add(audioMedia);
        }
    }

    public AudioMediaVector2(Iterable<AudioMedia> iterable) {
        this();
        Iterator<AudioMedia> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioMedia get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioMedia set(int i, AudioMedia audioMedia) {
        return doSet(i, audioMedia);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(AudioMedia audioMedia) {
        ((AbstractList) this).modCount++;
        doAdd(audioMedia);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, AudioMedia audioMedia) {
        ((AbstractList) this).modCount++;
        doAdd(i, audioMedia);
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioMedia remove(int i) {
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

    public AudioMediaVector2() {
        this(pjsua2JNI.new_AudioMediaVector2__SWIG_0(), true);
    }

    public AudioMediaVector2(AudioMediaVector2 audioMediaVector2) {
        this(pjsua2JNI.new_AudioMediaVector2__SWIG_1(getCPtr(audioMediaVector2), audioMediaVector2), true);
    }

    public long capacity() {
        return pjsua2JNI.AudioMediaVector2_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.AudioMediaVector2_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.AudioMediaVector2_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.AudioMediaVector2_clear(this.swigCPtr, this);
    }

    public AudioMediaVector2(int i, AudioMedia audioMedia) {
        this(pjsua2JNI.new_AudioMediaVector2__SWIG_2(i, AudioMedia.getCPtr(audioMedia), audioMedia), true);
    }

    private int doSize() {
        return pjsua2JNI.AudioMediaVector2_doSize(this.swigCPtr, this);
    }

    private void doAdd(AudioMedia audioMedia) {
        pjsua2JNI.AudioMediaVector2_doAdd__SWIG_0(this.swigCPtr, this, AudioMedia.getCPtr(audioMedia), audioMedia);
    }

    private void doAdd(int i, AudioMedia audioMedia) {
        pjsua2JNI.AudioMediaVector2_doAdd__SWIG_1(this.swigCPtr, this, i, AudioMedia.getCPtr(audioMedia), audioMedia);
    }

    private AudioMedia doRemove(int i) {
        return new AudioMedia(pjsua2JNI.AudioMediaVector2_doRemove(this.swigCPtr, this, i), true);
    }

    private AudioMedia doGet(int i) {
        return new AudioMedia(pjsua2JNI.AudioMediaVector2_doGet(this.swigCPtr, this, i), false);
    }

    private AudioMedia doSet(int i, AudioMedia audioMedia) {
        return new AudioMedia(pjsua2JNI.AudioMediaVector2_doSet(this.swigCPtr, this, i, AudioMedia.getCPtr(audioMedia), audioMedia), true);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.AudioMediaVector2_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
