package npi.spay;

import android.content.Context;
import android.text.Editable;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;

/* renamed from: npi.spay.cl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1525cl extends AppCompatEditText {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1525cl(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    public final void a(Context context) {
        setCursorVisible(false);
        setTextColor(context.getResources().getColor(R$color.spay_transparent));
        setBackgroundDrawable(null);
        setInputType(2);
        setSelectAllOnFocus(false);
        setTextIsSelectable(false);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int i, int i2) {
        Editable text = getText();
        if (text == null || (i == text.length() && i2 == text.length())) {
            super.onSelectionChanged(i, i2);
        } else {
            setSelection(text.length(), text.length());
        }
    }
}
