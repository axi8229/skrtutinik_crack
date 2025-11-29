package androidx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapperImpl();
    private static DataBindingComponent sDefaultComponent = null;

    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends ViewDataBinding> T inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        return (T) inflate(layoutInflater, i, viewGroup, z, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, DataBindingComponent dataBindingComponent) {
        boolean z2 = viewGroup != null && z;
        int childCount = z2 ? viewGroup.getChildCount() : 0;
        View viewInflate = layoutInflater.inflate(i, viewGroup, z);
        if (z2) {
            return (T) bindToAddedViews(dataBindingComponent, viewGroup, childCount, i);
        }
        return (T) bind(dataBindingComponent, viewInflate, i);
    }

    static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i);
    }

    static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View view, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i);
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) bind(dataBindingComponent, viewArr, i2);
    }
}
