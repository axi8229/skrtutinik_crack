package com.sputnik.common.viewmodels;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class NavigationViewModel_Factory implements Factory<NavigationViewModel> {

    private static final class InstanceHolder {
        private static final NavigationViewModel_Factory INSTANCE = new NavigationViewModel_Factory();
    }

    @Override // javax.inject.Provider
    public NavigationViewModel get() {
        return newInstance();
    }

    public static NavigationViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NavigationViewModel newInstance() {
        return new NavigationViewModel();
    }
}
