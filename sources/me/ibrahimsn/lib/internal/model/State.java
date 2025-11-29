package me.ibrahimsn.lib.internal.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: State.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lme/ibrahimsn/lib/internal/model/State;", "", "<init>", "()V", "Ready", "Lme/ibrahimsn/lib/internal/model/State$Ready;", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class State {
    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private State() {
    }

    /* compiled from: State.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lme/ibrahimsn/lib/internal/model/State$Ready;", "Lme/ibrahimsn/lib/internal/model/State;", "()V", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Ready extends State {
        public static final Ready INSTANCE = new Ready();

        private Ready() {
            super(null);
        }
    }
}
