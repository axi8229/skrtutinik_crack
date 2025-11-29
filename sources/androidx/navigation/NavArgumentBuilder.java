package androidx.navigation;

import androidx.navigation.NavArgument;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavDestinationBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR,\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/navigation/NavArgumentBuilder;", "", "<init>", "()V", "Landroidx/navigation/NavArgument;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/navigation/NavArgument;", "Landroidx/navigation/NavArgument$Builder;", "builder", "Landroidx/navigation/NavArgument$Builder;", "Landroidx/navigation/NavType;", "_type", "Landroidx/navigation/NavType;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getType", "()Landroidx/navigation/NavType;", "setType", "(Landroidx/navigation/NavType;)V", "type", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavArgumentBuilder {
    private NavType<?> _type;
    private final NavArgument.Builder builder = new NavArgument.Builder();

    public final void setType(NavType<?> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._type = value;
        this.builder.setType(value);
    }

    public final NavArgument build() {
        return this.builder.build();
    }
}
