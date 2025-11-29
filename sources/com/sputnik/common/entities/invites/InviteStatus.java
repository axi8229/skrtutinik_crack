package com.sputnik.common.entities.invites;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InviteStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/entities/invites/InviteStatus;", "", "(Ljava/lang/String;I)V", "sent", "denied", "accepted", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InviteStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InviteStatus[] $VALUES;
    public static final InviteStatus sent = new InviteStatus("sent", 0);
    public static final InviteStatus denied = new InviteStatus("denied", 1);
    public static final InviteStatus accepted = new InviteStatus("accepted", 2);

    private static final /* synthetic */ InviteStatus[] $values() {
        return new InviteStatus[]{sent, denied, accepted};
    }

    public static InviteStatus valueOf(String str) {
        return (InviteStatus) Enum.valueOf(InviteStatus.class, str);
    }

    public static InviteStatus[] values() {
        return (InviteStatus[]) $VALUES.clone();
    }

    private InviteStatus(String str, int i) {
    }

    static {
        InviteStatus[] inviteStatusArr$values = $values();
        $VALUES = inviteStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inviteStatusArr$values);
    }
}
