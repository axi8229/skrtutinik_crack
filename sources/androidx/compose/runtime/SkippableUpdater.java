package androidx.compose.runtime;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u0012\u0004\b\u0015\u0010\u0016\u0088\u0001\u0004\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/SkippableUpdater;", "T", "", "Landroidx/compose/runtime/Composer;", FFmpegMediaMetadataRetriever.METADATA_KEY_COMPOSER, "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "hashCode", "other", "", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "equals", "Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class SkippableUpdater<T> {
    private final Composer composer;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m721boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m722constructorimpl(Composer composer) {
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m723equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).getComposer());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m724hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m725toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    public boolean equals(Object obj) {
        return m723equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m724hashCodeimpl(this.composer);
    }

    public String toString() {
        return m725toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Composer getComposer() {
        return this.composer;
    }

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }
}
