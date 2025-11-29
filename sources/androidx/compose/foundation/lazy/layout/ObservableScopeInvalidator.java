package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ObservableScopeInvalidator.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0081@\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\b\u0088\u0001\u0004\u0092\u0001\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "", "Landroidx/compose/runtime/MutableState;", "", "state", "constructor-impl", "(Landroidx/compose/runtime/MutableState;)Landroidx/compose/runtime/MutableState;", "attachToScope-impl", "(Landroidx/compose/runtime/MutableState;)V", "attachToScope", "invalidateScope-impl", "invalidateScope", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ObservableScopeInvalidator {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static MutableState<Unit> m389constructorimpl(MutableState<Unit> mutableState) {
        return mutableState;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableState m390constructorimpl$default(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableState = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        }
        return m389constructorimpl(mutableState);
    }

    /* renamed from: attachToScope-impl, reason: not valid java name */
    public static final void m388attachToScopeimpl(MutableState<Unit> mutableState) {
        mutableState.getValue();
    }

    /* renamed from: invalidateScope-impl, reason: not valid java name */
    public static final void m391invalidateScopeimpl(MutableState<Unit> mutableState) {
        mutableState.setValue(Unit.INSTANCE);
    }
}
