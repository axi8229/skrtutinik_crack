package ru.yoomoney.sdk.gui.utils.properties;

import android.widget.TextView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;

/* compiled from: TextValueProperty.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/gui/utils/properties/TextValueProperty;", "Lkotlin/properties/ReadWriteProperty;", "", "", "Lkotlin/Function0;", "Landroid/widget/TextView;", "textView", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/CharSequence;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/CharSequence;)V", "Lkotlin/jvm/functions/Function0;", "getTextView", "()Lkotlin/jvm/functions/Function0;", "field", "Ljava/lang/CharSequence;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextValueProperty implements ReadWriteProperty<Object, CharSequence> {
    private CharSequence field;
    private final Function0<TextView> textView;

    /* JADX WARN: Multi-variable type inference failed */
    public TextValueProperty(Function0<? extends TextView> textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue(obj, (KProperty<?>) kProperty);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, CharSequence charSequence) {
        setValue2(obj, (KProperty<?>) kProperty, charSequence);
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public CharSequence getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        return this.field;
    }

    /* renamed from: setValue, reason: avoid collision after fix types in other method */
    public void setValue2(Object thisRef, KProperty<?> property, CharSequence value) {
        Unit unit;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        this.field = value;
        TextView textViewInvoke = this.textView.invoke();
        if (value != null) {
            ViewExtensions.show(textViewInvoke);
            textViewInvoke.setText(value);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ViewExtensions.hide(textViewInvoke);
        }
    }
}
