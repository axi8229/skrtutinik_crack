package com.sputnik.data.processors;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* compiled from: NetworkProcessUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/data/processors/NetworkProcessUtils;", "", "<init>", "()V", "", RemoteMessageConst.MessageBody.MSG, "_key", "process", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkProcessUtils {
    public static final NetworkProcessUtils INSTANCE = new NetworkProcessUtils();

    private NetworkProcessUtils() {
    }

    public final String process(String msg, String _key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(_key, "_key");
        try {
            Mac mac = Mac.getInstance(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256);
            Charset charset = Charsets.UTF_8;
            byte[] bytes = _key.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            mac.init(new SecretKeySpec(bytes, CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256));
            byte[] bytes2 = msg.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDoFinal = mac.doFinal(bytes2);
            Intrinsics.checkNotNull(bArrDoFinal);
            String str = "";
            for (byte b : bArrDoFinal) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                str = ((Object) str) + str2;
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
