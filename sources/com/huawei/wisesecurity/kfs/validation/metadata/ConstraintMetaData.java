package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.core.ConstraintHelper;
import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public class ConstraintMetaData {
    private final Annotation constraint;
    private final String fieldName;
    private final KfsConstraintValidator validator;

    public ConstraintMetaData(String str, Annotation annotation, Class<?> cls) throws KfsValidationException {
        try {
            this.fieldName = str;
            this.constraint = annotation;
            this.validator = (KfsConstraintValidator) ConstraintHelper.getValidator(annotation.annotationType(), cls).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new KfsValidationException("create constraint meta data for field:" + str + " failed, " + e.getMessage());
        }
    }

    public <T> void validate(T t) throws KfsValidationException {
        KfsConstraintValidator kfsConstraintValidator = this.validator;
        if (kfsConstraintValidator == null) {
            return;
        }
        kfsConstraintValidator.initialize(this.fieldName, this.constraint);
        if (!this.validator.isValid(t)) {
            throw new KfsValidationException(this.validator.getMessage());
        }
    }
}
