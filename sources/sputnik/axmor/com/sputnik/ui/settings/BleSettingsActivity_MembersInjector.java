package sputnik.axmor.com.sputnik.ui.settings;

import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BleSettingsActivity_MembersInjector implements MembersInjector<BleSettingsActivity> {
    public static void injectFactory(BleSettingsActivity bleSettingsActivity, MultiViewModelFactory multiViewModelFactory) {
        bleSettingsActivity.factory = multiViewModelFactory;
    }
}
