package sputnik.axmor.com.sputnik.core.push;

import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import dagger.MembersInjector;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class PushIntentService_MembersInjector implements MembersInjector<PushIntentService> {
    public static void injectPrefManager(PushIntentService pushIntentService, PrefManager prefManager) {
        pushIntentService.prefManager = prefManager;
    }

    public static void injectScope(PushIntentService pushIntentService, CoroutineScope coroutineScope) {
        pushIntentService.scope = coroutineScope;
    }

    public static void injectErrHandler(PushIntentService pushIntentService, CoroutineExceptionHandler coroutineExceptionHandler) {
        pushIntentService.errHandler = coroutineExceptionHandler;
    }

    public static void injectSendPushTokenUseCase(PushIntentService pushIntentService, SendPushTokenUseCase sendPushTokenUseCase) {
        pushIntentService.sendPushTokenUseCase = sendPushTokenUseCase;
    }
}
