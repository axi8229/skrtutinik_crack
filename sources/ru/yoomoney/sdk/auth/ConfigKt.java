package ru.yoomoney.sdk.auth;

import android.util.Base64;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.Origin;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"BASE_HOST_ENCODED_BASE64", "", "baseHost", "getBaseHost", "()Ljava/lang/String;", "baseHost$delegate", "Lkotlin/Lazy;", "toApiOrigin", "Lru/yoomoney/sdk/auth/api/Origin;", "Lru/yoomoney/sdk/auth/Config$Origin;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigKt {
    private static final String BASE_HOST_ENCODED_BASE64 = "eW9vbW9uZXkucnU=";
    private static final Lazy baseHost$delegate = LazyKt.lazy(a.a);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Config.Origin.values().length];
            try {
                iArr[Config.Origin.WALLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Config.Origin.CHECKOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Config.Origin.CORPORATE_BANKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            byte[] bArrDecode = Base64.decode(ConfigKt.BASE_HOST_ENCODED_BASE64, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            return new String(bArrDecode, Charsets.UTF_8);
        }
    }

    public static final String getBaseHost() {
        return (String) baseHost$delegate.getValue();
    }

    public static final Origin toApiOrigin(Config.Origin origin) {
        Intrinsics.checkNotNullParameter(origin, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[origin.ordinal()];
        if (i == 1) {
            return Origin.WALLET;
        }
        if (i == 2) {
            return Origin.CHECKOUT;
        }
        if (i == 3) {
            return Origin.CORPORATE_BANKING;
        }
        throw new NoWhenBranchMatchedException();
    }
}
