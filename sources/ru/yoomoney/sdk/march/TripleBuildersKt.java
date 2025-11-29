package ru.yoomoney.sdk.march;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TripleBuilders.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u001aQ\u0010\u0000\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0002¢\u0006\u0002\u0010\b\u001aV\u0010\t\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006*\u0002H\u00022\u0006\u0010\n\u001a\u0002H\u0005H\u0086\u0004¢\u0006\u0002\u0010\u000b\u001ab\u0010\t\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006*\u0002H\u00022\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00040\u0003H\u0086\u0004¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"just", "Lkotlin/Triple;", "STATE", "Lru/yoomoney/sdk/march/Command;", "ACTION", "EFFECT", "", "state", "(Ljava/lang/Object;)Lkotlin/Triple;", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "effect", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "command", "(Ljava/lang/Object;Lru/yoomoney/sdk/march/Command;)Lkotlin/Triple;", "march_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TripleBuildersKt {
    public static final <STATE, ACTION, EFFECT> Triple<STATE, Command<?, ACTION>, EFFECT> just(STATE state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new Triple<>(state, null, null);
    }

    public static final <STATE, ACTION, EFFECT> Triple<STATE, Command<?, ACTION>, EFFECT> with(STATE state, EFFECT effect) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(effect, "effect");
        return new Triple<>(state, null, effect);
    }

    public static final <STATE, ACTION, EFFECT> Triple<STATE, Command<?, ACTION>, EFFECT> with(STATE state, Command<?, ? extends ACTION> command) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(command, "command");
        return new Triple<>(state, command, null);
    }
}
