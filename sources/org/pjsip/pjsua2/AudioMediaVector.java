package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class AudioMediaVector extends AbstractList<AudioMedia> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioMediaVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMediaVector audioMediaVector) {
        if (audioMediaVector == null) {
            return 0L;
        }
        return audioMediaVector.swigCPtr;
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
                    pjsua2JNI.delete_AudioMediaVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public AudioMediaVector(AudioMedia[] audioMediaArr) {
        this();
        reserve(audioMediaArr.length);
        for (AudioMedia audioMedia : audioMediaArr) {
            add(audioMedia);
        }
    }

    public AudioMediaVector(Iterable<AudioMedia> iterable) {
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

    public AudioMediaVector() {
        this(pjsua2JNI.new_AudioMediaVector__SWIG_0(), true);
    }

    public AudioMediaVector(AudioMediaVector audioMediaVector) {
        this(pjsua2JNI.new_AudioMediaVector__SWIG_1(getCPtr(audioMediaVector), audioMediaVector), true);
    }

    public long capacity() {
        return pjsua2JNI.AudioMediaVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.AudioMediaVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.AudioMediaVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.AudioMediaVector_clear(this.swigCPtr, this);
    }

    public AudioMediaVector(int i, AudioMedia audioMedia) {
        this(pjsua2JNI.new_AudioMediaVector__SWIG_2(i, AudioMedia.getCPtr(audioMedia), audioMedia), true);
    }

    private int doSize() {
        return pjsua2JNI.AudioMediaVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(AudioMedia audioMedia) {
        pjsua2JNI.AudioMediaVector_doAdd__SWIG_0(this.swigCPtr, this, AudioMedia.getCPtr(audioMedia), audioMedia);
    }

    private void doAdd(int i, AudioMedia audioMedia) {
        pjsua2JNI.AudioMediaVector_doAdd__SWIG_1(this.swigCPtr, this, i, AudioMedia.getCPtr(audioMedia), audioMedia);
    }

    private AudioMedia doRemove(int i) {
        long jAudioMediaVector_doRemove = pjsua2JNI.AudioMediaVector_doRemove(this.swigCPtr, this, i);
        if (jAudioMediaVector_doRemove == 0) {
            return null;
        }
        return new AudioMedia(jAudioMediaVector_doRemove, false);
    }

    private AudioMedia doGet(int i) {
        long jAudioMediaVector_doGet = pjsua2JNI.AudioMediaVector_doGet(this.swigCPtr, this, i);
        if (jAudioMediaVector_doGet == 0) {
            return null;
        }
        return new AudioMedia(jAudioMediaVector_doGet, false);
    }

    private AudioMedia doSet(int i, AudioMedia audioMedia) {
        long jAudioMediaVector_doSet = pjsua2JNI.AudioMediaVector_doSet(this.swigCPtr, this, i, AudioMedia.getCPtr(audioMedia), audioMedia);
        if (jAudioMediaVector_doSet == 0) {
            return null;
        }
        return new AudioMedia(jAudioMediaVector_doSet, false);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.AudioMediaVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
