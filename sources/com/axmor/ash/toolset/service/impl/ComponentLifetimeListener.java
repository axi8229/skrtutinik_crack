package com.axmor.ash.toolset.service.impl;

import com.axmor.ash.toolset.service.Component;
import lombok.NonNull;

/* loaded from: classes.dex */
class ComponentLifetimeListener implements Component.LifetimeListener {

    @NonNull
    private final ServiceLifeline lifetime;
    private boolean locked = false;

    public ComponentLifetimeListener(@NonNull ServiceLifeline serviceLifeline) {
        if (serviceLifeline == null) {
            throw new NullPointerException("lifetime is marked non-null but is null");
        }
        this.lifetime = serviceLifeline;
    }
}
