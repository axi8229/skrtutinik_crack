package com.github.razir.progressbutton;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressButtonUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonUtils;", "", "Companion", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ProgressButtonUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ProgressButtonUtils.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonUtils$Companion;", "", "<init>", "()V", "Landroid/widget/TextView;", "textView", "Lcom/github/razir/progressbutton/ProgressParams;", "progressParams", "", "showProgress", "(Landroid/widget/TextView;Lcom/github/razir/progressbutton/ProgressParams;)V", "", "newText", "hideProgress", "(Landroid/widget/TextView;Ljava/lang/String;)V", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showProgress(TextView textView, ProgressParams progressParams) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(progressParams, "progressParams");
            DrawableButtonExtensionsKt.showProgress(textView, progressParams);
        }

        @JvmStatic
        public final void hideProgress(TextView textView, String newText) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            DrawableButtonExtensionsKt.hideProgress(textView, newText);
        }
    }
}
