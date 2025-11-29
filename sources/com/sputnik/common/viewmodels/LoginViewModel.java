package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.entities.sessions.LocalSession;
import com.sputnik.common.entities.sessions.LocalSessionKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainApplyRegistration;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.usecases.auth.ApplyRegistrationUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BU\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001b\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0019\u0010%\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010#¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b*\u0010&J\u0017\u0010,\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b,\u0010&J\u0017\u0010.\u001a\u00020-2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\u001c2\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J+\u00105\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010#2\b\u00104\u001a\u0004\u0018\u00010#¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\u001c2\u0006\u00101\u001a\u000200¢\u0006\u0004\b7\u00103J\u0015\u00109\u001a\u00020\u001c2\u0006\u00101\u001a\u000208¢\u0006\u0004\b9\u0010:J#\u0010<\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010;\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b<\u0010)J!\u0010=\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010;\u001a\u0004\u0018\u00010#¢\u0006\u0004\b=\u0010)J\r\u0010>\u001a\u00020\u001c¢\u0006\u0004\b>\u0010\u001eJ\u000f\u0010?\u001a\u0004\u0018\u000108¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u001c¢\u0006\u0004\bA\u0010\u001eJ\r\u0010B\u001a\u00020-¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u001c¢\u0006\u0004\bD\u0010\u001eJ\u000f\u0010E\u001a\u00020\u001cH\u0016¢\u0006\u0004\bE\u0010\u001eJ\r\u0010F\u001a\u00020\u001c¢\u0006\u0004\bF\u0010\u001eJ\r\u0010G\u001a\u00020\u001c¢\u0006\u0004\bG\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010HR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010IR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010JR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010KR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010LR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010MR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010NR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010O¨\u0006P"}, d2 = {"Lcom/sputnik/common/viewmodels/LoginViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/LoginViewState;", "", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "registerUserUserCase", "Lcom/sputnik/domain/usecases/auth/ApplyRegistrationUseCase;", "applyRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "confirmRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "getRequestUseCase", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;", "getCountryCodeUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "Lcom/sputnik/common/entities/country_code/CountryCode;", "domainCountryCodeToCountryCodeMapper", "Lcom/sputnik/data/IConfig;", "config", "<init>", "(Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;Lcom/sputnik/domain/usecases/auth/ApplyRegistrationUseCase;Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/IConfig;)V", "Landroidx/lifecycle/LiveData;", "", "getCountryCodeFromLocal", "()Landroidx/lifecycle/LiveData;", "", "initializeData", "()V", "loadAccounts", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainApplyRegistration;", "authorize", "", "phone", "handleRawPhone", "(Ljava/lang/String;)V", "countryCode", "handlePhone", "(Ljava/lang/String;Ljava/lang/String;)V", "handlePrettyPhone", "code", "handleCountryCode", "", "checkSessionByPhone", "(Ljava/lang/String;)Z", "Lcom/sputnik/common/entities/sessions/LocalSession;", "session", "deleteSession", "(Lcom/sputnik/common/entities/sessions/LocalSession;)V", "rawPhone", "selectSessionByPhone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "selectSession", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "saveSession", "(Lcom/sputnik/domain/entities/prefs/LoginState$Session;)V", "prettyPhone", "handleData", "handleDataNew", "registerCurrentSessionInIntercom", "getSessionByPhone", "()Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "checkoutSessionByPhone", "isIntercomOpenedForCurrentSession", "()Z", "markIntercomAsOpenedForCurrentSession", "cleanCamerasInWidget", "clearToRequestCode", "clearAccount", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "Lcom/sputnik/domain/usecases/auth/ApplyRegistrationUseCase;", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/IConfig;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginViewModel extends BaseViewModel<LoginViewState> {
    private final ApplyRegistrationUseCase applyRegistrationUseCase;
    private final IConfig config;
    private final ConfirmRegistrationUseCase confirmRegistrationUseCase;
    private final ListMapper<DomainCountryCode, CountryCode> domainCountryCodeToCountryCodeMapper;
    private final GetCountryCodeUseCase getCountryCodeUseCase;
    private final GetRequestUseCase getRequestUseCase;
    private final PrefManager prefManager;
    private final RegisterUserByPhoneUseCase registerUserUserCase;

    public final void registerCurrentSessionInIntercom() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel(RegisterUserByPhoneUseCase registerUserUserCase, ApplyRegistrationUseCase applyRegistrationUseCase, ConfirmRegistrationUseCase confirmRegistrationUseCase, GetRequestUseCase getRequestUseCase, PrefManager prefManager, GetCountryCodeUseCase getCountryCodeUseCase, ListMapper<DomainCountryCode, CountryCode> domainCountryCodeToCountryCodeMapper, IConfig config) {
        super(new LoginViewState(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 262143, null), Reflection.getOrCreateKotlinClass(LoginViewModel.class).toString());
        Intrinsics.checkNotNullParameter(registerUserUserCase, "registerUserUserCase");
        Intrinsics.checkNotNullParameter(applyRegistrationUseCase, "applyRegistrationUseCase");
        Intrinsics.checkNotNullParameter(confirmRegistrationUseCase, "confirmRegistrationUseCase");
        Intrinsics.checkNotNullParameter(getRequestUseCase, "getRequestUseCase");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(getCountryCodeUseCase, "getCountryCodeUseCase");
        Intrinsics.checkNotNullParameter(domainCountryCodeToCountryCodeMapper, "domainCountryCodeToCountryCodeMapper");
        Intrinsics.checkNotNullParameter(config, "config");
        this.registerUserUserCase = registerUserUserCase;
        this.applyRegistrationUseCase = applyRegistrationUseCase;
        this.confirmRegistrationUseCase = confirmRegistrationUseCase;
        this.getRequestUseCase = getRequestUseCase;
        this.prefManager = prefManager;
        this.getCountryCodeUseCase = getCountryCodeUseCase;
        this.domainCountryCodeToCountryCodeMapper = domainCountryCodeToCountryCodeMapper;
        this.config = config;
        subscribeOnDataSource(getCountryCodeFromLocal(), new Function2<List<? extends DomainCountryCode>, LoginViewState, LoginViewState>() { // from class: com.sputnik.common.viewmodels.LoginViewModel.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LoginViewState invoke(List<? extends DomainCountryCode> list, LoginViewState loginViewState) {
                return invoke2((List<DomainCountryCode>) list, loginViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final LoginViewState invoke2(List<DomainCountryCode> list, LoginViewState state) {
                String str;
                Object next;
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(state, "state");
                List map = LoginViewModel.this.domainCountryCodeToCountryCodeMapper.map(list);
                String countryCode = state.getCountryCode();
                if (countryCode == null) {
                    Iterator it = map.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics.areEqual(((CountryCode) next).getIsoCode(), AndroidConstants.INSTANCE.getPhoneCountry())) {
                            break;
                        }
                    }
                    CountryCode countryCode2 = (CountryCode) next;
                    String code = countryCode2 != null ? countryCode2.getCode() : null;
                    if (code == null) {
                        countryCode = "+7";
                        str = countryCode;
                    } else {
                        str = code;
                    }
                } else {
                    str = countryCode;
                }
                return state.copy((262119 & 1) != 0 ? state.serverState : null, (262119 & 2) != 0 ? state.phone : null, (262119 & 4) != 0 ? state.prettyPhone : null, (262119 & 8) != 0 ? state.countryCode : str, (262119 & 16) != 0 ? state.countryCodeList : map, (262119 & 32) != 0 ? state.rawPhone : null, (262119 & 64) != 0 ? state.code : null, (262119 & 128) != 0 ? state.confirmationType : null, (262119 & 256) != 0 ? state.toRequestCode : null, (262119 & 512) != 0 ? state.toLimitExceeded : null, (262119 & 1024) != 0 ? state.isLimitExceeded : null, (262119 & 2048) != 0 ? state.limitExceededMessage : null, (262119 & 4096) != 0 ? state.remainTimeInSeconds : null, (262119 & 8192) != 0 ? state.loginState : null, (262119 & 16384) != 0 ? state.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.sessionsState : null, (262119 & 131072) != 0 ? state.applyRegistration : null);
            }
        });
        loadAccounts();
        initializeData();
    }

    private final LiveData<List<DomainCountryCode>> getCountryCodeFromLocal() {
        return FlowLiveDataConversions.asLiveData$default(this.getCountryCodeUseCase.invoke(), null, 0L, 3, null);
    }

    public LiveData<Resource<DomainApplyRegistration>> authorize() {
        ApplyRegistrationUseCase applyRegistrationUseCase = this.applyRegistrationUseCase;
        String phone = getCurrentState().getPhone();
        Intrinsics.checkNotNull(phone);
        return FlowLiveDataConversions.asLiveData$default(applyRegistrationUseCase.invoke(phone, this.prefManager.getCurLocale(), this.config.getPlatformKeyName(), "default"), null, 0L, 3, null);
    }

    private final void initializeData() {
        int size;
        LoginViewState currentState = getCurrentState();
        LoginState loginState = this.prefManager.getLoginState();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long smsCodeExpiresAt = this.prefManager.getLoginState().getSmsCodeExpiresAt();
        boolean z = jCurrentTimeMillis - (smsCodeExpiresAt != null ? smsCodeExpiresAt.longValue() : jCurrentTimeMillis) > 0;
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : sessions) {
                if (((LoginState.Session) obj).getJwt() != null) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        boolean z2 = size >= 3;
        List<LoginState.Session> sessions2 = loginState.getSessions();
        if (sessions2 == null) {
            sessions2 = CollectionsKt.emptyList();
        }
        ArrayList<LoginState.Session> arrayList2 = new ArrayList();
        for (Object obj2 : sessions2) {
            if (((LoginState.Session) obj2).getJwt() != null) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (LoginState.Session session : arrayList2) {
            arrayList3.add(new LocalSession(session.getName(), session.getPhone(), session.getCountryCode(), session.getJwt(), session.getIsVisible(), session.getImage()));
        }
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : z, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : new SessionsState(z2, arrayList3), (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void clearAccount() {
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : new Event(Boolean.FALSE), (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void clearToRequestCode() {
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : new Event(Boolean.FALSE), (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public void handleCountryCode(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : code, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void handlePhone(String phone, String countryCode) {
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : countryCode + phone, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void handlePrettyPhone(String phone) {
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : phone, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public void handleRawPhone(String phone) {
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : phone, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public void loadAccounts() {
        int size;
        LoginViewState currentState = getCurrentState();
        LoginState loginState = this.prefManager.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : sessions) {
                LoginState.Session session = (LoginState.Session) obj;
                if (session.getJwt() != null && Intrinsics.areEqual(session.getIsVisible(), Boolean.TRUE)) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        boolean z = size >= 3;
        List<LoginState.Session> sessions2 = loginState.getSessions();
        if (sessions2 == null) {
            sessions2 = CollectionsKt.emptyList();
        }
        ArrayList<LoginState.Session> arrayList2 = new ArrayList();
        for (Object obj2 : sessions2) {
            LoginState.Session session2 = (LoginState.Session) obj2;
            if (session2.getJwt() != null && Intrinsics.areEqual(session2.getIsVisible(), Boolean.TRUE)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (LoginState.Session session3 : arrayList2) {
            arrayList3.add(new LocalSession(session3.getName(), session3.getPhone(), session3.getCountryCode(), session3.getJwt(), session3.getIsVisible(), session3.getImage()));
        }
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : new SessionsState(z, arrayList3), (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final boolean checkSessionByPhone(String phone) {
        if (phone == null) {
            return false;
        }
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        Object obj = null;
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                LoginState.Session session = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringsKt.replace$default(session.getCountryCode(), "+", "", false, 4, (Object) null) + StringUtilsKt.toPhoneHash(session.getPhone()), StringUtilsKt.toPhoneHash(phone)) || Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session.getPhone()), StringUtilsKt.toPhoneHash(phone))) {
                    if (session.getJwt() != null) {
                        obj = next;
                        break;
                    }
                }
            }
            obj = (LoginState.Session) obj;
        }
        return obj != null;
    }

    public final void deleteSession(LocalSession session) {
        LoginState.Session session2;
        Object next;
        Intrinsics.checkNotNullParameter(session, "session");
        LoginState loginState = this.prefManager.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next).getJwt(), session.getJwt())) {
                        break;
                    }
                }
            }
            session2 = (LoginState.Session) next;
        } else {
            session2 = null;
        }
        Integer numValueOf = sessions != null ? Integer.valueOf(CollectionsKt.indexOf((List<? extends LoginState.Session>) sessions, session2)) : null;
        if (session2 != null && numValueOf != null) {
            sessions.get(numValueOf.intValue()).setVisible(Boolean.FALSE);
        }
        PrefManager prefManager = this.prefManager;
        loginState.setSessions(sessions);
        prefManager.setLoginState(loginState);
        loadAccounts();
    }

    public final void selectSessionByPhone(String phone, String countryCode, String rawPhone) {
        LoginState.Session session;
        String jwt;
        String countryCode2;
        String countryCode3;
        Object next;
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (!Intrinsics.areEqual(StringsKt.replace$default(session2.getCountryCode(), "+", "", false, 4, (Object) null) + StringUtilsKt.toPhoneHash(session2.getPhone()), phone != null ? StringUtilsKt.toPhoneHash(phone) : null)) {
                    String phone2 = session2.getPhone();
                    if (!Intrinsics.areEqual(phone2 != null ? StringUtilsKt.toPhoneHash(phone2) : null, phone != null ? StringUtilsKt.toPhoneHash(phone) : null)) {
                        continue;
                    }
                }
                if (session2.getJwt() != null) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        if (session != null && (countryCode3 = session.getCountryCode()) != null && StringsKt.isBlank(countryCode3) && countryCode != null) {
            session.setCountryCode(countryCode);
            session.setPhone(String.valueOf(rawPhone));
        }
        Integer numValueOf = sessions != null ? Integer.valueOf(CollectionsKt.indexOf((List<? extends LoginState.Session>) sessions, session)) : null;
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            try {
                LoginState.Session session3 = sessions.get(iIntValue);
                session3.setVisible(Boolean.TRUE);
                Unit unit = Unit.INSTANCE;
                sessions.set(iIntValue, session3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (session == null || (jwt = session.getJwt()) == null) {
            return;
        }
        this.prefManager.updateJwtToken(jwt);
        PrefManager prefManager = this.prefManager;
        LoginState loginState = prefManager.getLoginState();
        loginState.setSmsCodeExpiresAt(0L);
        loginState.setPhone("");
        loginState.setSessions(sessions);
        prefManager.setLoginState(loginState);
        String rawPhone2 = getCurrentState().getRawPhone();
        if (rawPhone2 != null && (countryCode2 = getCurrentState().getCountryCode()) != null) {
            this.prefManager.updatePhone(LocalSessionKt.toPhoneHash(countryCode2 + rawPhone2));
        }
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : new Event(Boolean.TRUE), (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void selectSession(LocalSession session) {
        LoginState.Session session2;
        String jwt;
        Object next;
        Intrinsics.checkNotNullParameter(session, "session");
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((LoginState.Session) next).hash(), session.hash())) {
                        break;
                    }
                }
            }
            session2 = (LoginState.Session) next;
        } else {
            session2 = null;
        }
        if (session2 == null || (jwt = session2.getJwt()) == null) {
            return;
        }
        this.prefManager.updateJwtToken(jwt);
        PrefManager prefManager = this.prefManager;
        LoginState loginState = prefManager.getLoginState();
        loginState.setSmsCodeExpiresAt(0L);
        loginState.setPhone("");
        prefManager.setLoginState(loginState);
        this.prefManager.updatePhone(session.hash());
        LoginViewState currentState = getCurrentState();
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : new Event(Boolean.TRUE), (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final void saveSession(LoginState.Session session) {
        Object next;
        Intrinsics.checkNotNullParameter(session, "session");
        LoginState loginState = this.prefManager.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        Iterator<T> it = sessions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            LoginState.Session session2 = (LoginState.Session) next;
            if (Intrinsics.areEqual(StringsKt.replace$default(session2.getCountryCode(), "+", "", false, 4, (Object) null) + StringUtilsKt.toPhoneHash(session2.getPhone()), StringUtilsKt.toPhoneHash(session.getPhone())) || Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getPhone()), StringUtilsKt.toPhoneHash(session.getPhone()))) {
                break;
            }
        }
        LoginState.Session session3 = (LoginState.Session) next;
        if (session3 == null) {
            LoginState.Session session4 = new LoginState.Session(session.getName(), session.getCountryCode(), StringsKt.replace$default(session.getPhone(), session.getCountryCode(), "", false, 4, (Object) null), session.getJwt(), Boolean.TRUE, (String) null, (ProfileSettings) null, Boolean.FALSE, (String) null, session.getWay(), session.getCodeExpiresAt(), session.getRequestId(), session.getUserSmsCode(), session.getUserSmsPhone(), session.getIsIntercomOpened(), (Boolean) null, (Boolean) null, (List) null, 229376, (DefaultConstructorMarker) null);
            List<LoginState.Session> sessions2 = loginState.getSessions();
            if (sessions2 != null) {
                sessions2.add(session4);
            }
        } else {
            String name = session.getName();
            if (name == null) {
                name = session3.getName();
            }
            session3.setName(name);
            String jwt = session.getJwt();
            if (jwt == null) {
                jwt = session3.getJwt();
            }
            session3.setJwt(jwt);
            session3.setVisible(Boolean.TRUE);
            session3.setImage(session3.getImage());
            RegistrationWay way = session.getWay();
            if (way == null) {
                way = session3.getWay();
            }
            session3.setWay(way);
            Long codeExpiresAt = session.getCodeExpiresAt();
            if (codeExpiresAt == null) {
                codeExpiresAt = session3.getCodeExpiresAt();
            }
            session3.setCodeExpiresAt(codeExpiresAt);
            String requestId = session.getRequestId();
            if (requestId == null) {
                requestId = session3.getRequestId();
            }
            session3.setRequestId(requestId);
            String userSmsCode = session.getUserSmsCode();
            if (userSmsCode == null) {
                userSmsCode = session3.getUserSmsCode();
            }
            session3.setUserSmsCode(userSmsCode);
            String userSmsPhone = session.getUserSmsPhone();
            if (userSmsPhone == null) {
                userSmsPhone = session3.getUserSmsPhone();
            }
            session3.setUserSmsPhone(userSmsPhone);
            Boolean isIntercomOpened = session.getIsIntercomOpened();
            if (isIntercomOpened == null) {
                isIntercomOpened = session3.getIsIntercomOpened();
            }
            session3.setIntercomOpened(isIntercomOpened);
            int iIndexOf = sessions.indexOf(session3);
            try {
                List<LoginState.Session> sessions3 = loginState.getSessions();
                Intrinsics.checkNotNull(sessions3);
                sessions3.set(iIndexOf, session3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.prefManager.setLoginState(loginState);
    }

    public void handleData(String phone, String prettyPhone) {
        handleDataNew(phone, prettyPhone);
    }

    public final void handleDataNew(final String phone, final String prettyPhone) {
        PrefManager prefManager = this.prefManager;
        Intrinsics.checkNotNull(phone);
        prefManager.updatePhone(phone);
        String prettyPhone2 = prettyPhone == null ? getCurrentState().getPrettyPhone() : prettyPhone;
        final String countryCode = getCurrentState().getCountryCode();
        LoginViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        Boolean bool = Boolean.FALSE;
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : status, (262119 & 2) != 0 ? currentState.phone : phone, (262119 & 4) != 0 ? currentState.prettyPhone : prettyPhone2, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : new Event(bool), (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
        if (prettyPhone2 != null) {
            saveSession(new LoginState.Session((String) null, String.valueOf(countryCode), prettyPhone2, (String) null, bool, (String) null, (ProfileSettings) null, bool, (String) null, (RegistrationWay) null, (Long) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (List) null, 258048, (DefaultConstructorMarker) null));
        }
        subscribeOnDataSource(authorize(), new Function2<Resource<? extends DomainApplyRegistration>, LoginViewState, LoginViewState>() { // from class: com.sputnik.common.viewmodels.LoginViewModel.handleDataNew.2

            /* compiled from: LoginViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.LoginViewModel$handleDataNew$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LoginViewState invoke(Resource<? extends DomainApplyRegistration> resource, LoginViewState loginViewState) {
                return invoke2((Resource<DomainApplyRegistration>) resource, loginViewState);
            }

            /* JADX WARN: Removed duplicated region for block: B:100:0x01f0  */
            /* JADX WARN: Removed duplicated region for block: B:101:0x01f7  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x0201  */
            /* JADX WARN: Removed duplicated region for block: B:105:0x0208  */
            /* JADX WARN: Removed duplicated region for block: B:108:0x0212  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00eb  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00fc  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0103  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x010d  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0153  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0168  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x0184  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x018c  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x018f  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
            /* JADX WARN: Removed duplicated region for block: B:81:0x01a2  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x01ac  */
            /* JADX WARN: Removed duplicated region for block: B:85:0x01b3  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x01bd  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x01c4  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x01ce  */
            /* JADX WARN: Removed duplicated region for block: B:93:0x01d5  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x01df  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x01e6  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.sputnik.common.viewmodels.LoginViewState invoke2(com.sputnik.domain.common.Resource<com.sputnik.domain.entities.auth.DomainApplyRegistration> r37, com.sputnik.common.viewmodels.LoginViewState r38) throws java.text.ParseException {
                /*
                    Method dump skipped, instructions count: 842
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.LoginViewModel.AnonymousClass2.invoke2(com.sputnik.domain.common.Resource, com.sputnik.common.viewmodels.LoginViewState):com.sputnik.common.viewmodels.LoginViewState");
            }
        });
    }

    public final LoginState.Session getSessionByPhone() {
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        Object obj = null;
        if (sessions == null) {
            return null;
        }
        Iterator<T> it = sessions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(((LoginState.Session) next).getPhone()), StringUtilsKt.toPhoneHash(String.valueOf(getCurrentState().getRawPhone())))) {
                obj = next;
                break;
            }
        }
        return (LoginState.Session) obj;
    }

    public final void checkoutSessionByPhone() {
        ApplyRegistration applyRegistration;
        LoginState.Session sessionByPhone = getSessionByPhone();
        LoginViewState currentState = getCurrentState();
        ApplyRegistration applyRegistration2 = currentState.getApplyRegistration();
        if (applyRegistration2 != null) {
            applyRegistration2.setUserSmsCode(sessionByPhone != null ? sessionByPhone.getUserSmsCode() : null);
            applyRegistration2.setUserSmsPhone(sessionByPhone != null ? sessionByPhone.getUserSmsPhone() : null);
            Unit unit = Unit.INSTANCE;
            applyRegistration = applyRegistration2;
        } else {
            applyRegistration = null;
        }
        LoginViewState loginViewStateCopy = currentState.copy((262119 & 1) != 0 ? currentState.serverState : null, (262119 & 2) != 0 ? currentState.phone : null, (262119 & 4) != 0 ? currentState.prettyPhone : null, (262119 & 8) != 0 ? currentState.countryCode : null, (262119 & 16) != 0 ? currentState.countryCodeList : null, (262119 & 32) != 0 ? currentState.rawPhone : null, (262119 & 64) != 0 ? currentState.code : null, (262119 & 128) != 0 ? currentState.confirmationType : null, (262119 & 256) != 0 ? currentState.toRequestCode : null, (262119 & 512) != 0 ? currentState.toLimitExceeded : null, (262119 & 1024) != 0 ? currentState.isLimitExceeded : null, (262119 & 2048) != 0 ? currentState.limitExceededMessage : null, (262119 & 4096) != 0 ? currentState.remainTimeInSeconds : null, (262119 & 8192) != 0 ? currentState.loginState : null, (262119 & 16384) != 0 ? currentState.smsCodeExpired : false, (262119 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.isLoaded : null, (262119 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.sessionsState : null, (262119 & 131072) != 0 ? currentState.applyRegistration : applyRegistration);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(loginViewStateCopy, this, null), 3, null);
        getState().setValue(loginViewStateCopy);
    }

    public final boolean isIntercomOpenedForCurrentSession() {
        Boolean isIntercomOpened;
        LoginState.Session sessionByPhone = getSessionByPhone();
        if (sessionByPhone == null || (isIntercomOpened = sessionByPhone.getIsIntercomOpened()) == null) {
            return false;
        }
        return isIntercomOpened.booleanValue();
    }

    public final void markIntercomAsOpenedForCurrentSession() {
        LoginState.Session sessionByPhone = getSessionByPhone();
        if (sessionByPhone != null) {
            sessionByPhone.setIntercomOpened(Boolean.TRUE);
        }
        if (sessionByPhone != null) {
            saveSession(sessionByPhone);
        }
    }

    public void cleanCamerasInWidget() {
        this.prefManager.updateCamerasInWidgets(CollectionsKt.emptyList());
    }
}
