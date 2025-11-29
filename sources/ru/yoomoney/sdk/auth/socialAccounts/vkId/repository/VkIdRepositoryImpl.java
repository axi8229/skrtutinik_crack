package ru.yoomoney.sdk.auth.socialAccounts.vkId.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.OauthOrigin;
import ru.yoomoney.sdk.auth.OauthParams;
import ru.yoomoney.sdk.auth.api.crypt.oauth.OauthKeyProvider;
import ru.yoomoney.sdk.auth.api.crypt.oauth.model.VkApplicationType;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/repository/VkIdRepositoryImpl;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/repository/VkIdRepository;", "oauthKeyProvider", "Lru/yoomoney/sdk/auth/api/crypt/oauth/OauthKeyProvider;", "oauthParams", "Lru/yoomoney/sdk/auth/OauthParams;", "(Lru/yoomoney/sdk/auth/api/crypt/oauth/OauthKeyProvider;Lru/yoomoney/sdk/auth/OauthParams;)V", "getClientSecretKey", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkIdRepositoryImpl implements VkIdRepository {
    private final OauthKeyProvider oauthKeyProvider;
    private final OauthParams oauthParams;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthOrigin.values().length];
            try {
                iArr[OauthOrigin.WALLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthOrigin.INDIE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VkIdRepositoryImpl(OauthKeyProvider oauthKeyProvider, OauthParams oauthParams) {
        Intrinsics.checkNotNullParameter(oauthKeyProvider, "oauthKeyProvider");
        this.oauthKeyProvider = oauthKeyProvider;
        this.oauthParams = oauthParams;
    }

    @Override // ru.yoomoney.sdk.auth.socialAccounts.vkId.repository.VkIdRepository
    public String getClientSecretKey() {
        OauthKeyProvider oauthKeyProvider;
        VkApplicationType vkApplicationType;
        OauthParams oauthParams = this.oauthParams;
        OauthOrigin oauthOrigin = oauthParams != null ? oauthParams.getOauthOrigin() : null;
        int i = oauthOrigin == null ? -1 : WhenMappings.$EnumSwitchMapping$0[oauthOrigin.ordinal()];
        if (i == 1) {
            oauthKeyProvider = this.oauthKeyProvider;
            vkApplicationType = VkApplicationType.WALLET;
        } else {
            if (i != 2) {
                return null;
            }
            oauthKeyProvider = this.oauthKeyProvider;
            vkApplicationType = VkApplicationType.INDIE;
        }
        return oauthKeyProvider.getVkClientSecretKey(vkApplicationType);
    }
}
