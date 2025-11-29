package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.utils.LogUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.RecyclerViewCameraItemBinding;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;

/* compiled from: ManageCamerasAdapter.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004KLMNBm\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n¢\u0006\u0004\b&\u0010'J/\u0010+\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J/\u00102\u001a\u0002012\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R&\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00109R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010:\u001a\u0004\b=\u0010<R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010>\u001a\u0004\b?\u0010@R2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020Aj\b\u0012\u0004\u0012\u00020\u0002`B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010J¨\u0006O"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Lkotlin/Function1;", "", "", "saveOrderCallback", "", "maxActiveItems", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/sputnik/common/entities/camera/Camera;", "onItemClicked", "", "errorEmpty", "errorFull", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;", "adapterType", "<init>", "(Landroidx/recyclerview/widget/ItemTouchHelper;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/lang/String;Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;)V", "", "list", "submitList", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ItemViewHolder;", "holder", "position", "onBindViewHolder", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ItemViewHolder;I)V", RemoteMessageConst.FROM, RemoteMessageConst.TO, "moveItem", "(II)V", "", "needSaveOrder", "blockUpdatePreviousList", "notifyItems", "(Ljava/util/List;ZZ)V", "label", "printList", "(Ljava/util/List;Ljava/lang/String;)V", "_list", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "canMoveToFirstSection", "(IILjava/util/List;)Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/ItemTouchHelper;", "Lkotlin/jvm/functions/Function1;", "I", "Lkotlin/jvm/functions/Function2;", "Ljava/lang/String;", "getErrorEmpty", "()Ljava/lang/String;", "getErrorFull", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;", "getAdapterType", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "previousList", "Ljava/util/List;", "Z", "Companion", "ItemViewHolder", "ManageCamerasAdapterTypes", "MoveRestrictions", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageCamerasAdapter extends ListAdapter<ManageCamerasItem, ItemViewHolder> {
    private final ManageCamerasAdapterTypes adapterType;
    private boolean blockUpdatePreviousList;
    private final String errorEmpty;
    private final String errorFull;
    private final ItemTouchHelper itemTouchHelper;
    private ArrayList<ManageCamerasItem> list;
    private final int maxActiveItems;
    private final Function2<View, Camera, Unit> onItemClicked;
    private List<? extends ManageCamerasItem> previousList;
    private final Function1<List<? extends ManageCamerasItem>, Unit> saveOrderCallback;

    public final String getErrorEmpty() {
        return this.errorEmpty;
    }

    public final String getErrorFull() {
        return this.errorFull;
    }

    public final ManageCamerasAdapterTypes getAdapterType() {
        return this.adapterType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ManageCamerasAdapter(ItemTouchHelper itemTouchHelper, Function1<? super List<? extends ManageCamerasItem>, Unit> saveOrderCallback, int i, Function2<? super View, ? super Camera, Unit> onItemClicked, String str, String str2, ManageCamerasAdapterTypes adapterType) {
        super(new ManageCamerasDiffCallback());
        Intrinsics.checkNotNullParameter(itemTouchHelper, "itemTouchHelper");
        Intrinsics.checkNotNullParameter(saveOrderCallback, "saveOrderCallback");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(adapterType, "adapterType");
        this.itemTouchHelper = itemTouchHelper;
        this.saveOrderCallback = saveOrderCallback;
        this.maxActiveItems = i;
        this.onItemClicked = onItemClicked;
        this.errorEmpty = str;
        this.errorFull = str2;
        this.adapterType = adapterType;
        this.list = new ArrayList<>();
        this.previousList = new ArrayList();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ManageCamerasAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;", "", "(Ljava/lang/String;I)V", "MAIN_CAMERAS", "WIDGETS", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ManageCamerasAdapterTypes {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ManageCamerasAdapterTypes[] $VALUES;
        public static final ManageCamerasAdapterTypes MAIN_CAMERAS = new ManageCamerasAdapterTypes("MAIN_CAMERAS", 0);
        public static final ManageCamerasAdapterTypes WIDGETS = new ManageCamerasAdapterTypes("WIDGETS", 1);

        private static final /* synthetic */ ManageCamerasAdapterTypes[] $values() {
            return new ManageCamerasAdapterTypes[]{MAIN_CAMERAS, WIDGETS};
        }

        public static ManageCamerasAdapterTypes valueOf(String str) {
            return (ManageCamerasAdapterTypes) Enum.valueOf(ManageCamerasAdapterTypes.class, str);
        }

        public static ManageCamerasAdapterTypes[] values() {
            return (ManageCamerasAdapterTypes[]) $VALUES.clone();
        }

        private ManageCamerasAdapterTypes(String str, int i) {
        }

        static {
            ManageCamerasAdapterTypes[] manageCamerasAdapterTypesArr$values = $values();
            $VALUES = manageCamerasAdapterTypesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(manageCamerasAdapterTypesArr$values);
        }
    }

    public final ArrayList<ManageCamerasItem> getList() {
        return this.list;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<ManageCamerasItem> list) {
        LogUtilsKt.writeLog("GGGG: SUBMITTING LIST " + this.blockUpdatePreviousList);
        if (this.blockUpdatePreviousList) {
            List<ManageCamerasItem> currentList = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            this.previousList = currentList;
            this.blockUpdatePreviousList = false;
        }
        super.submitList(list);
        this.list = new ArrayList<>(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_camera_item, parent, false);
            Intrinsics.checkNotNull(viewDataBindingInflate);
            final ItemViewHolder itemViewHolder = new ItemViewHolder(viewDataBindingInflate);
            final RecyclerViewCameraItemBinding recyclerViewCameraItemBinding = (RecyclerViewCameraItemBinding) viewDataBindingInflate;
            recyclerViewCameraItemBinding.ivHamburger.setOnTouchListener(new View.OnTouchListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return ManageCamerasAdapter.onCreateViewHolder$lambda$4$lambda$3$lambda$0(this.f$0, itemViewHolder, view, motionEvent);
                }
            });
            itemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return ManageCamerasAdapter.onCreateViewHolder$lambda$4$lambda$3$lambda$1(this.f$0, itemViewHolder, view);
                }
            });
            recyclerViewCameraItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageCamerasAdapter.onCreateViewHolder$lambda$4$lambda$3$lambda$2(this.f$0, recyclerViewCameraItemBinding, itemViewHolder, view);
                }
            });
            return itemViewHolder;
        }
        ViewDataBinding viewDataBindingInflate2 = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_title_camera_item, parent, false);
        Intrinsics.checkNotNull(viewDataBindingInflate2);
        return new ItemViewHolder(viewDataBindingInflate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateViewHolder$lambda$4$lambda$3$lambda$0(ManageCamerasAdapter this$0, ItemViewHolder this_apply, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (motionEvent.getActionMasked() != 0) {
            return true;
        }
        this$0.itemTouchHelper.startDrag(this_apply);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateViewHolder$lambda$4$lambda$3$lambda$1(ManageCamerasAdapter this$0, ItemViewHolder this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.itemTouchHelper.startDrag(this_apply);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$4$lambda$3$lambda$2(ManageCamerasAdapter this$0, RecyclerViewCameraItemBinding this_run, ItemViewHolder this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Function2<View, Camera, Unit> function2 = this$0.onItemClicked;
        ImageView ivCameraImage = this_run.ivCameraImage;
        Intrinsics.checkNotNullExpressionValue(ivCameraImage, "ivCameraImage");
        ManageCamerasItem item = this$0.getItem(this_apply.getBindingAdapterPosition());
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem.ManageCamera");
        function2.invoke(ivCameraImage, ((ManageCamerasItem.ManageCamera) item).getItem());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ManageCamerasItem item = getItem(position);
        if (item != null) {
            holder.bindTo(item);
        }
    }

    public final void moveItem(int from, int to) {
        ManageCamerasItem item = getItem(from);
        ArrayList<ManageCamerasItem> arrayList = new ArrayList<>(getCurrentList());
        this.list = arrayList;
        arrayList.remove(from);
        this.list.add(to, item);
        notifyItems$default(this, this.list, false, true, 2, null);
    }

    public static /* synthetic */ void notifyItems$default(ManageCamerasAdapter manageCamerasAdapter, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        manageCamerasAdapter.notifyItems(list, z, z2);
    }

    public final void notifyItems(List<ManageCamerasItem> list, boolean needSaveOrder, boolean blockUpdatePreviousList) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.blockUpdatePreviousList = blockUpdatePreviousList;
        submitList(list);
        if (needSaveOrder) {
            this.saveOrderCallback.invoke(CollectionsKt.toList(list));
        }
    }

    public final void printList(List<? extends ManageCamerasItem> list, String label) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(label, "label");
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10));
        for (IndexedValue indexedValue : iterableWithIndex) {
            String str = indexedValue.getValue() instanceof ManageCamerasItem.ManageCamera ? "item" : FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE;
            arrayList.add(indexedValue.getIndex() + "-" + str);
        }
        LogUtilsKt.writeLog("GGGG: " + label + " " + arrayList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ManageCamerasAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "", "(Ljava/lang/String;I)V", "NONE", "EMPTY", "TOO_MUCH", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MoveRestrictions {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MoveRestrictions[] $VALUES;
        public static final MoveRestrictions NONE = new MoveRestrictions("NONE", 0);
        public static final MoveRestrictions EMPTY = new MoveRestrictions("EMPTY", 1);
        public static final MoveRestrictions TOO_MUCH = new MoveRestrictions("TOO_MUCH", 2);

        private static final /* synthetic */ MoveRestrictions[] $values() {
            return new MoveRestrictions[]{NONE, EMPTY, TOO_MUCH};
        }

        public static MoveRestrictions valueOf(String str) {
            return (MoveRestrictions) Enum.valueOf(MoveRestrictions.class, str);
        }

        public static MoveRestrictions[] values() {
            return (MoveRestrictions[]) $VALUES.clone();
        }

        private MoveRestrictions(String str, int i) {
        }

        static {
            MoveRestrictions[] moveRestrictionsArr$values = $values();
            $VALUES = moveRestrictionsArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(moveRestrictionsArr$values);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MoveRestrictions canMoveToFirstSection$default(ManageCamerasAdapter manageCamerasAdapter, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        return manageCamerasAdapter.canMoveToFirstSection(i, i2, list);
    }

    public final MoveRestrictions canMoveToFirstSection(int from, int to, List<? extends ManageCamerasItem> _list) {
        if (_list == null) {
            _list = this.list;
        }
        Iterable iterableWithIndex = CollectionsKt.withIndex(_list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterableWithIndex) {
            if (((IndexedValue) obj).getValue() instanceof ManageCamerasItem.ManageTitle) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((IndexedValue) it.next()).getIndex()));
        }
        printList(_list, "adapter");
        int i = 0;
        int iIntValue = ((Number) arrayList2.get(0)).intValue();
        int iIntValue2 = ((Number) arrayList2.get(1)).intValue();
        if (to == iIntValue2) {
            if (from < iIntValue2) {
                return MoveRestrictions.NONE;
            }
            List<? extends ManageCamerasItem> listSubList = _list.subList(iIntValue + 1, iIntValue2);
            if (!(listSubList instanceof Collection) || !listSubList.isEmpty()) {
                Iterator<T> it2 = listSubList.iterator();
                while (it2.hasNext()) {
                    if ((((ManageCamerasItem) it2.next()) instanceof ManageCamerasItem.ManageCamera) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            return i > this.maxActiveItems ? MoveRestrictions.TOO_MUCH : MoveRestrictions.NONE;
        }
        if (to <= iIntValue || to >= iIntValue2) {
            List<? extends ManageCamerasItem> listSubList2 = _list.subList(iIntValue + 1, iIntValue2);
            if (!(listSubList2 instanceof Collection) || !listSubList2.isEmpty()) {
                Iterator<T> it3 = listSubList2.iterator();
                while (it3.hasNext()) {
                    if ((((ManageCamerasItem) it3.next()) instanceof ManageCamerasItem.ManageCamera) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            return i < 1 ? MoveRestrictions.EMPTY : (from <= iIntValue || from >= iIntValue2 || (to > iIntValue && to < iIntValue2)) ? MoveRestrictions.NONE : MoveRestrictions.NONE;
        }
        if (from < iIntValue2 && from > iIntValue) {
            return MoveRestrictions.NONE;
        }
        List<? extends ManageCamerasItem> listSubList3 = _list.subList(iIntValue + 1, iIntValue2);
        if (!(listSubList3 instanceof Collection) || !listSubList3.isEmpty()) {
            Iterator<T> it4 = listSubList3.iterator();
            while (it4.hasNext()) {
                if ((((ManageCamerasItem) it4.next()) instanceof ManageCamerasItem.ManageCamera) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i > this.maxActiveItems ? MoveRestrictions.TOO_MUCH : MoveRestrictions.NONE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ManageCamerasItem item = getItem(position);
        if (item instanceof ManageCamerasItem.ManageCamera) {
            return 0;
        }
        if (item instanceof ManageCamerasItem.ManageTitle) {
            return 1;
        }
        throw new UnsupportedOperationException("Unknown view");
    }

    /* compiled from: ManageCamerasAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "binding", "<init>", "(Landroidx/databinding/ViewDataBinding;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "item", "", "bindTo", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;)V", "Landroidx/databinding/ViewDataBinding;", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bindTo(ManageCamerasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof ManageCamerasItem.ManageCamera) {
                this.binding.setVariable(1, ((ManageCamerasItem.ManageCamera) item).getItem());
            } else {
                this.binding.setVariable(1, ((ManageCamerasItem.ManageTitle) item).getTitle());
            }
            this.binding.executePendingBindings();
        }
    }
}
