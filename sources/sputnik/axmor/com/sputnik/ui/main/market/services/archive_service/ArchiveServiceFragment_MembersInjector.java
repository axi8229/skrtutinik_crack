package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.Lazy;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ArchiveServiceFragment_MembersInjector implements MembersInjector<ArchiveServiceFragment> {
    public static void injectFactory(ArchiveServiceFragment archiveServiceFragment, Lazy<MultiViewModelFactory> lazy) {
        archiveServiceFragment.factory = lazy;
    }

    public static void injectSupportManager(ArchiveServiceFragment archiveServiceFragment, ISupportManager iSupportManager) {
        archiveServiceFragment.supportManager = iSupportManager;
    }

    public static void injectLocalizationScreen(ArchiveServiceFragment archiveServiceFragment, LocalizationStorage localizationStorage) {
        archiveServiceFragment.localizationScreen = localizationStorage;
    }
}
