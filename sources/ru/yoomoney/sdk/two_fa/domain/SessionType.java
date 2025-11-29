package ru.yoomoney.sdk.two_fa.domain;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/SessionType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SMS", "EMAIL", "PUSH_APP", "PUSH_CODE", "PHONE_CALL", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SessionType implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionType[] $VALUES;
    public static final Parcelable.Creator<SessionType> CREATOR;
    public static final SessionType SMS = new SessionType("SMS", 0);
    public static final SessionType EMAIL = new SessionType("EMAIL", 1);
    public static final SessionType PUSH_APP = new SessionType("PUSH_APP", 2);
    public static final SessionType PUSH_CODE = new SessionType("PUSH_CODE", 3);
    public static final SessionType PHONE_CALL = new SessionType("PHONE_CALL", 4);
    public static final SessionType UNKNOWN_ENUM = new SessionType("UNKNOWN_ENUM", 5);

    private static final /* synthetic */ SessionType[] $values() {
        return new SessionType[]{SMS, EMAIL, PUSH_APP, PUSH_CODE, PHONE_CALL, UNKNOWN_ENUM};
    }

    public static EnumEntries<SessionType> getEntries() {
        return $ENTRIES;
    }

    public static SessionType valueOf(String str) {
        return (SessionType) Enum.valueOf(SessionType.class, str);
    }

    public static SessionType[] values() {
        return (SessionType[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }

    private SessionType(String str, int i) {
    }

    static {
        SessionType[] sessionTypeArr$values = $values();
        $VALUES = sessionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sessionTypeArr$values);
        CREATOR = new Parcelable.Creator<SessionType>() { // from class: ru.yoomoney.sdk.two_fa.domain.SessionType.Creator
            @Override // android.os.Parcelable.Creator
            public final SessionType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return SessionType.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SessionType[] newArray(int i) {
                return new SessionType[i];
            }
        };
    }
}
