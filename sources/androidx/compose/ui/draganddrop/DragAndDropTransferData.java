package androidx.compose.ui.draganddrop;

import android.content.ClipData;
import kotlin.Metadata;

/* compiled from: DragAndDrop.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "", "Landroid/content/ClipData;", "clipData", "Landroid/content/ClipData;", "getClipData", "()Landroid/content/ClipData;", "localState", "Ljava/lang/Object;", "getLocalState", "()Ljava/lang/Object;", "", "flags", "I", "getFlags", "()I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropTransferData {
    private final ClipData clipData;
    private final int flags;
    private final Object localState;

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final Object getLocalState() {
        return this.localState;
    }

    public final int getFlags() {
        return this.flags;
    }
}
