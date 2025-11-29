package sputnik.axmor.com.sputnik.utils.textWatchers;

import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultipleSymbolsRestrictTextWatcher.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/textWatchers/MultipleSymbolsRestrictTextWatcher;", "", "", "minLength", "", "Landroid/widget/EditText;", "views", "Lkotlin/Function1;", "", "", "onRestrictionPassed", "onLimited", "afterTextChangedListener", "<init>", "(ILjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "I", "Ljava/util/List;", "Lkotlin/jvm/functions/Function1;", "", "", "isPassed", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MultipleSymbolsRestrictTextWatcher {
    private final Function1<String, Unit> afterTextChangedListener;
    private final List<Boolean> isPassed;
    private final int minLength;
    private final Function1<Integer, Unit> onLimited;
    private final Function1<String, Unit> onRestrictionPassed;
    private final List<EditText> views;

    /* JADX WARN: Multi-variable type inference failed */
    public MultipleSymbolsRestrictTextWatcher(int i, List<? extends EditText> views, Function1<? super String, Unit> onRestrictionPassed, Function1<? super Integer, Unit> onLimited, Function1<? super String, Unit> afterTextChangedListener) {
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(onRestrictionPassed, "onRestrictionPassed");
        Intrinsics.checkNotNullParameter(onLimited, "onLimited");
        Intrinsics.checkNotNullParameter(afterTextChangedListener, "afterTextChangedListener");
        this.minLength = i;
        this.views = views;
        this.onRestrictionPassed = onRestrictionPassed;
        this.onLimited = onLimited;
        this.afterTextChangedListener = afterTextChangedListener;
        this.isPassed = new ArrayList();
        final int i2 = 0;
        for (Object obj : views) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.isPassed.add(Boolean.FALSE);
            ((EditText) obj).addTextChangedListener(new SymbolsRestrictTextWatcher(this.minLength, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.utils.textWatchers.MultipleSymbolsRestrictTextWatcher$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.isPassed.set(i2, Boolean.TRUE);
                }
            }, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.utils.textWatchers.MultipleSymbolsRestrictTextWatcher$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i4) {
                    this.this$0.isPassed.set(i2, Boolean.FALSE);
                    this.this$0.onLimited.invoke(1);
                }
            }, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.utils.textWatchers.MultipleSymbolsRestrictTextWatcher$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Iterator it2 = this.this$0.isPassed.iterator();
                    boolean z = true;
                    while (it2.hasNext()) {
                        if (!((Boolean) it2.next()).booleanValue()) {
                            z = false;
                        }
                    }
                    MultipleSymbolsRestrictTextWatcher multipleSymbolsRestrictTextWatcher = this.this$0;
                    if (z) {
                        multipleSymbolsRestrictTextWatcher.onRestrictionPassed.invoke(it);
                    } else {
                        multipleSymbolsRestrictTextWatcher.onLimited.invoke(Integer.valueOf(this.this$0.minLength - it.length()));
                    }
                    this.this$0.afterTextChangedListener.invoke(it);
                }
            }));
            i2 = i3;
        }
    }

    public /* synthetic */ MultipleSymbolsRestrictTextWatcher(int i, List list, Function1 function1, Function1 function12, Function1 function13, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, list, function1, function12, function13);
    }
}
