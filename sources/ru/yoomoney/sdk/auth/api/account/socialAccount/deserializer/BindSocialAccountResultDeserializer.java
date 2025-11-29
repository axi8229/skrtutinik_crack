package ru.yoomoney.sdk.auth.api.account.socialAccount.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.UpdateRequiredException;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountFailResult;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountSuccessResult;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/deserializer/BindSocialAccountResultDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BindSocialAccountResultDeserializer implements JsonDeserializer<BindSocialAccountResult> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BindSocialAccountResult.Status.values().length];
            try {
                iArr[BindSocialAccountResult.Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BindSocialAccountResult.Status.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public BindSocialAccountResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException, UpdateRequiredException {
        Type type;
        Intrinsics.checkNotNullParameter(json, "json");
        BindSocialAccountResult.Status status = (BindSocialAccountResult.Status) context.deserialize(a.a(typeOfT, "typeOfT", context, "context", json).get(UpdateKey.STATUS), BindSocialAccountResult.Status.class);
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            type = BindSocialAccountSuccessResult.class;
        } else {
            if (i != 2) {
                throw new UpdateRequiredException();
            }
            type = BindSocialAccountFailResult.class;
        }
        Object objDeserialize = context.deserialize(json, type);
        Intrinsics.checkNotNullExpressionValue(objDeserialize, "deserialize(...)");
        return (BindSocialAccountResult) objDeserialize;
    }
}
