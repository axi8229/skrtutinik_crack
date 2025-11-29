package ru.yoomoney.sdk.yoopinning;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PinningHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningHelper;", "", "context", "Landroid/content/Context;", "host", "", "(Landroid/content/Context;Ljava/lang/String;)V", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PinningHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final X509TrustManager trustManager;

    public /* synthetic */ PinningHelper(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str);
    }

    private PinningHelper(Context context, String str) {
        this.trustManager = YooTrustManager.INSTANCE.getYooTrustManager$yoopinning_release(new CertRepositoryImpl(context, Dispatchers.getIO(), str));
    }

    public final X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    /* compiled from: PinningHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningHelper$Companion;", "Lru/yoomoney/sdk/yoopinning/SingletonHolder;", "Lru/yoomoney/sdk/yoopinning/PinningHelper;", "Landroid/content/Context;", "", "()V", "TAG", "prepareCertsHostFromBaseUrl", "baseUrl", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion extends SingletonHolder<PinningHelper, Context, String> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PinningHelper.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: ru.yoomoney.sdk.yoopinning.PinningHelper$Companion$1, reason: invalid class name */
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Context, String, PinningHelper> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(2, PinningHelper.class, "<init>", "<init>(Landroid/content/Context;Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final PinningHelper invoke(Context p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                return new PinningHelper(p0, p1, null);
            }
        }

        private Companion() {
            super(AnonymousClass1.INSTANCE);
        }

        public final String prepareCertsHostFromBaseUrl(String baseUrl) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            try {
                String host = new URI(baseUrl).getHost();
                List listSplit$default = StringsKt.split$default((CharSequence) baseUrl, new char[]{'.'}, false, 0, 6, (Object) null);
                return listSplit$default.size() > 2 ? CollectionsKt.joinToString$default(CollectionsKt.takeLast(listSplit$default, 2), ".", null, null, 0, null, null, 62, null) : host;
            } catch (Exception e) {
                Log.d("PinningHelper", "Host url contains error: " + e.getMessage());
                return null;
            }
        }
    }
}
