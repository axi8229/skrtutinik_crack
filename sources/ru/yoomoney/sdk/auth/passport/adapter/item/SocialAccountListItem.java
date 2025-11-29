package ru.yoomoney.sdk.auth.passport.adapter.item;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.model.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/passport/adapter/item/SocialAccountListItem;", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "oauthServiceLinked", "", RemoteMessageConst.Notification.ICON, "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, RemoteMessageConst.Notification.TAG, "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;ZIII)V", "getIcon", "()I", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getOauthServiceLinked", "()Z", "getTag", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountListItem {
    private final int icon;
    private final OauthServiceProvider oauthService;
    private final boolean oauthServiceLinked;
    private final int tag;
    private final int title;

    public SocialAccountListItem(OauthServiceProvider oauthService, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        this.oauthService = oauthService;
        this.oauthServiceLinked = z;
        this.icon = i;
        this.title = i2;
        this.tag = i3;
    }

    public static /* synthetic */ SocialAccountListItem copy$default(SocialAccountListItem socialAccountListItem, OauthServiceProvider oauthServiceProvider, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            oauthServiceProvider = socialAccountListItem.oauthService;
        }
        if ((i4 & 2) != 0) {
            z = socialAccountListItem.oauthServiceLinked;
        }
        boolean z2 = z;
        if ((i4 & 4) != 0) {
            i = socialAccountListItem.icon;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = socialAccountListItem.title;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = socialAccountListItem.tag;
        }
        return socialAccountListItem.copy(oauthServiceProvider, z2, i5, i6, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getOauthServiceLinked() {
        return this.oauthServiceLinked;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTag() {
        return this.tag;
    }

    public final SocialAccountListItem copy(OauthServiceProvider oauthService, boolean oauthServiceLinked, int icon, int title, int tag) {
        Intrinsics.checkNotNullParameter(oauthService, "oauthService");
        return new SocialAccountListItem(oauthService, oauthServiceLinked, icon, title, tag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccountListItem)) {
            return false;
        }
        SocialAccountListItem socialAccountListItem = (SocialAccountListItem) other;
        return this.oauthService == socialAccountListItem.oauthService && this.oauthServiceLinked == socialAccountListItem.oauthServiceLinked && this.icon == socialAccountListItem.icon && this.title == socialAccountListItem.title && this.tag == socialAccountListItem.tag;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    public final boolean getOauthServiceLinked() {
        return this.oauthServiceLinked;
    }

    public final int getTag() {
        return this.tag;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.tag) + a.a(this.title, a.a(this.icon, b.a(this.oauthServiceLinked, this.oauthService.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        return "SocialAccountListItem(oauthService=" + this.oauthService + ", oauthServiceLinked=" + this.oauthServiceLinked + ", icon=" + this.icon + ", title=" + this.title + ", tag=" + this.tag + ")";
    }
}
