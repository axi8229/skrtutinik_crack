package sputnik.axmor.com.sputnik.utils.textWatchers;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SymbolsMinMaxRestrictTextWatcher.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0015\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0018\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001a¨\u0006\u001b"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/textWatchers/SymbolsMinMaxRestrictTextWatcher;", "Landroid/text/TextWatcher;", "", "minLength", "maxLength", "Lkotlin/Function1;", "", "", "onRestrictionPassed", "onLimited", "afterTextChangedListener", "<init>", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Landroid/text/Editable;", "s", "afterTextChanged", "(Landroid/text/Editable;)V", "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "I", "Lkotlin/jvm/functions/Function1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SymbolsMinMaxRestrictTextWatcher implements TextWatcher {
    private final Function1<String, Unit> afterTextChangedListener;
    private final int maxLength;
    private final int minLength;
    private final Function1<Integer, Unit> onLimited;
    private final Function1<String, Unit> onRestrictionPassed;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SymbolsMinMaxRestrictTextWatcher(int i, int i2, Function1<? super String, Unit> onRestrictionPassed, Function1<? super Integer, Unit> onLimited, Function1<? super String, Unit> afterTextChangedListener) {
        Intrinsics.checkNotNullParameter(onRestrictionPassed, "onRestrictionPassed");
        Intrinsics.checkNotNullParameter(onLimited, "onLimited");
        Intrinsics.checkNotNullParameter(afterTextChangedListener, "afterTextChangedListener");
        this.minLength = i;
        this.maxLength = i2;
        this.onRestrictionPassed = onRestrictionPassed;
        this.onLimited = onLimited;
        this.afterTextChangedListener = afterTextChangedListener;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (s != null) {
            if (s.length() >= this.minLength && s.length() <= this.maxLength) {
                this.onRestrictionPassed.invoke(s.toString());
                this.afterTextChangedListener.invoke(s.toString());
            } else {
                this.onLimited.invoke(Integer.valueOf(this.minLength - s.length()));
            }
        }
    }
}
