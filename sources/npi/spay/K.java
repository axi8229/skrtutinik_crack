package npi.spay;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.view.otpTextView.SpayOtpTextView;

/* loaded from: classes4.dex */
public final class K implements FlowCollector {
    public final /* synthetic */ Na a;
    public final /* synthetic */ Context b;

    public K(Na na, Context context) {
        this.a = na;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Bk bk = (Bk) obj;
        TextView observeViewModel$lambda$17$lambda$10$lambda$9 = this.a.e;
        Intrinsics.checkNotNullExpressionValue(observeViewModel$lambda$17$lambda$10$lambda$9, "observeViewModel$lambda$17$lambda$10$lambda$9");
        observeViewModel$lambda$17$lambda$10$lambda$9.setVisibility(bk == null ? 4 : 0);
        observeViewModel$lambda$17$lambda$10$lambda$9.setText(bk != null ? AbstractC1550dl.a(bk, this.b) : null);
        if (bk != null) {
            SpayOtpTextView spayOtpTextView = this.a.d;
            spayOtpTextView.d = true;
            ArrayList arrayList = spayOtpTextView.a;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Cl cl = (Cl) arrayList.get(i);
                    boolean z = spayOtpTextView.d;
                    int i2 = Cl.$r8$clinit;
                    cl.a("", false, z, false);
                    ((Cl) arrayList.get(i)).setViewState(-1);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
