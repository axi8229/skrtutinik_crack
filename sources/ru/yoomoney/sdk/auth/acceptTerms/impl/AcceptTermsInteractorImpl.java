package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractorImpl;", "Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;)V", "acceptTerms", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptTermsInteractorImpl implements AcceptTermsInteractor {
    private final EnrollmentRepository enrollmentRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractorImpl", f = "AcceptTermsInteractor.kt", l = {24, 29}, m = "acceptTerms")
    public static final class a extends ContinuationImpl {
        public AcceptTermsInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AcceptTermsInteractorImpl.this.acceptTerms(null, this);
        }
    }

    public AcceptTermsInteractorImpl(EnrollmentRepository enrollmentRepository) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        this.enrollmentRepository = enrollmentRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object acceptTerms(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractorImpl.acceptTerms(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
