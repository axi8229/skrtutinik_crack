package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class BindResolveClients {
    private static final Object b = new Object();
    private ArrayList<ResolveClientBean> a;

    private static class b {
        private static final BindResolveClients a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (b) {
            zContains = this.a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (b) {
            try {
                ListIterator<ResolveClientBean> listIterator = this.a.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.next().clientReconnect();
                }
                this.a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            try {
                if (!this.a.contains(resolveClientBean)) {
                    this.a.add(resolveClientBean);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            try {
                if (this.a.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.a.listIterator();
                    while (true) {
                        if (!listIterator.hasNext()) {
                            break;
                        } else if (resolveClientBean.equals(listIterator.next())) {
                            listIterator.remove();
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unRegisterAll() {
        synchronized (b) {
            this.a.clear();
        }
    }

    private BindResolveClients() {
        this.a = new ArrayList<>();
    }
}
