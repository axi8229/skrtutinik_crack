package sputnik.axmor.com.sputnik.ui.settings;

import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SettingsActivity_MembersInjector implements MembersInjector<SettingsActivity> {
    public static void injectFactory(SettingsActivity settingsActivity, MultiViewModelFactory multiViewModelFactory) {
        settingsActivity.factory = multiViewModelFactory;
    }
}
