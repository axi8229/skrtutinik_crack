package com.sputnik.common.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.R$drawable;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import com.sputnik.common.entities.camera.Camera;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalTabAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\"J\u0015\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b#\u0010%J\r\u0010&\u001a\u00020\u0007¢\u0006\u0004\b&\u0010\u001cJ\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b(\u0010%R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u001fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010-R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/sputnik/common/adapters/VerticalTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sputnik/common/adapters/VerticalTabAdapter$TabViewHolder;", "", "Lcom/sputnik/common/entities/camera/Camera;", "items", "Lkotlin/Function1;", "", "", "onTabSelected", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "adapterPosition", "getActualPosition", "(I)I", "current", "getPreviousPosition", "getNextPosition", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sputnik/common/adapters/VerticalTabAdapter$TabViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/sputnik/common/adapters/VerticalTabAdapter$TabViewHolder;I)V", "getItemCount", "()I", "list", "submitList", "(Ljava/util/List;)V", "actualPosition", "selectItem", "(I)V", "select", "item", "(Lcom/sputnik/common/entities/camera/Camera;)V", "getSelectedPosition", "camera", "updateCameraState", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "Lkotlin/jvm/functions/Function1;", "actualSelectedPosition", "I", "TabViewHolder", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerticalTabAdapter extends RecyclerView.Adapter<TabViewHolder> {
    private int actualSelectedPosition;
    private List<Camera> items;
    private final Function1<Integer, Unit> onTabSelected;

    private final int getPreviousPosition(int current) {
        return 0;
    }

    public final List<Camera> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VerticalTabAdapter(List<Camera> items, Function1<? super Integer, Unit> onTabSelected) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onTabSelected, "onTabSelected");
        this.items = items;
        this.onTabSelected = onTabSelected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_tab, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new TabViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TabViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            final int actualPosition = getActualPosition(position);
            if (actualPosition < this.items.size()) {
                Camera camera = this.items.get(actualPosition);
                int i = this.actualSelectedPosition;
                boolean z = false;
                if (i == 0) {
                    if (position == 0) {
                        z = true;
                    }
                } else if (i == this.items.size() - 1) {
                    if (position == getItemCount() - 1) {
                        z = true;
                    }
                } else if (position == 1) {
                    z = true;
                }
                holder.bind(camera, z);
                holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.adapters.VerticalTabAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VerticalTabAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, actualPosition, view);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(VerticalTabAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.items.isEmpty()) {
            return 0;
        }
        if (this.items.size() <= 3) {
            return this.items.size();
        }
        return 3;
    }

    private final int getActualPosition(int adapterPosition) {
        if (this.items.size() <= 3) {
            return adapterPosition;
        }
        if (adapterPosition == 0) {
            return getPreviousPosition(this.actualSelectedPosition);
        }
        if (adapterPosition == 1) {
            return this.actualSelectedPosition;
        }
        if (adapterPosition == 2) {
            return getNextPosition(this.actualSelectedPosition);
        }
        return this.actualSelectedPosition;
    }

    private final int getNextPosition(int current) {
        return this.items.size() - 1;
    }

    public final void submitList(List<Camera> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items = list;
        if (list.isEmpty()) {
            this.actualSelectedPosition = 0;
        } else {
            this.actualSelectedPosition = Math.min(this.actualSelectedPosition, this.items.size() - 1);
        }
        notifyDataSetChanged();
    }

    public final void selectItem(int actualPosition) {
        if (actualPosition >= 0) {
            try {
                if (actualPosition >= this.items.size() || this.actualSelectedPosition == actualPosition) {
                    return;
                }
                this.actualSelectedPosition = actualPosition;
                this.onTabSelected.invoke(Integer.valueOf(actualPosition));
                notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void select(int position) {
        selectItem(position);
    }

    public final void select(Camera item) {
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            Iterator<Camera> it = this.items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getUuid(), item.getUuid())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                selectItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: getSelectedPosition, reason: from getter */
    public final int getActualSelectedPosition() {
        return this.actualSelectedPosition;
    }

    public final void updateCameraState(Camera camera) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        try {
            Iterator<Camera> it = this.items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getUuid(), camera.getUuid())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.items.set(i, camera);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: VerticalTabAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/sputnik/common/adapters/VerticalTabAdapter$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tabIcon", "Landroid/widget/ImageView;", "bind", "", "item", "Lcom/sputnik/common/entities/camera/Camera;", "isSelected", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TabViewHolder extends RecyclerView.ViewHolder {
        private final ImageView tabIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.tabIcon = (ImageView) itemView.findViewById(R$id.iv_icon);
        }

        public final void bind(Camera item, boolean isSelected) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(item, "item");
            if (!isSelected) {
                ImageView imageView2 = this.tabIcon;
                if (imageView2 != null) {
                    imageView2.setImageResource(R$drawable.default_dot);
                    return;
                }
                return;
            }
            if (item.getIsLive() && isSelected) {
                ImageView imageView3 = this.tabIcon;
                if (imageView3 != null) {
                    imageView3.setImageResource(R$drawable.selected_live_dot);
                    return;
                }
                return;
            }
            if (item.getIsLive() || !isSelected || (imageView = this.tabIcon) == null) {
                return;
            }
            imageView.setImageResource(R$drawable.selected_dot);
        }
    }
}
