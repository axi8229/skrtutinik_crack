package com.sputnik.common.viewmodels;

import com.sputnik.common.viewmodels.CallCodeViewModel;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CallCodeViewModel_Factory_AssistFactory_Impl implements CallCodeViewModel.Factory.AssistFactory {
    private final CallCodeViewModel_Factory_Factory delegateFactory;

    CallCodeViewModel_Factory_AssistFactory_Impl(CallCodeViewModel_Factory_Factory callCodeViewModel_Factory_Factory) {
        this.delegateFactory = callCodeViewModel_Factory_Factory;
    }

    @Override // com.sputnik.common.viewmodels.CallCodeViewModel.Factory.AssistFactory
    public CallCodeViewModel.Factory create(String str) {
        return this.delegateFactory.get(str);
    }

    public static Provider<CallCodeViewModel.Factory.AssistFactory> create(CallCodeViewModel_Factory_Factory callCodeViewModel_Factory_Factory) {
        return InstanceFactory.create(new CallCodeViewModel_Factory_AssistFactory_Impl(callCodeViewModel_Factory_Factory));
    }
}
