package androidx.compose.runtime.livedata;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: LiveDataAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"R", "T", "Landroidx/lifecycle/LiveData;", "initial", "Landroidx/compose/runtime/State;", "observeAsState", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LiveDataAdapterKt {
    public static final <R, T extends R> State<R> observeAsState(LiveData<T> liveData, R r, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(411178300, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:57)");
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            if (liveData.isInitialized()) {
                r = liveData.getValue();
            }
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean zChangedInstance = composer.changedInstance(liveData) | composer.changedInstance(lifecycleOwner);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new LiveDataAdapterKt$observeAsState$1$1(liveData, lifecycleOwner, mutableState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(liveData, lifecycleOwner, (Function1) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }
}
