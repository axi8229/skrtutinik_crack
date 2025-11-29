package com.axmor.ash.toolset.service.impl;

import com.axmor.ash.toolset.service.Component;

/* loaded from: classes.dex */
public interface CompositeBuilder {
    <TService> void addComponent(Class<TService> cls, Component<? extends TService> component);
}
