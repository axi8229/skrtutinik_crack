package com.sputnik.common.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.R$styleable;
import com.sputnik.common.adapters.VerticalTabAdapter;
import com.sputnik.common.databinding.LayoutViewVerticalTabsBinding;
import com.sputnik.common.entities.camera.Camera;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalTabLayout.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0016R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/sputnik/common/ui/view/VerticalTabLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "setupRecyclerView", "()V", "Lcom/sputnik/common/adapters/VerticalTabAdapter;", "tabAdapter", "setAdapter", "(Lcom/sputnik/common/adapters/VerticalTabAdapter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "index", "setCurrentItem", "(I)V", "Lcom/sputnik/common/entities/camera/Camera;", "camera", "setLiveStateForCamera", "(Lcom/sputnik/common/entities/camera/Camera;)V", "count", "setCamerasSize", "Lcom/sputnik/common/databinding/LayoutViewVerticalTabsBinding;", "binding", "Lcom/sputnik/common/databinding/LayoutViewVerticalTabsBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutViewVerticalTabsBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutViewVerticalTabsBinding;)V", "camerasCount", "I", "getCamerasCount", "()I", "setCamerasCount", "adapter", "Lcom/sputnik/common/adapters/VerticalTabAdapter;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerticalTabLayout extends ConstraintLayout {
    private VerticalTabAdapter adapter;
    private LayoutViewVerticalTabsBinding binding;
    private int camerasCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VerticalTabLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutViewVerticalTabsBinding layoutViewVerticalTabsBindingInflate = LayoutViewVerticalTabsBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutViewVerticalTabsBindingInflate, "inflate(...)");
        this.binding = layoutViewVerticalTabsBindingInflate;
        context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.VerticalTabLayout, 0, 0);
        setupRecyclerView();
    }

    public final LayoutViewVerticalTabsBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutViewVerticalTabsBinding layoutViewVerticalTabsBinding) {
        Intrinsics.checkNotNullParameter(layoutViewVerticalTabsBinding, "<set-?>");
        this.binding = layoutViewVerticalTabsBinding;
    }

    public final int getCamerasCount() {
        return this.camerasCount;
    }

    public final void setCamerasCount(int i) {
        this.camerasCount = i;
    }

    private final void setupRecyclerView() {
        this.binding.tabsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.tabsRv.setNestedScrollingEnabled(false);
    }

    public final void setAdapter(VerticalTabAdapter tabAdapter) {
        Intrinsics.checkNotNullParameter(tabAdapter, "tabAdapter");
        this.adapter = tabAdapter;
        this.binding.tabsRv.setAdapter(tabAdapter);
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView tabsRv = this.binding.tabsRv;
        Intrinsics.checkNotNullExpressionValue(tabsRv, "tabsRv");
        return tabsRv;
    }

    public final void setCurrentItem(int index) {
        this.binding.tvCurrentCamera.setText((index + 1) + "/" + this.camerasCount);
        VerticalTabAdapter verticalTabAdapter = this.adapter;
        if (verticalTabAdapter != null) {
            verticalTabAdapter.selectItem(index);
        }
    }

    public final void setLiveStateForCamera(Camera camera) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        VerticalTabAdapter verticalTabAdapter = this.adapter;
        if (verticalTabAdapter != null) {
            verticalTabAdapter.updateCameraState(camera);
        }
    }

    public final void setCamerasSize(int count) {
        this.camerasCount = count;
        VerticalTabAdapter verticalTabAdapter = this.adapter;
        if (verticalTabAdapter != null) {
            this.binding.tvCurrentCamera.setText((verticalTabAdapter.getActualSelectedPosition() + 1) + "/" + count);
        }
    }
}
