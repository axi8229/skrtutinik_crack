package sputnik.axmor.com.sputnik.services.download_service;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DownloadService_MembersInjector implements MembersInjector<DownloadService> {
    public static void injectLocalizationScreen(DownloadService downloadService, LocalizationStorage localizationStorage) {
        downloadService.localizationScreen = localizationStorage;
    }
}
