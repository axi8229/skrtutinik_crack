package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsConstraint;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsValid;
import com.huawei.wisesecurity.ucs_credential.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class FieldMetaData {
    private final String beanName;
    private final List<ConstraintMetaData> constraintMetaDataList = new ArrayList();
    private final Field field;
    private BeanMetaData validKfsMetaData;

    public FieldMetaData(String str, Field field) throws KfsValidationException, SecurityException {
        this.beanName = str;
        this.field = field;
        field.setAccessible(true);
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            if (((KfsConstraint) annotation.annotationType().getAnnotation(KfsConstraint.class)) != null) {
                if (annotation.annotationType() != KfsValid.class) {
                    this.constraintMetaDataList.add(new ConstraintMetaData(getFieldName(), annotation, field.getType()));
                } else {
                    this.validKfsMetaData = new BeanMetaData(str, field.getType());
                }
            }
        }
    }

    private String getFieldName() {
        return this.beanName + "." + this.field.getName();
    }

    public boolean hasConstraints() {
        return this.constraintMetaDataList.size() > 0 || this.validKfsMetaData != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void validate(T t) throws IllegalAccessException, KfsValidationException, IllegalArgumentException {
        try {
            Object obj = this.field.get(t);
            Iterator<ConstraintMetaData> it = this.constraintMetaDataList.iterator();
            while (it.hasNext()) {
                it.next().validate(obj);
            }
            BeanMetaData beanMetaData = this.validKfsMetaData;
            if (beanMetaData != 0) {
                beanMetaData.validate(obj);
            }
        } catch (IllegalAccessException e) {
            StringBuilder sbA = f.a("field validate failed:");
            sbA.append(e.getMessage());
            throw new KfsValidationException(sbA.toString());
        }
    }
}
