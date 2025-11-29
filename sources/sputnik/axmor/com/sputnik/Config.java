package sputnik.axmor.com.sputnik;

import com.sputnik.data.IConfig;
import kotlin.Metadata;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Lsputnik/axmor/com/sputnik/Config;", "Lcom/sputnik/data/IConfig;", "<init>", "()V", "", "versionName", "Ljava/lang/String;", "getVersionName", "()Ljava/lang/String;", "", "versionCode", "I", "getVersionCode", "()I", "flavor", "getFlavor", "platformKeyName", "getPlatformKeyName", "", "isStage", "Z", "()Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Config implements IConfig {
    private final boolean isStage;
    private final String versionName = "6.24.3";
    private final int versionCode = pjsip_status_code.PJSIP_SC_USE_IDENTITY_HEADER;
    private final String flavor = "huawei";
    private final String platformKeyName = "hms";

    @Override // com.sputnik.data.IConfig
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.sputnik.data.IConfig
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.sputnik.data.IConfig
    public String getPlatformKeyName() {
        return this.platformKeyName;
    }

    @Override // com.sputnik.data.IConfig
    /* renamed from: isStage, reason: from getter */
    public boolean getIsStage() {
        return this.isStage;
    }
}
