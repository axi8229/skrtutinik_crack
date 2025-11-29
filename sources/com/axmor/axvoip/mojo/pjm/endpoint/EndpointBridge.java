package com.axmor.axvoip.mojo.pjm.endpoint;

import com.axmor.ash.toolset.data.result.AshResult;
import com.axmor.ash.toolset.data.result.AsyncResultListener;
import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.ash.toolset.utils.Lambda$Code0;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.ash.toolset.utils.Lambda$FactoryCode0;
import com.axmor.ash.toolset.utils.Lambda$FactoryCode2;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import com.axmor.axvoip.mojo.pjm.common.PjmErrors;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccount;
import com.axmor.axvoip.mojo.pjm.facade.PjmEndpoint;
import java.util.concurrent.Executors;
import lombok.NonNull;
import org.pjsip.pjsua2.AudDevManager;
import org.pjsip.pjsua2.Endpoint;
import org.pjsip.pjsua2.TransportConfig;

/* loaded from: classes.dex */
final class EndpointBridge implements PjmEndpoint {
    private final Bridge bridge;
    private final PjmEndpointConfig config;
    private final Object $lock = new Object[0];
    private Endpoint endpoint = null;
    private boolean initialized = false;

    public EndpointBridge(@NonNull PjmEndpointConfig pjmEndpointConfig, final Lambda$Code0 lambda$Code0) {
        if (pjmEndpointConfig == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        Bridge bridge = new Bridge(new EndpointServices(Executors.newSingleThreadExecutor(), new Lambda$FactoryCode0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda0
            @Override // com.axmor.ash.toolset.utils.Lambda$FactoryCode0
            public final Object produce() {
                return this.f$0.getAudDevManager();
            }
        }), new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda1
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doShutdown();
            }
        }, new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda2
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doDelete();
            }
        }, new Lambda$Code1() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda3
            @Override // com.axmor.ash.toolset.utils.Lambda$Code1
            public final void invoke(Object obj) {
                lambda$Code0.invoke();
            }
        });
        this.bridge = bridge;
        this.config = pjmEndpointConfig;
        bridge.enableLogging(EndpointBridge.class.getSimpleName());
        bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.init();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        synchronized (this.$lock) {
            this.bridge.log("init");
            try {
                Endpoint endpoint = new Endpoint();
                this.endpoint = endpoint;
                endpoint.libCreate();
                this.endpoint.libInit(this.config.getEndpointConfig());
                TransportConfig transportConfig = this.config.getTransportConfig();
                this.endpoint.transportCreate(1, transportConfig);
                this.endpoint.transportCreate(2, transportConfig);
                this.endpoint.libStart();
                this.initialized = true;
            } catch (Exception e) {
                this.bridge.log("init::failed", e);
                this.endpoint.delete();
                this.config.delete();
                shutdown();
            }
        }
    }

    public boolean isDestroyed() {
        boolean zIsDestroyed;
        synchronized (this.$lock) {
            zIsDestroyed = this.bridge.isDestroyed();
        }
        return zIsDestroyed;
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmEndpoint
    public void shutdown() {
        synchronized (this.$lock) {
            this.bridge.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShutdown() {
        synchronized (this.$lock) {
            if (!this.initialized) {
                this.bridge.shutdownCompleted();
                return;
            }
            try {
                this.endpoint.libDestroy();
            } catch (Exception e) {
                this.bridge.log("doShutdown::failed", e);
            }
            this.bridge.shutdownCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDelete() {
        synchronized (this.$lock) {
            try {
                if (this.initialized) {
                    this.endpoint.delete();
                    this.config.delete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmEndpoint
    public void makeIdleAccount(@NonNull final AsyncResultListener<PjmAccount> asyncResultListener) {
        synchronized (this.$lock) {
            try {
                if (asyncResultListener == null) {
                    throw new NullPointerException("listener is marked non-null but is null");
                }
                this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$makeIdleAccount$1(asyncResultListener);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doMakeIdleAccount, reason: merged with bridge method [inline-methods] */
    public void lambda$makeIdleAccount$1(@NonNull AsyncResultListener<PjmAccount> asyncResultListener) {
        AshError.Builder builderUnknown;
        synchronized (this.$lock) {
            try {
                if (asyncResultListener == null) {
                    throw new NullPointerException("listener is marked non-null but is null");
                }
                AccountBridge accountBridge = (AccountBridge) this.bridge.addChild(new Lambda$FactoryCode2() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.EndpointBridge$$ExternalSyntheticLambda6
                    @Override // com.axmor.ash.toolset.utils.Lambda$FactoryCode2
                    public final Object produce(Object obj, Object obj2) {
                        return new AccountBridge((EndpointServices) obj, (Lambda$Code1) obj2);
                    }
                });
                if (accountBridge == null) {
                    if (isDestroyed()) {
                        builderUnknown = PjmErrors.Domains.ENDPOINT.error();
                        if (!this.initialized) {
                            builderUnknown.code(0L).debugDescription("Failed to create account, because endpoint init failed.");
                        } else {
                            builderUnknown.code(1L).debugDescription("Failed to create account, because endpoint has been destroyed.");
                        }
                    } else {
                        builderUnknown = PjmErrors.unknown("Failed to create account for an unknown reason.");
                    }
                    asyncResultListener.onResult(new AshResult<>(builderUnknown.build()));
                } else {
                    asyncResultListener.onResult(new AshResult<>(accountBridge));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AudDevManager getAudDevManager() {
        if (isDestroyed()) {
            return null;
        }
        return this.endpoint.audDevManager();
    }
}
