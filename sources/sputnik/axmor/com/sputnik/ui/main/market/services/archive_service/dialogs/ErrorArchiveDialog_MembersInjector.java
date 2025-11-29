package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.dialogs;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ErrorArchiveDialog_MembersInjector implements MembersInjector<ErrorArchiveDialog> {
    public static void injectLocalizationScreen(ErrorArchiveDialog errorArchiveDialog, LocalizationStorage localizationStorage) {
        errorArchiveDialog.localizationScreen = localizationStorage;
    }
}
