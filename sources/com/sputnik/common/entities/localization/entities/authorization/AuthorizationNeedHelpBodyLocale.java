package com.sputnik.common.entities.localization.entities.authorization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationNeedHelpLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpBodyLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpLocale;", "body", "<init>", "(Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpLocale;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpLocale;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpLocale;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthorizationNeedHelpBodyLocale implements Parcelable {
    public static final Parcelable.Creator<AuthorizationNeedHelpBodyLocale> CREATOR = new Creator();
    private final AuthorizationNeedHelpLocale body;

    /* compiled from: AuthorizationNeedHelpLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthorizationNeedHelpBodyLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationNeedHelpBodyLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthorizationNeedHelpBodyLocale(parcel.readInt() == 0 ? null : AuthorizationNeedHelpLocale.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationNeedHelpBodyLocale[] newArray(int i) {
            return new AuthorizationNeedHelpBodyLocale[i];
        }
    }

    public AuthorizationNeedHelpBodyLocale() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AuthorizationNeedHelpBodyLocale) && Intrinsics.areEqual(this.body, ((AuthorizationNeedHelpBodyLocale) other).body);
    }

    public int hashCode() {
        AuthorizationNeedHelpLocale authorizationNeedHelpLocale = this.body;
        if (authorizationNeedHelpLocale == null) {
            return 0;
        }
        return authorizationNeedHelpLocale.hashCode();
    }

    public String toString() {
        return "AuthorizationNeedHelpBodyLocale(body=" + this.body + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AuthorizationNeedHelpLocale authorizationNeedHelpLocale = this.body;
        if (authorizationNeedHelpLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationNeedHelpLocale.writeToParcel(parcel, flags);
        }
    }

    public AuthorizationNeedHelpBodyLocale(AuthorizationNeedHelpLocale authorizationNeedHelpLocale) {
        this.body = authorizationNeedHelpLocale;
    }

    public /* synthetic */ AuthorizationNeedHelpBodyLocale(AuthorizationNeedHelpLocale authorizationNeedHelpLocale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : authorizationNeedHelpLocale);
    }

    public final AuthorizationNeedHelpLocale getBody() {
        return this.body;
    }
}
