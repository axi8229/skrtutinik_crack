package com.huawei.wisesecurity.kfs.util;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;

/* loaded from: classes3.dex */
public final class StringUtil {
    public static String replaceIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static String replaceIfEmptyForMax(KfsMax kfsMax, String str) {
        return replaceIfEmpty(kfsMax.message(), str + " must <= " + kfsMax.value());
    }

    public static String replaceIfEmptyForMin(KfsMin kfsMin, String str) {
        return replaceIfEmpty(kfsMin.message(), str + " must >= " + kfsMin.value());
    }

    public static String replaceIfEmptyForNotEmpty(KfsNotEmpty kfsNotEmpty, String str) {
        return replaceIfEmpty(kfsNotEmpty.message(), str + " can't be empty");
    }

    public static String replaceIfEmptyForSize(KfsSize kfsSize, String str) {
        return replaceIfEmpty(kfsSize.message(), str + " len must between [" + kfsSize.min() + ", " + kfsSize.max() + "]");
    }
}
