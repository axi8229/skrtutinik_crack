package ru.yoomoney.sdk.auth.api.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeApi;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeApi;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeApi;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountApi;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/di/ProfileApiModule;", "", "()V", "changeEmailRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;", "accountToken", "", "changePasswordRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "changePhoneRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;", "socialAccountRepositoryImpl", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProfileApiModule {
    public final EmailChangeRepository changeEmailRepository(EmailChangeApi api, String accountToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        return new EmailChangeRepositoryImpl(api, accountToken);
    }

    public final PasswordChangeRepository changePasswordRepository(PasswordChangeApi api, String accountToken, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        return new PasswordChangeRepositoryImpl(api, accountToken, locationHeaderManager);
    }

    public final PhoneChangeRepository changePhoneRepository(PhoneChangeApi api, String accountToken, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        return new PhoneChangeRepositoryImpl(api, accountToken, locationHeaderManager);
    }

    public final SocialAccountRepository socialAccountRepositoryImpl(SocialAccountApi api, String accountToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        return new SocialAccountRepositoryImpl(api, accountToken);
    }
}
