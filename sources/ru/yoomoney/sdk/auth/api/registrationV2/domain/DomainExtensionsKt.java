package ru.yoomoney.sdk.auth.api.registrationV2.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.account.model.ServiceType;
import ru.yoomoney.sdk.auth.api.account.model.SocialAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountFailResult;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationInitResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.ApiOrigin;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountFailResult;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountSuccessResult;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBaseDefaultType;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessFailure;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessRequire2faEmail;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessRequire2faPhone;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessSetEmail;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessSetPassword;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessSetPhone;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessSuccess;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestIdentifier;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestLoginOauth;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.Service;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0000\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0000\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0000\u001a\f\u0010!\u001a\u00020\"*\u00020#H\u0000\u001a\u000e\u0010$\u001a\u0004\u0018\u00010%*\u00020&H\u0000\u001a\u000e\u0010'\u001a\u0004\u0018\u00010(*\u00020\u0001H\u0000\u001a\f\u0010)\u001a\u00020**\u00020+H\u0000¨\u0006,"}, d2 = {"toApiOrigin", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", "Lru/yoomoney/sdk/auth/api/Origin;", "toApiRegistrationRequest", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", "toApiType", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Type;", "toDomainAccount", "Lru/yoomoney/sdk/auth/api/model/Account;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Account;", "toDomainBindSocialAccount", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", "toDomainBindSocialAccountFailReason", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountFailResult$Reason;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountFailResult$Reason;", "toDomainCountryCallingCode", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;", "toDomainPrefilledPhone", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/PrefilledPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/PrefilledPhone;", "toDomainRegistrationInit", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationInit;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationInitResponse;", "toDomainRegistrationProcess", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "toDomainRegistrationProcessError", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure$Error;", "toDomainService", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Service;", "toDomainServiceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "toDomainServiceType", "Lru/yoomoney/sdk/auth/api/account/model/ServiceType;", "toDomainSocialAccount", "Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/SocialAccount;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DomainExtensionsKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[Origin.values().length];
            try {
                iArr[Origin.WALLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Origin.CHECKOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Origin.CORPORATE_BANKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Registration.Type.values().length];
            try {
                iArr2[Registration.Type.IDENTIFIER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Registration.Type.LOGIN_OAUTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[RegistrationProcessFailure.Error.values().length];
            try {
                iArr3[RegistrationProcessFailure.Error.REGISTRATION_FORBIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[RegistrationProcessFailure.Error.PROCESS_EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[RegistrationProcessFailure.Error.EMAIL_ALREADY_TAKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[RegistrationProcessFailure.Error.PHONE_NUMBER_LIMIT_REACHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[RegistrationProcessFailure.Error.AUTHORIZATION_ISSUE_LIMIT_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[ApiOrigin.values().length];
            try {
                iArr4[ApiOrigin.WALLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[ApiOrigin.CHECKOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[ApiOrigin.CORPORATE_BANKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[OauthServiceProvider.values().length];
            try {
                iArr5[OauthServiceProvider.APPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[OauthServiceProvider.SBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[OauthServiceProvider.VK.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr5[OauthServiceProvider.ESIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[BindSocialAccountFailResult.Reason.values().length];
            try {
                iArr6[BindSocialAccountFailResult.Reason.SOCIAL_ACCOUNT_ALREADY_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$5 = iArr6;
        }
    }

    public static final ApiOrigin toApiOrigin(Origin origin) {
        Intrinsics.checkNotNullParameter(origin, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[origin.ordinal()];
        if (i == 1) {
            return ApiOrigin.WALLET;
        }
        if (i == 2) {
            return ApiOrigin.CHECKOUT;
        }
        if (i == 3) {
            return ApiOrigin.CORPORATE_BANKING;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final RegistrationRequestBase toApiRegistrationRequest(Registration registration) {
        Intrinsics.checkNotNullParameter(registration, "<this>");
        if (registration instanceof Registration.Identifier) {
            return new RegistrationRequestIdentifier(toApiType(registration.getType()), toApiOrigin(((Registration.Identifier) registration).getOrigin()));
        }
        if (registration instanceof Registration.LoginOauth) {
            return new RegistrationRequestLoginOauth(toApiType(registration.getType()), ((Registration.LoginOauth) registration).getLoginOauthProcessId());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final RegistrationRequestBase.Type toApiType(Registration.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
        if (i == 1) {
            return RegistrationRequestBase.Type.IDENTIFIER;
        }
        if (i == 2) {
            return RegistrationRequestBase.Type.LOGIN_OAUTH;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Account toDomainAccount(ru.yoomoney.sdk.auth.api.registrationV2.api.model.Account account) {
        Intrinsics.checkNotNullParameter(account, "<this>");
        String uid = account.getUid();
        String title = account.getTitle();
        List<Service> services = account.getServices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(services, 10));
        Iterator<T> it = services.iterator();
        while (it.hasNext()) {
            arrayList.add(toDomainService((Service) it.next()));
        }
        return new Account(uid, title, account.getLogoUrl(), account.getMigrationRequired(), arrayList);
    }

    public static final BindSocialAccountResult toDomainBindSocialAccount(BindSocialAccountResultBase bindSocialAccountResultBase) {
        Intrinsics.checkNotNullParameter(bindSocialAccountResultBase, "<this>");
        if (bindSocialAccountResultBase instanceof BindSocialAccountFailResult) {
            return new ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountFailResult(BindSocialAccountResult.Status.ERROR, toDomainServiceProvider(bindSocialAccountResultBase.getService()), toDomainBindSocialAccountFailReason(((BindSocialAccountFailResult) bindSocialAccountResultBase).getReason()));
        }
        if (bindSocialAccountResultBase instanceof BindSocialAccountSuccessResult) {
            return new ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountSuccessResult(BindSocialAccountResult.Status.SUCCESS, toDomainServiceProvider(bindSocialAccountResultBase.getService()), toDomainSocialAccount(((BindSocialAccountSuccessResult) bindSocialAccountResultBase).getSocialAccount()));
        }
        return new ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountFailResult(BindSocialAccountResult.Status.ERROR, toDomainServiceProvider(bindSocialAccountResultBase.getService()), BindSocialAccountFailResult.Reason.TECHNICAL_ERROR);
    }

    public static final BindSocialAccountFailResult.Reason toDomainBindSocialAccountFailReason(BindSocialAccountFailResult.Reason reason) {
        Intrinsics.checkNotNullParameter(reason, "<this>");
        return WhenMappings.$EnumSwitchMapping$5[reason.ordinal()] == 1 ? BindSocialAccountFailResult.Reason.SOCIAL_ACCOUNT_ALREADY_BOUND : BindSocialAccountFailResult.Reason.TECHNICAL_ERROR;
    }

    public static final CountryCallingCode toDomainCountryCallingCode(ru.yoomoney.sdk.auth.api.registrationV2.api.model.CountryCallingCode countryCallingCode) {
        Intrinsics.checkNotNullParameter(countryCallingCode, "<this>");
        return new CountryCallingCode(countryCallingCode.getPhonePrefix(), countryCallingCode.getCountryCode(), countryCallingCode.getTitle());
    }

    public static final PrefilledPhone toDomainPrefilledPhone(ru.yoomoney.sdk.auth.api.registrationV2.api.model.PrefilledPhone prefilledPhone) {
        Intrinsics.checkNotNullParameter(prefilledPhone, "<this>");
        return new PrefilledPhone(prefilledPhone.getValue(), toDomainCountryCallingCode(prefilledPhone.getCountryCallingCode()));
    }

    public static final RegistrationInit toDomainRegistrationInit(RegistrationInitResponse registrationInitResponse) {
        Intrinsics.checkNotNullParameter(registrationInitResponse, "<this>");
        return new RegistrationInit(toDomainRegistrationProcess(registrationInitResponse.getProcess()), registrationInitResponse.getTmxSessionId());
    }

    public static final RegistrationProcess toDomainRegistrationProcess(RegistrationProcessBase registrationProcessBase) {
        RegistrationProcess setPhone;
        Intrinsics.checkNotNullParameter(registrationProcessBase, "<this>");
        if (registrationProcessBase instanceof RegistrationProcessAcquireAuthorization) {
            return new RegistrationProcess.AcquireAuthorization(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack());
        }
        if (registrationProcessBase instanceof RegistrationProcessBaseDefaultType) {
            return new RegistrationProcess.Failure(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack(), RegistrationProcessError.FatalError.INSTANCE);
        }
        if (registrationProcessBase instanceof RegistrationProcessFailure) {
            return new RegistrationProcess.Failure(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack(), toDomainRegistrationProcessError(((RegistrationProcessFailure) registrationProcessBase).getError()));
        }
        if (registrationProcessBase instanceof RegistrationProcessRequire2faEmail) {
            return new RegistrationProcess.Require2faEmail(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack(), ((RegistrationProcessRequire2faEmail) registrationProcessBase).getAuthProcessId());
        }
        if (registrationProcessBase instanceof RegistrationProcessRequire2faPhone) {
            return new RegistrationProcess.Require2faPhone(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack(), ((RegistrationProcessRequire2faPhone) registrationProcessBase).getAuthProcessId());
        }
        ArrayList arrayList = null;
        if (registrationProcessBase instanceof RegistrationProcessSetEmail) {
            String id = registrationProcessBase.getId();
            boolean addToBackStack = registrationProcessBase.getAddToBackStack();
            RegistrationProcessSetEmail registrationProcessSetEmail = (RegistrationProcessSetEmail) registrationProcessBase;
            String prefilledEmail = registrationProcessSetEmail.getPrefilledEmail();
            List<ru.yoomoney.sdk.auth.api.registrationV2.api.model.Account> accounts = registrationProcessSetEmail.getAccounts();
            if (accounts != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(accounts, 10));
                Iterator<T> it = accounts.iterator();
                while (it.hasNext()) {
                    arrayList.add(toDomainAccount((ru.yoomoney.sdk.auth.api.registrationV2.api.model.Account) it.next()));
                }
            }
            setPhone = new RegistrationProcess.SetEmail(id, addToBackStack, prefilledEmail, arrayList);
        } else {
            if (registrationProcessBase instanceof RegistrationProcessSetPassword) {
                return new RegistrationProcess.SetPassword(registrationProcessBase.getId(), registrationProcessBase.getAddToBackStack());
            }
            if (!(registrationProcessBase instanceof RegistrationProcessSetPhone)) {
                if (!(registrationProcessBase instanceof RegistrationProcessSuccess)) {
                    throw new NoWhenBranchMatchedException();
                }
                String id2 = registrationProcessBase.getId();
                boolean addToBackStack2 = registrationProcessBase.getAddToBackStack();
                RegistrationProcessSuccess registrationProcessSuccess = (RegistrationProcessSuccess) registrationProcessBase;
                String accessToken = registrationProcessSuccess.getAccessToken();
                BindSocialAccountResultBase bindSocialAccountResult = registrationProcessSuccess.getBindSocialAccountResult();
                return new RegistrationProcess.Success(id2, addToBackStack2, accessToken, bindSocialAccountResult != null ? toDomainBindSocialAccount(bindSocialAccountResult) : null);
            }
            String id3 = registrationProcessBase.getId();
            boolean addToBackStack3 = registrationProcessBase.getAddToBackStack();
            RegistrationProcessSetPhone registrationProcessSetPhone = (RegistrationProcessSetPhone) registrationProcessBase;
            List<ru.yoomoney.sdk.auth.api.registrationV2.api.model.CountryCallingCode> countryCallingCodes = registrationProcessSetPhone.getCountryCallingCodes();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(countryCallingCodes, 10));
            Iterator<T> it2 = countryCallingCodes.iterator();
            while (it2.hasNext()) {
                arrayList2.add(toDomainCountryCallingCode((ru.yoomoney.sdk.auth.api.registrationV2.api.model.CountryCallingCode) it2.next()));
            }
            ru.yoomoney.sdk.auth.api.registrationV2.api.model.PrefilledPhone prefilledPhone = registrationProcessSetPhone.getPrefilledPhone();
            setPhone = new RegistrationProcess.SetPhone(id3, addToBackStack3, arrayList2, prefilledPhone != null ? toDomainPrefilledPhone(prefilledPhone) : null);
        }
        return setPhone;
    }

    public static final RegistrationProcessError toDomainRegistrationProcessError(RegistrationProcessFailure.Error error) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[error.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? RegistrationProcessError.FatalError.INSTANCE : RegistrationProcessError.AuthorizationIssueLimitExceeded.INSTANCE : RegistrationProcessError.PhoneNumberLimitReached.INSTANCE : RegistrationProcessError.EmailAlreadyTaken.INSTANCE : RegistrationProcessError.ProcessExpired.INSTANCE : RegistrationProcessError.RegistrationForbidden.INSTANCE;
    }

    public static final ru.yoomoney.sdk.auth.api.account.model.Service toDomainService(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return new ru.yoomoney.sdk.auth.api.account.model.Service(toDomainServiceType(service.getType()), service.getTitle(), service.getLogoUrl());
    }

    public static final ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider toDomainServiceProvider(OauthServiceProvider oauthServiceProvider) {
        Intrinsics.checkNotNullParameter(oauthServiceProvider, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$4[oauthServiceProvider.ordinal()];
        if (i == 1) {
            return ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider.APPLE;
        }
        if (i == 2) {
            return ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider.SBER;
        }
        if (i == 3) {
            return ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider.VK;
        }
        if (i != 4) {
            return null;
        }
        return ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider.ESIA;
    }

    public static final ServiceType toDomainServiceType(ApiOrigin apiOrigin) {
        Intrinsics.checkNotNullParameter(apiOrigin, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$3[apiOrigin.ordinal()];
        if (i == 1) {
            return ServiceType.WALLET;
        }
        if (i == 2) {
            return ServiceType.CHECKOUT;
        }
        if (i != 3) {
            return null;
        }
        return ServiceType.CORPORATE_BANKING;
    }

    public static final SocialAccount toDomainSocialAccount(ru.yoomoney.sdk.auth.api.registrationV2.api.model.SocialAccount socialAccount) {
        Intrinsics.checkNotNullParameter(socialAccount, "<this>");
        return new SocialAccount(socialAccount.getTitle(), toDomainServiceProvider(socialAccount.getService()));
    }
}
