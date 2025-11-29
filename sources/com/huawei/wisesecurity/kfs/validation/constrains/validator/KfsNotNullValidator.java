package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;

/* loaded from: classes3.dex */
public class KfsNotNullValidator implements KfsConstraintValidator<KfsNotNull, Object> {
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsNotNull kfsNotNull) {
        this.message = StringUtil.replaceIfEmpty(kfsNotNull.message(), str + " can't be null");
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Object obj) {
        return obj != null;
    }
}
