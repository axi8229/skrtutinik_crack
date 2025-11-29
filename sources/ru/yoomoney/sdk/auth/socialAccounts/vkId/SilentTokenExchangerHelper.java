package ru.yoomoney.sdk.auth.socialAccounts.vkId;

import com.vk.auth.main.SilentAuthSource;
import com.vk.auth.main.VkFastLoginModifiedUser;
import com.vk.auth.main.VkSilentTokenExchanger;
import com.vk.silentauth.SilentAuthInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/SilentTokenExchangerHelper;", "", "<init>", "()V", "Lcom/vk/auth/main/VkSilentTokenExchanger;", "exchanger", "Lcom/vk/auth/main/VkSilentTokenExchanger;", "getExchanger$auth_release", "()Lcom/vk/auth/main/VkSilentTokenExchanger;", "Lkotlin/Function2;", "", "", "onTokenReceived", "Lkotlin/jvm/functions/Function2;", "getOnTokenReceived$auth_release", "()Lkotlin/jvm/functions/Function2;", "setOnTokenReceived$auth_release", "(Lkotlin/jvm/functions/Function2;)V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SilentTokenExchangerHelper {
    public static final SilentTokenExchangerHelper INSTANCE = new SilentTokenExchangerHelper();
    private static final VkSilentTokenExchanger exchanger = new VkSilentTokenExchanger() { // from class: ru.yoomoney.sdk.auth.socialAccounts.vkId.SilentTokenExchangerHelper$exchanger$1
        public VkSilentTokenExchanger.Result exchangeSilentToken(SilentAuthInfo user, VkFastLoginModifiedUser modifiedUser, SilentAuthSource source) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(source, "source");
            Function2<String, String, Unit> onTokenReceived$auth_release = SilentTokenExchangerHelper.INSTANCE.getOnTokenReceived$auth_release();
            if (onTokenReceived$auth_release != null) {
                onTokenReceived$auth_release.invoke(user.getToken(), user.getUuid());
            }
            return new VkSilentTokenExchanger.Result.Success("", 1L);
        }
    };
    private static Function2<? super String, ? super String, Unit> onTokenReceived;

    private SilentTokenExchangerHelper() {
    }

    public final VkSilentTokenExchanger getExchanger$auth_release() {
        return exchanger;
    }

    public final Function2<String, String, Unit> getOnTokenReceived$auth_release() {
        return onTokenReceived;
    }

    public final void setOnTokenReceived$auth_release(Function2<? super String, ? super String, Unit> function2) {
        onTokenReceived = function2;
    }
}
