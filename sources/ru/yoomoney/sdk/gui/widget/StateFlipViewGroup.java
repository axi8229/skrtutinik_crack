package ru.yoomoney.sdk.gui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$id;

/* compiled from: StateFlipViewGroup.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "Landroid/widget/ViewFlipper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "content", "", "empty", "error", "progress", "invalidateIds", "", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "showContent", "showEmpty", "showError", "showProgress", "showState", "index", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StateFlipViewGroup extends ViewFlipper {
    private int content;
    private int empty;
    private int error;
    private int progress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlipViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = -1;
        this.progress = -1;
        this.empty = -1;
        this.error = -1;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewAdded(child);
        if (child.getId() > 0) {
            invalidateIds();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewRemoved(child);
        if (child.getId() > 0) {
            invalidateIds();
        }
    }

    public final void showContent() {
        showState(this.content);
    }

    public final void showProgress() {
        showState(this.progress);
    }

    public final void showEmpty() {
        showState(this.empty);
    }

    public final void showError() {
        showState(this.error);
    }

    private final void invalidateIds() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int id = getChildAt(i).getId();
            if (id == R$id.content_container) {
                this.content = i;
            } else if (id == R$id.progress_container) {
                this.progress = i;
            } else if (id == R$id.empty_container) {
                this.empty = i;
            } else if (id == R$id.error_container) {
                this.error = i;
            }
        }
    }

    private final void showState(int index) {
        if (index < 0 || getDisplayedChild() == index) {
            return;
        }
        setDisplayedChild(index);
    }
}
