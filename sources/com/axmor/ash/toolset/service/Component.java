package com.axmor.ash.toolset.service;

/* loaded from: classes.dex */
public interface Component<TService> {

    public interface LifetimeListener {
    }

    void activate(CompositeContext compositeContext);

    void deactivate();

    TService getService();
}
