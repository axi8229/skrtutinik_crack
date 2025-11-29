package com.axmor.ash.toolset.service.bus;

import com.axmor.ash.toolset.service.Composite;
import com.axmor.ash.toolset.utils.AshAssert;
import lombok.NonNull;

/* loaded from: classes.dex */
public abstract class DeliveryListener implements DeliveryNode {
    private final boolean busListener;
    private Composite composite = null;

    public DeliveryListener(boolean z) {
        this.busListener = z;
    }

    @Override // com.axmor.ash.toolset.service.bus.DeliveryNode
    public void compositeConnected(@NonNull Composite composite) {
        if (composite == null) {
            throw new NullPointerException("composite is marked non-null but is null");
        }
        AshAssert.aFalse(isConnected());
        if (isConnected()) {
            compositeDisconnecting();
        }
        this.composite = composite;
        if (this.busListener) {
            composite.busSubscribe(this);
        }
        onConnected(composite);
    }

    @Override // com.axmor.ash.toolset.service.bus.DeliveryNode
    public final void compositeDisconnecting() {
        AshAssert.aTrue(isConnected());
        if (isConnected()) {
            onDisconnecting();
            if (this.busListener) {
                this.composite.busUnsubscribe(this);
            }
            this.composite = null;
        }
    }

    public final Composite getComposite() {
        return this.composite;
    }

    public final boolean isConnected() {
        return this.composite != null;
    }

    protected abstract void onConnected(Composite composite);

    protected void onDisconnecting() {
    }
}
