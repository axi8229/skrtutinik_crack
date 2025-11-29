package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApiErrorBodyResponse.kt */
@JsonSubTypes({@JsonSubTypes.Type(name = "TechnicalError", value = TechnicalErrorResponse.class), @JsonSubTypes.Type(name = "TooManyRequests", value = TooManyRequestsResponse.class), @JsonSubTypes.Type(name = "PermissionsError", value = PermissionsErrorResponse.class), @JsonSubTypes.Type(name = "InvalidCredentials", value = AuthenticationCredentialsErrorResponse.class), @JsonSubTypes.Type(name = "InvalidScope", value = InvalidScopeErrorResponse.class), @JsonSubTypes.Type(name = "ServiceUnavailable", value = ServiceUnavailableErrorResponse.class), @JsonSubTypes.Type(name = "InvalidToken", value = AuthenticationTokenErrorResponse.class), @JsonSubTypes.Type(name = "SyntaxError", value = ArgumentsSyntaxErrorResponse.class), @JsonSubTypes.Type(name = "IllegalParameters", value = ArgumentsParametersErrorResponse.class), @JsonSubTypes.Type(name = "IllegalHeaders", value = ArgumentsHeadersErrorResponse.class), @JsonSubTypes.Type(name = "RuleViolation", value = RuleViolationErrorResponse.class)})
@JsonTypeInfo(defaultImpl = UnknownErrorResponse.class, include = JsonTypeInfo.As.PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "", "()V", "Lru/yoomoney/sdk/core_api/ArgumentRuleViolationErrorResponse;", "Lru/yoomoney/sdk/core_api/ArgumentsHeadersErrorResponse;", "Lru/yoomoney/sdk/core_api/ArgumentsParametersErrorResponse;", "Lru/yoomoney/sdk/core_api/ArgumentsSyntaxErrorResponse;", "Lru/yoomoney/sdk/core_api/AuthenticationCredentialsErrorResponse;", "Lru/yoomoney/sdk/core_api/AuthenticationTokenErrorResponse;", "Lru/yoomoney/sdk/core_api/InvalidScopeErrorResponse;", "Lru/yoomoney/sdk/core_api/PermissionRuleViolationErrorResponse;", "Lru/yoomoney/sdk/core_api/PermissionsErrorResponse;", "Lru/yoomoney/sdk/core_api/RuleViolationErrorResponse;", "Lru/yoomoney/sdk/core_api/ServiceUnavailableErrorResponse;", "Lru/yoomoney/sdk/core_api/TechnicalErrorResponse;", "Lru/yoomoney/sdk/core_api/TooManyRequestsResponse;", "Lru/yoomoney/sdk/core_api/UnknownErrorResponse;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ApiErrorBodyResponse {
    public /* synthetic */ ApiErrorBodyResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiErrorBodyResponse() {
    }
}
