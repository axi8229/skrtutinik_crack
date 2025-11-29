package com.sputnik.common.extensions.snackbar;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import com.sputnik.common.extensions.ViewKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import flussonic.watcher.sdk.presentation.timeline.animation.TimelineAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultSnackbar.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/sputnik/common/extensions/snackbar/DefaultSnackbar;", "Lcom/google/android/material/snackbar/BaseTransientBottomBar;", "parent", "Landroid/view/ViewGroup;", "content", "Lcom/sputnik/common/extensions/snackbar/DefaultSnackbarView;", "(Landroid/view/ViewGroup;Lcom/sputnik/common/extensions/snackbar/DefaultSnackbarView;)V", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultSnackbar extends BaseTransientBottomBar<DefaultSnackbar> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSnackbar(ViewGroup parent, DefaultSnackbarView content) {
        super(parent, content, content);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(content, "content");
        View view = getView();
        view.setBackgroundColor(ContextCompat.getColor(this.view.getContext(), R.color.transparent));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.extensions.snackbar.DefaultSnackbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DefaultSnackbar.lambda$1$lambda$0(this.f$0, view2);
            }
        });
        view.setPadding(0, 0, 0, 0);
        Intrinsics.checkNotNull(view);
        ViewKt.addSystemWindowInsetToPadding(view, true);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 48;
        layoutParams2.setMargins(0, TimelineAnimator.DURATION, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(DefaultSnackbar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* compiled from: DefaultSnackbar.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/extensions/snackbar/DefaultSnackbar$Companion;", "", "()V", "make", "Lcom/sputnik/common/extensions/snackbar/DefaultSnackbar;", "viewGroup", "Landroid/view/ViewGroup;", RemoteMessageConst.MessageBody.MSG, "", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DefaultSnackbar make$default(Companion companion, ViewGroup viewGroup, String str, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return companion.make(viewGroup, str, i);
        }

        public final DefaultSnackbar make(ViewGroup viewGroup, String msg, int duration) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(msg, "msg");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.layout_default_snackbar, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.sputnik.common.extensions.snackbar.DefaultSnackbarView");
            DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) viewInflate;
            ((TextView) defaultSnackbarView.findViewById(R$id.tv_snackbar_message)).setText(msg);
            return new DefaultSnackbar(viewGroup, defaultSnackbarView);
        }
    }
}
