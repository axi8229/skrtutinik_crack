package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* loaded from: classes4.dex */
public interface VariableDescriptor extends ValueDescriptor {
    /* renamed from: getCompileTimeInitializer */
    ConstantValue<?> mo2738getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
