package com.axmor.ash.toolset.service.bus;

import com.axmor.ash.toolset.service.Composite;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.ash.toolset.utils.StreamCompat;
import java.util.ArrayList;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class ConnectionNode implements DeliveryNode {
    private final ArrayList<DeliveryNode> clients = new ArrayList<>();
    private final DeliveryListener compositeListener = new AnonymousClass1(false);

    /* renamed from: com.axmor.ash.toolset.service.bus.ConnectionNode$1, reason: invalid class name */
    class AnonymousClass1 extends DeliveryListener {
        AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // com.axmor.ash.toolset.service.bus.DeliveryListener
        protected void onConnected(final Composite composite) {
            StreamCompat.forEach(ConnectionNode.this.clients, new Lambda$Code1() { // from class: com.axmor.ash.toolset.service.bus.ConnectionNode$1$$ExternalSyntheticLambda1
                @Override // com.axmor.ash.toolset.utils.Lambda$Code1
                public final void invoke(Object obj) {
                    ((DeliveryNode) obj).compositeConnected(composite);
                }
            });
        }

        @Override // com.axmor.ash.toolset.service.bus.DeliveryListener
        protected void onDisconnecting() {
            StreamCompat.forEach(ConnectionNode.this.clients, new Lambda$Code1() { // from class: com.axmor.ash.toolset.service.bus.ConnectionNode$1$$ExternalSyntheticLambda0
                @Override // com.axmor.ash.toolset.utils.Lambda$Code1
                public final void invoke(Object obj) {
                    ((DeliveryNode) obj).compositeDisconnecting();
                }
            });
        }
    }

    public void addDeliveryNode(@NonNull DeliveryNode deliveryNode) {
        if (deliveryNode == null) {
            throw new NullPointerException("node is marked non-null but is null");
        }
        AshAssert.aFalse(this == deliveryNode);
        if (this == deliveryNode) {
            return;
        }
        AshAssert.aFalse(this.clients.contains(deliveryNode));
        this.clients.add(deliveryNode);
        if (this.compositeListener.isConnected()) {
            deliveryNode.compositeConnected(this.compositeListener.getComposite());
        }
    }

    @Override // com.axmor.ash.toolset.service.bus.DeliveryNode
    public void compositeConnected(Composite composite) {
        this.compositeListener.compositeConnected(composite);
    }

    @Override // com.axmor.ash.toolset.service.bus.DeliveryNode
    public void compositeDisconnecting() {
        this.compositeListener.compositeDisconnecting();
    }

    public boolean isConnected() {
        return this.compositeListener.isConnected();
    }
}
