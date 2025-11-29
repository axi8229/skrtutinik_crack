package com.sputnik.common.viewmodels;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class StateViewModel_Factory implements Factory<StateViewModel> {

    private static final class InstanceHolder {
        private static final StateViewModel_Factory INSTANCE = new StateViewModel_Factory();
    }

    @Override // javax.inject.Provider
    public StateViewModel get() {
        return newInstance();
    }

    public static StateViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static StateViewModel newInstance() {
        return new StateViewModel();
    }
}
