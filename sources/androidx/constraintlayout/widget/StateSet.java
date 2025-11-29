package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateSet {
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();

    public StateSet(Context context, XmlPullParser parser) throws XmlPullParserException, IOException {
        load(context, parser);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R$styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R$styleable.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r8.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r8.mDefaultState = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r1 = 0
        L2d:
            r3 = 1
            if (r0 == r3) goto La9
            if (r0 == 0) goto L9a
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L4b
            if (r0 == r5) goto L3c
            goto L9d
        L3c:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            boolean r0 = r4.equals(r0)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L9d
            return
        L47:
            r9 = move-exception
            goto La2
        L49:
            r9 = move-exception
            goto La6
        L4b:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            int r7 = r0.hashCode()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            switch(r7) {
                case 80204913: goto L72;
                case 1301459538: goto L68;
                case 1382829617: goto L61;
                case 1901439077: goto L57;
                default: goto L56;
            }     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
        L56:
            goto L7c
        L57:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r5
            goto L7d
        L61:
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            goto L7d
        L68:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r2
            goto L7d
        L72:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r6
            goto L7d
        L7c:
            r3 = -1
        L7d:
            if (r3 == r6) goto L8d
            if (r3 == r5) goto L82
            goto L9d
        L82:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r0.<init>(r9, r10)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r1 == 0) goto L9d
            r1.add(r0)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L9d
        L8d:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r1.<init>(r9, r10)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.mStateList     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            int r3 = r1.mId     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r0.put(r3, r1)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L9d
        L9a:
            r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
        L9d:
            int r0 = r10.next()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L2d
        La2:
            r9.printStackTrace()
            goto La9
        La6:
            r9.printStackTrace()
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int stateGetConstraintID(int id, int width, int height) {
        return updateConstraints(-1, id, width, height);
    }

    public int convertToConstraintSet(int currentConstrainSettId, int stateId, float width, float height) {
        State state = this.mStateList.get(stateId);
        if (state == null) {
            return stateId;
        }
        if (width == -1.0f || height == -1.0f) {
            if (state.mConstraintID == currentConstrainSettId) {
                return currentConstrainSettId;
            }
            Iterator<Variant> it = state.mVariants.iterator();
            while (it.hasNext()) {
                if (currentConstrainSettId == it.next().mConstraintID) {
                    return currentConstrainSettId;
                }
            }
            return state.mConstraintID;
        }
        Iterator<Variant> it2 = state.mVariants.iterator();
        Variant variant = null;
        while (it2.hasNext()) {
            Variant next = it2.next();
            if (next.match(width, height)) {
                if (currentConstrainSettId == next.mConstraintID) {
                    return currentConstrainSettId;
                }
                variant = next;
            }
        }
        if (variant != null) {
            return variant.mConstraintID;
        }
        return state.mConstraintID;
    }

    public int updateConstraints(int currentId, int id, float width, float height) {
        State stateValueAt;
        int iFindMatch;
        if (currentId != id) {
            State state = this.mStateList.get(id);
            if (state == null) {
                return -1;
            }
            int iFindMatch2 = state.findMatch(width, height);
            return iFindMatch2 == -1 ? state.mConstraintID : state.mVariants.get(iFindMatch2).mConstraintID;
        }
        if (id == -1) {
            stateValueAt = this.mStateList.valueAt(0);
        } else {
            stateValueAt = this.mStateList.get(this.mCurrentStateId);
        }
        if (stateValueAt == null) {
            return -1;
        }
        return ((this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(currentId).match(width, height)) && currentId != (iFindMatch = stateValueAt.findMatch(width, height))) ? iFindMatch == -1 ? stateValueAt.mConstraintID : stateValueAt.mVariants.get(iFindMatch).mConstraintID : currentId;
    }

    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser parser) throws Resources.NotFoundException {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.State_android_id) {
                    this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.State_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void add(Variant size) {
            this.mVariants.add(size);
        }

        public int findMatch(float width, float height) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(width, height)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser parser) throws Resources.NotFoundException {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Variant_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean match(float widthDp, float heightDp) {
            if (!Float.isNaN(this.mMinWidth) && widthDp < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && heightDp < this.mMinHeight) {
                return false;
            }
            if (Float.isNaN(this.mMaxWidth) || widthDp <= this.mMaxWidth) {
                return Float.isNaN(this.mMaxHeight) || heightDp <= this.mMaxHeight;
            }
            return false;
        }
    }
}
