package com.sputnik.common.viewmodels;

import android.os.CountDownTimer;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ErrorCodes;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainConfirmResponse;
import com.sputnik.domain.entities.auth.DomainRequestInfo;
import com.sputnik.domain.entities.auth.RegistrationState;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.usecases.auth.ConfirmCodeUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import com.sputnik.domain.utils.DateUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* compiled from: CallCodeViewModel.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002JKB?\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u001c\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJK\u0010\"\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020!2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b&\u0010'J-\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,JK\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0)0(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010/J7\u00100\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020!¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020!2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020!2\u0006\u00105\u001a\u000204¢\u0006\u0004\b8\u00107J/\u0010:\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b:\u00101J\u000f\u0010;\u001a\u00020!H\u0016¢\u0006\u0004\b;\u00103J\r\u0010<\u001a\u00020!¢\u0006\u0004\b<\u00103J\u000f\u0010=\u001a\u00020!H\u0014¢\u0006\u0004\b=\u00103R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010>R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010?R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010@R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010AR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010BR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010E¨\u0006L"}, d2 = {"Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/CallCodeViewState;", "", "", "phone", "Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;", "confirmCodeUseCase", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "registerUserUserCase", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "confirmRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "getRequestUseCase", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;)V", "", "seconds", "Lkotlinx/coroutines/Job;", "startCountDownJob", "(I)Lkotlinx/coroutines/Job;", "requestId", "code", "countryCode", "startHandlingRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/Job;", "authCode", "platform", "app", "", "confirmRegistrationOnServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "startCountDown", "(I)V", "startCountDownNew", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", "getRequestInfo", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/auth/DomainConfirmResponse;", "confirmRegistration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "startProfileJob", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "stopJob", "()V", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "session", "saveSession", "(Lcom/sputnik/domain/entities/prefs/LoginState$Session;)V", "deleteSession", "prettyPhone", "handleCodeNew", "clearError", "clearTimer", "onCleared", "Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/data/IConfig;", "countDownJob", "Lkotlinx/coroutines/Job;", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroid/os/CountDownTimer;", "handleCodeJob", "Companion", "Factory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallCodeViewModel extends BaseViewModel<CallCodeViewState> {
    private final IConfig config;
    private final ConfirmCodeUseCase confirmCodeUseCase;
    private final ConfirmRegistrationUseCase confirmRegistrationUseCase;
    private Job countDownJob;
    private CountDownTimer countDownTimer;
    private final GetRequestUseCase getRequestUseCase;
    private Job handleCodeJob;
    private final PrefManager prefManager;
    private final RegisterUserByPhoneUseCase registerUserUserCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallCodeViewModel(String phone, ConfirmCodeUseCase confirmCodeUseCase, RegisterUserByPhoneUseCase registerUserUserCase, ConfirmRegistrationUseCase confirmRegistrationUseCase, GetRequestUseCase getRequestUseCase, PrefManager prefManager, IConfig config) {
        super(new CallCodeViewState(null, phone, null, null, null, null, null, null, null, null, 0, false, false, null, false, 32765, null), "javaClass");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(confirmCodeUseCase, "confirmCodeUseCase");
        Intrinsics.checkNotNullParameter(registerUserUserCase, "registerUserUserCase");
        Intrinsics.checkNotNullParameter(confirmRegistrationUseCase, "confirmRegistrationUseCase");
        Intrinsics.checkNotNullParameter(getRequestUseCase, "getRequestUseCase");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        this.confirmCodeUseCase = confirmCodeUseCase;
        this.registerUserUserCase = registerUserUserCase;
        this.confirmRegistrationUseCase = confirmRegistrationUseCase;
        this.getRequestUseCase = getRequestUseCase;
        this.prefManager = prefManager;
        this.config = config;
    }

    /* compiled from: CallCodeViewModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017BC\b\u0007\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "phone", "", "confirmCodeUseCase", "Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;", "registerUserUserCase", "Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;", "confirmRegistrationUseCase", "Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "getRequestUseCase", "Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "config", "Lcom/sputnik/data/IConfig;", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/auth/ConfirmCodeUseCase;Lcom/sputnik/domain/usecases/auth/RegisterUserByPhoneUseCase;Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final IConfig config;
        private final ConfirmCodeUseCase confirmCodeUseCase;
        private final ConfirmRegistrationUseCase confirmRegistrationUseCase;
        private final GetRequestUseCase getRequestUseCase;
        private final String phone;
        private final PrefManager prefManager;
        private final RegisterUserByPhoneUseCase registerUserUserCase;

        /* compiled from: CallCodeViewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "", "create", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory;", "phone", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String phone);
        }

        public Factory(String str, ConfirmCodeUseCase confirmCodeUseCase, RegisterUserByPhoneUseCase registerUserUserCase, ConfirmRegistrationUseCase confirmRegistrationUseCase, GetRequestUseCase getRequestUseCase, PrefManager prefManager, IConfig config) {
            Intrinsics.checkNotNullParameter(confirmCodeUseCase, "confirmCodeUseCase");
            Intrinsics.checkNotNullParameter(registerUserUserCase, "registerUserUserCase");
            Intrinsics.checkNotNullParameter(confirmRegistrationUseCase, "confirmRegistrationUseCase");
            Intrinsics.checkNotNullParameter(getRequestUseCase, "getRequestUseCase");
            Intrinsics.checkNotNullParameter(prefManager, "prefManager");
            Intrinsics.checkNotNullParameter(config, "config");
            this.phone = str;
            this.confirmCodeUseCase = confirmCodeUseCase;
            this.registerUserUserCase = registerUserUserCase;
            this.confirmRegistrationUseCase = confirmRegistrationUseCase;
            this.getRequestUseCase = getRequestUseCase;
            this.prefManager = prefManager;
            this.config = config;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, CallCodeViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String str = this.phone;
            if (str == null) {
                str = "";
            }
            return new CallCodeViewModel(str, this.confirmCodeUseCase, this.registerUserUserCase, this.confirmRegistrationUseCase, this.getRequestUseCase, this.prefManager, this.config);
        }
    }

    /* compiled from: CallCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.CallCodeViewModel$startCountDownJob$1", f = "CallCodeViewModel.kt", l = {128}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.CallCodeViewModel$startCountDownJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C06431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $seconds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06431(int i, Continuation<? super C06431> continuation) {
            super(2, continuation);
            this.$seconds = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CallCodeViewModel.this.new C06431(this.$seconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x010e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c5 -> B:21:0x00c8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 335
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.CallCodeViewModel.C06431.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job startCountDownJob(int seconds) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06431(seconds, null), 3, null);
    }

    public void clearError() {
        CallCodeViewState currentState = getCurrentState();
        CallCodeViewState callCodeViewStateCopy = currentState.copy((32511 & 1) != 0 ? currentState.handleCodeServerState : null, (32511 & 2) != 0 ? currentState.phone : null, (32511 & 4) != 0 ? currentState.code : null, (32511 & 8) != 0 ? currentState.isLoaded : null, (32511 & 16) != 0 ? currentState.confirmationType : null, (32511 & 32) != 0 ? currentState.jwt : null, (32511 & 64) != 0 ? currentState.state : null, (32511 & 128) != 0 ? currentState.app : null, (32511 & 256) != 0 ? currentState.error : null, (32511 & 512) != 0 ? currentState.parsedError : null, (32511 & 1024) != 0 ? currentState.count : 0, (32511 & 2048) != 0 ? currentState.needSendSms : false, (32511 & 4096) != 0 ? currentState.smsSent : false, (32511 & 8192) != 0 ? currentState.smsTimer : null, (32511 & 16384) != 0 ? currentState.smsSendRestricted : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy, this, null), 3, null);
        getState().setValue(callCodeViewStateCopy);
    }

    public final void handleCodeNew(String code, final String prettyPhone, final String countryCode, String phone) {
        final LoginState.Session session;
        List<LoginState.Session> sessions;
        Object next;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(prettyPhone, "prettyPhone");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        CallCodeViewState currentState = getCurrentState();
        CallCodeViewState callCodeViewStateCopy = currentState.copy((32511 & 1) != 0 ? currentState.handleCodeServerState : Resource.Status.LOADING, (32511 & 2) != 0 ? currentState.phone : null, (32511 & 4) != 0 ? currentState.code : code, (32511 & 8) != 0 ? currentState.isLoaded : null, (32511 & 16) != 0 ? currentState.confirmationType : null, (32511 & 32) != 0 ? currentState.jwt : null, (32511 & 64) != 0 ? currentState.state : null, (32511 & 128) != 0 ? currentState.app : null, (32511 & 256) != 0 ? currentState.error : null, (32511 & 512) != 0 ? currentState.parsedError : null, (32511 & 1024) != 0 ? currentState.count : 0, (32511 & 2048) != 0 ? currentState.needSendSms : false, (32511 & 4096) != 0 ? currentState.smsSent : false, (32511 & 8192) != 0 ? currentState.smsTimer : null, (32511 & 16384) != 0 ? currentState.smsSendRestricted : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy, this, null), 3, null);
        getState().setValue(callCodeViewStateCopy);
        LoginState loginState = this.prefManager.getLoginState();
        if (loginState == null || (sessions = loginState.getSessions()) == null) {
            session = null;
        } else {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringsKt.replace$default(session2.getCountryCode(), "+", "", false, 4, (Object) null) + StringUtilsKt.toPhoneHash(session2.getPhone()), phone != null ? StringUtilsKt.toPhoneHash(phone) : null)) {
                    break;
                }
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getPhone()), phone != null ? StringUtilsKt.toPhoneHash(phone) : null)) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        }
        subscribeOnDataSource(confirmRegistration(session != null ? session.getRequestId() : null, code, this.config.getPlatformKeyName(), getCurrentState().getApp(), phone), new Function2<Resource<? extends DomainConfirmResponse>, CallCodeViewState, CallCodeViewState>() { // from class: com.sputnik.common.viewmodels.CallCodeViewModel.handleCodeNew.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallCodeViewState invoke(Resource<? extends DomainConfirmResponse> resource, CallCodeViewState callCodeViewState) {
                return invoke2((Resource<DomainConfirmResponse>) resource, callCodeViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallCodeViewState invoke2(Resource<DomainConfirmResponse> codeResponse, CallCodeViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(codeResponse, "codeResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                LoginState.Session session3 = session;
                CallCodeViewModel callCodeViewModel = this;
                String str = prettyPhone;
                String str2 = countryCode;
                if (codeResponse.getStatus() == Resource.Status.LOADING) {
                    return null;
                }
                Resource.Status status = codeResponse.getStatus();
                Resource.Status status2 = Resource.Status.ERROR;
                if (status != status2) {
                    callCodeViewModel.prefManager.updateIsLoggedIn(true);
                    PrefManager prefManager = callCodeViewModel.prefManager;
                    DomainConfirmResponse data = codeResponse.getData();
                    Intrinsics.checkNotNull(data);
                    String jwt = data.getJwt();
                    Intrinsics.checkNotNull(jwt);
                    prefManager.updateJwtToken(jwt);
                    String strReplace$default = StringsKt.replace$default(str, str2, "", false, 4, (Object) null);
                    DomainConfirmResponse data2 = codeResponse.getData();
                    Intrinsics.checkNotNull(data2);
                    String jwt2 = data2.getJwt();
                    Intrinsics.checkNotNull(jwt2);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Boolean bool = Boolean.TRUE;
                    callCodeViewModel.saveSession(new LoginState.Session((String) null, str2, strReplace$default, jwt2, bool, (String) null, (ProfileSettings) null, Boolean.FALSE, (String) null, (RegistrationWay) null, Long.valueOf(jCurrentTimeMillis), (String) null, (String) null, (String) null, bool, (Boolean) null, (Boolean) null, (List) null, 241664, (DefaultConstructorMarker) null));
                    PrefManager prefManager2 = callCodeViewModel.prefManager;
                    LoginState loginState2 = callCodeViewModel.prefManager.getLoginState();
                    loginState2.setSmsCodeExpiresAt(0L);
                    loginState2.setPhone("");
                    prefManager2.setLoginState(loginState2);
                    Resource.Status status3 = Resource.Status.SUCCESS;
                    DomainConfirmResponse data3 = codeResponse.getData();
                    Intrinsics.checkNotNull(data3);
                    String jwt3 = data3.getJwt();
                    DomainConfirmResponse data4 = codeResponse.getData();
                    Intrinsics.checkNotNull(data4);
                    return state.copy((32511 & 1) != 0 ? state.handleCodeServerState : status3, (32511 & 2) != 0 ? state.phone : null, (32511 & 4) != 0 ? state.code : null, (32511 & 8) != 0 ? state.isLoaded : new Event(bool), (32511 & 16) != 0 ? state.confirmationType : null, (32511 & 32) != 0 ? state.jwt : jwt3, (32511 & 64) != 0 ? state.state : data4.getCitizenState(), (32511 & 128) != 0 ? state.app : null, (32511 & 256) != 0 ? state.error : null, (32511 & 512) != 0 ? state.parsedError : null, (32511 & 1024) != 0 ? state.count : 0, (32511 & 2048) != 0 ? state.needSendSms : false, (32511 & 4096) != 0 ? state.smsSent : false, (32511 & 8192) != 0 ? state.smsTimer : null, (32511 & 16384) != 0 ? state.smsSendRestricted : false);
                }
                DomainEmpty errorMsg = codeResponse.getErrorMsg();
                if (errorMsg != null) {
                    Integer code2 = errorMsg.getCode();
                    int attemps_exceeded = ErrorCodes.INSTANCE.getATTEMPS_EXCEEDED();
                    if (code2 != null && code2.intValue() == attemps_exceeded && session3 != null) {
                        callCodeViewModel.deleteSession(session3);
                    }
                }
                DomainEmpty errorMsg2 = codeResponse.getErrorMsg();
                if (errorMsg2 != null && (message = errorMsg2.getMessage()) != null) {
                    callCodeViewModel.notifyErrorMessage(message);
                }
                Exception error = codeResponse.getError();
                Intrinsics.checkNotNull(error);
                return state.copy((32511 & 1) != 0 ? state.handleCodeServerState : status2, (32511 & 2) != 0 ? state.phone : null, (32511 & 4) != 0 ? state.code : null, (32511 & 8) != 0 ? state.isLoaded : null, (32511 & 16) != 0 ? state.confirmationType : null, (32511 & 32) != 0 ? state.jwt : null, (32511 & 64) != 0 ? state.state : null, (32511 & 128) != 0 ? state.app : null, (32511 & 256) != 0 ? state.error : error, (32511 & 512) != 0 ? state.parsedError : codeResponse.getErrorMsg(), (32511 & 1024) != 0 ? state.count : 0, (32511 & 2048) != 0 ? state.needSendSms : false, (32511 & 4096) != 0 ? state.smsSent : false, (32511 & 8192) != 0 ? state.smsTimer : null, (32511 & 16384) != 0 ? state.smsSendRestricted : false);
            }
        });
    }

    public final void startCountDown(int seconds) {
        if (this.countDownJob == null) {
            this.countDownJob = startCountDownJob(seconds);
        }
    }

    public final void startCountDownNew(String phone) {
        LoginState.Session session;
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
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), StringUtilsKt.toPhoneHash(String.valueOf(phone)))) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        if (this.countDownTimer == null) {
            if ((session != null ? session.getCodeExpiresAt() : null) == null) {
                CallCodeViewState currentState = getCurrentState();
                CallCodeViewState callCodeViewStateCopy = currentState.copy((32511 & 1) != 0 ? currentState.handleCodeServerState : null, (32511 & 2) != 0 ? currentState.phone : null, (32511 & 4) != 0 ? currentState.code : null, (32511 & 8) != 0 ? currentState.isLoaded : null, (32511 & 16) != 0 ? currentState.confirmationType : null, (32511 & 32) != 0 ? currentState.jwt : null, (32511 & 64) != 0 ? currentState.state : null, (32511 & 128) != 0 ? currentState.app : null, (32511 & 256) != 0 ? currentState.error : null, (32511 & 512) != 0 ? currentState.parsedError : null, (32511 & 1024) != 0 ? currentState.count : 0, (32511 & 2048) != 0 ? currentState.needSendSms : false, (32511 & 4096) != 0 ? currentState.smsSent : false, (32511 & 8192) != 0 ? currentState.smsTimer : "Лимит запросов кода исчерпан", (32511 & 16384) != 0 ? currentState.smsSendRestricted : true);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy, this, null), 3, null);
                getState().setValue(callCodeViewStateCopy);
                return;
            }
            Long codeExpiresAt = session != null ? session.getCodeExpiresAt() : null;
            Intrinsics.checkNotNull(codeExpiresAt);
            long jLongValue = codeExpiresAt.longValue() - System.currentTimeMillis();
            if (jLongValue <= 0) {
                CallCodeViewState currentState2 = getCurrentState();
                CallCodeViewState callCodeViewStateCopy2 = currentState2.copy((32511 & 1) != 0 ? currentState2.handleCodeServerState : null, (32511 & 2) != 0 ? currentState2.phone : null, (32511 & 4) != 0 ? currentState2.code : null, (32511 & 8) != 0 ? currentState2.isLoaded : null, (32511 & 16) != 0 ? currentState2.confirmationType : null, (32511 & 32) != 0 ? currentState2.jwt : null, (32511 & 64) != 0 ? currentState2.state : null, (32511 & 128) != 0 ? currentState2.app : null, (32511 & 256) != 0 ? currentState2.error : null, (32511 & 512) != 0 ? currentState2.parsedError : null, (32511 & 1024) != 0 ? currentState2.count : 0, (32511 & 2048) != 0 ? currentState2.needSendSms : true, (32511 & 4096) != 0 ? currentState2.smsSent : false, (32511 & 8192) != 0 ? currentState2.smsTimer : null, (32511 & 16384) != 0 ? currentState2.smsSendRestricted : false);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy2, this, null), 3, null);
                getState().setValue(callCodeViewStateCopy2);
                return;
            }
            try {
                CountDownTimer countDownTimer = this.countDownTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.countDownTimer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(jLongValue) { // from class: com.sputnik.common.viewmodels.CallCodeViewModel.startCountDownNew.3
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    if (millisUntilFinished > 1000) {
                        CallCodeViewModel callCodeViewModel = this;
                        CallCodeViewState currentState3 = callCodeViewModel.getCurrentState();
                        CallCodeViewState callCodeViewStateCopy3 = currentState3.copy((32511 & 1) != 0 ? currentState3.handleCodeServerState : null, (32511 & 2) != 0 ? currentState3.phone : null, (32511 & 4) != 0 ? currentState3.code : null, (32511 & 8) != 0 ? currentState3.isLoaded : null, (32511 & 16) != 0 ? currentState3.confirmationType : null, (32511 & 32) != 0 ? currentState3.jwt : null, (32511 & 64) != 0 ? currentState3.state : null, (32511 & 128) != 0 ? currentState3.app : null, (32511 & 256) != 0 ? currentState3.error : null, (32511 & 512) != 0 ? currentState3.parsedError : null, (32511 & 1024) != 0 ? currentState3.count : 0, (32511 & 2048) != 0 ? currentState3.needSendSms : false, (32511 & 4096) != 0 ? currentState3.smsSent : false, (32511 & 8192) != 0 ? currentState3.smsTimer : DateUtilsKt.toTime(millisUntilFinished), (32511 & 16384) != 0 ? currentState3.smsSendRestricted : false);
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(callCodeViewModel), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy3, callCodeViewModel, null), 3, null);
                        callCodeViewModel.getState().setValue(callCodeViewStateCopy3);
                        return;
                    }
                    CallCodeViewModel callCodeViewModel2 = this;
                    CallCodeViewState currentState4 = callCodeViewModel2.getCurrentState();
                    CallCodeViewState callCodeViewStateCopy4 = currentState4.copy((32511 & 1) != 0 ? currentState4.handleCodeServerState : null, (32511 & 2) != 0 ? currentState4.phone : null, (32511 & 4) != 0 ? currentState4.code : null, (32511 & 8) != 0 ? currentState4.isLoaded : null, (32511 & 16) != 0 ? currentState4.confirmationType : null, (32511 & 32) != 0 ? currentState4.jwt : null, (32511 & 64) != 0 ? currentState4.state : null, (32511 & 128) != 0 ? currentState4.app : null, (32511 & 256) != 0 ? currentState4.error : null, (32511 & 512) != 0 ? currentState4.parsedError : null, (32511 & 1024) != 0 ? currentState4.count : 0, (32511 & 2048) != 0 ? currentState4.needSendSms : true, (32511 & 4096) != 0 ? currentState4.smsSent : false, (32511 & 8192) != 0 ? currentState4.smsTimer : "", (32511 & 16384) != 0 ? currentState4.smsSendRestricted : false);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(callCodeViewModel2), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy4, callCodeViewModel2, null), 3, null);
                    callCodeViewModel2.getState().setValue(callCodeViewStateCopy4);
                    this.countDownTimer = null;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    CallCodeViewModel callCodeViewModel = this;
                    CallCodeViewState currentState3 = callCodeViewModel.getCurrentState();
                    CallCodeViewState callCodeViewStateCopy3 = currentState3.copy((32511 & 1) != 0 ? currentState3.handleCodeServerState : null, (32511 & 2) != 0 ? currentState3.phone : null, (32511 & 4) != 0 ? currentState3.code : null, (32511 & 8) != 0 ? currentState3.isLoaded : null, (32511 & 16) != 0 ? currentState3.confirmationType : null, (32511 & 32) != 0 ? currentState3.jwt : null, (32511 & 64) != 0 ? currentState3.state : null, (32511 & 128) != 0 ? currentState3.app : null, (32511 & 256) != 0 ? currentState3.error : null, (32511 & 512) != 0 ? currentState3.parsedError : null, (32511 & 1024) != 0 ? currentState3.count : 0, (32511 & 2048) != 0 ? currentState3.needSendSms : true, (32511 & 4096) != 0 ? currentState3.smsSent : false, (32511 & 8192) != 0 ? currentState3.smsTimer : null, (32511 & 16384) != 0 ? currentState3.smsSendRestricted : false);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(callCodeViewModel), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy3, callCodeViewModel, null), 3, null);
                    callCodeViewModel.getState().setValue(callCodeViewStateCopy3);
                }
            };
            this.countDownTimer = countDownTimer2;
            countDownTimer2.start();
        }
    }

    public final LiveData<Resource<DomainRequestInfo>> getRequestInfo(String requestId, String phone) {
        return FlowLiveDataConversions.asLiveData$default(this.getRequestUseCase.invoke(requestId, phone), null, 0L, 3, null);
    }

    public final LiveData<Resource<DomainConfirmResponse>> confirmRegistration(String requestId, String authCode, String platform, String app, String phone) {
        return FlowLiveDataConversions.asLiveData$default(this.confirmRegistrationUseCase.invoke(requestId, authCode, platform, app, phone), null, 0L, 3, null);
    }

    /* compiled from: CallCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.CallCodeViewModel$startHandlingRequest$1", f = "CallCodeViewModel.kt", l = {306}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.CallCodeViewModel$startHandlingRequest$1, reason: invalid class name and case insensitive filesystem */
    static final class C06441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        final /* synthetic */ String $countryCode;
        final /* synthetic */ String $phone;
        final /* synthetic */ String $requestId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06441(String str, String str2, String str3, String str4, Continuation<? super C06441> continuation) {
            super(2, continuation);
            this.$requestId = str;
            this.$phone = str2;
            this.$code = str3;
            this.$countryCode = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CallCodeViewModel.this.new C06441(this.$requestId, this.$phone, this.$code, this.$countryCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$BooleanRef ref$BooleanRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                ref$BooleanRef2.element = true;
                ref$BooleanRef = ref$BooleanRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$BooleanRef = (Ref$BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (ref$BooleanRef.element) {
                CallCodeViewModel callCodeViewModel = CallCodeViewModel.this;
                LiveData<Resource<DomainRequestInfo>> requestInfo = callCodeViewModel.getRequestInfo(this.$requestId, this.$phone);
                final CallCodeViewModel callCodeViewModel2 = CallCodeViewModel.this;
                final String str = this.$requestId;
                final String str2 = this.$code;
                final String str3 = this.$phone;
                final String str4 = this.$countryCode;
                final Ref$BooleanRef ref$BooleanRef3 = ref$BooleanRef;
                callCodeViewModel.subscribeOnDataSource(requestInfo, new Function2<Resource<? extends DomainRequestInfo>, CallCodeViewState, CallCodeViewState>() { // from class: com.sputnik.common.viewmodels.CallCodeViewModel.startHandlingRequest.1.1

                    /* compiled from: CallCodeViewModel.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    /* renamed from: com.sputnik.common.viewmodels.CallCodeViewModel$startHandlingRequest$1$1$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[RegistrationState.values().length];
                            try {
                                iArr[RegistrationState.waiting.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[RegistrationState.approved.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ CallCodeViewState invoke(Resource<? extends DomainRequestInfo> resource, CallCodeViewState callCodeViewState) {
                        return invoke2((Resource<DomainRequestInfo>) resource, callCodeViewState);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final CallCodeViewState invoke2(Resource<DomainRequestInfo> res, CallCodeViewState state) {
                        LoginState.Session session;
                        String message;
                        DomainEmpty errorMsg;
                        Object next;
                        Intrinsics.checkNotNullParameter(res, "res");
                        Intrinsics.checkNotNullParameter(state, "state");
                        CallCodeViewModel callCodeViewModel3 = callCodeViewModel2;
                        String str5 = str;
                        String str6 = str2;
                        String str7 = str3;
                        String str8 = str4;
                        Ref$BooleanRef ref$BooleanRef4 = ref$BooleanRef3;
                        unit = null;
                        Unit unit = null;
                        if (res.getStatus() == Resource.Status.LOADING) {
                            return null;
                        }
                        if (res.getStatus() == Resource.Status.ERROR) {
                            List<LoginState.Session> sessions = callCodeViewModel3.prefManager.getLoginState().getSessions();
                            if (sessions != null) {
                                Iterator<T> it = sessions.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                    LoginState.Session session2 = (LoginState.Session) next;
                                    if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), StringUtilsKt.toPhoneHash(String.valueOf(str7)))) {
                                        break;
                                    }
                                }
                                session = (LoginState.Session) next;
                            } else {
                                session = null;
                            }
                            if (session != null && (errorMsg = res.getErrorMsg()) != null) {
                                Integer code = errorMsg.getCode();
                                int session_expired = ErrorCodes.INSTANCE.getSESSION_EXPIRED();
                                if (code != null && code.intValue() == session_expired) {
                                    callCodeViewModel3.deleteSession(session);
                                }
                            }
                            DomainEmpty errorMsg2 = res.getErrorMsg();
                            if (errorMsg2 != null && (message = errorMsg2.getMessage()) != null) {
                                callCodeViewModel3.notifyErrorMessage(message);
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                Exception error = res.getError();
                                Intrinsics.checkNotNull(error);
                                callCodeViewModel3.notifySimpleError(error);
                            }
                            Exception error2 = res.getError();
                            Intrinsics.checkNotNull(error2);
                            return state.copy((32511 & 1) != 0 ? state.handleCodeServerState : null, (32511 & 2) != 0 ? state.phone : null, (32511 & 4) != 0 ? state.code : null, (32511 & 8) != 0 ? state.isLoaded : null, (32511 & 16) != 0 ? state.confirmationType : null, (32511 & 32) != 0 ? state.jwt : null, (32511 & 64) != 0 ? state.state : null, (32511 & 128) != 0 ? state.app : null, (32511 & 256) != 0 ? state.error : error2, (32511 & 512) != 0 ? state.parsedError : res.getErrorMsg(), (32511 & 1024) != 0 ? state.count : 0, (32511 & 2048) != 0 ? state.needSendSms : false, (32511 & 4096) != 0 ? state.smsSent : false, (32511 & 8192) != 0 ? state.smsTimer : null, (32511 & 16384) != 0 ? state.smsSendRestricted : false);
                        }
                        DomainRequestInfo data = res.getData();
                        RegistrationState state2 = data != null ? data.getState() : null;
                        if ((state2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state2.ordinal()]) == 2) {
                            callCodeViewModel3.stopJob();
                            callCodeViewModel3.confirmRegistrationOnServer(str5, str6, callCodeViewModel3.config.getPlatformKeyName(), callCodeViewModel3.getCurrentState().getApp(), str7, str8);
                            ref$BooleanRef4.element = false;
                            return callCodeViewModel3.getCurrentState();
                        }
                        return callCodeViewModel2.getCurrentState();
                    }
                });
                this.L$0 = ref$BooleanRef;
                this.label = 1;
                if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final Job startHandlingRequest(String requestId, String code, String phone, String countryCode) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06441(requestId, phone, code, countryCode, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmRegistrationOnServer(String requestId, String authCode, String platform, String app, final String phone, final String countryCode) {
        subscribeOnDataSource(confirmRegistration(requestId, authCode, this.config.getPlatformKeyName(), getCurrentState().getApp(), phone), new Function2<Resource<? extends DomainConfirmResponse>, CallCodeViewState, CallCodeViewState>() { // from class: com.sputnik.common.viewmodels.CallCodeViewModel.confirmRegistrationOnServer.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallCodeViewState invoke(Resource<? extends DomainConfirmResponse> resource, CallCodeViewState callCodeViewState) {
                return invoke2((Resource<DomainConfirmResponse>) resource, callCodeViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallCodeViewState invoke2(Resource<DomainConfirmResponse> res, CallCodeViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(res, "res");
                Intrinsics.checkNotNullParameter(state, "state");
                CallCodeViewModel callCodeViewModel = CallCodeViewModel.this;
                String str = phone;
                String str2 = countryCode;
                Unit unit = null;
                if (res.getStatus() == Resource.Status.LOADING) {
                    return null;
                }
                if (res.getStatus() != Resource.Status.ERROR) {
                    PrefManager prefManager = callCodeViewModel.prefManager;
                    DomainConfirmResponse data = res.getData();
                    Intrinsics.checkNotNull(data);
                    String jwt = data.getJwt();
                    Intrinsics.checkNotNull(jwt);
                    prefManager.updateJwtToken(jwt);
                    callCodeViewModel.prefManager.updateIsLoggedIn(true);
                    String strValueOf = String.valueOf(str);
                    DomainConfirmResponse data2 = res.getData();
                    Intrinsics.checkNotNull(data2);
                    String jwt2 = data2.getJwt();
                    Intrinsics.checkNotNull(jwt2);
                    String strValueOf2 = String.valueOf(str2);
                    Boolean bool = Boolean.TRUE;
                    callCodeViewModel.saveSession(new LoginState.Session((String) null, strValueOf2, strValueOf, jwt2, bool, (String) null, (ProfileSettings) null, Boolean.FALSE, (String) null, (RegistrationWay) null, (Long) null, (String) null, (String) null, (String) null, bool, (Boolean) null, (Boolean) null, (List) null, 241664, (DefaultConstructorMarker) null));
                    PrefManager prefManager2 = callCodeViewModel.prefManager;
                    LoginState loginState = callCodeViewModel.prefManager.getLoginState();
                    loginState.setSmsCodeExpiresAt(0L);
                    loginState.setPhone("");
                    prefManager2.setLoginState(loginState);
                    DomainConfirmResponse data3 = res.getData();
                    Intrinsics.checkNotNull(data3);
                    String jwt3 = data3.getJwt();
                    DomainConfirmResponse data4 = res.getData();
                    Intrinsics.checkNotNull(data4);
                    return state.copy((32511 & 1) != 0 ? state.handleCodeServerState : null, (32511 & 2) != 0 ? state.phone : null, (32511 & 4) != 0 ? state.code : null, (32511 & 8) != 0 ? state.isLoaded : new Event(bool), (32511 & 16) != 0 ? state.confirmationType : null, (32511 & 32) != 0 ? state.jwt : jwt3, (32511 & 64) != 0 ? state.state : data4.getCitizenState(), (32511 & 128) != 0 ? state.app : null, (32511 & 256) != 0 ? state.error : null, (32511 & 512) != 0 ? state.parsedError : null, (32511 & 1024) != 0 ? state.count : 0, (32511 & 2048) != 0 ? state.needSendSms : false, (32511 & 4096) != 0 ? state.smsSent : false, (32511 & 8192) != 0 ? state.smsTimer : null, (32511 & 16384) != 0 ? state.smsSendRestricted : false);
                }
                DomainEmpty errorMsg = res.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    callCodeViewModel.notifyErrorMessage(message);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    Exception error = res.getError();
                    Intrinsics.checkNotNull(error);
                    callCodeViewModel.notifySimpleError(error);
                }
                Exception error2 = res.getError();
                Intrinsics.checkNotNull(error2);
                return state.copy((32511 & 1) != 0 ? state.handleCodeServerState : null, (32511 & 2) != 0 ? state.phone : null, (32511 & 4) != 0 ? state.code : null, (32511 & 8) != 0 ? state.isLoaded : null, (32511 & 16) != 0 ? state.confirmationType : null, (32511 & 32) != 0 ? state.jwt : null, (32511 & 64) != 0 ? state.state : null, (32511 & 128) != 0 ? state.app : null, (32511 & 256) != 0 ? state.error : error2, (32511 & 512) != 0 ? state.parsedError : null, (32511 & 1024) != 0 ? state.count : 0, (32511 & 2048) != 0 ? state.needSendSms : false, (32511 & 4096) != 0 ? state.smsSent : false, (32511 & 8192) != 0 ? state.smsTimer : null, (32511 & 16384) != 0 ? state.smsSendRestricted : false);
            }
        });
    }

    public final void startProfileJob(String requestId, String code, String phone, String countryCode) {
        if (this.handleCodeJob == null) {
            this.handleCodeJob = startHandlingRequest(requestId, code, phone, countryCode);
        }
    }

    public final void stopJob() {
        Job job = this.handleCodeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.handleCodeJob = null;
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
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((LoginState.Session) next).getPhone(), session.getPhone())) {
                    break;
                }
            }
        }
        LoginState.Session session2 = (LoginState.Session) next;
        if (session2 == null) {
            String name = session.getName();
            String strReplace$default = StringsKt.replace$default(session.getPhone(), session.getCountryCode(), "", false, 4, (Object) null);
            String jwt = session.getJwt();
            LoginState.Session session3 = new LoginState.Session(name, session.getCountryCode(), strReplace$default, jwt, Boolean.TRUE, (String) null, (ProfileSettings) null, Boolean.FALSE, (String) null, (RegistrationWay) null, (Long) null, session.getRequestId(), (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (List) null, 258048, (DefaultConstructorMarker) null);
            List<LoginState.Session> sessions2 = loginState.getSessions();
            if (sessions2 != null) {
                sessions2.add(session3);
            }
        } else {
            String name2 = session.getName();
            if (name2 == null) {
                name2 = session2.getName();
            }
            session2.setName(name2);
            String jwt2 = session.getJwt();
            if (jwt2 == null) {
                jwt2 = session2.getJwt();
            }
            session2.setJwt(jwt2);
            int iIndexOf = sessions.indexOf(session2);
            try {
                List<LoginState.Session> sessions3 = loginState.getSessions();
                Intrinsics.checkNotNull(sessions3);
                sessions3.set(iIndexOf, session2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.prefManager.setLoginState(loginState);
    }

    public final void deleteSession(LoginState.Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        LoginState loginState = this.prefManager.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            sessions.remove(session);
        }
        this.prefManager.setLoginState(loginState);
    }

    public final void clearTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        CallCodeViewState currentState = getCurrentState();
        CallCodeViewState callCodeViewStateCopy = currentState.copy((32511 & 1) != 0 ? currentState.handleCodeServerState : null, (32511 & 2) != 0 ? currentState.phone : null, (32511 & 4) != 0 ? currentState.code : null, (32511 & 8) != 0 ? currentState.isLoaded : null, (32511 & 16) != 0 ? currentState.confirmationType : null, (32511 & 32) != 0 ? currentState.jwt : null, (32511 & 64) != 0 ? currentState.state : null, (32511 & 128) != 0 ? currentState.app : null, (32511 & 256) != 0 ? currentState.error : null, (32511 & 512) != 0 ? currentState.parsedError : null, (32511 & 1024) != 0 ? currentState.count : 0, (32511 & 2048) != 0 ? currentState.needSendSms : false, (32511 & 4096) != 0 ? currentState.smsSent : false, (32511 & 8192) != 0 ? currentState.smsTimer : null, (32511 & 16384) != 0 ? currentState.smsSendRestricted : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(callCodeViewStateCopy, this, null), 3, null);
        getState().setValue(callCodeViewStateCopy);
    }

    @Override // com.sputnik.common.base.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        clearTimer();
    }
}
