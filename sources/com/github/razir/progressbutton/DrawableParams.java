package com.github.razir.progressbutton;

import kotlin.Metadata;

/* compiled from: DrawableParams.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/github/razir/progressbutton/DrawableParams;", "", "<init>", "()V", "", "buttonTextRes", "Ljava/lang/Integer;", "getButtonTextRes", "()Ljava/lang/Integer;", "setButtonTextRes", "(Ljava/lang/Integer;)V", "", "buttonText", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "gravity", "I", "getGravity", "()I", "setGravity", "(I)V", "textMarginRes", "getTextMarginRes", "setTextMarginRes", "textMarginPx", "getTextMarginPx", "setTextMarginPx", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class DrawableParams {
    private String buttonText;
    private Integer buttonTextRes;
    private int gravity = 1;
    private int textMarginPx = -1;
    private Integer textMarginRes;

    public final Integer getButtonTextRes() {
        return this.buttonTextRes;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final Integer getTextMarginRes() {
        return this.textMarginRes;
    }

    public final int getTextMarginPx() {
        return this.textMarginPx;
    }
}
