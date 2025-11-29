package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BiometricManager {
    private final android.hardware.biometrics.BiometricManager mBiometricManager;
    private final FingerprintManagerCompat mFingerprintManager;
    private final Injector mInjector;

    interface Injector {
        android.hardware.biometrics.BiometricManager getBiometricManager();

        FingerprintManagerCompat getFingerprintManager();

        boolean isDeviceSecurable();

        boolean isDeviceSecuredWithCredential();

        boolean isFingerprintHardwarePresent();

        boolean isStrongBiometricGuaranteed();
    }

    private static class DefaultInjector implements Injector {
        private final Context mContext;

        DefaultInjector(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public android.hardware.biometrics.BiometricManager getBiometricManager() {
            return Api29Impl.create(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public FingerprintManagerCompat getFingerprintManager() {
            return FingerprintManagerCompat.from(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecurable() {
            return KeyguardUtils.getKeyguardManager(this.mContext) != null;
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecuredWithCredential() {
            return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFingerprintHardwarePresent() {
            return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isStrongBiometricGuaranteed() {
            return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
        }
    }

    public static BiometricManager from(Context context) {
        return new BiometricManager(new DefaultInjector(context));
    }

    BiometricManager(Injector injector) {
        this.mInjector = injector;
        int i = Build.VERSION.SDK_INT;
        this.mBiometricManager = i >= 29 ? injector.getBiometricManager() : null;
        this.mFingerprintManager = i <= 29 ? injector.getFingerprintManager() : null;
    }

    public int canAuthenticate(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
            if (biometricManager == null) {
                Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
                return 1;
            }
            return Api30Impl.canAuthenticate(biometricManager, i);
        }
        return canAuthenticateCompat(i);
    }

    private int canAuthenticateCompat(int i) {
        if (!AuthenticatorUtils.isSupportedCombination(i)) {
            return -2;
        }
        if (i == 0 || !this.mInjector.isDeviceSecurable()) {
            return 12;
        }
        if (AuthenticatorUtils.isDeviceCredentialAllowed(i)) {
            return this.mInjector.isDeviceSecuredWithCredential() ? 0 : 11;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 29) {
            if (AuthenticatorUtils.isWeakBiometricAllowed(i)) {
                return canAuthenticateWithWeakBiometricOnApi29();
            }
            return canAuthenticateWithStrongBiometricOnApi29();
        }
        if (i2 == 28) {
            if (this.mInjector.isFingerprintHardwarePresent()) {
                return canAuthenticateWithFingerprintOrUnknownBiometric();
            }
            return 12;
        }
        return canAuthenticateWithFingerprint();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int canAuthenticateWithStrongBiometricOnApi29() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            java.lang.String r0 = "BiometricManager"
            java.lang.reflect.Method r1 = androidx.biometric.BiometricManager.Api29Impl.getCanAuthenticateWithCryptoMethod()
            if (r1 == 0) goto L38
            androidx.biometric.BiometricPrompt$CryptoObject r2 = androidx.biometric.CryptoObjectUtils.createFakeCryptoObject()
            android.hardware.biometrics.BiometricPrompt$CryptoObject r2 = androidx.biometric.CryptoObjectUtils.wrapForBiometricPrompt(r2)
            if (r2 == 0) goto L38
            android.hardware.biometrics.BiometricManager r3 = r4.mBiometricManager     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            if (r2 == 0) goto L2d
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            int r0 = r1.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            return r0
        L27:
            r1 = move-exception
            goto L33
        L29:
            r1 = move-exception
            goto L33
        L2b:
            r1 = move-exception
            goto L33
        L2d:
            java.lang.String r1 = "Invalid return type for canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            goto L38
        L33:
            java.lang.String r2 = "Failed to invoke canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r2, r1)
        L38:
            int r0 = r4.canAuthenticateWithWeakBiometricOnApi29()
            androidx.biometric.BiometricManager$Injector r1 = r4.mInjector
            boolean r1 = r1.isStrongBiometricGuaranteed()
            if (r1 != 0) goto L4b
            if (r0 == 0) goto L47
            goto L4b
        L47:
            int r0 = r4.canAuthenticateWithFingerprintOrUnknownBiometric()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.BiometricManager.canAuthenticateWithStrongBiometricOnApi29():int");
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
        if (biometricManager == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
            return 1;
        }
        return Api29Impl.canAuthenticate(biometricManager);
    }

    private int canAuthenticateWithFingerprintOrUnknownBiometric() {
        if (this.mInjector.isDeviceSecuredWithCredential()) {
            return canAuthenticateWithFingerprint() == 0 ? 0 : -1;
        }
        return canAuthenticateWithFingerprint();
    }

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat fingerprintManagerCompat = this.mFingerprintManager;
        if (fingerprintManagerCompat == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        }
        if (fingerprintManagerCompat.isHardwareDetected()) {
            return !this.mFingerprintManager.hasEnrolledFingerprints() ? 11 : 0;
        }
        return 12;
    }

    private static class Api30Impl {
        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager, int i) {
            return biometricManager.canAuthenticate(i);
        }
    }

    private static class Api29Impl {
        static android.hardware.biometrics.BiometricManager create(Context context) {
            return (android.hardware.biometrics.BiometricManager) context.getSystemService(android.hardware.biometrics.BiometricManager.class);
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        static Method getCanAuthenticateWithCryptoMethod() {
            try {
                return android.hardware.biometrics.BiometricManager.class.getMethod("canAuthenticate", BiometricPrompt.CryptoObject.class);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }
}
