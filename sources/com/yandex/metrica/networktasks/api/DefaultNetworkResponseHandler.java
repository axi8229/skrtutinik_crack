package com.yandex.metrica.networktasks.api;

import com.yandex.metrica.networktasks.api.DefaultResponseParser;

/* loaded from: classes3.dex */
public class DefaultNetworkResponseHandler implements NetworkResponseHandler {
    private final DefaultResponseParser a;

    public DefaultNetworkResponseHandler() {
        this(new DefaultResponseParser());
    }

    DefaultNetworkResponseHandler(DefaultResponseParser defaultResponseParser) {
        this.a = defaultResponseParser;
    }

    @Override // com.yandex.metrica.networktasks.api.NetworkResponseHandler
    public DefaultResponseParser.Response handle(ResponseDataHolder responseDataHolder) {
        if (200 == responseDataHolder.getResponseCode()) {
            return this.a.parse(responseDataHolder.getResponseData());
        }
        return null;
    }
}
