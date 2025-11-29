package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.BiometricSuggestionModel;

/* loaded from: classes4.dex */
public final class U2 extends Z2 {
    public final BiometricSuggestionModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U2(BiometricSuggestionModel biometricSuggestionModel) {
        super(0);
        Intrinsics.checkNotNullParameter(biometricSuggestionModel, "biometricSuggestionModel");
        this.a = biometricSuggestionModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof U2) && Intrinsics.areEqual(this.a, ((U2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowBiometricSuggestionAlert(biometricSuggestionModel=" + this.a + ')';
    }
}
