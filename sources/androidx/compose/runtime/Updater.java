package androidx.compose.runtime;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000e\u001a\u00020\n\"\u0004\b\u0001\u0010\u00072\u0006\u0010\b\u001a\u00028\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\r\u0088\u0001\u0004\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/Updater;", "T", "", "Landroidx/compose/runtime/Composer;", FFmpegMediaMetadataRetriever.METADATA_KEY_COMPOSER, "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function2;", "", "block", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Updater<T> {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m727constructorimpl(Composer composer) {
        return composer;
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final <V> void m728setimpl(Composer composer, V v, Function2<? super T, ? super V, Unit> function2) {
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), v)) {
            composer.updateRememberedValue(v);
            composer.apply(v, function2);
        }
    }
}
