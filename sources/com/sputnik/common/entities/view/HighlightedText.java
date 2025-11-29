package com.sputnik.common.entities.view;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$dimen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HighlightedText.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0003\u0010\n\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u000fR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010 R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b!\u0010\u0011¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/view/HighlightedText;", "", "", RemoteMessageConst.MessageBody.PARAM, "", RemoteMessageConst.Notification.COLOR, "address", "Lkotlin/Function0;", "", "onClickListener", "textStyle", "textSize", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function0;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getParam", "I", "getColor", "getAddress", "Lkotlin/jvm/functions/Function0;", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "getTextStyle", "setTextStyle", "(I)V", "getTextSize", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HighlightedText {
    private final String address;
    private final int color;
    private final Function0<Unit> onClickListener;
    private final String param;
    private final int textSize;
    private int textStyle;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HighlightedText)) {
            return false;
        }
        HighlightedText highlightedText = (HighlightedText) other;
        return Intrinsics.areEqual(this.param, highlightedText.param) && this.color == highlightedText.color && Intrinsics.areEqual(this.address, highlightedText.address) && Intrinsics.areEqual(this.onClickListener, highlightedText.onClickListener) && this.textStyle == highlightedText.textStyle && this.textSize == highlightedText.textSize;
    }

    public int hashCode() {
        int iHashCode = ((this.param.hashCode() * 31) + Integer.hashCode(this.color)) * 31;
        String str = this.address;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Function0<Unit> function0 = this.onClickListener;
        return ((((iHashCode2 + (function0 != null ? function0.hashCode() : 0)) * 31) + Integer.hashCode(this.textStyle)) * 31) + Integer.hashCode(this.textSize);
    }

    public String toString() {
        return "HighlightedText(param=" + this.param + ", color=" + this.color + ", address=" + this.address + ", onClickListener=" + this.onClickListener + ", textStyle=" + this.textStyle + ", textSize=" + this.textSize + ")";
    }

    public HighlightedText(String param, int i, String str, Function0<Unit> function0, int i2, int i3) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.color = i;
        this.address = str;
        this.onClickListener = function0;
        this.textStyle = i2;
        this.textSize = i3;
    }

    public final String getParam() {
        return this.param;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Function0<Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public /* synthetic */ HighlightedText(String str, int i, String str2, Function0 function0, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? -1 : i, (i4 & 4) != 0 ? null : str2, (i4 & 8) == 0 ? function0 : null, (i4 & 16) == 0 ? i2 : -1, (i4 & 32) != 0 ? R$dimen.text_title_1 : i3);
    }
}
