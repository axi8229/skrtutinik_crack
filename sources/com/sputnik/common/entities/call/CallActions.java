package com.sputnik.common.entities.call;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CallActions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/sputnik/common/entities/call/CallActions;", "", "(Ljava/lang/String;I)V", "hang_up", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallActions {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CallActions[] $VALUES;
    public static final CallActions hang_up = new CallActions("hang_up", 0);

    private static final /* synthetic */ CallActions[] $values() {
        return new CallActions[]{hang_up};
    }

    public static CallActions valueOf(String str) {
        return (CallActions) Enum.valueOf(CallActions.class, str);
    }

    public static CallActions[] values() {
        return (CallActions[]) $VALUES.clone();
    }

    private CallActions(String str, int i) {
    }

    static {
        CallActions[] callActionsArr$values = $values();
        $VALUES = callActionsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(callActionsArr$values);
    }
}
