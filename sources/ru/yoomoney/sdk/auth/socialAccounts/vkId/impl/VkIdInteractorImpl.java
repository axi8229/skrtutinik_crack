package ru.yoomoney.sdk.auth.socialAccounts.vkId.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.vk.api.sdk.VK;
import com.vk.auth.main.VkClientAuthLibConfig;
import com.vk.auth.main.VkClientLibverifyInfo;
import com.vk.auth.main.VkClientUiInfo;
import com.vk.superapp.core.SuperappConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.domain.VkIdSdkParameters;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.repository.VkIdRepository;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/impl/VkIdInteractorImpl;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/impl/VkIdInteractor;", "vkIdRepository", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/repository/VkIdRepository;", "(Lru/yoomoney/sdk/auth/socialAccounts/vkId/repository/VkIdRepository;)V", "initVkSdk", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkIdInteractorImpl implements VkIdInteractor {
    private final VkIdRepository vkIdRepository;

    public VkIdInteractorImpl(VkIdRepository vkIdRepository) {
        Intrinsics.checkNotNullParameter(vkIdRepository, "vkIdRepository");
        this.vkIdRepository = vkIdRepository;
    }

    @Override // ru.yoomoney.sdk.auth.socialAccounts.vkId.impl.VkIdInteractor
    public Object initVkSdk(Context context, Continuation<? super VkId.Action> continuation) throws PackageManager.NameNotFoundException {
        String clientSecretKey = this.vkIdRepository.getClientSecretKey();
        if (clientSecretKey == null) {
            return VkId.Action.Cancel.INSTANCE;
        }
        VkClientAuthLibConfig.AuthModelData authModelData = new VkClientAuthLibConfig.AuthModelData(clientSecretKey, VkClientLibverifyInfo.Companion.disabled(), true, false, false, 24, (DefaultConstructorMarker) null);
        String string = context.getString(context.getApplicationInfo().labelRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
        if (drawable == null) {
            return VkId.Action.Cancel.INSTANCE;
        }
        VkClientUiInfo vkClientUiInfo = new VkClientUiInfo(drawable, string);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        String str = packageInfo != null ? packageInfo.versionName : null;
        if (str == null) {
            str = "";
        }
        return new VkId.Action.Init(new VkIdSdkParameters(authModelData, vkClientUiInfo, new SuperappConfig.AppInfo(string, String.valueOf(VK.getAppId(context)), str, (String) null, (String) null, 24, (DefaultConstructorMarker) null)));
    }
}
