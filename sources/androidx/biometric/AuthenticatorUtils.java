package androidx.biometric;

import android.os.Build;
import androidx.biometric.BiometricPrompt;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* loaded from: classes.dex */
class AuthenticatorUtils {
    static boolean isDeviceCredentialAllowed(int i) {
        return (i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0;
    }

    static boolean isSomeBiometricAllowed(int i) {
        return (i & 32767) != 0;
    }

    static boolean isWeakBiometricAllowed(int i) {
        return (i & KotlinVersion.MAX_COMPONENT_VALUE) == 255;
    }

    static String convertToString(int i) {
        if (i == 15) {
            return "BIOMETRIC_STRONG";
        }
        if (i == 255) {
            return "BIOMETRIC_WEAK";
        }
        if (i == 32768) {
            return "DEVICE_CREDENTIAL";
        }
        if (i == 32783) {
            return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
        }
        if (i == 33023) {
            return "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
        }
        return String.valueOf(i);
    }

    static int getConsolidatedAuthenticators(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.CryptoObject cryptoObject) {
        if (promptInfo.getAllowedAuthenticators() != 0) {
            return promptInfo.getAllowedAuthenticators();
        }
        int i = cryptoObject != null ? 15 : KotlinVersion.MAX_COMPONENT_VALUE;
        return promptInfo.isDeviceCredentialAllowed() ? 32768 | i : i;
    }

    static boolean isSupportedCombination(int i) {
        if (i == 15 || i == 255) {
            return true;
        }
        if (i == 32768) {
            return Build.VERSION.SDK_INT >= 30;
        }
        if (i != 32783) {
            return i == 33023 || i == 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 28 || i2 > 29;
    }
}
