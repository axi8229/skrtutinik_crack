package ru.yoomoney.sdk.yoopinning;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;
import org.json.JSONException;
import ru.yoomoney.sdk.yoopinning.KidType;
import ru.yoomoney.sdk.yoopinning.PinningException;

/* compiled from: CertRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0007H\u0082 J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\t\u0010\"\u001a\u00020\u0007H\u0082 J0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010$\u001a\u00020\u00072\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190&H\u0002J\t\u0010'\u001a\u00020\u0007H\u0082 J\t\u0010(\u001a\u00020\u0007H\u0082 J\t\u0010)\u001a\u00020\u0007H\u0082 J\b\u0010*\u001a\u00020+H\u0016J$\u0010,\u001a\u00020+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\t\u0010/\u001a\u00020\u0007H\u0082 J\u0018\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0002R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u00063"}, d2 = {"Lru/yoomoney/sdk/yoopinning/CertRepositoryImpl;", "Lru/yoomoney/sdk/yoopinning/CertRepository;", "context", "Landroid/content/Context;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "host", "", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;)V", "certificates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/yoomoney/sdk/yoopinning/CertificatesLists;", "getCertificates", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "certificates$delegate", "Lkotlin/Lazy;", "secretKey", "Lorg/jose4j/keys/AesKey;", "getSecretKey", "()Lorg/jose4j/keys/AesKey;", "secretKey$delegate", "blackEncryptedCerts", "checkSignature", AppMeasurementSdk.ConditionalUserProperty.VALUE, "decryptCerts", "", "encryptedCerts", "getBlackList", "getPublicKey", "Ljava/security/Key;", "kid", "Lru/yoomoney/sdk/yoopinning/KidType;", "getServerAnswer", "getWhiteList", "primaryKey", "readList", "fileName", "decrypt", "Lkotlin/Function1;", "secondaryKey", "secretAppKey", "secretCertKey", "updateCertificates", "", "updateLists", "blackList", "whiteList", "whiteEncryptedCerts", "writeToFile", RemoteMessageConst.DATA, "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CertRepositoryImpl implements CertRepository {
    private static final String BLACK_CERT_LIST = "black_cert_list";
    private static final String BLACK_KEY_LIST = "black_key_list";
    private static final String WHITE_CERT_LIST = "white_cert_list";

    /* renamed from: certificates$delegate, reason: from kotlin metadata */
    private final Lazy certificates;
    private final Context context;
    private final CoroutineDispatcher coroutineDispatcher;
    private final String host;

    /* renamed from: secretKey$delegate, reason: from kotlin metadata */
    private final Lazy secretKey;

    /* compiled from: CertRepository.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KidType.values().length];
            try {
                iArr[KidType.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KidType.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final native String blackEncryptedCerts();

    private final native String primaryKey();

    private final native String secondaryKey();

    /* JADX INFO: Access modifiers changed from: private */
    public final native String secretAppKey();

    /* JADX INFO: Access modifiers changed from: private */
    public final native String secretCertKey();

    private final native String whiteEncryptedCerts();

    public CertRepositoryImpl(Context context, CoroutineDispatcher coroutineDispatcher, String host) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(host, "host");
        this.context = context;
        this.coroutineDispatcher = coroutineDispatcher;
        this.host = host;
        this.secretKey = LazyKt.lazy(new Function0<AesKey>() { // from class: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$secretKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AesKey invoke() {
                CryptUtils cryptUtils = CryptUtils.INSTANCE;
                return new AesKey(Base64Url.decode(cryptUtils.decryptCertSecretKey$yoopinning_release(cryptUtils.decodeAppSecretKey$yoopinning_release(this.this$0.secretAppKey()), this.this$0.secretCertKey())));
            }
        });
        this.certificates = LazyKt.lazy(new Function0<MutableStateFlow<CertificatesLists>>() { // from class: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$certificates$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MutableStateFlow<CertificatesLists> invoke() {
                return StateFlowKt.MutableStateFlow(new CertificatesLists(this.this$0.getWhiteList(), this.this$0.getBlackList()));
            }
        });
    }

    private final AesKey getSecretKey() {
        return (AesKey) this.secretKey.getValue();
    }

    @Override // ru.yoomoney.sdk.yoopinning.CertRepository
    public MutableStateFlow<CertificatesLists> getCertificates() {
        return (MutableStateFlow) this.certificates.getValue();
    }

    /* compiled from: CertRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1", f = "CertRepository.kt", l = {51}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CertRepositoryImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    C03551 c03551 = new C03551(CertRepositoryImpl.this, null);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c03551, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }

        /* compiled from: CertRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1$1", f = "CertRepository.kt", l = {52}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ CertRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03551(CertRepositoryImpl certRepositoryImpl, Continuation<? super C03551> continuation) {
                super(2, continuation);
                this.this$0 = certRepositoryImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03551(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: CertRepository.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1$1$1", f = "CertRepository.kt", l = {59}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$updateCertificates$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C03561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CertRepositoryImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03561(CertRepositoryImpl certRepositoryImpl, Continuation<? super C03561> continuation) {
                    super(2, continuation);
                    this.this$0 = certRepositoryImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C03561(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C03561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws JSONException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, InvalidAlgorithmParameterException {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CertificatesListResponse certificatesListResponseFromJson = CertificatesListResponse.INSTANCE.fromJson(this.this$0.checkSignature(this.this$0.getServerAnswer()));
                        List<String> whiteList = certificatesListResponseFromJson.getWhiteList();
                        this.this$0.updateLists(certificatesListResponseFromJson.getBlackList(), whiteList);
                        MutableStateFlow<CertificatesLists> certificates = this.this$0.getCertificates();
                        CertificatesLists certificatesLists = new CertificatesLists(this.this$0.getWhiteList(), this.this$0.getBlackList());
                        this.label = 1;
                        if (certificates.emit(certificatesLists, this) == coroutine_suspended) {
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

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.this$0.coroutineDispatcher;
                    C03561 c03561 = new C03561(this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(coroutineDispatcher, c03561, this) == coroutine_suspended) {
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
    }

    @Override // ru.yoomoney.sdk.yoopinning.CertRepository
    public void updateCertificates() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default(null, 1, null)), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getBlackList() {
        try {
            List<String> list = readList(BLACK_CERT_LIST, new CertRepositoryImpl$getBlackList$cachedList$1(this));
            if (list.isEmpty()) {
                list = decryptCerts(blackEncryptedCerts());
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getWhiteList() {
        try {
            List<String> list = readList(WHITE_CERT_LIST, new CertRepositoryImpl$getWhiteList$cachedList$1(this));
            if (list.isEmpty()) {
                list = decryptCerts(whiteEncryptedCerts());
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getServerAnswer() {
        return new CertificateRequest(new ETagRepositoryImpl(this.context)).getCertificates(this.context, this.host);
    }

    private final Key getPublicKey(KidType kid) throws BadPaddingException, PinningException.KeyInBlackListException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, InvalidAlgorithmParameterException {
        List<String> list = readList(BLACK_KEY_LIST, new Function1<String, List<? extends String>>() { // from class: ru.yoomoney.sdk.yoopinning.CertRepositoryImpl$getPublicKey$blackKeyList$1
            @Override // kotlin.jvm.functions.Function1
            public final List<String> invoke(String data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return StringsKt.split$default((CharSequence) data, new String[]{","}, false, 0, 6, (Object) null);
            }
        });
        String strPrimaryKey = primaryKey();
        int i = WhenMappings.$EnumSwitchMapping$0[kid.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (!list.contains(CryptUtils.INSTANCE.decrypt$yoopinning_release(strPrimaryKey, getSecretKey()))) {
                List mutableList = CollectionsKt.toMutableList((Collection) list);
                mutableList.add(strPrimaryKey);
                writeToFile(CollectionsKt.joinToString$default(mutableList, ",", null, null, 0, null, null, 62, null), BLACK_KEY_LIST);
            }
            strPrimaryKey = secondaryKey();
        }
        String strDecrypt$yoopinning_release = CryptUtils.INSTANCE.decrypt$yoopinning_release(strPrimaryKey, getSecretKey());
        if (list.contains(strDecrypt$yoopinning_release)) {
            throw PinningException.KeyInBlackListException.INSTANCE;
        }
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Url.decode(strDecrypt$yoopinning_release)));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String checkSignature(String value) throws JoseException, PinningException.SignatureNotVerifyException {
        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.setCompactSerialization(value);
        KidType.Companion companion = KidType.INSTANCE;
        String keyIdHeaderValue = jsonWebSignature.getKeyIdHeaderValue();
        Intrinsics.checkNotNullExpressionValue(keyIdHeaderValue, "getKeyIdHeaderValue(...)");
        jsonWebSignature.setKey(getPublicKey(companion.fromString(keyIdHeaderValue)));
        if (!jsonWebSignature.verifySignature()) {
            throw PinningException.SignatureNotVerifyException.INSTANCE;
        }
        String payload = jsonWebSignature.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
        return payload;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLists(List<String> blackList, List<String> whiteList) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, InvalidAlgorithmParameterException {
        CryptUtils cryptUtils = CryptUtils.INSTANCE;
        String strEncrypt$yoopinning_release = cryptUtils.encrypt$yoopinning_release(CollectionsKt.joinToString$default(whiteList, ",", null, null, 0, null, null, 62, null), getSecretKey());
        writeToFile(cryptUtils.encrypt$yoopinning_release(CollectionsKt.joinToString$default(blackList, ",", null, null, 0, null, null, 62, null), getSecretKey()), BLACK_CERT_LIST);
        writeToFile(strEncrypt$yoopinning_release, WHITE_CERT_LIST);
    }

    private final void writeToFile(String data, String fileName) throws FileNotFoundException {
        FileOutputStream fileOutputStreamOpenFileOutput = this.context.openFileOutput(fileName, 0);
        try {
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStreamOpenFileOutput.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, null);
        } finally {
        }
    }

    private final List<String> readList(String fileName, Function1<? super String, ? extends List<String>> decrypt) throws FileNotFoundException {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.context.openFileInput(fileName);
            try {
                Intrinsics.checkNotNull(fileInputStreamOpenFileInput);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStreamOpenFileInput, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    List<String> listInvoke = decrypt.invoke(text);
                    CloseableKt.closeFinally(fileInputStreamOpenFileInput, null);
                    return listInvoke;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStreamOpenFileInput, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused) {
            return CollectionsKt.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> decryptCerts(String encryptedCerts) {
        if (encryptedCerts.length() == 0) {
            return CollectionsKt.emptyList();
        }
        return StringsKt.split$default((CharSequence) CryptUtils.INSTANCE.decrypt$yoopinning_release(encryptedCerts, getSecretKey()), new String[]{","}, false, 0, 6, (Object) null);
    }

    static {
        System.loadLibrary("native-keys-pinning-container");
    }
}
