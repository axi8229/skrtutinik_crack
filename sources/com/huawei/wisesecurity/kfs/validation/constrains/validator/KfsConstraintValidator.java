package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public interface KfsConstraintValidator<A extends Annotation, T> {
    String getMessage();

    void initialize(String str, A a) throws KfsValidationException;

    boolean isValid(T t);
}
