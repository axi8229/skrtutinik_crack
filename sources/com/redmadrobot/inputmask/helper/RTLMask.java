package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTLMask.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask;", "Lcom/redmadrobot/inputmask/helper/Mask;", "format", "", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "(Ljava/lang/String;Ljava/util/List;)V", "apply", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "makeIterator", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "Factory", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RTLMask extends Mask {

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, RTLMask> cache = new HashMap();

    /* compiled from: RTLMask.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask$Factory;", "", "()V", "cache", "", "", "Lcom/redmadrobot/inputmask/helper/RTLMask;", "getOrCreate", "format", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.redmadrobot.inputmask.helper.RTLMask$Factory, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RTLMask getOrCreate(String format, List<Notation> customNotations) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(customNotations, "customNotations");
            RTLMask rTLMask = (RTLMask) RTLMask.cache.get(RTLMaskKt.reversedFormat(format));
            if (rTLMask != null) {
                return rTLMask;
            }
            RTLMask rTLMask2 = new RTLMask(format, customNotations);
            RTLMask.cache.put(RTLMaskKt.reversedFormat(format), rTLMask2);
            return rTLMask2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTLMask(String format, List<Notation> customNotations) {
        super(RTLMaskKt.reversedFormat(format), customNotations);
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(customNotations, "customNotations");
    }

    @Override // com.redmadrobot.inputmask.helper.Mask
    public Mask.Result apply(CaretString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return super.apply(text.reversed()).reversed();
    }

    @Override // com.redmadrobot.inputmask.helper.Mask
    public CaretStringIterator makeIterator(CaretString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new RTLCaretStringIterator(text);
    }
}
