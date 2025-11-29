package org.pjsip.pjsua2;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public class AudioDevInfoVector extends AbstractList<AudioDevInfo> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioDevInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioDevInfoVector audioDevInfoVector) {
        if (audioDevInfoVector == null) {
            return 0L;
        }
        return audioDevInfoVector.swigCPtr;
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
                    pjsua2JNI.delete_AudioDevInfoVector(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public AudioDevInfoVector(AudioDevInfo[] audioDevInfoArr) {
        this();
        reserve(audioDevInfoArr.length);
        for (AudioDevInfo audioDevInfo : audioDevInfoArr) {
            add(audioDevInfo);
        }
    }

    public AudioDevInfoVector(Iterable<AudioDevInfo> iterable) {
        this();
        Iterator<AudioDevInfo> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioDevInfo get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioDevInfo set(int i, AudioDevInfo audioDevInfo) {
        return doSet(i, audioDevInfo);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(AudioDevInfo audioDevInfo) {
        ((AbstractList) this).modCount++;
        doAdd(audioDevInfo);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, AudioDevInfo audioDevInfo) {
        ((AbstractList) this).modCount++;
        doAdd(i, audioDevInfo);
    }

    @Override // java.util.AbstractList, java.util.List
    public AudioDevInfo remove(int i) {
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

    public AudioDevInfoVector() {
        this(pjsua2JNI.new_AudioDevInfoVector__SWIG_0(), true);
    }

    public AudioDevInfoVector(AudioDevInfoVector audioDevInfoVector) {
        this(pjsua2JNI.new_AudioDevInfoVector__SWIG_1(getCPtr(audioDevInfoVector), audioDevInfoVector), true);
    }

    public long capacity() {
        return pjsua2JNI.AudioDevInfoVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        pjsua2JNI.AudioDevInfoVector_reserve(this.swigCPtr, this, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return pjsua2JNI.AudioDevInfoVector_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        pjsua2JNI.AudioDevInfoVector_clear(this.swigCPtr, this);
    }

    public AudioDevInfoVector(int i, AudioDevInfo audioDevInfo) {
        this(pjsua2JNI.new_AudioDevInfoVector__SWIG_2(i, AudioDevInfo.getCPtr(audioDevInfo), audioDevInfo), true);
    }

    private int doSize() {
        return pjsua2JNI.AudioDevInfoVector_doSize(this.swigCPtr, this);
    }

    private void doAdd(AudioDevInfo audioDevInfo) {
        pjsua2JNI.AudioDevInfoVector_doAdd__SWIG_0(this.swigCPtr, this, AudioDevInfo.getCPtr(audioDevInfo), audioDevInfo);
    }

    private void doAdd(int i, AudioDevInfo audioDevInfo) {
        pjsua2JNI.AudioDevInfoVector_doAdd__SWIG_1(this.swigCPtr, this, i, AudioDevInfo.getCPtr(audioDevInfo), audioDevInfo);
    }

    private AudioDevInfo doRemove(int i) {
        long jAudioDevInfoVector_doRemove = pjsua2JNI.AudioDevInfoVector_doRemove(this.swigCPtr, this, i);
        if (jAudioDevInfoVector_doRemove == 0) {
            return null;
        }
        return new AudioDevInfo(jAudioDevInfoVector_doRemove, false);
    }

    private AudioDevInfo doGet(int i) {
        long jAudioDevInfoVector_doGet = pjsua2JNI.AudioDevInfoVector_doGet(this.swigCPtr, this, i);
        if (jAudioDevInfoVector_doGet == 0) {
            return null;
        }
        return new AudioDevInfo(jAudioDevInfoVector_doGet, false);
    }

    private AudioDevInfo doSet(int i, AudioDevInfo audioDevInfo) {
        long jAudioDevInfoVector_doSet = pjsua2JNI.AudioDevInfoVector_doSet(this.swigCPtr, this, i, AudioDevInfo.getCPtr(audioDevInfo), audioDevInfo);
        if (jAudioDevInfoVector_doSet == 0) {
            return null;
        }
        return new AudioDevInfo(jAudioDevInfoVector_doSet, false);
    }

    private void doRemoveRange(int i, int i2) {
        pjsua2JNI.AudioDevInfoVector_doRemoveRange(this.swigCPtr, this, i, i2);
    }
}
