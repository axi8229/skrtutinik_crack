package ru.yoomoney.sdk.auth.api.account.socialAccount;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u0010\u001a\u00020\u0016H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;", "", "token", "", "getToken", "()Ljava/lang/String;", "deleteSocialAccount", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "deleteSocialAccount-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOAuthCode", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/EnterOauthCodeResponse;", "connectSocialAccountProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "enterOAuthCode-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "socialAccount", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountResponse;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;", "socialAccount-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SocialAccountRepository {
    /* renamed from: deleteSocialAccount-gIAlu-s, reason: not valid java name */
    Object mo3238deleteSocialAccountgIAlus(OauthServiceProvider oauthServiceProvider, Continuation<? super Result<UserAccount>> continuation);

    /* renamed from: enterOAuthCode-0E7RQCE, reason: not valid java name */
    Object mo3239enterOAuthCode0E7RQCE(String str, SocialAccountEnterOauthCodeRequest socialAccountEnterOauthCodeRequest, Continuation<? super Result<? extends EnterOauthCodeResponse>> continuation);

    String getToken();

    /* renamed from: socialAccount-gIAlu-s, reason: not valid java name */
    Object mo3240socialAccountgIAlus(SocialAccountRequest socialAccountRequest, Continuation<? super Result<? extends ConnectSocialAccountResponse>> continuation);
}
