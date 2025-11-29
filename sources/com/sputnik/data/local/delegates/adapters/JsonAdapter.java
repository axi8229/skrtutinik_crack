package com.sputnik.data.local.delegates.adapters;

import kotlin.Metadata;

/* compiled from: JsonAdapter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;", "T", "", "fromJson", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "toJson", "obj", "(Ljava/lang/Object;)Ljava/lang/String;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface JsonAdapter<T> {
    T fromJson(String json);

    String toJson(T obj);
}
