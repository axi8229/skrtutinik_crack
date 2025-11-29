package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.Metadata;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.SberOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.VkOauthCodeParameters;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"getState", "", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileBusinessLogicKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getState(OauthCodeParameters oauthCodeParameters) {
        return oauthCodeParameters instanceof SberOauthCodeParameters ? ((SberOauthCodeParameters) oauthCodeParameters).getState() : oauthCodeParameters instanceof VkOauthCodeParameters ? ((VkOauthCodeParameters) oauthCodeParameters).getState() : "";
    }
}
