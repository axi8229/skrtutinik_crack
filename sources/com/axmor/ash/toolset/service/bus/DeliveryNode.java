package com.axmor.ash.toolset.service.bus;

import com.axmor.ash.toolset.service.Composite;

/* loaded from: classes.dex */
public interface DeliveryNode {
    void compositeConnected(Composite composite);

    void compositeDisconnecting();
}
