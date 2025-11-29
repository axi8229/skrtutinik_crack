package com.yandex.metrica.networktasks.api;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class NetworkTaskForSendingDataParamsAppender {
    private final RequestBodyEncrypter a;

    public NetworkTaskForSendingDataParamsAppender(RequestBodyEncrypter requestBodyEncrypter) {
        this.a = requestBodyEncrypter;
    }

    public void appendCommitHash(Uri.Builder builder, String str, String str2) {
        if (str2 == null || !str2.contains("source") || TextUtils.isEmpty(str)) {
            return;
        }
        builder.appendQueryParameter("commit_hash", str);
    }

    public void appendEncryptedData(Uri.Builder builder) {
        if (this.a.getEncryptionMode() == RequestBodyEncryptionMode.AES_RSA) {
            builder.appendQueryParameter("encrypted_request", "1");
        }
    }
}
