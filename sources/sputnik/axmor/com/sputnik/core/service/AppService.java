package sputnik.axmor.com.sputnik.core.service;

import com.axmor.ash.toolset.service.impl.CompositeBuilder;
import com.axmor.ash.toolset.service.impl.CompositeService;
import com.axmor.axvoip.mojo.core.sip.SipSession;
import com.axmor.axvoip.mojo.core.sip.SipSessionComponent;

/* loaded from: classes5.dex */
public class AppService extends CompositeService {
    @Override // com.axmor.ash.toolset.service.impl.CompositeService
    protected void buildComposite(CompositeBuilder compositeBuilder) {
        compositeBuilder.addComponent(SipSession.class, new SipSessionComponent());
    }
}
