package ru.yoomoney.sdk.auth.api.account;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.account.method.LanguageRequest;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\bJ#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "", "account", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "token", "", "account-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayName", "nickname", "displayName-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "request", "Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;", "language-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revoke", "", "revoke-gIAlu-s", "revokeAll", "revokeAll-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AccountRepository {
    /* renamed from: account-gIAlu-s, reason: not valid java name */
    Object mo3209accountgIAlus(String str, Continuation<? super Result<UserAccount>> continuation);

    /* renamed from: displayName-0E7RQCE, reason: not valid java name */
    Object mo3210displayName0E7RQCE(String str, String str2, Continuation<? super Result<UserAccount>> continuation);

    /* renamed from: language-0E7RQCE, reason: not valid java name */
    Object mo3211language0E7RQCE(String str, LanguageRequest languageRequest, Continuation<? super Result<UserAccount>> continuation);

    /* renamed from: revoke-gIAlu-s, reason: not valid java name */
    Object mo3212revokegIAlus(String str, Continuation<? super Result<Unit>> continuation);

    /* renamed from: revokeAll-IoAF18A, reason: not valid java name */
    Object mo3213revokeAllIoAF18A(String token);
}
