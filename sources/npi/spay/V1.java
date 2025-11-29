package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V1 extends AbstractC1855q2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V1() {
        super(0);
        Intrinsics.checkNotNullParameter("Время ожидания ответа от сервера истекло", "description");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V1)) {
            return false;
        }
        ((V1) obj).getClass();
        return Intrinsics.areEqual("Время ожидания ответа от сервера истекло", "Время ожидания ответа от сервера истекло");
    }

    public final int hashCode() {
        return 1337660109;
    }

    public final String toString() {
        return "TimeoutException(description=Время ожидания ответа от сервера истекло)";
    }
}
