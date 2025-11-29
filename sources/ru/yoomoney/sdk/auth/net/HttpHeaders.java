package ru.yoomoney.sdk.auth.net;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/net/HttpHeaders;", "", "()V", "ACCEPT_LANGUAGE", "", "AUTHORIZATION", CodePackage.LOCATION, "USER_AGENT", "X_APPLICATION_USER_AGENT", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpHeaders {
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String AUTHORIZATION = "Authorization";
    public static final HttpHeaders INSTANCE = new HttpHeaders();
    public static final String LOCATION = "Location";
    public static final String USER_AGENT = "User-Agent";
    public static final String X_APPLICATION_USER_AGENT = "X-Application-User-Agent";

    private HttpHeaders() {
    }
}
