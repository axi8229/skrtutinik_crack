package ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmationHelpUiState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;", "", "Content", "Init", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Content;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Init;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ConfirmationHelpUiState {

    /* compiled from: ConfirmationHelpUiState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Init;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Init implements ConfirmationHelpUiState {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        private Init() {
        }
    }

    /* compiled from: ConfirmationHelpUiState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Content;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "description", "isActionVisible", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getDescription", "()Ljava/lang/String;", "()Z", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content implements ConfirmationHelpUiState {
        public static final int $stable = 0;
        private final String description;
        private final boolean isActionVisible;
        private final String title;

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = content.title;
            }
            if ((i & 2) != 0) {
                str2 = content.description;
            }
            if ((i & 4) != 0) {
                z = content.isActionVisible;
            }
            return content.copy(str, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsActionVisible() {
            return this.isActionVisible;
        }

        public final Content copy(String title, String description, boolean isActionVisible) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            return new Content(title, description, isActionVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.description, content.description) && this.isActionVisible == content.isActionVisible;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.isActionVisible);
        }

        public String toString() {
            return "Content(title=" + this.title + ", description=" + this.description + ", isActionVisible=" + this.isActionVisible + ")";
        }

        public Content(String title, String description, boolean z) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            this.title = title;
            this.description = description;
            this.isActionVisible = z;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDescription() {
            return this.description;
        }

        public final boolean isActionVisible() {
            return this.isActionVisible;
        }
    }
}
