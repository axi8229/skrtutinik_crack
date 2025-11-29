package com.sputnik.data.processors;

import kotlin.Metadata;

/* compiled from: NetworkString.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086 J\t\u0010\u0005\u001a\u00020\u0004H\u0086 J\t\u0010\u0006\u001a\u00020\u0004H\u0086 J\t\u0010\u0007\u001a\u00020\u0004H\u0086 ¨\u0006\b"}, d2 = {"Lcom/sputnik/data/processors/NetworkString;", "", "()V", "getEndpoint1", "", "getEndpoint2", "getString", "getStringHeader", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkString {
    public static final NetworkString INSTANCE = new NetworkString();

    public final native String getEndpoint1();

    public final native String getEndpoint2();

    public final native String getString();

    public final native String getStringHeader();

    private NetworkString() {
    }

    static {
        System.loadLibrary("network-lib");
    }
}
