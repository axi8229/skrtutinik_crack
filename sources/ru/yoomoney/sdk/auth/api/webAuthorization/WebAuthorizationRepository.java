package ru.yoomoney.sdk.auth.api.webAuthorization;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepository;", "", "getLandingUrl", "Lkotlin/Result;", "", "token", "targetUrl", "getLandingUrl-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebAuthorizationRepository {
    /* renamed from: getLandingUrl-0E7RQCE, reason: not valid java name */
    Object mo3306getLandingUrl0E7RQCE(String str, String str2, Continuation<? super Result<String>> continuation);
}
