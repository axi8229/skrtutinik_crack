package npi.spay;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Fi implements InterfaceC1943tg {
    public final Context a;
    public SharedPreferences b;
    public int c;

    public Fi(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.a = applicationContext;
    }

    @Override // npi.spay.InterfaceC1943tg
    public final SharedPreferences a() {
        return this.b;
    }

    public final MasterKey b() throws GeneralSecurityException, IOException {
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(false).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "Builder(\n            Mas…lse)\n            .build()");
        MasterKey masterKeyBuild = new MasterKey.Builder(this.a).setKeyGenParameterSpec(keyGenParameterSpecBuild).build();
        Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "Builder(applicationConte…pec)\n            .build()");
        return masterKeyBuild;
    }

    public final void d() {
        Object objM2628constructorimpl;
        this.c++;
        Timber.INSTANCE.i("ENCRYPT_SP count of try : " + this.c, new Object[0]);
        Unit unit = null;
        if (10 == this.c) {
            this.b = null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(EncryptedSharedPreferences.create(this.a, "SPAY_ENCRYPTED_DATA", b(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2633isFailureimpl(objM2628constructorimpl)) {
            this.a.getSharedPreferences("SPAY_ENCRYPTED_DATA", 0).edit().clear().apply();
        }
        if (Result.m2633isFailureimpl(objM2628constructorimpl)) {
            objM2628constructorimpl = null;
        }
        SharedPreferences sharedPreferences = (SharedPreferences) objM2628constructorimpl;
        if (sharedPreferences != null) {
            this.b = sharedPreferences;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            d();
        }
    }

    @Override // npi.spay.InterfaceC1943tg
    public final Object a(String key, String str) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesA = a();
        if (sharedPreferencesA == null || (string = sharedPreferencesA.getString(key, str)) == null) {
            throw Q9.a;
        }
        return string;
    }

    @Override // npi.spay.InterfaceC1943tg
    /* renamed from: a, reason: collision with other method in class */
    public final void mo2849a(String str, String str2) {
        AbstractC1918sg.a(this, str, str2);
    }

    @Override // npi.spay.InterfaceC1943tg
    public final void a(String[] strArr) {
        AbstractC1918sg.a(this, strArr);
    }
}
