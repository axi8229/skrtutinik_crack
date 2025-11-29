package ru.yoomoney.sdk.auth.passport.impl;

import android.net.Uri;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\u0010J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\u001aJ<\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\"H&J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H¦@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H¦@¢\u0006\u0002\u0010&¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "", "account", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "action", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountSuccess", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmail", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "changePhone", "checkEmail", Scopes.EMAIL, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPhone", "phone", "enterOauthCodeEsia", "uri", "Landroid/net/Uri;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeSberId", "returnUrl", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeVkId", "code", "state", "redirectUrl", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmailChange", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountSuccess;", "startBindingSocialAccount", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindSocialAccount", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PassportProfileInteractor {
    Object account(PassportProfile.Action action, Continuation<? super PassportProfile.Action> continuation);

    Object accountSuccess(PassportProfile.Action.HandleAccountSuccess handleAccountSuccess, Continuation<? super PassportProfile.Action> continuation);

    Object changeEmail(Continuation<? super PassportProfile.Action> continuation);

    Object changePassword(Continuation<? super PassportProfile.Action> continuation);

    Object changePhone(Continuation<? super PassportProfile.Action> continuation);

    Object checkEmail(String str, Continuation<? super PassportProfile.Action> continuation);

    Object checkPhone(String str, Continuation<? super PassportProfile.Action> continuation);

    Object enterOauthCodeEsia(Uri uri, String str, Continuation<? super PassportProfile.Action> continuation);

    Object enterOauthCodeSberId(Uri uri, String str, String str2, Continuation<? super PassportProfile.Action> continuation);

    Object enterOauthCodeVkId(String str, String str2, String str3, String str4, String str5, Continuation<? super PassportProfile.Action> continuation);

    PassportProfile.Action handleEmailChange(PassportProfile.Action.AccountSuccess action);

    Object startBindingSocialAccount(OauthServiceProvider oauthServiceProvider, Continuation<? super PassportProfile.Action> continuation);

    Object unbindSocialAccount(OauthServiceProvider oauthServiceProvider, Continuation<? super PassportProfile.Action> continuation);
}
