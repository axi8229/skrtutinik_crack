package com.axmor.ash.toolset.service.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.axmor.ash.toolset.service.Composite;
import com.axmor.ash.toolset.service.bus.ConnectionNode;
import com.axmor.ash.toolset.service.bus.DeliveryNode;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class CompositeServiceConnection {
    private final Context context;
    private final ConnectionNode rootConnection = new ConnectionNode();
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.axmor.ash.toolset.service.impl.CompositeServiceConnection.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null || !(iBinder instanceof ServiceBinder)) {
                throw new RuntimeException("Bad service binder.");
            }
            Composite composite = ((ServiceBinder) iBinder).getComposite();
            if (composite == null) {
                throw new IllegalStateException("Composite is null.");
            }
            CompositeServiceConnection.this.onConnect(composite);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CompositeServiceConnection.this.onDisconnect();
        }
    };
    private final Intent serviceIntent;

    public CompositeServiceConnection(Context context, Class<? extends CompositeService> cls) {
        this.context = context;
        this.serviceIntent = new Intent(context, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnect(@NonNull Composite composite) {
        if (composite == null) {
            throw new NullPointerException("composite is marked non-null but is null");
        }
        this.rootConnection.compositeConnected(composite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisconnect() {
        this.rootConnection.compositeDisconnecting();
    }

    public void addDeliveryNode(DeliveryNode deliveryNode) {
        this.rootConnection.addDeliveryNode(deliveryNode);
    }

    public void onStart() {
        this.context.bindService(this.serviceIntent, this.serviceConnection, 1);
    }

    public void onStop() {
        if (this.rootConnection.isConnected()) {
            onDisconnect();
        }
        this.context.unbindService(this.serviceConnection);
    }
}
