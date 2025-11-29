package ru.yoomoney.sdk.auth.qrAuth.di;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.api.signIn.SignInApi;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/di/QrAuthActivityComponent;", "", "factory", "Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Builder", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface QrAuthActivityComponent {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/di/QrAuthActivityComponent$Builder;", "", "accountToken", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/auth/qrAuth/di/QrAuthActivityComponent;", "context", "Landroid/content/Context;", "signInApi", "Lru/yoomoney/sdk/auth/api/signIn/SignInApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        Builder accountToken(String accountToken);

        QrAuthActivityComponent build();

        Builder context(Context context);

        Builder signInApi(SignInApi signInApi);
    }

    ActivityFragmentFactory factory();
}
