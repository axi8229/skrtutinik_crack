package com.axmor.axvoip.mojo.pjm.facade;

import com.axmor.ash.toolset.data.result.AsyncResultListener;

/* loaded from: classes.dex */
public interface PjmEndpoint {
    void makeIdleAccount(AsyncResultListener<PjmAccount> asyncResultListener);

    void shutdown();
}
