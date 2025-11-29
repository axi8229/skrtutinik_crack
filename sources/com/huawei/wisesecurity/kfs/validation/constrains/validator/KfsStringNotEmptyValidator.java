package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;

/* loaded from: classes3.dex */
public class KfsStringNotEmptyValidator implements KfsConstraintValidator<KfsStringNotEmpty, String> {
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsStringNotEmpty kfsStringNotEmpty) throws KfsValidationException {
        this.message = StringUtil.replaceIfEmpty(kfsStringNotEmpty.message(), str + " can't be empty");
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(String str) {
        return !TextUtils.isEmpty(str);
    }
}
