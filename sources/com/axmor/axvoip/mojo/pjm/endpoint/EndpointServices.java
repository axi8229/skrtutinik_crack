package com.axmor.axvoip.mojo.pjm.endpoint;

import com.axmor.ash.toolset.utils.Lambda$FactoryCode0;
import java.util.concurrent.ExecutorService;
import lombok.NonNull;
import org.pjsip.pjsua2.AudDevManager;

/* loaded from: classes.dex */
public class EndpointServices {

    @NonNull
    private final Lambda$FactoryCode0<AudDevManager> audioManagerProvider;

    @NonNull
    private final ExecutorService executor;

    public EndpointServices(@NonNull ExecutorService executorService, @NonNull Lambda$FactoryCode0<AudDevManager> lambda$FactoryCode0) {
        if (executorService == null) {
            throw new NullPointerException("executor is marked non-null but is null");
        }
        if (lambda$FactoryCode0 == null) {
            throw new NullPointerException("audioManagerProvider is marked non-null but is null");
        }
        this.executor = executorService;
        this.audioManagerProvider = lambda$FactoryCode0;
    }

    final void execute(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        this.executor.execute(runnable);
    }

    final AudDevManager getAudioManager() {
        return this.audioManagerProvider.produce();
    }
}
