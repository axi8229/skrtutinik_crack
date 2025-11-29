package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BeanMetaData<T> {
    private final List<FieldMetaData> allConstraintFieldMetaData;
    private final String beanName;

    public BeanMetaData(Class<T> cls) throws KfsValidationException {
        this(null, cls);
    }

    public BeanMetaData(String str, Class<?> cls) throws KfsValidationException {
        String simpleName;
        this.allConstraintFieldMetaData = new ArrayList();
        if (str != null) {
            simpleName = str + "." + cls.getSimpleName();
        } else {
            simpleName = cls.getSimpleName();
        }
        this.beanName = simpleName;
        getFieldMetaDataFromClassAndHierarchy(cls);
    }

    private void getFieldMetaDataFromClassAndHierarchy(Class<?> cls) throws KfsValidationException {
        if (cls == null) {
            return;
        }
        getFieldMetaDataFromClassAndHierarchy(cls.getSuperclass());
        for (Field field : cls.getDeclaredFields()) {
            FieldMetaData fieldMetaData = new FieldMetaData(this.beanName, field);
            if (fieldMetaData.hasConstraints()) {
                this.allConstraintFieldMetaData.add(fieldMetaData);
            }
        }
    }

    public boolean hasConstraints() {
        return this.allConstraintFieldMetaData.size() > 0;
    }

    public void validate(T t) throws KfsValidationException {
        if (t == null) {
            return;
        }
        for (FieldMetaData fieldMetaData : this.allConstraintFieldMetaData) {
            if (fieldMetaData.hasConstraints()) {
                fieldMetaData.validate(t);
            }
        }
    }
}
