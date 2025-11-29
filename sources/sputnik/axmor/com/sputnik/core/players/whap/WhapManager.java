package sputnik.axmor.com.sputnik.core.players.whap;

import android.webkit.URLUtil;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: WhapManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/whap/WhapManager;", "Lsputnik/axmor/com/sputnik/core/players/whap/IWhapManager;", "callback", "Lsputnik/axmor/com/sputnik/core/players/whap/WhapCallback;", "client", "Lokhttp3/OkHttpClient;", "(Lsputnik/axmor/com/sputnik/core/players/whap/WhapCallback;Lokhttp3/OkHttpClient;)V", "getCallback", "()Lsputnik/axmor/com/sputnik/core/players/whap/WhapCallback;", "getClient", "()Lokhttp3/OkHttpClient;", "requestSdp", "", "wsUrl", "", "sdp", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WhapManager implements IWhapManager {
    private final WhapCallback callback;
    private final OkHttpClient client;

    public WhapManager(WhapCallback callback, OkHttpClient client) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(client, "client");
        this.callback = callback;
        this.client = client;
    }

    public final WhapCallback getCallback() {
        return this.callback;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    @Override // sputnik.axmor.com.sputnik.core.players.whap.IWhapManager
    public void requestSdp(String wsUrl, String sdp) {
        Intrinsics.checkNotNullParameter(wsUrl, "wsUrl");
        Intrinsics.checkNotNullParameter(sdp, "sdp");
        try {
            try {
                if (URLUtil.isValidUrl(wsUrl)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(wsUrl, sdp, null), 3, null);
                } else {
                    this.callback.onIncorrectUrl();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.callback.onIncorrectUrl();
            }
        } catch (Exception e2) {
            this.callback.onError(String.valueOf(e2.getMessage()));
            e2.printStackTrace();
        }
    }

    /* compiled from: WhapManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.core.players.whap.WhapManager$requestSdp$1", f = "WhapManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.core.players.whap.WhapManager$requestSdp$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sdp;
        final /* synthetic */ String $wsUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$wsUrl = str;
            this.$sdp = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhapManager.this.new AnonymousClass1(this.$wsUrl, this.$sdp, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Call callNewCall = WhapManager.this.getClient().newCall(new Request.Builder().url(this.$wsUrl).post(RequestBody.INSTANCE.create(MediaType.INSTANCE.parse("application/sdp"), this.$sdp)).build());
            if (callNewCall != null) {
                final WhapManager whapManager = WhapManager.this;
                callNewCall.enqueue(new Callback() { // from class: sputnik.axmor.com.sputnik.core.players.whap.WhapManager$requestSdp$1$response$1
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException e) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(e, "e");
                        whapManager.getCallback().onError(String.valueOf(e.getMessage()));
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        WhapCallback callback = whapManager.getCallback();
                        ResponseBody responseBodyBody = response.body();
                        callback.onResult(String.valueOf(responseBodyBody != null ? responseBodyBody.string() : null));
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }
}
