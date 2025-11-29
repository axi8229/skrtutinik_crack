package ru.yoomoney.sdk.yoopinning;

import android.os.Build;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserAgent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/yoopinning/UserAgent;", "", "isTablet", "", "application", "", "platform", "(ZLjava/lang/String;Ljava/lang/String;)V", "deviceType", AppMeasurementSdk.ConditionalUserProperty.NAME, "getName", "()Ljava/lang/String;", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserAgent {
    private final String deviceType;
    private final String name;

    public UserAgent(boolean z, String application, String platform) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(platform, "platform");
        String str = z ? "Tablet" : "Phone";
        this.deviceType = str;
        String str2 = application + " " + platform + " " + str;
        if (UserAgentKt.agentNamePattern.matches(str2)) {
            this.name = str2;
            return;
        }
        throw new IllegalStateException(("Agent name must match the pattern: <application name>.<target platform>/<application version> <running platform>/<OS version> <device class>. For example: PinningSdk.Android/4.17.0200 Android/8.0 Phone but this look - " + str2).toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserAgent(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str = (i & 2) != 0 ? "PinningSdk.Android/1.5.0" : str;
        if ((i & 4) != 0) {
            str2 = "Android/" + Build.VERSION.RELEASE;
        }
        this(z, str, str2);
    }

    public final String getName() {
        return this.name;
    }
}
