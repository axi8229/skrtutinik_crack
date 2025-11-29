package com.sputnik.common.base;

import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BaseFragment_MembersInjector implements MembersInjector<BaseFragment> {
    public static void injectBaseFactory(BaseFragment baseFragment, MultiViewModelFactory multiViewModelFactory) {
        baseFragment.baseFactory = multiViewModelFactory;
    }

    public static void inject_prefManager(BaseFragment baseFragment, PrefManager prefManager) {
        baseFragment._prefManager = prefManager;
    }
}
