package com.sputnik.common.entities.views;

import android.view.LayoutInflater;
import android.view.View;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/entities/views/BaseView;", "", "Lcom/sputnik/common/entities/views/BaseView$Types;", "viewType", "<init>", "(Lcom/sputnik/common/entities/views/BaseView$Types;)V", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/View;", "getView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "Lcom/sputnik/common/entities/views/BaseView$Types;", "getViewType", "()Lcom/sputnik/common/entities/views/BaseView$Types;", "Types", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseView {
    private final Types viewType;

    public abstract View getView(LayoutInflater layoutInflater);

    public BaseView(Types viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.viewType = viewType;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BaseView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/entities/views/BaseView$Types;", "", "(Ljava/lang/String;I)V", "text", "image", "button", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Types {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Types[] $VALUES;
        public static final Types text = new Types("text", 0);
        public static final Types image = new Types("image", 1);
        public static final Types button = new Types("button", 2);

        private static final /* synthetic */ Types[] $values() {
            return new Types[]{text, image, button};
        }

        public static Types valueOf(String str) {
            return (Types) Enum.valueOf(Types.class, str);
        }

        public static Types[] values() {
            return (Types[]) $VALUES.clone();
        }

        private Types(String str, int i) {
        }

        static {
            Types[] typesArr$values = $values();
            $VALUES = typesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typesArr$values);
        }
    }
}
