package com.sputnik.common.viewmodels;

import com.sputnik.common.viewmodels.AllCamerasViewModel;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AllCamerasViewModel_Factory_AssistFactory_Impl implements AllCamerasViewModel.Factory.AssistFactory {
    private final AllCamerasViewModel_Factory_Factory delegateFactory;

    AllCamerasViewModel_Factory_AssistFactory_Impl(AllCamerasViewModel_Factory_Factory allCamerasViewModel_Factory_Factory) {
        this.delegateFactory = allCamerasViewModel_Factory_Factory;
    }

    @Override // com.sputnik.common.viewmodels.AllCamerasViewModel.Factory.AssistFactory
    public AllCamerasViewModel.Factory create(String str) {
        return this.delegateFactory.get(str);
    }

    public static Provider<AllCamerasViewModel.Factory.AssistFactory> create(AllCamerasViewModel_Factory_Factory allCamerasViewModel_Factory_Factory) {
        return InstanceFactory.create(new AllCamerasViewModel_Factory_AssistFactory_Impl(allCamerasViewModel_Factory_Factory));
    }
}
