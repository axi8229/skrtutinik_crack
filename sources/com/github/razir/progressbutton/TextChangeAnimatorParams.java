package com.github.razir.progressbutton;

import android.content.res.ColorStateList;
import kotlin.Metadata;

/* compiled from: TextChangeAnimatorParams.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/github/razir/progressbutton/TextChangeAnimatorParams;", "", "<init>", "()V", "", "useCurrentTextColor", "Z", "getUseCurrentTextColor", "()Z", "setUseCurrentTextColor", "(Z)V", "", "textColor", "I", "getTextColor", "()I", "setTextColor", "(I)V", "Landroid/content/res/ColorStateList;", "textColorList", "Landroid/content/res/ColorStateList;", "getTextColorList", "()Landroid/content/res/ColorStateList;", "setTextColorList", "(Landroid/content/res/ColorStateList;)V", "", "fadeInMills", "J", "getFadeInMills", "()J", "setFadeInMills", "(J)V", "fadeOutMills", "getFadeOutMills", "setFadeOutMills", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class TextChangeAnimatorParams {
    private int textColor;
    private ColorStateList textColorList;
    private boolean useCurrentTextColor = true;
    private long fadeInMills = 150;
    private long fadeOutMills = 150;

    public final int getTextColor() {
        return this.textColor;
    }

    public final ColorStateList getTextColorList() {
        return this.textColorList;
    }

    public final long getFadeInMills() {
        return this.fadeInMills;
    }

    public final long getFadeOutMills() {
        return this.fadeOutMills;
    }
}
