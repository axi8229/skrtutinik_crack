package com.axmor.axvoip.mojo.core.sip;

import android.util.Log;
import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.ash.toolset.service.Component;
import com.axmor.ash.toolset.service.CompositeContext;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code1;

/* loaded from: classes.dex */
public final class SipSessionComponent implements Component<SipSession> {
    private SipSessionInternal session = null;

    @Override // com.axmor.ash.toolset.service.Component
    public void activate(CompositeContext compositeContext) {
        this.session = new SipSessionManager(compositeContext, new Lambda$Code1() { // from class: com.axmor.axvoip.mojo.core.sip.SipSessionComponent$$ExternalSyntheticLambda0
            @Override // com.axmor.ash.toolset.utils.Lambda$Code1
            public final void invoke(Object obj) {
                this.f$0.onSessionFailed((AshError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionFailed(AshError ashError) {
        Log.e("SipSessionComponent", "onSessionFailed:" + ashError.getDebugDescription());
        this.session = new SipSessionDummy();
    }

    @Override // com.axmor.ash.toolset.service.Component
    public void deactivate() {
        SipSessionInternal sipSessionInternal = this.session;
        if (sipSessionInternal != null) {
            sipSessionInternal.destroy();
            this.session = null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.axmor.ash.toolset.service.Component
    public SipSession getService() {
        AshAssert.aNonNull(this.session);
        return this.session;
    }
}
