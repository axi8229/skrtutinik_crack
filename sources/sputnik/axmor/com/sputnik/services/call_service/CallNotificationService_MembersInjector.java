package sputnik.axmor.com.sputnik.services.call_service;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CallNotificationService_MembersInjector implements MembersInjector<CallNotificationService> {
    public static void injectLocalizationScreen(CallNotificationService callNotificationService, LocalizationStorage localizationStorage) {
        callNotificationService.localizationScreen = localizationStorage;
    }
}
