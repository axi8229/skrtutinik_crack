package com.axmor.ash.toolset.service.impl;

import android.content.Context;
import com.axmor.ash.toolset.service.Component;
import com.axmor.ash.toolset.service.CompositeContext;
import lombok.NonNull;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes.dex */
abstract class ComponentContext implements CompositeContext {

    @NonNull
    private final Context aContext;

    @NonNull
    private final EventBus eventBus;

    @NonNull
    private final Component.LifetimeListener lifetimeListener;

    public ComponentContext(@NonNull Context context, @NonNull EventBus eventBus, @NonNull Component.LifetimeListener lifetimeListener) {
        if (context == null) {
            throw new NullPointerException("aContext is marked non-null but is null");
        }
        if (eventBus == null) {
            throw new NullPointerException("eventBus is marked non-null but is null");
        }
        if (lifetimeListener == null) {
            throw new NullPointerException("lifetimeListener is marked non-null but is null");
        }
        this.aContext = context;
        this.eventBus = eventBus;
        this.lifetimeListener = lifetimeListener;
    }

    @Override // com.axmor.ash.toolset.service.CompositeContext
    public EventBus eventBus() {
        return this.eventBus;
    }
}
