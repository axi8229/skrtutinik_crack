package com.axmor.axvoip.mojo.pjm.endpoint;

import android.util.Log;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code0;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.ash.toolset.utils.Lambda$FactoryCode2;
import com.axmor.ash.toolset.utils.StreamCompat;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.NonNull;

/* loaded from: classes.dex */
final class Bridge {

    @NonNull
    private final Lambda$Code0 doDeleteDelegate;

    @NonNull
    private final Lambda$Code0 doShutdownDelegate;

    @NonNull
    private final EndpointServices endpointServices;

    @NonNull
    private final Lambda$Code1<Bridge> onDeletedHandler;
    private final Object $lock = new Object[0];
    private final CopyOnWriteArrayList<Bridge> children = new CopyOnWriteArrayList<>();
    private boolean destroyed = false;
    private boolean canDelete = false;
    private boolean deleted = false;
    private boolean loggingEnabled = false;
    private String logTag = null;

    interface Entity {
        Bridge getBridge();
    }

    public Bridge(@NonNull EndpointServices endpointServices, @NonNull Lambda$Code0 lambda$Code0, @NonNull Lambda$Code0 lambda$Code02, @NonNull Lambda$Code1<Bridge> lambda$Code1) {
        if (endpointServices == null) {
            throw new NullPointerException("endpointServices is marked non-null but is null");
        }
        if (lambda$Code0 == null) {
            throw new NullPointerException("doShutdownDelegate is marked non-null but is null");
        }
        if (lambda$Code02 == null) {
            throw new NullPointerException("doDeleteDelegate is marked non-null but is null");
        }
        if (lambda$Code1 == null) {
            throw new NullPointerException("onDeletedHandler is marked non-null but is null");
        }
        this.endpointServices = endpointServices;
        this.doShutdownDelegate = lambda$Code0;
        this.doDeleteDelegate = lambda$Code02;
        this.onDeletedHandler = lambda$Code1;
    }

    @NonNull
    public EndpointServices getEndpointServices() {
        return this.endpointServices;
    }

    final void execute(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        this.endpointServices.execute(runnable);
    }

    final boolean isDestroyed() {
        boolean z;
        synchronized (this.$lock) {
            z = this.destroyed;
        }
        return z;
    }

    final <T extends Entity> T addChild(@NonNull Lambda$FactoryCode2<T, EndpointServices, Lambda$Code1<Bridge>> lambda$FactoryCode2) {
        synchronized (this.$lock) {
            try {
                if (lambda$FactoryCode2 == null) {
                    throw new NullPointerException("builder is marked non-null but is null");
                }
                if (isDestroyed()) {
                    return null;
                }
                T tProduce = lambda$FactoryCode2.produce(this.endpointServices, new Lambda$Code1() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.Bridge$$ExternalSyntheticLambda3
                    @Override // com.axmor.ash.toolset.utils.Lambda$Code1
                    public final void invoke(Object obj) {
                        this.f$0.onChildDeleted((Bridge) obj);
                    }
                });
                AshAssert.aNonNull(tProduce);
                Bridge bridge = tProduce.getBridge();
                AshAssert.aNonNull(bridge);
                this.children.add(bridge);
                return tProduce;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChildDeleted(@NonNull Bridge bridge) {
        synchronized (this.$lock) {
            try {
                if (bridge == null) {
                    throw new NullPointerException("child is marked non-null but is null");
                }
                this.children.remove(bridge);
                deleteIfAble();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void shutdown() {
        synchronized (this.$lock) {
            try {
                if (this.destroyed) {
                    return;
                }
                this.destroyed = true;
                log("shutdown");
                StreamCompat.forEach(this.children, new Lambda$Code1() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.Bridge$$ExternalSyntheticLambda0
                    @Override // com.axmor.ash.toolset.utils.Lambda$Code1
                    public final void invoke(Object obj) {
                        ((Bridge) obj).shutdown();
                    }
                });
                log("doShutdown");
                final Lambda$Code0 lambda$Code0 = this.doShutdownDelegate;
                Objects.requireNonNull(lambda$Code0);
                execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.Bridge$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        lambda$Code0.invoke();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void shutdownCompleted() {
        synchronized (this.$lock) {
            log("shutdownCompleted");
            AshAssert.aTrue(this.destroyed);
            this.canDelete = true;
            deleteIfAble();
        }
    }

    private void deleteIfAble() {
        synchronized (this.$lock) {
            try {
                log(String.format("deleteIfAble::{children.size() = %d}", Integer.valueOf(this.children.size())));
                if (this.destroyed && this.canDelete && !this.deleted) {
                    if (this.children.size() != 0) {
                        return;
                    }
                    this.deleted = true;
                    execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.Bridge$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.delete();
                        }
                    });
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        synchronized (this.$lock) {
            AshAssert.aTrue(this.deleted);
            log("doDelete");
            this.doDeleteDelegate.invoke();
            this.onDeletedHandler.invoke(this);
        }
    }

    final void enableLogging(@NonNull String str) {
        synchronized (this.$lock) {
            try {
                if (str == null) {
                    throw new NullPointerException("tag is marked non-null but is null");
                }
                this.loggingEnabled = false;
                this.logTag = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void log(String str) {
        synchronized (this.$lock) {
            log(str, null);
        }
    }

    final void log(String str, Throwable th) {
        synchronized (this.$lock) {
            try {
                if (this.loggingEnabled) {
                    String str2 = "bridge::" + this.logTag + "@" + hashCode();
                    String str3 = String.format("{destroyed:%b, canDelete:%b, deleted:%b}", Boolean.valueOf(this.destroyed), Boolean.valueOf(this.canDelete), Boolean.valueOf(this.deleted)) + " -- " + str;
                    if (th == null) {
                        Log.e(str2, str3);
                    } else {
                        Log.e(str2, str3, th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
