package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AffinityCalculationStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "", "(Ljava/lang/String;I)V", "calculateAffinityOfMask", "", "mask", "Lcom/redmadrobot/inputmask/helper/Mask;", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "prefixIntersection", "", "another", "WHOLE_STRING", "PREFIX", "CAPACITY", "EXTRACTED_VALUE_CAPACITY", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum AffinityCalculationStrategy {
    WHOLE_STRING,
    PREFIX,
    CAPACITY,
    EXTRACTED_VALUE_CAPACITY;

    /* compiled from: AffinityCalculationStrategy.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AffinityCalculationStrategy.values().length];
            iArr[AffinityCalculationStrategy.WHOLE_STRING.ordinal()] = 1;
            iArr[AffinityCalculationStrategy.PREFIX.ordinal()] = 2;
            iArr[AffinityCalculationStrategy.CAPACITY.ordinal()] = 3;
            iArr[AffinityCalculationStrategy.EXTRACTED_VALUE_CAPACITY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int calculateAffinityOfMask(Mask mask, CaretString text) {
        int length;
        int i;
        Intrinsics.checkNotNullParameter(mask, "mask");
        Intrinsics.checkNotNullParameter(text, "text");
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            return mask.apply(text).getAffinity();
        }
        if (i2 == 2) {
            return prefixIntersection(mask.apply(text).getFormattedText().getString(), text.getString()).length();
        }
        if (i2 != 3) {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            length = mask.apply(text).getExtractedValue().length();
            if (length > mask.totalValueLength()) {
                return Integer.MIN_VALUE;
            }
            i = mask.totalValueLength();
        } else {
            if (text.getString().length() > mask.totalTextLength()) {
                return Integer.MIN_VALUE;
            }
            length = text.getString().length();
            i = mask.totalTextLength();
        }
        return length - i;
    }

    private final String prefixIntersection(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0) {
            return "";
        }
        int i = 0;
        while (i < str.length() && i < str2.length()) {
            if (str.charAt(i) != str2.charAt(i)) {
                String strSubstring = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
            i++;
        }
        String strSubstring2 = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring2;
    }
}
