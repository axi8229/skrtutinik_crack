package sputnik.axmor.com.sputnik.ui.main.market.services.partner_dialog;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PartnerServiceDialog_MembersInjector implements MembersInjector<PartnerServiceDialog> {
    public static void injectLocalizationScreen(PartnerServiceDialog partnerServiceDialog, LocalizationStorage localizationStorage) {
        partnerServiceDialog.localizationScreen = localizationStorage;
    }
}
