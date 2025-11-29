package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout container) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void resolveRtl(ConstraintWidget widget, boolean isRtl) {
    }

    public void updatePostLayout(ConstraintLayout container) {
    }

    public void updatePostMeasure(ConstraintLayout container) {
    }

    public void updatePreDraw(ConstraintLayout container) {
    }

    public ConstraintHelper(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attrs) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attrs);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attrs);
    }

    protected void init(AttributeSet attrs) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] ids) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : ids) {
            addRscID(i);
        }
    }

    private void addRscID(int id) {
        if (id == getId()) {
            return;
        }
        int i = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i2 = this.mCount;
        iArr2[i2] = id;
        this.mCount = i2 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mUseViewMeasure) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).widget = (ConstraintWidget) this.mHelperWidget;
        }
    }

    private void addID(String idString) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (idString == null || idString.length() == 0 || this.myContext == null) {
            return;
        }
        String strTrim = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iFindId = findId(strTrim);
        if (iFindId != 0) {
            this.mMap.put(Integer.valueOf(iFindId), strTrim);
            addRscID(iFindId);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void addTag(String tagString) {
        if (tagString == null || tagString.length() == 0 || this.myContext == null) {
            return;
        }
        String strTrim = tagString.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    addRscID(childAt.getId());
                }
            }
        }
    }

    private int findId(String referenceId) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iFindId = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, referenceId);
            if (designInformation instanceof Integer) {
                iFindId = ((Integer) designInformation).intValue();
            }
        }
        if (iFindId == 0 && constraintLayout != null) {
            iFindId = findId(constraintLayout, referenceId);
        }
        if (iFindId == 0) {
            try {
                iFindId = R$id.class.getField(referenceId).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iFindId == 0 ? this.myContext.getResources().getIdentifier(referenceId, "id", this.myContext.getPackageName()) : iFindId;
    }

    private int findId(ConstraintLayout container, String idString) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (idString == null || container == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = container.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (idString.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    protected void setIds(String idList) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.mReferenceIds = idList;
        if (idList == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i);
            if (iIndexOf == -1) {
                addID(idList.substring(i));
                return;
            } else {
                addID(idList.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String tagList) {
        this.mReferenceTags = tagList;
        if (tagList == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int iIndexOf = tagList.indexOf(44, i);
            if (iIndexOf == -1) {
                addTag(tagList.substring(i));
                return;
            } else {
                addTag(tagList.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    protected void applyLayoutFeatures(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = container.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    public void updatePreLayout(ConstraintLayout container) {
        String str;
        int iFindId;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        Helper helper = this.mHelperWidget;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            int i2 = this.mIds[i];
            View viewById = container.getViewById(i2);
            if (viewById == null && (iFindId = findId(container, (str = this.mMap.get(Integer.valueOf(i2))))) != 0) {
                this.mIds[i] = iFindId;
                this.mMap.put(Integer.valueOf(iFindId), str);
                viewById = container.getViewById(iFindId);
            }
            if (viewById != null) {
                this.mHelperWidget.add(container.getViewWidget(viewById));
            }
        }
        this.mHelperWidget.updateConstraints(container.mLayoutWidget);
    }

    protected View[] getViews(ConstraintLayout layout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.mViews[i] = layout.getViewById(this.mIds[i]);
        }
        return this.mViews;
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null && this.mReferenceIds == null) {
            addRscID(key);
        }
    }
}
