package com.yandex.metrica.networktasks.api;

import com.yandex.metrica.networktasks.api.DefaultResponseParser;
import com.yandex.metrica.networktasks.impl.h;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SendingDataTaskHelper {
    private final RequestBodyEncrypter a;
    private final Compressor b;
    private final h c;
    private final RequestDataHolder d;
    private final ResponseDataHolder e;
    private final NetworkResponseHandler f;

    public SendingDataTaskHelper(RequestBodyEncrypter requestBodyEncrypter, Compressor compressor, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, NetworkResponseHandler networkResponseHandler) {
        this(requestBodyEncrypter, compressor, new h(), requestDataHolder, responseDataHolder, networkResponseHandler);
    }

    public SendingDataTaskHelper(RequestBodyEncrypter requestBodyEncrypter, Compressor compressor, h hVar, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, NetworkResponseHandler networkResponseHandler) {
        this.a = requestBodyEncrypter;
        this.b = compressor;
        this.c = hVar;
        this.d = requestDataHolder;
        this.e = responseDataHolder;
        this.f = networkResponseHandler;
    }

    public boolean isResponseValid() {
        DefaultResponseParser.Response response = (DefaultResponseParser.Response) this.f.handle(this.e);
        return response != null && "accepted".equals(response.mStatus);
    }

    public void onPerformRequest() {
        RequestDataHolder requestDataHolder = this.d;
        this.c.getClass();
        requestDataHolder.applySendTime(System.currentTimeMillis());
    }

    public boolean prepareAndSetPostData(byte[] bArr) {
        byte[] bArrEncrypt;
        try {
            byte[] bArrCompress = this.b.compress(bArr);
            if (bArrCompress == null || (bArrEncrypt = this.a.encrypt(bArrCompress)) == null) {
                return false;
            }
            this.d.setPostData(bArrEncrypt);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
