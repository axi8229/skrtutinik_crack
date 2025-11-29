package npi.spay;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lnpi/spay/x3;", "", "", "url", "Lretrofit2/Response;", "Lnpi/spay/Hg;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.x3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC2030x3 {
    @GET
    Object a(@Url String str, Continuation<? super Response<Hg>> continuation);
}
