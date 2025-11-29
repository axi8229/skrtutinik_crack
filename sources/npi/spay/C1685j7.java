package npi.spay;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import timber.log.Timber;

/* renamed from: npi.spay.j7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1685j7 extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ D7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1685j7(D7 d7, Continuation continuation) {
        super(2, continuation);
        this.c = d7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1685j7 c1685j7 = new C1685j7(this.c, continuation);
        c1685j7.b = obj;
        return c1685j7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1685j7 c1685j7 = new C1685j7(this.c, (Continuation) obj2);
        c1685j7.b = (Yl) obj;
        return c1685j7.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String message;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Yl yl = (Yl) this.b;
            S8 s8 = this.c.b;
            this.a = 1;
            s8.getClass();
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            String requestBody = companion.encodeToString(Xl.a, yl);
            C1675im c1675im = s8.b;
            String url = s8.a.a;
            c1675im.getClass();
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
            Request requestBuild = new Request.Builder().url(url).post(RequestBody.INSTANCE.create(requestBody, MediaType.INSTANCE.get("application/json"))).build();
            int iCode = -1;
            try {
                OkHttpClient okHttpClient = c1675im.a.f;
                if (okHttpClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("okHttpClient");
                    okHttpClient = null;
                }
                Response responseExecute = okHttpClient.newCall(requestBuild).execute();
                try {
                    iCode = responseExecute.code();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(responseExecute, null);
                } finally {
                }
            } catch (Exception e) {
                Timber.INSTANCE.tag("NetworkClientImpl").d("Во время отправки произошла ошибка: " + e, new Object[0]);
            }
            if (200 > iCode || iCode >= 207) {
                s8.a.d.getClass();
                Intrinsics.checkNotNullParameter("NetworkDelegate", RemoteMessageConst.Notification.TAG);
                message = "Data not sent";
            } else {
                s8.a.d.getClass();
                Intrinsics.checkNotNullParameter("NetworkDelegate", RemoteMessageConst.Notification.TAG);
                message = "Data sent successfully";
            }
            Intrinsics.checkNotNullParameter(message, "message");
            if (Unit.INSTANCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
