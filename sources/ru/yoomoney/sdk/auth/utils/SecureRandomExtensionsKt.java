package ru.yoomoney.sdk.auth.utils;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"nextInt", "", "Ljava/security/SecureRandom;", RemoteMessageConst.FROM, "until", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecureRandomExtensionsKt {
    public static final int nextInt(SecureRandom secureRandom, int i, int i2) {
        Intrinsics.checkNotNullParameter(secureRandom, "<this>");
        if (i2 > i) {
            return secureRandom.nextInt(i2 - i) + i;
        }
        throw new IllegalArgumentException(new IllegalArgumentException("Random range is empty: [" + i + ", " + i2 + ").").toString());
    }
}
