package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontVariation.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"androidx/compose/ui/text/font/FontVariation$Settings", "", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "settings", "<init>", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Ljava/util/List;", "getSettings", "()Ljava/util/List;", "needsDensity", "Z", "getNeedsDensity$ui_text_release", "()Z", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontVariation$Settings {
    private final boolean needsDensity;
    private final List<FontVariation$Setting> settings;

    public FontVariation$Settings(FontVariation$Setting... fontVariation$SettingArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        for (FontVariation$Setting fontVariation$Setting : fontVariation$SettingArr) {
            String axisName = fontVariation$Setting.getAxisName();
            Object arrayList = linkedHashMap.get(axisName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(axisName, arrayList);
            }
            ((List) arrayList).add(fontVariation$Setting);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() != 1) {
                throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null) + ']').toString());
            }
            CollectionsKt.addAll(arrayList2, list);
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        this.settings = arrayList3;
        int size = arrayList3.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (((FontVariation$Setting) arrayList3.get(i)).getNeedsDensity()) {
                z = true;
                break;
            }
            i++;
        }
        this.needsDensity = z;
    }

    public final List<FontVariation$Setting> getSettings() {
        return this.settings;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FontVariation$Settings) && Intrinsics.areEqual(this.settings, ((FontVariation$Settings) other).settings);
    }

    public int hashCode() {
        return this.settings.hashCode();
    }
}
