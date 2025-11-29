package com.axmor.ash.toolset.service;

/* loaded from: classes.dex */
public interface Composite {
    void busSubscribe(Object obj);

    void busUnsubscribe(Object obj);

    <TService> TService getService(Class<TService> cls);
}
