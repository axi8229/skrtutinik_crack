package ru.yoomoney.sdk.auth.oauth.failure.di;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.oauth.failure.OauthFailureFragment;
import ru.yoomoney.sdk.auth.oauth.failure.impl.OauthFailureViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/failure/di/OauthFailureModule;", "", "()V", "provideOauthFailureFragment", "Landroidx/fragment/app/Fragment;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthFailureModule {
    public final Fragment provideOauthFailureFragment(Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new OauthFailureFragment(new OauthFailureViewModelFactory(), router, processMapper, resourceMapper);
    }
}
