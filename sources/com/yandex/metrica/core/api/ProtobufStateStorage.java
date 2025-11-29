package com.yandex.metrica.core.api;

/* loaded from: classes3.dex */
public interface ProtobufStateStorage {
    void delete();

    Object read();

    void save(Object obj);
}
