package ru.yoomoney.sdk.auth.socialAccounts.vkId.domain;

import com.vk.auth.main.VkClientAuthLibConfig;
import com.vk.auth.main.VkClientUiInfo;
import com.vk.superapp.core.SuperappConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "", "authModelData", "Lcom/vk/auth/main/VkClientAuthLibConfig$AuthModelData;", "uiInfo", "Lcom/vk/auth/main/VkClientUiInfo;", "appInfo", "Lcom/vk/superapp/core/SuperappConfig$AppInfo;", "(Lcom/vk/auth/main/VkClientAuthLibConfig$AuthModelData;Lcom/vk/auth/main/VkClientUiInfo;Lcom/vk/superapp/core/SuperappConfig$AppInfo;)V", "getAppInfo", "()Lcom/vk/superapp/core/SuperappConfig$AppInfo;", "getAuthModelData", "()Lcom/vk/auth/main/VkClientAuthLibConfig$AuthModelData;", "getUiInfo", "()Lcom/vk/auth/main/VkClientUiInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VkIdSdkParameters {
    private final SuperappConfig.AppInfo appInfo;
    private final VkClientAuthLibConfig.AuthModelData authModelData;
    private final VkClientUiInfo uiInfo;

    public VkIdSdkParameters(VkClientAuthLibConfig.AuthModelData authModelData, VkClientUiInfo uiInfo, SuperappConfig.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(authModelData, "authModelData");
        Intrinsics.checkNotNullParameter(uiInfo, "uiInfo");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.authModelData = authModelData;
        this.uiInfo = uiInfo;
        this.appInfo = appInfo;
    }

    public static /* synthetic */ VkIdSdkParameters copy$default(VkIdSdkParameters vkIdSdkParameters, VkClientAuthLibConfig.AuthModelData authModelData, VkClientUiInfo vkClientUiInfo, SuperappConfig.AppInfo appInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            authModelData = vkIdSdkParameters.authModelData;
        }
        if ((i & 2) != 0) {
            vkClientUiInfo = vkIdSdkParameters.uiInfo;
        }
        if ((i & 4) != 0) {
            appInfo = vkIdSdkParameters.appInfo;
        }
        return vkIdSdkParameters.copy(authModelData, vkClientUiInfo, appInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final VkClientAuthLibConfig.AuthModelData getAuthModelData() {
        return this.authModelData;
    }

    /* renamed from: component2, reason: from getter */
    public final VkClientUiInfo getUiInfo() {
        return this.uiInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final SuperappConfig.AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final VkIdSdkParameters copy(VkClientAuthLibConfig.AuthModelData authModelData, VkClientUiInfo uiInfo, SuperappConfig.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(authModelData, "authModelData");
        Intrinsics.checkNotNullParameter(uiInfo, "uiInfo");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        return new VkIdSdkParameters(authModelData, uiInfo, appInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VkIdSdkParameters)) {
            return false;
        }
        VkIdSdkParameters vkIdSdkParameters = (VkIdSdkParameters) other;
        return Intrinsics.areEqual(this.authModelData, vkIdSdkParameters.authModelData) && Intrinsics.areEqual(this.uiInfo, vkIdSdkParameters.uiInfo) && Intrinsics.areEqual(this.appInfo, vkIdSdkParameters.appInfo);
    }

    public final SuperappConfig.AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final VkClientAuthLibConfig.AuthModelData getAuthModelData() {
        return this.authModelData;
    }

    public final VkClientUiInfo getUiInfo() {
        return this.uiInfo;
    }

    public int hashCode() {
        return this.appInfo.hashCode() + ((this.uiInfo.hashCode() + (this.authModelData.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "VkIdSdkParameters(authModelData=" + this.authModelData + ", uiInfo=" + this.uiInfo + ", appInfo=" + this.appInfo + ")";
    }
}
