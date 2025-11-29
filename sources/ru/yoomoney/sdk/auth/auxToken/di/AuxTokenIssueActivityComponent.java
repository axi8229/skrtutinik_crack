package ru.yoomoney.sdk.auth.auxToken.di;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationApi;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/di/AuxTokenIssueActivityComponent;", "", "factory", "Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Builder", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuxTokenIssueActivityComponent {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H'J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/di/AuxTokenIssueActivityComponent$Builder;", "", "accountApi", "api", "Lru/yoomoney/sdk/auth/api/account/AccountApi;", "auxAuthorizationApi", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/auth/auxToken/di/AuxTokenIssueActivityComponent;", "context", "Landroid/content/Context;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        Builder accountApi(AccountApi api);

        Builder auxAuthorizationApi(AuxAuthorizationApi api);

        AuxTokenIssueActivityComponent build();

        Builder context(Context context);
    }

    ActivityFragmentFactory factory();
}
