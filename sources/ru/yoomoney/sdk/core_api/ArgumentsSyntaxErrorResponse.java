package ru.yoomoney.sdk.core_api;

import kotlin.Metadata;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/core_api/ArgumentsSyntaxErrorResponse;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "()V", "equals", "", "other", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgumentsSyntaxErrorResponse extends ApiErrorBodyResponse {
    public static final ArgumentsSyntaxErrorResponse INSTANCE = new ArgumentsSyntaxErrorResponse();

    private ArgumentsSyntaxErrorResponse() {
        super(null);
    }

    public boolean equals(Object other) {
        return other instanceof ArgumentsSyntaxErrorResponse;
    }
}
