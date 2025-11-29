package androidx.view.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.ViewTreeOnBackPressedDispatcherOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "<init>", "()V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "current", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalOnBackPressedDispatcherOwner {
    public static final LocalOnBackPressedDispatcherOwner INSTANCE = new LocalOnBackPressedDispatcherOwner();
    private static final ProvidableCompositionLocal<OnBackPressedDispatcherOwner> LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(null, new Function0<OnBackPressedDispatcherOwner>() { // from class: androidx.activity.compose.LocalOnBackPressedDispatcherOwner$LocalOnBackPressedDispatcherOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OnBackPressedDispatcherOwner invoke() {
            return null;
        }
    }, 1, null);

    private LocalOnBackPressedDispatcherOwner() {
    }

    public final OnBackPressedDispatcherOwner getCurrent(Composer composer, int i) {
        composer.startReplaceableGroup(-2068013981);
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) composer.consume(LocalOnBackPressedDispatcherOwner);
        composer.startReplaceableGroup(1680121597);
        if (onBackPressedDispatcherOwner == null) {
            onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        }
        composer.endReplaceableGroup();
        if (onBackPressedDispatcherOwner == null) {
            Object baseContext = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof OnBackPressedDispatcherOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) baseContext;
        }
        composer.endReplaceableGroup();
        return onBackPressedDispatcherOwner;
    }
}
