package sputnik.axmor.com.sputnik.widgets;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import dagger.MembersInjector;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class BaseOpenDoorWidget_MembersInjector implements MembersInjector<BaseOpenDoorWidget> {
    public static void injectLocalizationScreen(BaseOpenDoorWidget baseOpenDoorWidget, LocalizationStorage localizationStorage) {
        baseOpenDoorWidget.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(BaseOpenDoorWidget baseOpenDoorWidget, PrefManager prefManager) {
        baseOpenDoorWidget.prefManager = prefManager;
    }

    public static void injectOpenDoorUseCase(BaseOpenDoorWidget baseOpenDoorWidget, OpenDoorUseCase openDoorUseCase) {
        baseOpenDoorWidget.openDoorUseCase = openDoorUseCase;
    }

    public static void injectErrHandler(BaseOpenDoorWidget baseOpenDoorWidget, CoroutineExceptionHandler coroutineExceptionHandler) {
        baseOpenDoorWidget.errHandler = coroutineExceptionHandler;
    }

    public static void injectAnalytics(BaseOpenDoorWidget baseOpenDoorWidget, Analytics analytics) {
        baseOpenDoorWidget.analytics = analytics;
    }

    public static void injectScope(BaseOpenDoorWidget baseOpenDoorWidget, CoroutineScope coroutineScope) {
        baseOpenDoorWidget.scope = coroutineScope;
    }
}
