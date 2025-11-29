package sputnik.axmor.com.sputnik.ui.main.market.services.ble;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NoPermissionsDialog_MembersInjector implements MembersInjector<NoPermissionsDialog> {
    public static void injectLocalizationScreen(NoPermissionsDialog noPermissionsDialog, LocalizationStorage localizationStorage) {
        noPermissionsDialog.localizationScreen = localizationStorage;
    }
}
