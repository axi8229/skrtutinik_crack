package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

/* renamed from: npi.spay.z3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2080z3 {
    public static final boolean a(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return response.isSuccessful() && response.body() != null && response.errorBody() == null;
    }
}
