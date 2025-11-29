package com.sputnik.domain.entities.family;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFamily.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ^\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\b\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\t\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0011¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/family/DomainFamily;", "", "", "id", "", "fullName", "avatar", "", "isAdmin", "isMe", "controlled", "phone", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)Lcom/sputnik/domain/entities/family/DomainFamily;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullName", "getAvatar", "Z", "()Z", "getControlled", "getPhone", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainFamily {
    private final String avatar;
    private final boolean controlled;
    private final String fullName;
    private final Integer id;
    private final boolean isAdmin;
    private final boolean isMe;
    private final String phone;

    public DomainFamily() {
        this(null, null, null, false, false, false, null, 127, null);
    }

    public static /* synthetic */ DomainFamily copy$default(DomainFamily domainFamily, Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = domainFamily.id;
        }
        if ((i & 2) != 0) {
            str = domainFamily.fullName;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = domainFamily.avatar;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            z = domainFamily.isAdmin;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = domainFamily.isMe;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = domainFamily.controlled;
        }
        boolean z6 = z3;
        if ((i & 64) != 0) {
            str3 = domainFamily.phone;
        }
        return domainFamily.copy(num, str4, str5, z4, z5, z6, str3);
    }

    public final DomainFamily copy(Integer id, String fullName, String avatar, boolean isAdmin, boolean isMe, boolean controlled, String phone) {
        return new DomainFamily(id, fullName, avatar, isAdmin, isMe, controlled, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainFamily)) {
            return false;
        }
        DomainFamily domainFamily = (DomainFamily) other;
        return Intrinsics.areEqual(this.id, domainFamily.id) && Intrinsics.areEqual(this.fullName, domainFamily.fullName) && Intrinsics.areEqual(this.avatar, domainFamily.avatar) && this.isAdmin == domainFamily.isAdmin && this.isMe == domainFamily.isMe && this.controlled == domainFamily.controlled && Intrinsics.areEqual(this.phone, domainFamily.phone);
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
        return "DomainFamily(id=" + this.id + ", fullName=" + this.fullName + ", avatar=" + this.avatar + ", isAdmin=" + this.isAdmin + ", isMe=" + this.isMe + ", controlled=" + this.controlled + ", phone=" + this.phone + ")";
    }

    public DomainFamily(Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        this.id = num;
        this.fullName = str;
        this.avatar = str2;
        this.isAdmin = z;
        this.isMe = z2;
        this.controlled = z3;
        this.phone = str3;
    }

    public /* synthetic */ DomainFamily(Integer num, String str, String str2, boolean z, boolean z2, boolean z3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final String getPhone() {
        return this.phone;
    }
}
