package ru.yoomoney.sdk.auth.api.crypt;

import java.security.MessageDigest;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jose4j.base64url.Base64Url;
import org.jose4j.keys.HmacKey;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\rH\u0082 J\t\u0010\u000e\u001a\u00020\rH\u0082 J\t\u0010\u000f\u001a\u00020\rH\u0082 J\t\u0010\u0010\u001a\u00020\rH\u0082 J\t\u0010\u0011\u001a\u00020\rH\u0082 J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/crypt/ApiKeyProviderImpl;", "Lru/yoomoney/sdk/auth/api/crypt/ApiKeyProvider;", "isDebugMode", "", "(Z)V", "secretKeyV1", "Lorg/jose4j/keys/HmacKey;", "getSecretKeyV1", "()Lorg/jose4j/keys/HmacKey;", "secretKeyV1$delegate", "Lkotlin/Lazy;", "secretKeyV2", "apiSecretKeyDebugV1", "", "apiSecretKeyDebugV2", "apiSecretKeyProdV1", "apiSecretKeyProdV2", "appSecretKey", "getApiSecretKeyV1", "getApiSecretKeyV2", "clientSecret", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiKeyProviderImpl implements ApiKeyProvider {
    private final boolean isDebugMode;

    /* renamed from: secretKeyV1$delegate, reason: from kotlin metadata */
    private final Lazy secretKeyV1 = LazyKt.lazy(new a());
    private HmacKey secretKeyV2;

    public static final class a extends Lambda implements Function0<HmacKey> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final HmacKey invoke() {
            CryptUtils cryptUtils = CryptUtils.INSTANCE;
            return new HmacKey(Base64Url.decode(cryptUtils.decryptApiSecretKey(cryptUtils.decodeAppSecretKey(ApiKeyProviderImpl.this.appSecretKey()), ApiKeyProviderImpl.this.isDebugMode ? ApiKeyProviderImpl.this.apiSecretKeyDebugV1() : ApiKeyProviderImpl.this.apiSecretKeyProdV1())));
        }
    }

    static {
        System.loadLibrary("native-keys-container");
    }

    public ApiKeyProviderImpl(boolean z) {
        this.isDebugMode = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native String apiSecretKeyDebugV1();

    private final native String apiSecretKeyDebugV2();

    /* JADX INFO: Access modifiers changed from: private */
    public final native String apiSecretKeyProdV1();

    private final native String apiSecretKeyProdV2();

    /* JADX INFO: Access modifiers changed from: private */
    public final native String appSecretKey();

    private final HmacKey getSecretKeyV1() {
        return (HmacKey) this.secretKeyV1.getValue();
    }

    @Override // ru.yoomoney.sdk.auth.api.crypt.ApiKeyProvider
    public HmacKey getApiSecretKeyV1() {
        return getSecretKeyV1();
    }

    @Override // ru.yoomoney.sdk.auth.api.crypt.ApiKeyProvider
    public HmacKey getApiSecretKeyV2(String clientSecret) throws BadPaddingException, IllegalBlockSizeException {
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        if (this.secretKeyV2 == null) {
            CryptUtils cryptUtils = CryptUtils.INSTANCE;
            String strDecryptApiSecretKey = cryptUtils.decryptApiSecretKey(cryptUtils.decodeAppSecretKey(appSecretKey()), this.isDebugMode ? apiSecretKeyDebugV2() : apiSecretKeyProdV2());
            byte[] bArrDecode = Base64Url.decode(clientSecret);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            byte[] bArrDecode2 = Base64Url.decode(strDecryptApiSecretKey);
            Intrinsics.checkNotNullExpressionValue(bArrDecode2, "decode(...)");
            this.secretKeyV2 = new HmacKey(MessageDigest.getInstance("SHA-256").digest(ArraysKt.plus(bArrDecode, bArrDecode2)));
        }
        HmacKey hmacKey = this.secretKeyV2;
        if (hmacKey != null) {
            return hmacKey;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
