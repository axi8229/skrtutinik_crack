package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter;

import com.sputnik.common.entities.camera.Camera;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManageCamerasAdapter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "", "()V", "ManageCamera", "ManageTitle", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem$ManageCamera;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem$ManageTitle;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ManageCamerasItem {
    public /* synthetic */ ManageCamerasItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ManageCamerasAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem$ManageCamera;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "Lcom/sputnik/common/entities/camera/Camera;", "item", "<init>", "(Lcom/sputnik/common/entities/camera/Camera;)V", "copy", "(Lcom/sputnik/common/entities/camera/Camera;)Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem$ManageCamera;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/camera/Camera;", "getItem", "()Lcom/sputnik/common/entities/camera/Camera;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ManageCamera extends ManageCamerasItem {
        private final Camera item;

        public final ManageCamera copy(Camera item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new ManageCamera(item);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ManageCamera) && Intrinsics.areEqual(this.item, ((ManageCamera) other).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ManageCamera(item=" + this.item + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManageCamera(Camera item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final Camera getItem() {
            return this.item;
        }
    }

    private ManageCamerasItem() {
    }

    /* compiled from: ManageCamerasAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem$ManageTitle;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ManageTitle extends ManageCamerasItem {
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ManageTitle) && Intrinsics.areEqual(this.title, ((ManageTitle) other).title);
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "ManageTitle(title=" + this.title + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManageTitle(String title) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
