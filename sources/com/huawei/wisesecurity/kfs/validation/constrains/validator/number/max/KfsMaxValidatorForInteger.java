package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* loaded from: classes3.dex */
public class KfsMaxValidatorForInteger implements KfsConstraintValidator<KfsMax, Integer> {
    private long maxValue;
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsMax kfsMax) {
        this.message = StringUtil.replaceIfEmptyForMax(kfsMax, str);
        this.maxValue = kfsMax.value();
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Integer num) {
        if (num == null || this.maxValue >= 2147483647L) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.maxValue);
        sb.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb.toString()))) <= 0;
    }
}
