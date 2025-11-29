package ru.yoomoney.sdk.auth.loading.impl;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.PhoneIdentifier;
import ru.yoomoney.sdk.auth.loading.AuthLoading;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\rH¦@¢\u0006\u0002\u0010\u0016J<\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\rH¦@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010 J&\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H¦@¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;", "", "chooseLoading", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "processType", "Lru/yoomoney/sdk/auth/Config$ProcessType;", "isForcedRegistration", "", "(Lru/yoomoney/sdk/auth/Config$ProductType;Lru/yoomoney/sdk/auth/Config$ProcessType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterIdentifier", "phone", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeEsia", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeSberId", "returnUrl", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeVkId", "code", "state", "redirectUrl", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLoginSuccess", "action", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "(Lru/yoomoney/sdk/auth/Config$ProcessType;Ljava/lang/String;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuthLoadingInteractor {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object chooseLoading$default(AuthLoadingInteractor authLoadingInteractor, Config.ProductType productType, Config.ProcessType processType, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chooseLoading");
            }
            if ((i & 1) != 0) {
                productType = Config.ProductType.DEFAULT;
            }
            return authLoadingInteractor.chooseLoading(productType, processType, z, continuation);
        }
    }

    Object chooseLoading(Config.ProductType productType, Config.ProcessType processType, boolean z, Continuation<? super AuthLoading.Action> continuation);

    Object enterIdentifier(String str, String str2, Continuation<? super AuthLoading.Action> continuation);

    Object enterOauthCodeEsia(String str, Uri uri, Continuation<? super AuthLoading.Action> continuation);

    Object enterOauthCodeSberId(String str, Uri uri, String str2, Continuation<? super AuthLoading.Action> continuation);

    Object enterOauthCodeVkId(String str, String str2, String str3, String str4, String str5, Continuation<? super AuthLoading.Action> continuation);

    Object handleLoginSuccess(AuthLoading.Action.LoginSuccess loginSuccess, Continuation<? super AuthLoading.Action> continuation);

    Object setPhone(Config.ProcessType processType, String str, PhoneIdentifier phoneIdentifier, Continuation<? super AuthLoading.Action> continuation);
}
