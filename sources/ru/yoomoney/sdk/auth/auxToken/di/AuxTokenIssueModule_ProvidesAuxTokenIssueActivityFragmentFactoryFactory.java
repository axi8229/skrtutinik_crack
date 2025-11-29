package ru.yoomoney.sdk.auth.auxToken.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;

/* loaded from: classes4.dex */
public final class AuxTokenIssueModule_ProvidesAuxTokenIssueActivityFragmentFactoryFactory implements Factory<ActivityFragmentFactory> {
    private final Provider<Map<Class<?>, Provider<Fragment>>> fragmentsProvider;
    private final AuxTokenIssueModule module;

    public AuxTokenIssueModule_ProvidesAuxTokenIssueActivityFragmentFactoryFactory(AuxTokenIssueModule auxTokenIssueModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        this.module = auxTokenIssueModule;
        this.fragmentsProvider = provider;
    }

    public static AuxTokenIssueModule_ProvidesAuxTokenIssueActivityFragmentFactoryFactory create(AuxTokenIssueModule auxTokenIssueModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        return new AuxTokenIssueModule_ProvidesAuxTokenIssueActivityFragmentFactoryFactory(auxTokenIssueModule, provider);
    }

    public static ActivityFragmentFactory providesAuxTokenIssueActivityFragmentFactory(AuxTokenIssueModule auxTokenIssueModule, Map<Class<?>, Provider<Fragment>> map) {
        return (ActivityFragmentFactory) Preconditions.checkNotNullFromProvides(auxTokenIssueModule.providesAuxTokenIssueActivityFragmentFactory(map));
    }

    @Override // javax.inject.Provider
    public ActivityFragmentFactory get() {
        return providesAuxTokenIssueActivityFragmentFactory(this.module, this.fragmentsProvider.get());
    }
}
