package coil.intercept;

import coil.EventListener;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RealInterceptorChain.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b\u000f\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "Lcoil/request/ImageRequest;", "initialRequest", "", "Lcoil/intercept/Interceptor;", "interceptors", "", "index", "request", "Lcoil/size/Size;", "size", "Lcoil/EventListener;", "eventListener", "", "isPlaceholderCached", "<init>", "(Lcoil/request/ImageRequest;Ljava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/EventListener;Z)V", "interceptor", "", "checkRequest", "(Lcoil/request/ImageRequest;Lcoil/intercept/Interceptor;)V", "copy", "(ILcoil/request/ImageRequest;Lcoil/size/Size;)Lcoil/intercept/RealInterceptorChain;", "Lcoil/request/ImageResult;", "proceed", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/request/ImageRequest;", "getInitialRequest", "()Lcoil/request/ImageRequest;", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "I", "getIndex", "()I", "getRequest", "Lcoil/size/Size;", "getSize", "()Lcoil/size/Size;", "Lcoil/EventListener;", "getEventListener", "()Lcoil/EventListener;", "Z", "()Z", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* compiled from: RealInterceptorChain.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", l = {25}, m = "proceed")
    /* renamed from: coil.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(ImageRequest imageRequest, List<? extends Interceptor> list, int i, ImageRequest imageRequest2, Size size, EventListener eventListener, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener;
        this.isPlaceholderCached = z;
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.size;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    /* renamed from: isPlaceholderCached, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object proceed(coil.request.ImageRequest r12, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof coil.intercept.RealInterceptorChain.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r12 = r0.L$1
            coil.intercept.Interceptor r12 = (coil.intercept.Interceptor) r12
            java.lang.Object r0 = r0.L$0
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L74
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L39:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r11.index
            if (r13 <= 0) goto L4c
            java.util.List<coil.intercept.Interceptor> r2 = r11.interceptors
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            r11.checkRequest(r12, r13)
        L4c:
            java.util.List<coil.intercept.Interceptor> r13 = r11.interceptors
            int r2 = r11.index
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            int r2 = r11.index
            int r5 = r2 + 1
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r11
            r6 = r12
            coil.intercept.RealInterceptorChain r12 = copy$default(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r11
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r12 = r13.intercept(r12, r0)
            if (r12 != r1) goto L70
            return r1
        L70:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L74:
            coil.request.ImageResult r13 = (coil.request.ImageResult) r13
            coil.request.ImageRequest r1 = r13.getRequest()
            r0.checkRequest(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.proceed(coil.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkRequest(ImageRequest request, Interceptor interceptor) {
        if (request.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (request.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (request.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (request.getLifecycle() != this.initialRequest.getLifecycle()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (request.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size);
    }

    private final RealInterceptorChain copy(int index, ImageRequest request, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, index, request, size, this.eventListener, this.isPlaceholderCached);
    }
}
