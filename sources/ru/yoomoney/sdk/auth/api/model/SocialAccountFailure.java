package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/SocialAccountFailure;", "Lru/yoomoney/sdk/auth/api/model/Failure;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/model/ProcessError;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountFailure extends Failure {
    public static final Parcelable.Creator<SocialAccountFailure> CREATOR = new Creator();
    private final ProcessError error;
    private final OauthServiceProvider service;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SocialAccountFailure> {
        @Override // android.os.Parcelable.Creator
        public final SocialAccountFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SocialAccountFailure((ProcessError) parcel.readParcelable(SocialAccountFailure.class.getClassLoader()), OauthServiceProvider.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final SocialAccountFailure[] newArray(int i) {
            return new SocialAccountFailure[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialAccountFailure(ProcessError error, OauthServiceProvider service) {
        super(null);
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(service, "service");
        this.error = error;
        this.service = service;
    }

    public static /* synthetic */ SocialAccountFailure copy$default(SocialAccountFailure socialAccountFailure, ProcessError processError, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            processError = socialAccountFailure.error;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = socialAccountFailure.service;
        }
        return socialAccountFailure.copy(processError, oauthServiceProvider);
    }

    /* renamed from: component1, reason: from getter */
    public final ProcessError getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    public final SocialAccountFailure copy(ProcessError error, OauthServiceProvider service) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(service, "service");
        return new SocialAccountFailure(error, service);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccountFailure)) {
            return false;
        }
        SocialAccountFailure socialAccountFailure = (SocialAccountFailure) other;
        return Intrinsics.areEqual(this.error, socialAccountFailure.error) && this.service == socialAccountFailure.service;
    }

    public final ProcessError getError() {
        return this.error;
    }

    public final OauthServiceProvider getService() {
        return this.service;
    }

    public int hashCode() {
        return this.service.hashCode() + (this.error.hashCode() * 31);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "SocialAccountFailure(error=" + this.error + ", service=" + this.service + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.error, flags);
        parcel.writeString(this.service.name());
    }
}
