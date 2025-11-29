package com.sputnik.common.extensions.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.ContentViewCallback;
import com.sputnik.common.R$layout;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultSnackbarView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/extensions/snackbar/DefaultSnackbarView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/google/android/material/snackbar/ContentViewCallback;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defaultStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateContentIn", "", "delay", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "animateContentOut", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultSnackbarView extends CoordinatorLayout implements ContentViewCallback {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultSnackbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int delay, int duration) {
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int delay, int duration) {
    }

    public /* synthetic */ DefaultSnackbarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSnackbarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R$layout.item_default_snackbar, this);
    }
}
