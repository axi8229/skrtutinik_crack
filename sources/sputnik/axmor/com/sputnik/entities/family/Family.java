package sputnik.axmor.com.sputnik.entities.family;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Family.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ^\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b\b\u0010&R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b\t\u0010&R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b'\u0010&R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b(\u0010\u0011¨\u0006)"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/family/Family;", "Landroid/os/Parcelable;", "", "id", "", "fullName", "avatar", "", "isAdmin", "isMe", "controlled", "phone", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)Lsputnik/axmor/com/sputnik/entities/family/Family;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullName", "getAvatar", "Z", "()Z", "getControlled", "getPhone", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Family implements Parcelable {
    public static final Parcelable.Creator<Family> CREATOR = new Creator();
    private final String avatar;
    private final boolean controlled;
    private final String fullName;
    private final Integer id;
    private final boolean isAdmin;
    private final boolean isMe;
    private final String phone;

    /* compiled from: Family.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Family> {
        @Override // android.os.Parcelable.Creator
        public final Family createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Family(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Family[] newArray(int i) {
            return new Family[i];
        }
    }

    public Family() {
        this(null, null, null, false, false, false, null, 127, null);
    }

    public static /* synthetic */ Family copy$default(Family family, Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = family.id;
        }
        if ((i & 2) != 0) {
            str = family.fullName;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = family.avatar;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            z = family.isAdmin;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = family.isMe;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = family.controlled;
        }
        boolean z6 = z3;
        if ((i & 64) != 0) {
            str3 = family.phone;
        }
        return family.copy(num, str4, str5, z4, z5, z6, str3);
    }

    public final Family copy(Integer id, String fullName, String avatar, boolean isAdmin, boolean isMe, boolean controlled, String phone) {
        return new Family(id, fullName, avatar, isAdmin, isMe, controlled, phone);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Family)) {
            return false;
        }
        Family family = (Family) other;
        return Intrinsics.areEqual(this.id, family.id) && Intrinsics.areEqual(this.fullName, family.fullName) && Intrinsics.areEqual(this.avatar, family.avatar) && this.isAdmin == family.isAdmin && this.isMe == family.isMe && this.controlled == family.controlled && Intrinsics.areEqual(this.phone, family.phone);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.fullName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isAdmin;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z2 = this.isMe;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.controlled;
        int i5 = (i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str3 = this.phone;
        return i5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Family(id=" + this.id + ", fullName=" + this.fullName + ", avatar=" + this.avatar + ", isAdmin=" + this.isAdmin + ", isMe=" + this.isMe + ", controlled=" + this.controlled + ", phone=" + this.phone + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.id;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeString(this.fullName);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.isAdmin ? 1 : 0);
        parcel.writeInt(this.isMe ? 1 : 0);
        parcel.writeInt(this.controlled ? 1 : 0);
        parcel.writeString(this.phone);
    }

    public Family(Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        this.id = num;
        this.fullName = str;
        this.avatar = str2;
        this.isAdmin = z;
        this.isMe = z2;
        this.controlled = z3;
        this.phone = str3;
    }

    public /* synthetic */ Family(Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? null : str3);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: isAdmin, reason: from getter */
    public final boolean getIsAdmin() {
        return this.isAdmin;
    }

    /* renamed from: isMe, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    public final boolean getControlled() {
        return this.controlled;
    }

    public final String getPhone() {
        return this.phone;
    }
}
