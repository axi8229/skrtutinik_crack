package sputnik.axmor.com.sputnik.ui.settings.push;

import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PushSettingsActivity_MembersInjector implements MembersInjector<PushSettingsActivity> {
    public static void injectFactory(PushSettingsActivity pushSettingsActivity, MultiViewModelFactory multiViewModelFactory) {
        pushSettingsActivity.factory = multiViewModelFactory;
    }
}
