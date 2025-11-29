package ru.yoomoney.sdk.auth.api.crypt.oauth;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.crypt.CryptUtils;
import ru.yoomoney.sdk.auth.api.crypt.oauth.model.VkApplicationType;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0082 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\t\u0010\b\u001a\u00020\u0004H\u0082 J\t\u0010\t\u001a\u00020\u0004H\u0082 J\f\u0010\n\u001a\u00020\u0004*\u00020\u0007H\u0002¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/crypt/oauth/OauthKeyProviderImpl;", "Lru/yoomoney/sdk/auth/api/crypt/oauth/OauthKeyProvider;", "()V", "appSecretKey", "", "getVkClientSecretKey", "type", "Lru/yoomoney/sdk/auth/api/crypt/oauth/model/VkApplicationType;", "oauthVkClientSecretIndie", "oauthVkClientSecretWallet", "getRawSecretKey", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthKeyProviderImpl implements OauthKeyProvider {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VkApplicationType.values().length];
            try {
                iArr[VkApplicationType.WALLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VkApplicationType.INDIE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OauthKeyProviderImpl() {
        System.loadLibrary("oauth-keys-container");
    }

    private final native String appSecretKey();

    private final String getRawSecretKey(VkApplicationType vkApplicationType) {
        int i = WhenMappings.$EnumSwitchMapping$0[vkApplicationType.ordinal()];
        if (i == 1) {
            return oauthVkClientSecretWallet();
        }
        if (i == 2) {
            return oauthVkClientSecretIndie();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final native String oauthVkClientSecretIndie();

    private final native String oauthVkClientSecretWallet();

    @Override // ru.yoomoney.sdk.auth.api.crypt.oauth.OauthKeyProvider
    public String getVkClientSecretKey(VkApplicationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        CryptUtils cryptUtils = CryptUtils.INSTANCE;
        return cryptUtils.decryptApiSecretKey(cryptUtils.decodeAppSecretKey(appSecretKey()), getRawSecretKey(type));
    }
}
