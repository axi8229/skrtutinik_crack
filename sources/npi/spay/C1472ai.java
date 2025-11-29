package npi.spay;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.ai, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1472ai implements FlowCollector {
    public final /* synthetic */ C1771mi a;

    public C1472ai(C1771mi c1771mi) {
        this.a = c1771mi;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        B4 b4 = (B4) obj;
        C1771mi c1771mi = this.a;
        int i = C1771mi.$r8$clinit;
        c1771mi.getClass();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b4.a);
        int i2 = 0;
        for (Object obj2 : b4.b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            spannableStringBuilder.setSpan(new Ni(c1771mi, i2, (String) obj2), ((A4) b4.c.get(i2)).a, ((A4) b4.c.get(i2)).b, 34);
            i2 = i3;
        }
        ViewBinding viewBinding = c1771mi.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView = ((C1570eg) viewBinding).i;
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        return Unit.INSTANCE;
    }
}
