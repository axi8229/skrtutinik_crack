package sputnik.axmor.com.sputnik.utils.textWatchers;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangedTextWatcher.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0016\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0019\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001b¨\u0006\u001c"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/textWatchers/ChangedTextWatcher;", "Landroid/text/TextWatcher;", "", "initialValue", "Lkotlin/Function2;", "", "", "onValueChanged", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "updateInitialValue", "(Ljava/lang/String;)V", "Landroid/text/Editable;", "s", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function2;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangedTextWatcher implements TextWatcher {
    private String initialValue;
    private final Function2<Boolean, String, Unit> onValueChanged;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChangedTextWatcher(String initialValue, Function2<? super Boolean, ? super String, Unit> onValueChanged) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        this.initialValue = initialValue;
        this.onValueChanged = onValueChanged;
    }

    public final void updateInitialValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.initialValue = value;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (s != null) {
            if (!Intrinsics.areEqual(s.toString(), this.initialValue) && s.toString().length() > 0) {
                this.onValueChanged.invoke(Boolean.TRUE, s.toString());
            } else {
                this.onValueChanged.invoke(Boolean.FALSE, s.toString());
            }
        }
    }
}
