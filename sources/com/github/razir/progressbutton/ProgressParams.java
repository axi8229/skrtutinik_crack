package com.github.razir.progressbutton;

import kotlin.Metadata;

/* compiled from: ProgressParams.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/github/razir/progressbutton/ProgressParams;", "Lcom/github/razir/progressbutton/DrawableParams;", "<init>", "()V", "", "progressRadiusRes", "Ljava/lang/Integer;", "getProgressRadiusRes", "()Ljava/lang/Integer;", "setProgressRadiusRes", "(Ljava/lang/Integer;)V", "progressRadiusPx", "I", "getProgressRadiusPx", "()I", "setProgressRadiusPx", "(I)V", "progressStrokeRes", "getProgressStrokeRes", "setProgressStrokeRes", "progressStrokePx", "getProgressStrokePx", "setProgressStrokePx", "progressColor", "getProgressColor", "setProgressColor", "progressColorRes", "getProgressColorRes", "setProgressColorRes", "", "progressColors", "[I", "getProgressColors", "()[I", "setProgressColors", "([I)V", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class ProgressParams extends DrawableParams {
    private Integer progressColor;
    private Integer progressColorRes;
    private int[] progressColors;
    private Integer progressRadiusRes;
    private Integer progressStrokeRes;
    private int progressRadiusPx = -1;
    private int progressStrokePx = -1;

    public final Integer getProgressRadiusRes() {
        return this.progressRadiusRes;
    }

    public final int getProgressRadiusPx() {
        return this.progressRadiusPx;
    }

    public final Integer getProgressStrokeRes() {
        return this.progressStrokeRes;
    }

    public final int getProgressStrokePx() {
        return this.progressStrokePx;
    }

    public final Integer getProgressColor() {
        return this.progressColor;
    }

    public final void setProgressColor(Integer num) {
        this.progressColor = num;
    }

    public final Integer getProgressColorRes() {
        return this.progressColorRes;
    }

    public final int[] getProgressColors() {
        return this.progressColors;
    }
}
