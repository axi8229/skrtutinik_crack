package com.yandex.metrica.impl.ob;

import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class Fl {
    private final C1396yl a;

    public Fl(C1396yl c1396yl) {
        this.a = c1396yl;
    }

    public int a(TextView textView) {
        int length = 0;
        try {
            if (TextUtils.isEmpty(textView.getText()) || textView.getVisibility() != 0) {
                return 0;
            }
            String string = textView.getText().toString();
            Layout layout = textView.getLayout();
            length = string.length();
            if (layout == null) {
                return length;
            }
            int lineCount = textView.getLineCount() - 1;
            TextUtils.TruncateAt ellipsize = textView.getEllipsize();
            if (ellipsize == null || lineCount < 0) {
                return length;
            }
            if (lineCount != 0 && ellipsize != TextUtils.TruncateAt.END) {
                return length;
            }
            return length - layout.getEllipsisCount(lineCount);
        } catch (Throwable th) {
            this.a.a("ui_parsing_visibility", th);
            return length;
        }
    }
}
