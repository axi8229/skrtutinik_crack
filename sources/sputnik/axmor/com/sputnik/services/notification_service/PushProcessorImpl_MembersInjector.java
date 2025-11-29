package sputnik.axmor.com.sputnik.services.notification_service;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PushProcessorImpl_MembersInjector implements MembersInjector<PushProcessorImpl> {
    public static void injectLocalizationScreen(PushProcessorImpl pushProcessorImpl, LocalizationStorage localizationStorage) {
        pushProcessorImpl.localizationScreen = localizationStorage;
    }
}
