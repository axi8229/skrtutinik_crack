package com.axmor.ash.toolset.service.impl;

import android.os.Binder;
import com.axmor.ash.toolset.service.Composite;
import lombok.NonNull;

/* loaded from: classes.dex */
final class ServiceBinder extends Binder {

    @NonNull
    private final ServiceCore core;

    public ServiceBinder(@NonNull ServiceCore serviceCore) {
        if (serviceCore == null) {
            throw new NullPointerException("core is marked non-null but is null");
        }
        this.core = serviceCore;
    }

    public Composite getComposite() {
        return this.core;
    }
}
