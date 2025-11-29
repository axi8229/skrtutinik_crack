package npi.spay;

import androidx.biometric.BiometricPrompt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import timber.log.Timber;

/* renamed from: npi.spay.vj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1996vj extends BiometricPrompt.AuthenticationCallback {
    public final /* synthetic */ CancellableContinuationImpl a;
    public final /* synthetic */ Ek b;

    public C1996vj(CancellableContinuationImpl cancellableContinuationImpl, Ek ek) {
        this.a = cancellableContinuationImpl;
        this.b = ek;
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public final void onAuthenticationError(int i, CharSequence errString) {
        Intrinsics.checkNotNullParameter(errString, "errString");
        super.onAuthenticationError(i, errString);
        String str = "Authentication error: " + ((Object) errString);
        CancellableContinuationImpl cancellableContinuationImpl = this.a;
        Mi mi = new Mi(1, str, false);
        Intrinsics.checkNotNullParameter(cancellableContinuationImpl, "<this>");
        if (cancellableContinuationImpl.isActive()) {
            cancellableContinuationImpl.resume(mi, null);
        }
        this.b.b.a(new C1560e6(K7.LC_FAIL_BIO_AUTH, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120));
        Timber.INSTANCE.e(str, new Object[0]);
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public final void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Ek ek = this.b;
        int i = ek.c + 1;
        ek.c = i;
        if (i >= 3) {
            CancellableContinuationImpl cancellableContinuationImpl = this.a;
            Mi mi = new Mi(1, "Authentication failed", false);
            Intrinsics.checkNotNullParameter(cancellableContinuationImpl, "<this>");
            if (cancellableContinuationImpl.isActive()) {
                cancellableContinuationImpl.resume(mi, null);
            }
        }
        this.b.b.a(new C1560e6(K7.LC_FAIL_BIO_AUTH, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120));
        Timber.INSTANCE.e("Authentication failed", new Object[0]);
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public final void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onAuthenticationSucceeded(result);
        ((Ec) this.b.a).d = true;
        CancellableContinuationImpl cancellableContinuationImpl = this.a;
        Mi mi = new Mi(3, null, true);
        Intrinsics.checkNotNullParameter(cancellableContinuationImpl, "<this>");
        if (cancellableContinuationImpl.isActive()) {
            cancellableContinuationImpl.resume(mi, null);
        }
        this.b.b.a(new C1560e6(K7.LC_GOOD_BIO_AUTH, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120));
    }
}
