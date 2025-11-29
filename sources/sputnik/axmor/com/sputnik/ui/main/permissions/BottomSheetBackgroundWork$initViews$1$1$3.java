package sputnik.axmor.com.sputnik.ui.main.permissions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetBackgroundWork.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class BottomSheetBackgroundWork$initViews$1$1$3 extends FunctionReferenceImpl implements Function2<String, Integer, Unit> {
    BottomSheetBackgroundWork$initViews$1$1$3(Object obj) {
        super(2, obj, BottomSheetBackgroundWork.class, "changeManufacturerAndSDKInt", "changeManufacturerAndSDKInt(Ljava/lang/String;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String p0, int i) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BottomSheetBackgroundWork) this.receiver).changeManufacturerAndSDKInt(p0, i);
    }
}
