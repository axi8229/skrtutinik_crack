package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u001f\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/core_api/RuleViolationErrorResponse;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "rule", "Lcom/fasterxml/jackson/databind/JsonNode;", "description", "", "(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getRule", "()Lcom/fasterxml/jackson/databind/JsonNode;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "ruleTo", "T", "errorClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RuleViolationErrorResponse extends ApiErrorBodyResponse {
    private final String description;
    private final JsonNode rule;

    public static /* synthetic */ RuleViolationErrorResponse copy$default(RuleViolationErrorResponse ruleViolationErrorResponse, JsonNode jsonNode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonNode = ruleViolationErrorResponse.rule;
        }
        if ((i & 2) != 0) {
            str = ruleViolationErrorResponse.description;
        }
        return ruleViolationErrorResponse.copy(jsonNode, str);
    }

    /* renamed from: component1, reason: from getter */
    public final JsonNode getRule() {
        return this.rule;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final RuleViolationErrorResponse copy(@JsonProperty("rule") JsonNode rule, @JsonProperty("description") String description) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        return new RuleViolationErrorResponse(rule, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleViolationErrorResponse)) {
            return false;
        }
        RuleViolationErrorResponse ruleViolationErrorResponse = (RuleViolationErrorResponse) other;
        return Intrinsics.areEqual(this.rule, ruleViolationErrorResponse.rule) && Intrinsics.areEqual(this.description, ruleViolationErrorResponse.description);
    }

    public int hashCode() {
        int iHashCode = this.rule.hashCode() * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RuleViolationErrorResponse(rule=" + this.rule + ", description=" + this.description + ")";
    }

    public final JsonNode getRule() {
        return this.rule;
    }

    public final String getDescription() {
        return this.description;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuleViolationErrorResponse(@JsonProperty("rule") JsonNode rule, @JsonProperty("description") String str) {
        super(null);
        Intrinsics.checkNotNullParameter(rule, "rule");
        this.rule = rule;
        this.description = str;
    }

    public final <T> T ruleTo(Class<T> errorClass) {
        Intrinsics.checkNotNullParameter(errorClass, "errorClass");
        return (T) Serializer.getJacksonObjectMapper().treeToValue(this.rule, errorClass);
    }
}
