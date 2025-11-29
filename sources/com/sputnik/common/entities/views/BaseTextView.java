package com.sputnik.common.entities.views;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sputnik.common.R$dimen;
import com.sputnik.common.R$style;
import com.sputnik.common.entities.views.BaseView;
import com.sputnik.common.utils.DpUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseTextView.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sputnik/common/entities/views/BaseTextView;", "Lcom/sputnik/common/entities/views/BaseView;", "_text", "", "style", "", "_textColor", "_gravity", "fontSize", "(Ljava/lang/String;ILjava/lang/String;II)V", "getView", "Landroid/view/View;", "layoutInflater", "Landroid/view/LayoutInflater;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseTextView extends BaseView {
    private final int _gravity;
    private final String _text;
    private final String _textColor;
    private final int fontSize;
    private final int style;

    public /* synthetic */ BaseTextView(String str, int i, String str2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? R$style.TextView_Body1 : i, (i4 & 4) != 0 ? "#000000" : str2, (i4 & 8) != 0 ? 8388611 : i2, (i4 & 16) != 0 ? R$dimen.text_main : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTextView(String _text, int i, String _textColor, int i2, int i3) {
        super(BaseView.Types.text);
        Intrinsics.checkNotNullParameter(_text, "_text");
        Intrinsics.checkNotNullParameter(_textColor, "_textColor");
        this._text = _text;
        this.style = i;
        this._textColor = _textColor;
        this._gravity = i2;
        this.fontSize = i3;
    }

    @Override // com.sputnik.common.entities.views.BaseView
    public View getView(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        TextView textView = new TextView(layoutInflater.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Resources resources = textView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int iConvertPxToDb = DpUtilsKt.convertPxToDb(16.0f, resources);
        Resources resources2 = textView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        int iConvertPxToDb2 = DpUtilsKt.convertPxToDb(20.0f, resources2);
        textView.setGravity(this._gravity);
        layoutParams.setMargins(iConvertPxToDb2, iConvertPxToDb, iConvertPxToDb2, 0);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setTextAppearance(this.style);
        textView.setTextSize(0, textView.getResources().getDimension(this.fontSize));
        String str = this._textColor;
        if (str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        textView.setText(this._text);
        return textView;
    }
}
