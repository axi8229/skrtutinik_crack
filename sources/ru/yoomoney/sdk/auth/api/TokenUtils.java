package ru.yoomoney.sdk.auth.api;

import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;
import ru.yoomoney.sdk.auth.api.crypt.ApiKeyProvider;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\u00020\u0004*\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/TokenUtils;", "", "()V", "generateTokenHeader", "", "apiKeyProvider", "Lru/yoomoney/sdk/auth/api/crypt/ApiKeyProvider;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "toHexString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TokenUtils {
    public static final TokenUtils INSTANCE = new TokenUtils();

    public static final class a extends Lambda implements Function1<Byte, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b.byteValue())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    private TokenUtils() {
    }

    private final String toHexString(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.a, 30, (Object) null);
    }

    public final String generateTokenHeader(ApiKeyProvider apiKeyProvider, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) throws JoseException {
        Intrinsics.checkNotNullParameter(apiKeyProvider, "apiKeyProvider");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        long currentTimeMillis = serverTimeRepository.getCurrentTimeMillis() / 1000;
        int i = clientAppParams.getClientSecret() != null ? 2 : 1;
        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.setAlgorithmHeaderValue("HS256");
        jsonWebSignature.setKey(clientAppParams.getClientSecret() != null ? apiKeyProvider.getApiSecretKeyV2(clientAppParams.getClientSecret()) : apiKeyProvider.getApiSecretKeyV1());
        jsonWebSignature.setPayload("{\"iat\": " + currentTimeMillis + ", \"sub\": \"" + clientAppParams.getClientId() + "\"}");
        jsonWebSignature.setHeader("alg", "HS256");
        jsonWebSignature.setHeader("kid", String.valueOf(i));
        jsonWebSignature.setHeader("typ", "JWT");
        String compactSerialization = jsonWebSignature.getCompactSerialization();
        if (i != 2) {
            TokenUtils tokenUtils = INSTANCE;
            Intrinsics.checkNotNull(compactSerialization);
            Charset charset = Charsets.UTF_8;
            byte[] bytes = compactSerialization.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = tokenUtils.toHexString(bytes).getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            compactSerialization = Base64Url.encode(bytes2);
        }
        return "Client " + compactSerialization;
    }
}
