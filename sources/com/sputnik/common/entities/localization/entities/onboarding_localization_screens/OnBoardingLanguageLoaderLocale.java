package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingLanguageLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderBody;", "body", "<init>", "(Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderBody;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderBody;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OnBoardingLanguageLoaderLocale implements Parcelable {
    public static final Parcelable.Creator<OnBoardingLanguageLoaderLocale> CREATOR = new Creator();
    private final OnBoardingLanguageLoaderBody body;

    /* compiled from: OnBoardingLanguageLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OnBoardingLanguageLoaderLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OnBoardingLanguageLoaderLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OnBoardingLanguageLoaderLocale(OnBoardingLanguageLoaderBody.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OnBoardingLanguageLoaderLocale[] newArray(int i) {
            return new OnBoardingLanguageLoaderLocale[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OnBoardingLanguageLoaderLocale) && Intrinsics.areEqual(this.body, ((OnBoardingLanguageLoaderLocale) other).body);
    }

    public int hashCode() {
        return this.body.hashCode();
    }

    public String toString() {
        return "OnBoardingLanguageLoaderLocale(body=" + this.body + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.body.writeToParcel(parcel, flags);
    }

    public OnBoardingLanguageLoaderLocale(OnBoardingLanguageLoaderBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    public final OnBoardingLanguageLoaderBody getBody() {
        return this.body;
    }
}
