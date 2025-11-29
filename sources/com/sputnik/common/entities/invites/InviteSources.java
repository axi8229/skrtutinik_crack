package com.sputnik.common.entities.invites;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InviteSources.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/entities/invites/InviteSources;", "", "(Ljava/lang/String;I)V", "mobile", "partner", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InviteSources {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InviteSources[] $VALUES;
    public static final InviteSources mobile = new InviteSources("mobile", 0);
    public static final InviteSources partner = new InviteSources("partner", 1);

    private static final /* synthetic */ InviteSources[] $values() {
        return new InviteSources[]{mobile, partner};
    }

    public static InviteSources valueOf(String str) {
        return (InviteSources) Enum.valueOf(InviteSources.class, str);
    }

    public static InviteSources[] values() {
        return (InviteSources[]) $VALUES.clone();
    }

    private InviteSources(String str, int i) {
    }

    static {
        InviteSources[] inviteSourcesArr$values = $values();
        $VALUES = inviteSourcesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inviteSourcesArr$values);
    }
}
