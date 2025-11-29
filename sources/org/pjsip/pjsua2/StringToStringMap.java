package org.pjsip.pjsua2;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class StringToStringMap extends AbstractMap<String, String> {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StringToStringMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StringToStringMap stringToStringMap) {
        if (stringToStringMap == null) {
            return 0L;
        }
        return stringToStringMap.swigCPtr;
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
                    pjsua2JNI.delete_StringToStringMap(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return sizeImpl();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsImpl((String) obj);
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        Iterator iteratorFind = find((String) obj);
        if (iteratorFind.isNot(end())) {
            return iteratorFind.getValue();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String put(String str, String str2) {
        Iterator iteratorFind = find(str);
        if (iteratorFind.isNot(end())) {
            String value = iteratorFind.getValue();
            iteratorFind.setValue(str2);
            return value;
        }
        putUnchecked(str, str2);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        Iterator iteratorFind = find((String) obj);
        if (!iteratorFind.isNot(end())) {
            return null;
        }
        String value = iteratorFind.getValue();
        removeUnchecked(iteratorFind);
        return value;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [org.pjsip.pjsua2.StringToStringMap$1] */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, String>> entrySet() {
        HashSet hashSet = new HashSet();
        Iterator iteratorEnd = end();
        for (Iterator iteratorBegin = begin(); iteratorBegin.isNot(iteratorEnd); iteratorBegin = iteratorBegin.getNextUnchecked()) {
            hashSet.add(new Map.Entry<String, String>() { // from class: org.pjsip.pjsua2.StringToStringMap.1
                private Iterator iterator;

                /* JADX INFO: Access modifiers changed from: private */
                public Map.Entry<String, String> init(Iterator iterator) {
                    this.iterator = iterator;
                    return this;
                }

                @Override // java.util.Map.Entry
                public String getKey() {
                    return this.iterator.getKey();
                }

                @Override // java.util.Map.Entry
                public String getValue() {
                    return this.iterator.getValue();
                }

                @Override // java.util.Map.Entry
                public String setValue(String str) {
                    String value = this.iterator.getValue();
                    this.iterator.setValue(str);
                    return value;
                }
            }.init(iteratorBegin));
        }
        return hashSet;
    }

    public StringToStringMap() {
        this(pjsua2JNI.new_StringToStringMap__SWIG_0(), true);
    }

    public StringToStringMap(StringToStringMap stringToStringMap) {
        this(pjsua2JNI.new_StringToStringMap__SWIG_1(getCPtr(stringToStringMap), stringToStringMap), true);
    }

    protected static class Iterator {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        protected Iterator(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(Iterator iterator) {
            if (iterator == null) {
                return 0L;
            }
            return iterator.swigCPtr;
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
                        pjsua2JNI.delete_StringToStringMap_Iterator(j);
                    }
                    this.swigCPtr = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator getNextUnchecked() {
            return new Iterator(pjsua2JNI.StringToStringMap_Iterator_getNextUnchecked(this.swigCPtr, this), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isNot(Iterator iterator) {
            return pjsua2JNI.StringToStringMap_Iterator_isNot(this.swigCPtr, this, getCPtr(iterator), iterator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getKey() {
            return pjsua2JNI.StringToStringMap_Iterator_getKey(this.swigCPtr, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getValue() {
            return pjsua2JNI.StringToStringMap_Iterator_getValue(this.swigCPtr, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(String str) {
            pjsua2JNI.StringToStringMap_Iterator_setValue(this.swigCPtr, this, str);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return pjsua2JNI.StringToStringMap_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        pjsua2JNI.StringToStringMap_clear(this.swigCPtr, this);
    }

    private Iterator find(String str) {
        return new Iterator(pjsua2JNI.StringToStringMap_find(this.swigCPtr, this, str), true);
    }

    private Iterator begin() {
        return new Iterator(pjsua2JNI.StringToStringMap_begin(this.swigCPtr, this), true);
    }

    private Iterator end() {
        return new Iterator(pjsua2JNI.StringToStringMap_end(this.swigCPtr, this), true);
    }

    private int sizeImpl() {
        return pjsua2JNI.StringToStringMap_sizeImpl(this.swigCPtr, this);
    }

    private boolean containsImpl(String str) {
        return pjsua2JNI.StringToStringMap_containsImpl(this.swigCPtr, this, str);
    }

    private void putUnchecked(String str, String str2) {
        pjsua2JNI.StringToStringMap_putUnchecked(this.swigCPtr, this, str, str2);
    }

    private void removeUnchecked(Iterator iterator) {
        pjsua2JNI.StringToStringMap_removeUnchecked(this.swigCPtr, this, Iterator.getCPtr(iterator), iterator);
    }
}
