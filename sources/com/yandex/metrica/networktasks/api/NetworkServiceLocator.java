package com.yandex.metrica.networktasks.api;

/* loaded from: classes3.dex */
public final class NetworkServiceLocator implements NetworkServiceLifecycleObserver {
    private static volatile NetworkServiceLocator b;
    private NetworkCore a;

    private NetworkServiceLocator() {
    }

    public static NetworkServiceLocator getInstance() {
        return b;
    }

    public static void init() {
        if (b == null) {
            synchronized (NetworkServiceLocator.class) {
                try {
                    if (b == null) {
                        b = new NetworkServiceLocator();
                    }
                } finally {
                }
            }
        }
    }

    public NetworkCore getNetworkCore() {
        return this.a;
    }

    public void initAsync() {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        NetworkCore networkCore = new NetworkCore();
                        this.a = networkCore;
                        networkCore.setName("YMM-NC");
                        this.a.start();
                    }
                } finally {
                }
            }
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
        NetworkCore networkCore = this.a;
        if (networkCore != null) {
            networkCore.onDestroy();
        }
    }
}
