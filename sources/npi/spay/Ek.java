package npi.spay;

import android.content.Context;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Executor;
import kotlin.KotlinVersion;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.RedirectActivity;

/* loaded from: classes4.dex */
public final class Ek implements InterfaceC1995vi {
    public final Qb a;
    public final C1955u3 b;
    public int c;

    public Ek(Qb authHandler, C1955u3 metricFacade) {
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        this.a = authHandler;
        this.b = metricFacade;
    }

    @Override // npi.spay.InterfaceC1995vi
    public final Object a(RedirectActivity redirectActivity, Ph ph, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Executor mainExecutor = ContextCompat.getMainExecutor(redirectActivity);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(activity)");
        BiometricPrompt biometricPrompt = new BiometricPrompt(redirectActivity, mainExecutor, new C1996vj(cancellableContinuationImpl, this));
        Context baseContext = redirectActivity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "activity.baseContext");
        BiometricPrompt.PromptInfo promptInfoBuild = new BiometricPrompt.PromptInfo.Builder().setTitle(baseContext.getString(R$string.spay_full_emission_biometric_title)).setSubtitle(baseContext.getString(R$string.spay_full_emission_biometric_subtitle)).setNegativeButtonText(baseContext.getString(R$string.spay_full_emission_biometric_negative)).setAllowedAuthenticators(KotlinVersion.MAX_COMPONENT_VALUE).build();
        Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "Builder()\n            .s…EAK)\n            .build()");
        biometricPrompt.authenticate(promptInfoBuild);
        this.b.a(new C1560e6(K7.LC_BIO_AUTH_START, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // npi.spay.InterfaceC1995vi
    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiometricManager.from(context).canAuthenticate(KotlinVersion.MAX_COMPONENT_VALUE) == 0;
    }
}
