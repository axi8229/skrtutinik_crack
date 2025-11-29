package ru.yoomoney.sdk.auth.api.account.socialAccount.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeAppleRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeEsiaRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeSberRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeVkRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/serializer/SocialAccountEnterOauthCodeRequestSerializer;", "Lcom/google/gson/JsonSerializer;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountEnterOauthCodeRequestSerializer implements JsonSerializer<SocialAccountEnterOauthCodeRequest> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthServiceProvider.values().length];
            try {
                iArr[OauthServiceProvider.APPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthServiceProvider.SBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OauthServiceProvider.VK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OauthServiceProvider.ESIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(SocialAccountEnterOauthCodeRequest src, Type typeOfSrc, JsonSerializationContext context) {
        Object obj;
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(typeOfSrc, "typeOfSrc");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = WhenMappings.$EnumSwitchMapping$0[src.getOauthService().ordinal()];
        if (i == 1) {
            obj = (SocialAccountEnterOauthCodeAppleRequest) src;
        } else if (i == 2) {
            obj = (SocialAccountEnterOauthCodeSberRequest) src;
        } else if (i == 3) {
            obj = (SocialAccountEnterOauthCodeVkRequest) src;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            obj = (SocialAccountEnterOauthCodeEsiaRequest) src;
        }
        JsonElement jsonElementSerialize = context.serialize(obj);
        Intrinsics.checkNotNullExpressionValue(jsonElementSerialize, "serialize(...)");
        return jsonElementSerialize;
    }
}
