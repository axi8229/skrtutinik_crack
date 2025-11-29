package ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntryPointUiState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;", "", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState$Init;", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface EntryPointUiState {

    /* compiled from: EntryPointUiState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState$Init;", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Init implements EntryPointUiState {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        private Init() {
        }
    }

    /* compiled from: EntryPointUiState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState$InitialError;", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;", "failureTitle", "", "failureDescription", "actionText", "onAction", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getActionText", "()Ljava/lang/String;", "getFailureDescription", "getFailureTitle", "getOnAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InitialError implements EntryPointUiState {
        public static final int $stable = 0;
        private final String actionText;
        private final String failureDescription;
        private final String failureTitle;
        private final Function0<Unit> onAction;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitialError copy$default(InitialError initialError, String str, String str2, String str3, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initialError.failureTitle;
            }
            if ((i & 2) != 0) {
                str2 = initialError.failureDescription;
            }
            if ((i & 4) != 0) {
                str3 = initialError.actionText;
            }
            if ((i & 8) != 0) {
                function0 = initialError.onAction;
            }
            return initialError.copy(str, str2, str3, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFailureTitle() {
            return this.failureTitle;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFailureDescription() {
            return this.failureDescription;
        }

        /* renamed from: component3, reason: from getter */
        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> component4() {
            return this.onAction;
        }

        public final InitialError copy(String failureTitle, String failureDescription, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(failureDescription, "failureDescription");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            return new InitialError(failureTitle, failureDescription, actionText, onAction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitialError)) {
                return false;
            }
            InitialError initialError = (InitialError) other;
            return Intrinsics.areEqual(this.failureTitle, initialError.failureTitle) && Intrinsics.areEqual(this.failureDescription, initialError.failureDescription) && Intrinsics.areEqual(this.actionText, initialError.actionText) && Intrinsics.areEqual(this.onAction, initialError.onAction);
        }

        public int hashCode() {
            String str = this.failureTitle;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.failureDescription.hashCode()) * 31) + this.actionText.hashCode()) * 31) + this.onAction.hashCode();
        }

        public String toString() {
            return "InitialError(failureTitle=" + this.failureTitle + ", failureDescription=" + this.failureDescription + ", actionText=" + this.actionText + ", onAction=" + this.onAction + ")";
        }

        public InitialError(String str, String failureDescription, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(failureDescription, "failureDescription");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            this.failureTitle = str;
            this.failureDescription = failureDescription;
            this.actionText = actionText;
            this.onAction = onAction;
        }

        public final String getFailureTitle() {
            return this.failureTitle;
        }

        public final String getFailureDescription() {
            return this.failureDescription;
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> getOnAction() {
            return this.onAction;
        }
    }
}
