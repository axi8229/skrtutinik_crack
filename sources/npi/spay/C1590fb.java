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

/* renamed from: npi.spay.fb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1590fb implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public C1590fb(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        B4 b4 = (B4) obj;
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        c1888rb.getClass();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b4.a);
        int i2 = 0;
        for (Object obj2 : b4.b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            spannableStringBuilder.setSpan(new C1939tc(c1888rb, i2, (String) obj2), ((A4) b4.c.get(i2)).a, ((A4) b4.c.get(i2)).b, 34);
            i2 = i3;
        }
        ViewBinding viewBinding = c1888rb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView = ((Ed) viewBinding).e;
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        return Unit.INSTANCE;
    }
}
