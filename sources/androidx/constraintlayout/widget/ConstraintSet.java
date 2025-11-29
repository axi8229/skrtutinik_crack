package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintSet {
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static SparseIntArray mapToConstant = new SparseIntArray();
    private static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String mIdString;
    private boolean mValidate;
    public String derivedState = "";
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    static {
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R$styleable.Constraint_guidelineUseRtl, 99);
        mapToConstant.append(R$styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R$styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R$styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R$styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R$styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R$styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R$styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R$styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R$styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R$styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R$styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R$styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R$styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R$styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R$styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R$styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R$styleable.Constraint_drawPath, 66);
        mapToConstant.append(R$styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R$styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R$styleable.Constraint_android_id, 38);
        mapToConstant.append(R$styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R$styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R$styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R$styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R$styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R$styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R$styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R$styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = overrideMapToConstant;
        int i = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i, 6);
        overrideMapToConstant.append(i, 7);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public void readFallback(ConstraintSet set) {
        for (Integer num : set.mConstraints.keySet()) {
            num.intValue();
            Constraint constraint = set.mConstraints.get(num);
            if (!this.mConstraints.containsKey(num)) {
                this.mConstraints.put(num, new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                Transform transform = constraint.transform;
                if (!transform.mApply) {
                    transform.mApply = true;
                    transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != ConfigValue.DOUBLE_DEFAULT_VALUE || pivotY != ConfigValue.DOUBLE_DEFAULT_VALUE) {
                        Transform transform2 = constraint.transform;
                        transform2.transformPivotX = pivotX;
                        transform2.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform3 = constraint.transform;
                    if (transform3.applyElevation) {
                        transform3.elevation = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet cs) {
        for (Constraint constraint : cs.mConstraints.values()) {
            if (constraint.mDelta != null) {
                if (constraint.mTargetString != null) {
                    Iterator<Integer> it = this.mConstraints.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraint2 = getConstraint(it.next().intValue());
                        String str = constraint2.layout.mConstraintTag;
                        if (str != null && constraint.mTargetString.matches(str)) {
                            constraint.mDelta.applyDelta(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                } else {
                    constraint.mDelta.applyDelta(getConstraint(constraint.mViewId));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void parseDimensionConstraints(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L71
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L26
            r6 = -3
            if (r5 == r6) goto L20
            if (r5 == r0) goto L22
            r6 = -1
            if (r5 == r6) goto L22
        L20:
            r5 = r2
            goto L2f
        L22:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L2f
        L26:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L2f
        L2a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L22
        L2f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L41
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L3c
            r4.width = r2
            r4.constrainedWidth = r5
            goto L70
        L3c:
            r4.height = r2
            r4.constrainedHeight = r5
            goto L70
        L41:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r6 == 0) goto L53
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r4
            if (r7 != 0) goto L4e
            r4.mWidth = r2
            r4.constrainedWidth = r5
            goto L70
        L4e:
            r4.mHeight = r2
            r4.constrainedHeight = r5
            goto L70
        L53:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r6 == 0) goto L70
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r4 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r4
            if (r7 != 0) goto L66
            r6 = 23
            r4.add(r6, r2)
            r6 = 80
            r4.add(r6, r5)
            goto L70
        L66:
            r6 = 21
            r4.add(r6, r2)
            r6 = 81
            r4.add(r6, r5)
        L70:
            return
        L71:
            java.lang.String r5 = r5.getString(r6)
            parseDimensionConstraintsString(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.parseDimensionConstraints(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams params, String value) {
        float fAbs = Float.NaN;
        int i = -1;
        if (value != null) {
            int length = value.length();
            int iIndexOf = value.indexOf(44);
            int i2 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = value.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i = 1;
                }
                i2 = iIndexOf + 1;
            }
            int iIndexOf2 = value.indexOf(58);
            try {
                if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                    String strSubstring2 = value.substring(i2, iIndexOf2);
                    String strSubstring3 = value.substring(iIndexOf2 + 1);
                    if (strSubstring2.length() > 0 && strSubstring3.length() > 0) {
                        float f = Float.parseFloat(strSubstring2);
                        float f2 = Float.parseFloat(strSubstring3);
                        if (f > 0.0f && f2 > 0.0f) {
                            if (i == 1) {
                                fAbs = Math.abs(f2 / f);
                            } else {
                                fAbs = Math.abs(f / f2);
                            }
                        }
                    }
                } else {
                    String strSubstring4 = value.substring(i2);
                    if (strSubstring4.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        params.dimensionRatio = value;
        params.dimensionRatioValue = fAbs;
        params.dimensionRatioSide = i;
    }

    static void parseDimensionConstraintsString(Object data, String value, int orientation) throws NumberFormatException {
        if (value == null) {
            return;
        }
        int iIndexOf = value.indexOf(61);
        int length = value.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = value.substring(0, iIndexOf);
        String strSubstring2 = value.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (data instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) data;
                    if (orientation == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    parseDimensionRatioString(layoutParams, strTrim2);
                    return;
                }
                if (data instanceof Layout) {
                    ((Layout) data).dimensionRatio = strTrim2;
                    return;
                } else {
                    if (data instanceof Constraint.Delta) {
                        ((Constraint.Delta) data).add(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f = Float.parseFloat(strTrim2);
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.horizontalWeight = f;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.verticalWeight = f;
                        }
                    } else if (data instanceof Layout) {
                        Layout layout = (Layout) data;
                        if (orientation == 0) {
                            layout.mWidth = 0;
                            layout.horizontalWeight = f;
                        } else {
                            layout.mHeight = 0;
                            layout.verticalWeight = f;
                        }
                    } else if (data instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) data;
                        if (orientation == 0) {
                            delta.add(23, 0);
                            delta.add(39, f);
                        } else {
                            delta.add(21, 0);
                            delta.add(40, f);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.matchConstraintPercentWidth = fMax;
                            layoutParams3.matchConstraintDefaultWidth = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.matchConstraintPercentHeight = fMax;
                            layoutParams3.matchConstraintDefaultHeight = 2;
                        }
                    } else if (data instanceof Layout) {
                        Layout layout2 = (Layout) data;
                        if (orientation == 0) {
                            layout2.mWidth = 0;
                            layout2.widthPercent = fMax;
                            layout2.widthDefault = 2;
                        } else {
                            layout2.mHeight = 0;
                            layout2.heightPercent = fMax;
                            layout2.heightDefault = 2;
                        }
                    } else if (data instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) data;
                        if (orientation == 0) {
                            delta2.add(23, 0);
                            delta2.add(54, 2);
                        } else {
                            delta2.add(21, 0);
                            delta2.add(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static class Layout {
        private static SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public boolean mOverride = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int baselineToTop = -1;
        public int baselineToBottom = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = 0;
        public int rightMargin = 0;
        public int topMargin = 0;
        public int bottomMargin = 0;
        public int endMargin = 0;
        public int startMargin = 0;
        public int baselineMargin = 0;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = 0;
        public int heightMax = 0;
        public int widthMin = 0;
        public int heightMin = 0;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mWrapBehavior = 0;

        public void copyFrom(Layout src) {
            this.mIsGuideline = src.mIsGuideline;
            this.mWidth = src.mWidth;
            this.mApply = src.mApply;
            this.mHeight = src.mHeight;
            this.guideBegin = src.guideBegin;
            this.guideEnd = src.guideEnd;
            this.guidePercent = src.guidePercent;
            this.guidelineUseRtl = src.guidelineUseRtl;
            this.leftToLeft = src.leftToLeft;
            this.leftToRight = src.leftToRight;
            this.rightToLeft = src.rightToLeft;
            this.rightToRight = src.rightToRight;
            this.topToTop = src.topToTop;
            this.topToBottom = src.topToBottom;
            this.bottomToTop = src.bottomToTop;
            this.bottomToBottom = src.bottomToBottom;
            this.baselineToBaseline = src.baselineToBaseline;
            this.baselineToTop = src.baselineToTop;
            this.baselineToBottom = src.baselineToBottom;
            this.startToEnd = src.startToEnd;
            this.startToStart = src.startToStart;
            this.endToStart = src.endToStart;
            this.endToEnd = src.endToEnd;
            this.horizontalBias = src.horizontalBias;
            this.verticalBias = src.verticalBias;
            this.dimensionRatio = src.dimensionRatio;
            this.circleConstraint = src.circleConstraint;
            this.circleRadius = src.circleRadius;
            this.circleAngle = src.circleAngle;
            this.editorAbsoluteX = src.editorAbsoluteX;
            this.editorAbsoluteY = src.editorAbsoluteY;
            this.orientation = src.orientation;
            this.leftMargin = src.leftMargin;
            this.rightMargin = src.rightMargin;
            this.topMargin = src.topMargin;
            this.bottomMargin = src.bottomMargin;
            this.endMargin = src.endMargin;
            this.startMargin = src.startMargin;
            this.baselineMargin = src.baselineMargin;
            this.goneLeftMargin = src.goneLeftMargin;
            this.goneTopMargin = src.goneTopMargin;
            this.goneRightMargin = src.goneRightMargin;
            this.goneBottomMargin = src.goneBottomMargin;
            this.goneEndMargin = src.goneEndMargin;
            this.goneStartMargin = src.goneStartMargin;
            this.goneBaselineMargin = src.goneBaselineMargin;
            this.verticalWeight = src.verticalWeight;
            this.horizontalWeight = src.horizontalWeight;
            this.horizontalChainStyle = src.horizontalChainStyle;
            this.verticalChainStyle = src.verticalChainStyle;
            this.widthDefault = src.widthDefault;
            this.heightDefault = src.heightDefault;
            this.widthMax = src.widthMax;
            this.heightMax = src.heightMax;
            this.widthMin = src.widthMin;
            this.heightMin = src.heightMin;
            this.widthPercent = src.widthPercent;
            this.heightPercent = src.heightPercent;
            this.mBarrierDirection = src.mBarrierDirection;
            this.mBarrierMargin = src.mBarrierMargin;
            this.mHelperType = src.mHelperType;
            this.mConstraintTag = src.mConstraintTag;
            int[] iArr = src.mReferenceIds;
            if (iArr != null && src.mReferenceIdString == null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = src.mReferenceIdString;
            this.constrainedWidth = src.constrainedWidth;
            this.constrainedHeight = src.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = src.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = src.mWrapBehavior;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R$styleable.Layout_guidelineUseRtl, 90);
            mapToConstant.append(R$styleable.Layout_android_orientation, 26);
            mapToConstant.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            mapToConstant.append(R$styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R$styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R$styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R$styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R$styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R$styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R$styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R$styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R$styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R$styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R$styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R$styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R$styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R$styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R$styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R$styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.Layout);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                int i2 = mapToConstant.get(index);
                switch (i2) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = typedArrayObtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.parseDimensionConstraints(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.parseDimensionConstraints(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.circleConstraint = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.circleConstraint);
                                break;
                            case 62:
                                this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                break;
                            case 63:
                                this.circleAngle = typedArrayObtainStyledAttributes.getFloat(index, this.circleAngle);
                                break;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.widthPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.heightPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.mBarrierDirection = typedArrayObtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        break;
                                    case 73:
                                        this.mBarrierMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        break;
                                    case 74:
                                        this.mReferenceIdString = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = typedArrayObtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        break;
                                    case 76:
                                        this.mWrapBehavior = typedArrayObtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        break;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToTop);
                                        break;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToBottom);
                                        break;
                                    case 79:
                                        this.goneBaselineMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        break;
                                    case 80:
                                        this.baselineMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        break;
                                    case 81:
                                        this.widthDefault = typedArrayObtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 82:
                                        this.heightDefault = typedArrayObtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 83:
                                        this.heightMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 84:
                                        this.widthMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 85:
                                        this.heightMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    case 86:
                                        this.widthMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 87:
                                        this.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        break;
                                    case 88:
                                        this.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        break;
                                    case 89:
                                        this.mConstraintTag = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.guidelineUseRtl = typedArrayObtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        public void copyFrom(Transform src) {
            this.mApply = src.mApply;
            this.rotation = src.rotation;
            this.rotationX = src.rotationX;
            this.rotationY = src.rotationY;
            this.scaleX = src.scaleX;
            this.scaleY = src.scaleY;
            this.transformPivotX = src.transformPivotX;
            this.transformPivotY = src.transformPivotY;
            this.transformPivotTarget = src.transformPivotTarget;
            this.translationX = src.translationX;
            this.translationY = src.translationY;
            this.translationZ = src.translationZ;
            this.applyElevation = src.applyElevation;
            this.elevation = src.elevation;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            mapToConstant.append(R$styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R$styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R$styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R$styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R$styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R$styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R$styleable.Transform_android_translationX, 8);
            mapToConstant.append(R$styleable.Transform_android_translationY, 9);
            mapToConstant.append(R$styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R$styleable.Transform_android_elevation, 11);
            mapToConstant.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.Transform);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = typedArrayObtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = typedArrayObtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = typedArrayObtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = typedArrayObtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = typedArrayObtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = typedArrayObtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = typedArrayObtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = typedArrayObtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = typedArrayObtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet src) {
            this.mApply = src.mApply;
            this.visibility = src.visibility;
            this.alpha = src.alpha;
            this.mProgress = src.mProgress;
            this.mVisibilityMode = src.mVisibilityMode;
        }

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.PropertySet);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.alpha = typedArrayObtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.visibility = typedArrayObtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = typedArrayObtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.mProgress = typedArrayObtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;

        public void copyFrom(Motion src) {
            this.mApply = src.mApply;
            this.mAnimateRelativeTo = src.mAnimateRelativeTo;
            this.mTransitionEasing = src.mTransitionEasing;
            this.mPathMotionArc = src.mPathMotionArc;
            this.mDrawPath = src.mDrawPath;
            this.mPathRotate = src.mPathRotate;
            this.mMotionStagger = src.mMotionStagger;
            this.mPolarRelativeTo = src.mPolarRelativeTo;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R$styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R$styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R$styleable.Motion_drawPath, 4);
            mapToConstant.append(R$styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R$styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R$styleable.Motion_motionStagger, 7);
            mapToConstant.append(R$styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R$styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.Motion);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = typedArrayObtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = typedArrayObtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = typedArrayObtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = typedArrayObtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = typedArrayObtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.mQuantizeInterpolatorString = string;
                            if (string.indexOf("/") > 0) {
                                this.mQuantizeInterpolatorID = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -1;
                                break;
                            }
                        } else {
                            this.mQuantizeInterpolatorType = typedArrayObtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Constraint {
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        static class Delta {
            int[] mTypeInt = new int[10];
            int[] mValueInt = new int[10];
            int mCountInt = 0;
            int[] mTypeFloat = new int[10];
            float[] mValueFloat = new float[10];
            int mCountFloat = 0;
            int[] mTypeString = new int[5];
            String[] mValueString = new String[5];
            int mCountString = 0;
            int[] mTypeBoolean = new int[4];
            boolean[] mValueBoolean = new boolean[4];
            int mCountBoolean = 0;

            Delta() {
            }

            void add(int type, int value) {
                int i = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i2 = this.mCountInt;
                iArr3[i2] = type;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i2 + 1;
                iArr4[i2] = value;
            }

            void add(int type, float value) {
                int i = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i2 = this.mCountFloat;
                iArr2[i2] = type;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i2 + 1;
                fArr2[i2] = value;
            }

            void add(int type, String value) {
                int i = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i2 = this.mCountString;
                iArr2[i2] = type;
                String[] strArr2 = this.mValueString;
                this.mCountString = i2 + 1;
                strArr2[i2] = value;
            }

            void add(int type, boolean value) {
                int i = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i2 = this.mCountBoolean;
                iArr2[i2] = type;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i2 + 1;
                zArr2[i2] = value;
            }

            void applyDelta(Constraint c) {
                for (int i = 0; i < this.mCountInt; i++) {
                    ConstraintSet.setDeltaValue(c, this.mTypeInt[i], this.mValueInt[i]);
                }
                for (int i2 = 0; i2 < this.mCountFloat; i2++) {
                    ConstraintSet.setDeltaValue(c, this.mTypeFloat[i2], this.mValueFloat[i2]);
                }
                for (int i3 = 0; i3 < this.mCountString; i3++) {
                    ConstraintSet.setDeltaValue(c, this.mTypeString[i3], this.mValueString[i3]);
                }
                for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
                    ConstraintSet.setDeltaValue(c, this.mTypeBoolean[i4], this.mValueBoolean[i4]);
                }
            }
        }

        public void applyDelta(Constraint c) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.applyDelta(c);
            }
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Constraint m2213clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper helper, int viewId, Constraints.LayoutParams param) {
            fillFromConstraints(viewId, param);
            if (helper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) helper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int viewId, Constraints.LayoutParams param) {
            fillFrom(viewId, param);
            this.propertySet.alpha = param.alpha;
            Transform transform = this.transform;
            transform.rotation = param.rotation;
            transform.rotationX = param.rotationX;
            transform.rotationY = param.rotationY;
            transform.scaleX = param.scaleX;
            transform.scaleY = param.scaleY;
            transform.transformPivotX = param.transformPivotX;
            transform.transformPivotY = param.transformPivotY;
            transform.translationX = param.translationX;
            transform.translationY = param.translationY;
            transform.translationZ = param.translationZ;
            transform.elevation = param.elevation;
            transform.applyElevation = param.applyElevation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int viewId, ConstraintLayout.LayoutParams param) {
            this.mViewId = viewId;
            Layout layout = this.layout;
            layout.leftToLeft = param.leftToLeft;
            layout.leftToRight = param.leftToRight;
            layout.rightToLeft = param.rightToLeft;
            layout.rightToRight = param.rightToRight;
            layout.topToTop = param.topToTop;
            layout.topToBottom = param.topToBottom;
            layout.bottomToTop = param.bottomToTop;
            layout.bottomToBottom = param.bottomToBottom;
            layout.baselineToBaseline = param.baselineToBaseline;
            layout.baselineToTop = param.baselineToTop;
            layout.baselineToBottom = param.baselineToBottom;
            layout.startToEnd = param.startToEnd;
            layout.startToStart = param.startToStart;
            layout.endToStart = param.endToStart;
            layout.endToEnd = param.endToEnd;
            layout.horizontalBias = param.horizontalBias;
            layout.verticalBias = param.verticalBias;
            layout.dimensionRatio = param.dimensionRatio;
            layout.circleConstraint = param.circleConstraint;
            layout.circleRadius = param.circleRadius;
            layout.circleAngle = param.circleAngle;
            layout.editorAbsoluteX = param.editorAbsoluteX;
            layout.editorAbsoluteY = param.editorAbsoluteY;
            layout.orientation = param.orientation;
            layout.guidePercent = param.guidePercent;
            layout.guideBegin = param.guideBegin;
            layout.guideEnd = param.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) param).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) param).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) param).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            layout.baselineMargin = param.baselineMargin;
            layout.verticalWeight = param.verticalWeight;
            layout.horizontalWeight = param.horizontalWeight;
            layout.verticalChainStyle = param.verticalChainStyle;
            layout.horizontalChainStyle = param.horizontalChainStyle;
            layout.constrainedWidth = param.constrainedWidth;
            layout.constrainedHeight = param.constrainedHeight;
            layout.widthDefault = param.matchConstraintDefaultWidth;
            layout.heightDefault = param.matchConstraintDefaultHeight;
            layout.widthMax = param.matchConstraintMaxWidth;
            layout.heightMax = param.matchConstraintMaxHeight;
            layout.widthMin = param.matchConstraintMinWidth;
            layout.heightMin = param.matchConstraintMinHeight;
            layout.widthPercent = param.matchConstraintPercentWidth;
            layout.heightPercent = param.matchConstraintPercentHeight;
            layout.mConstraintTag = param.constraintTag;
            layout.goneTopMargin = param.goneTopMargin;
            layout.goneBottomMargin = param.goneBottomMargin;
            layout.goneLeftMargin = param.goneLeftMargin;
            layout.goneRightMargin = param.goneRightMargin;
            layout.goneStartMargin = param.goneStartMargin;
            layout.goneEndMargin = param.goneEndMargin;
            layout.goneBaselineMargin = param.goneBaselineMargin;
            layout.mWrapBehavior = param.wrapBehaviorInParent;
            layout.endMargin = param.getMarginEnd();
            this.layout.startMargin = param.getMarginStart();
        }

        public void applyTo(ConstraintLayout.LayoutParams param) {
            Layout layout = this.layout;
            param.leftToLeft = layout.leftToLeft;
            param.leftToRight = layout.leftToRight;
            param.rightToLeft = layout.rightToLeft;
            param.rightToRight = layout.rightToRight;
            param.topToTop = layout.topToTop;
            param.topToBottom = layout.topToBottom;
            param.bottomToTop = layout.bottomToTop;
            param.bottomToBottom = layout.bottomToBottom;
            param.baselineToBaseline = layout.baselineToBaseline;
            param.baselineToTop = layout.baselineToTop;
            param.baselineToBottom = layout.baselineToBottom;
            param.startToEnd = layout.startToEnd;
            param.startToStart = layout.startToStart;
            param.endToStart = layout.endToStart;
            param.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) param).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = layout.bottomMargin;
            param.goneStartMargin = layout.goneStartMargin;
            param.goneEndMargin = layout.goneEndMargin;
            param.goneTopMargin = layout.goneTopMargin;
            param.goneBottomMargin = layout.goneBottomMargin;
            param.horizontalBias = layout.horizontalBias;
            param.verticalBias = layout.verticalBias;
            param.circleConstraint = layout.circleConstraint;
            param.circleRadius = layout.circleRadius;
            param.circleAngle = layout.circleAngle;
            param.dimensionRatio = layout.dimensionRatio;
            param.editorAbsoluteX = layout.editorAbsoluteX;
            param.editorAbsoluteY = layout.editorAbsoluteY;
            param.verticalWeight = layout.verticalWeight;
            param.horizontalWeight = layout.horizontalWeight;
            param.verticalChainStyle = layout.verticalChainStyle;
            param.horizontalChainStyle = layout.horizontalChainStyle;
            param.constrainedWidth = layout.constrainedWidth;
            param.constrainedHeight = layout.constrainedHeight;
            param.matchConstraintDefaultWidth = layout.widthDefault;
            param.matchConstraintDefaultHeight = layout.heightDefault;
            param.matchConstraintMaxWidth = layout.widthMax;
            param.matchConstraintMaxHeight = layout.heightMax;
            param.matchConstraintMinWidth = layout.widthMin;
            param.matchConstraintMinHeight = layout.heightMin;
            param.matchConstraintPercentWidth = layout.widthPercent;
            param.matchConstraintPercentHeight = layout.heightPercent;
            param.orientation = layout.orientation;
            param.guidePercent = layout.guidePercent;
            param.guideBegin = layout.guideBegin;
            param.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) param).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) param).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                param.constraintTag = str;
            }
            param.wrapBehaviorInParent = layout.mWrapBehavior;
            param.setMarginStart(layout.startMargin);
            param.setMarginEnd(this.layout.endMargin);
            param.validate();
        }
    }

    public void clone(Context context, int constraintLayoutId) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void clone(ConstraintSet set) {
        this.mConstraints.clear();
        for (Integer num : set.mConstraints.keySet()) {
            Constraint constraint = set.mConstraints.get(num);
            if (constraint != null) {
                this.mConstraints.put(num, constraint.m2213clone());
            }
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                constraint.fillFrom(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != ConfigValue.DOUBLE_DEFAULT_VALUE || pivotY != ConfigValue.DOUBLE_DEFAULT_VALUE) {
                    Transform transform = constraint.transform;
                    transform.transformPivotX = pivotX;
                    transform.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform2 = constraint.transform;
                if (transform2.applyElevation) {
                    transform2.elevation = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.fillFromConstraints(id, layoutParams);
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            } else {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt));
            }
        }
    }

    void applyToInternal(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.validate();
                            constraint.applyTo(layoutParams);
                            if (applyPostLayout) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            childAt.setAlpha(constraint.propertySet.alpha);
                            childAt.setRotation(constraint.transform.rotation);
                            childAt.setRotationX(constraint.transform.rotationX);
                            childAt.setRotationY(constraint.transform.rotationY);
                            childAt.setScaleX(constraint.transform.scaleX);
                            childAt.setScaleY(constraint.transform.scaleY);
                            Transform transform = constraint.transform;
                            if (transform.transformPivotTarget != -1) {
                                if (((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.transformPivotX)) {
                                    childAt.setPivotX(constraint.transform.transformPivotX);
                                }
                                if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                    childAt.setPivotY(constraint.transform.transformPivotY);
                                }
                            }
                            childAt.setTranslationX(constraint.transform.translationX);
                            childAt.setTranslationY(constraint.transform.translationY);
                            childAt.setTranslationZ(constraint.transform.translationZ);
                            Transform transform2 = constraint.transform;
                            if (transform2.applyElevation) {
                                childAt.setElevation(transform2.elevation);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            } else {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt));
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void connect(int startID, int startSide, int endID, int endSide, int margin) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        if (constraint == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.leftMargin = margin;
                return;
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                }
                constraint.layout.rightMargin = margin;
                return;
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = endID;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                }
                constraint.layout.topMargin = margin;
                return;
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                } else {
                    if (endSide != 3) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = endID;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                }
                constraint.layout.bottomMargin = margin;
                return;
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (endSide == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = endID;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = endID;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (endSide == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = endID;
                    layout12.startToEnd = -1;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = endID;
                    layout13.startToStart = -1;
                }
                constraint.layout.startMargin = margin;
                return;
            case 7:
                if (endSide == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = endID;
                    layout14.endToStart = -1;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = endID;
                    layout15.endToEnd = -1;
                }
                constraint.layout.endMargin = margin;
                return;
            default:
                throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
        }
    }

    public void connect(int startID, int startSide, int endID, int endSide) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        if (constraint == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                    return;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + sideToString(endSide) + " undefined");
                }
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                    return;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                    return;
                }
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                Layout layout6 = constraint.layout;
                layout6.topToBottom = endID;
                layout6.topToTop = -1;
                layout6.baselineToBaseline = -1;
                layout6.baselineToTop = -1;
                layout6.baselineToBottom = -1;
                return;
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                    return;
                }
                if (endSide != 3) {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                Layout layout8 = constraint.layout;
                layout8.bottomToTop = endID;
                layout8.bottomToBottom = -1;
                layout8.baselineToBaseline = -1;
                layout8.baselineToTop = -1;
                layout8.baselineToBottom = -1;
                return;
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (endSide == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = endID;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = endID;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (endSide == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = endID;
                    layout12.startToEnd = -1;
                    return;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = endID;
                    layout13.startToStart = -1;
                    return;
                }
            case 7:
                if (endSide == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = endID;
                    layout14.endToStart = -1;
                    return;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = endID;
                    layout15.endToEnd = -1;
                    return;
                }
            default:
                throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
        }
    }

    public void clear(int viewId, int anchor) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(viewId)) || (constraint = this.mConstraints.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        switch (anchor) {
            case 1:
                Layout layout = constraint.layout;
                layout.leftToRight = -1;
                layout.leftToLeft = -1;
                layout.leftMargin = -1;
                layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.layout;
                layout2.rightToRight = -1;
                layout2.rightToLeft = -1;
                layout2.rightMargin = -1;
                layout2.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.layout;
                layout3.topToBottom = -1;
                layout3.topToTop = -1;
                layout3.topMargin = 0;
                layout3.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.layout;
                layout4.bottomToTop = -1;
                layout4.bottomToBottom = -1;
                layout4.bottomMargin = 0;
                layout4.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.layout;
                layout5.baselineToBaseline = -1;
                layout5.baselineToTop = -1;
                layout5.baselineToBottom = -1;
                layout5.baselineMargin = 0;
                layout5.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.layout;
                layout6.startToEnd = -1;
                layout6.startToStart = -1;
                layout6.startMargin = 0;
                layout6.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.layout;
                layout7.endToStart = -1;
                layout7.endToEnd = -1;
                layout7.endMargin = 0;
                layout7.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.layout;
                layout8.circleAngle = -1.0f;
                layout8.circleRadius = -1;
                layout8.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void constrainWidth(int viewId, int width) {
        get(viewId).layout.mWidth = width;
    }

    public void constrainCircle(int viewId, int id, int radius, float angle) {
        Layout layout = get(viewId).layout;
        layout.circleConstraint = id;
        layout.circleRadius = radius;
        layout.circleAngle = angle;
    }

    private Constraint get(int id) {
        if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
            this.mConstraints.put(Integer.valueOf(id), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(id));
    }

    private String sideToString(int side) {
        switch (side) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void load(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintFillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cf, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(TypedArray a, int index, int def) {
        int resourceId = a.getResourceId(index, def);
        return resourceId == -1 ? a.getInt(index, -1) : resourceId;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attrs, boolean override) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, override ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        populateConstraint(context, constraint, typedArrayObtainStyledAttributes, override);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    public static Constraint buildDelta(Context context, XmlPullParser parser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(parser);
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R$styleable.ConstraintOverride);
        populateOverride(context, constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    private static void populateOverride(Context ctx, Constraint c, TypedArray a) {
        int indexCount = a.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        c.mDelta = delta;
        c.motion.mApply = false;
        c.layout.mApply = false;
        c.propertySet.mApply = false;
        c.transform.mApply = false;
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, a.getDimensionPixelSize(index, c.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 5:
                    delta.add(5, a.getString(index));
                    break;
                case 6:
                    delta.add(6, a.getDimensionPixelOffset(index, c.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, a.getDimensionPixelOffset(index, c.layout.editorAbsoluteY));
                    break;
                case 8:
                    delta.add(8, a.getDimensionPixelSize(index, c.layout.endMargin));
                    break;
                case 11:
                    delta.add(11, a.getDimensionPixelSize(index, c.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, a.getDimensionPixelSize(index, c.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, a.getDimensionPixelSize(index, c.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, a.getDimensionPixelSize(index, c.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, a.getDimensionPixelSize(index, c.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, a.getDimensionPixelSize(index, c.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, a.getDimensionPixelOffset(index, c.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, a.getDimensionPixelOffset(index, c.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, a.getFloat(index, c.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, a.getFloat(index, c.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, a.getLayoutDimension(index, c.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[a.getInt(index, c.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, a.getLayoutDimension(index, c.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, a.getDimensionPixelSize(index, c.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, a.getInt(index, c.layout.orientation));
                    break;
                case 28:
                    delta.add(28, a.getDimensionPixelSize(index, c.layout.rightMargin));
                    break;
                case 31:
                    delta.add(31, a.getDimensionPixelSize(index, c.layout.startMargin));
                    break;
                case 34:
                    delta.add(34, a.getDimensionPixelSize(index, c.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, a.getFloat(index, c.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = a.getResourceId(index, c.mViewId);
                    c.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, a.getFloat(index, c.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, a.getFloat(index, c.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, a.getInt(index, c.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, a.getInt(index, c.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, a.getFloat(index, c.propertySet.alpha));
                    break;
                case 44:
                    delta.add(44, true);
                    delta.add(44, a.getDimension(index, c.transform.elevation));
                    break;
                case 45:
                    delta.add(45, a.getFloat(index, c.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, a.getFloat(index, c.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, a.getFloat(index, c.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, a.getFloat(index, c.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, a.getDimension(index, c.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, a.getDimension(index, c.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, a.getDimension(index, c.transform.translationX));
                    break;
                case 52:
                    delta.add(52, a.getDimension(index, c.transform.translationY));
                    break;
                case 53:
                    delta.add(53, a.getDimension(index, c.transform.translationZ));
                    break;
                case 54:
                    delta.add(54, a.getInt(index, c.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, a.getInt(index, c.layout.heightDefault));
                    break;
                case 56:
                    delta.add(56, a.getDimensionPixelSize(index, c.layout.widthMax));
                    break;
                case 57:
                    delta.add(57, a.getDimensionPixelSize(index, c.layout.heightMax));
                    break;
                case 58:
                    delta.add(58, a.getDimensionPixelSize(index, c.layout.widthMin));
                    break;
                case 59:
                    delta.add(59, a.getDimensionPixelSize(index, c.layout.heightMin));
                    break;
                case 60:
                    delta.add(60, a.getFloat(index, c.transform.rotation));
                    break;
                case 62:
                    delta.add(62, a.getDimensionPixelSize(index, c.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, a.getFloat(index, c.layout.circleAngle));
                    break;
                case 64:
                    delta.add(64, lookupID(a, index, c.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (a.peekValue(index).type == 3) {
                        delta.add(65, a.getString(index));
                        break;
                    } else {
                        delta.add(65, Easing.NAMED_EASING[a.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    delta.add(66, a.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, a.getFloat(index, c.motion.mPathRotate));
                    break;
                case 68:
                    delta.add(68, a.getFloat(index, c.propertySet.mProgress));
                    break;
                case 69:
                    delta.add(69, a.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.add(70, a.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.add(72, a.getInt(index, c.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.add(73, a.getDimensionPixelSize(index, c.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.add(74, a.getString(index));
                    break;
                case 75:
                    delta.add(75, a.getBoolean(index, c.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, a.getInt(index, c.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.add(77, a.getString(index));
                    break;
                case 78:
                    delta.add(78, a.getInt(index, c.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.add(79, a.getFloat(index, c.motion.mMotionStagger));
                    break;
                case 80:
                    delta.add(80, a.getBoolean(index, c.layout.constrainedWidth));
                    break;
                case 81:
                    delta.add(81, a.getBoolean(index, c.layout.constrainedHeight));
                    break;
                case 82:
                    delta.add(82, a.getInteger(index, c.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.add(83, lookupID(a, index, c.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.add(84, a.getInteger(index, c.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.add(85, a.getFloat(index, c.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i2 = a.peekValue(index).type;
                    if (i2 == 1) {
                        c.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                        delta.add(89, c.motion.mQuantizeInterpolatorID);
                        Motion motion = c.motion;
                        if (motion.mQuantizeInterpolatorID != -1) {
                            motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        c.motion.mQuantizeInterpolatorString = a.getString(index);
                        delta.add(90, c.motion.mQuantizeInterpolatorString);
                        if (c.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                            c.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                            delta.add(89, c.motion.mQuantizeInterpolatorID);
                            c.motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            c.motion.mQuantizeInterpolatorType = -1;
                            delta.add(88, -1);
                            break;
                        }
                    } else {
                        Motion motion2 = c.motion;
                        motion2.mQuantizeInterpolatorType = a.getInteger(index, motion2.mQuantizeInterpolatorID);
                        delta.add(88, c.motion.mQuantizeInterpolatorType);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 93:
                    delta.add(93, a.getDimensionPixelSize(index, c.layout.baselineMargin));
                    break;
                case 94:
                    delta.add(94, a.getDimensionPixelSize(index, c.layout.goneBaselineMargin));
                    break;
                case 95:
                    parseDimensionConstraints(delta, a, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(delta, a, index, 1);
                    break;
                case 97:
                    delta.add(97, a.getInt(index, c.layout.mWrapBehavior));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = a.getResourceId(index, c.mViewId);
                        c.mViewId = resourceId2;
                        if (resourceId2 == -1) {
                            c.mTargetString = a.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (a.peekValue(index).type == 3) {
                        c.mTargetString = a.getString(index);
                        break;
                    } else {
                        c.mViewId = a.getResourceId(index, c.mViewId);
                        break;
                    }
                case 99:
                    delta.add(99, a.getBoolean(index, c.layout.guidelineUseRtl));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c, int type, float value) {
        if (type == 19) {
            c.layout.guidePercent = value;
            return;
        }
        if (type == 20) {
            c.layout.horizontalBias = value;
            return;
        }
        if (type == 37) {
            c.layout.verticalBias = value;
            return;
        }
        if (type == 60) {
            c.transform.rotation = value;
            return;
        }
        if (type == 63) {
            c.layout.circleAngle = value;
            return;
        }
        if (type == 79) {
            c.motion.mMotionStagger = value;
            return;
        }
        if (type == 85) {
            c.motion.mQuantizeMotionPhase = value;
            return;
        }
        if (type != 87) {
            if (type == 39) {
                c.layout.horizontalWeight = value;
                return;
            }
            if (type != 40) {
                switch (type) {
                    case 43:
                        c.propertySet.alpha = value;
                        break;
                    case 44:
                        Transform transform = c.transform;
                        transform.elevation = value;
                        transform.applyElevation = true;
                        break;
                    case 45:
                        c.transform.rotationX = value;
                        break;
                    case 46:
                        c.transform.rotationY = value;
                        break;
                    case 47:
                        c.transform.scaleX = value;
                        break;
                    case 48:
                        c.transform.scaleY = value;
                        break;
                    case 49:
                        c.transform.transformPivotX = value;
                        break;
                    case 50:
                        c.transform.transformPivotY = value;
                        break;
                    case 51:
                        c.transform.translationX = value;
                        break;
                    case 52:
                        c.transform.translationY = value;
                        break;
                    case 53:
                        c.transform.translationZ = value;
                        break;
                    default:
                        switch (type) {
                            case 67:
                                c.motion.mPathRotate = value;
                                break;
                            case 68:
                                c.propertySet.mProgress = value;
                                break;
                            case 69:
                                c.layout.widthPercent = value;
                                break;
                            case 70:
                                c.layout.heightPercent = value;
                                break;
                            default:
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                break;
                        }
                }
                return;
            }
            c.layout.verticalWeight = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c, int type, int value) {
        if (type == 6) {
            c.layout.editorAbsoluteX = value;
            return;
        }
        if (type == 7) {
            c.layout.editorAbsoluteY = value;
            return;
        }
        if (type == 8) {
            c.layout.endMargin = value;
            return;
        }
        if (type == 27) {
            c.layout.orientation = value;
            return;
        }
        if (type == 28) {
            c.layout.rightMargin = value;
            return;
        }
        if (type == 41) {
            c.layout.horizontalChainStyle = value;
            return;
        }
        if (type == 42) {
            c.layout.verticalChainStyle = value;
            return;
        }
        if (type == 61) {
            c.layout.circleConstraint = value;
            return;
        }
        if (type == 62) {
            c.layout.circleRadius = value;
            return;
        }
        if (type == 72) {
            c.layout.mBarrierDirection = value;
            return;
        }
        if (type != 73) {
            switch (type) {
                case 2:
                    c.layout.bottomMargin = value;
                    break;
                case 11:
                    c.layout.goneBottomMargin = value;
                    break;
                case 12:
                    c.layout.goneEndMargin = value;
                    break;
                case 13:
                    c.layout.goneLeftMargin = value;
                    break;
                case 14:
                    c.layout.goneRightMargin = value;
                    break;
                case 15:
                    c.layout.goneStartMargin = value;
                    break;
                case 16:
                    c.layout.goneTopMargin = value;
                    break;
                case 17:
                    c.layout.guideBegin = value;
                    break;
                case 18:
                    c.layout.guideEnd = value;
                    break;
                case 31:
                    c.layout.startMargin = value;
                    break;
                case 34:
                    c.layout.topMargin = value;
                    break;
                case 38:
                    c.mViewId = value;
                    break;
                case 64:
                    c.motion.mAnimateRelativeTo = value;
                    break;
                case 66:
                    c.motion.mDrawPath = value;
                    break;
                case 76:
                    c.motion.mPathMotionArc = value;
                    break;
                case 78:
                    c.propertySet.mVisibilityMode = value;
                    break;
                case 93:
                    c.layout.baselineMargin = value;
                    break;
                case 94:
                    c.layout.goneBaselineMargin = value;
                    break;
                case 97:
                    c.layout.mWrapBehavior = value;
                    break;
                default:
                    switch (type) {
                        case 21:
                            c.layout.mHeight = value;
                            break;
                        case 22:
                            c.propertySet.visibility = value;
                            break;
                        case 23:
                            c.layout.mWidth = value;
                            break;
                        case 24:
                            c.layout.leftMargin = value;
                            break;
                        default:
                            switch (type) {
                                case 54:
                                    c.layout.widthDefault = value;
                                    break;
                                case 55:
                                    c.layout.heightDefault = value;
                                    break;
                                case 56:
                                    c.layout.widthMax = value;
                                    break;
                                case 57:
                                    c.layout.heightMax = value;
                                    break;
                                case 58:
                                    c.layout.widthMin = value;
                                    break;
                                case 59:
                                    c.layout.heightMin = value;
                                    break;
                                default:
                                    switch (type) {
                                        case 82:
                                            c.motion.mAnimateCircleAngleTo = value;
                                            break;
                                        case 83:
                                            c.transform.transformPivotTarget = value;
                                            break;
                                        case 84:
                                            c.motion.mQuantizeMotionSteps = value;
                                            break;
                                        default:
                                            switch (type) {
                                                case 87:
                                                    break;
                                                case 88:
                                                    c.motion.mQuantizeInterpolatorType = value;
                                                    break;
                                                case 89:
                                                    c.motion.mQuantizeInterpolatorID = value;
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                    break;
                                            }
                                    }
                            }
                    }
            }
            return;
        }
        c.layout.mBarrierMargin = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c, int type, String value) {
        if (type == 5) {
            c.layout.dimensionRatio = value;
            return;
        }
        if (type == 65) {
            c.motion.mTransitionEasing = value;
            return;
        }
        if (type == 74) {
            Layout layout = c.layout;
            layout.mReferenceIdString = value;
            layout.mReferenceIds = null;
        } else if (type == 77) {
            c.layout.mConstraintTag = value;
        } else if (type != 87) {
            if (type == 90) {
                c.motion.mQuantizeInterpolatorString = value;
            } else {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c, int type, boolean value) {
        if (type == 44) {
            c.transform.applyElevation = value;
            return;
        }
        if (type == 75) {
            c.layout.mBarrierAllowsGoneWidgets = value;
            return;
        }
        if (type != 87) {
            if (type == 80) {
                c.layout.constrainedWidth = value;
            } else if (type == 81) {
                c.layout.constrainedHeight = value;
            } else {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            }
        }
    }

    private void populateConstraint(Context ctx, Constraint c, TypedArray a, boolean override) {
        if (override) {
            populateOverride(ctx, c, a);
            return;
        }
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                c.motion.mApply = true;
                c.layout.mApply = true;
                c.propertySet.mApply = true;
                c.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = c.layout;
                    layout.baselineToBaseline = lookupID(a, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = c.layout;
                    layout2.bottomMargin = a.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = c.layout;
                    layout3.bottomToBottom = lookupID(a, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = c.layout;
                    layout4.bottomToTop = lookupID(a, index, layout4.bottomToTop);
                    break;
                case 5:
                    c.layout.dimensionRatio = a.getString(index);
                    break;
                case 6:
                    Layout layout5 = c.layout;
                    layout5.editorAbsoluteX = a.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = c.layout;
                    layout6.editorAbsoluteY = a.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = c.layout;
                    layout7.endMargin = a.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = c.layout;
                    layout8.endToEnd = lookupID(a, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = c.layout;
                    layout9.endToStart = lookupID(a, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = c.layout;
                    layout10.goneBottomMargin = a.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = c.layout;
                    layout11.goneEndMargin = a.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = c.layout;
                    layout12.goneLeftMargin = a.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = c.layout;
                    layout13.goneRightMargin = a.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = c.layout;
                    layout14.goneStartMargin = a.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = c.layout;
                    layout15.goneTopMargin = a.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = c.layout;
                    layout16.guideBegin = a.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = c.layout;
                    layout17.guideEnd = a.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = c.layout;
                    layout18.guidePercent = a.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = c.layout;
                    layout19.horizontalBias = a.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = c.layout;
                    layout20.mHeight = a.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = c.propertySet;
                    propertySet.visibility = a.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = c.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = c.layout;
                    layout21.mWidth = a.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = c.layout;
                    layout22.leftMargin = a.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = c.layout;
                    layout23.leftToLeft = lookupID(a, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = c.layout;
                    layout24.leftToRight = lookupID(a, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = c.layout;
                    layout25.orientation = a.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = c.layout;
                    layout26.rightMargin = a.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = c.layout;
                    layout27.rightToLeft = lookupID(a, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = c.layout;
                    layout28.rightToRight = lookupID(a, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = c.layout;
                    layout29.startMargin = a.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = c.layout;
                    layout30.startToEnd = lookupID(a, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = c.layout;
                    layout31.startToStart = lookupID(a, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = c.layout;
                    layout32.topMargin = a.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = c.layout;
                    layout33.topToBottom = lookupID(a, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = c.layout;
                    layout34.topToTop = lookupID(a, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = c.layout;
                    layout35.verticalBias = a.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    c.mViewId = a.getResourceId(index, c.mViewId);
                    break;
                case 39:
                    Layout layout36 = c.layout;
                    layout36.horizontalWeight = a.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = c.layout;
                    layout37.verticalWeight = a.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = c.layout;
                    layout38.horizontalChainStyle = a.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = c.layout;
                    layout39.verticalChainStyle = a.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = c.propertySet;
                    propertySet3.alpha = a.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = c.transform;
                    transform.applyElevation = true;
                    transform.elevation = a.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = c.transform;
                    transform2.rotationX = a.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = c.transform;
                    transform3.rotationY = a.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = c.transform;
                    transform4.scaleX = a.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = c.transform;
                    transform5.scaleY = a.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = c.transform;
                    transform6.transformPivotX = a.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = c.transform;
                    transform7.transformPivotY = a.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = c.transform;
                    transform8.translationX = a.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = c.transform;
                    transform9.translationY = a.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = c.transform;
                    transform10.translationZ = a.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = c.layout;
                    layout40.widthDefault = a.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = c.layout;
                    layout41.heightDefault = a.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = c.layout;
                    layout42.widthMax = a.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = c.layout;
                    layout43.heightMax = a.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = c.layout;
                    layout44.widthMin = a.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = c.layout;
                    layout45.heightMin = a.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = c.transform;
                    transform11.rotation = a.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = c.layout;
                    layout46.circleConstraint = lookupID(a, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = c.layout;
                    layout47.circleRadius = a.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = c.layout;
                    layout48.circleAngle = a.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = c.motion;
                    motion.mAnimateRelativeTo = lookupID(a, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (a.peekValue(index).type == 3) {
                        c.motion.mTransitionEasing = a.getString(index);
                        break;
                    } else {
                        c.motion.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    c.motion.mDrawPath = a.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = c.motion;
                    motion2.mPathRotate = a.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = c.propertySet;
                    propertySet4.mProgress = a.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    c.layout.widthPercent = a.getFloat(index, 1.0f);
                    break;
                case 70:
                    c.layout.heightPercent = a.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = c.layout;
                    layout49.mBarrierDirection = a.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = c.layout;
                    layout50.mBarrierMargin = a.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    c.layout.mReferenceIdString = a.getString(index);
                    break;
                case 75:
                    Layout layout51 = c.layout;
                    layout51.mBarrierAllowsGoneWidgets = a.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = c.motion;
                    motion3.mPathMotionArc = a.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    c.layout.mConstraintTag = a.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = c.propertySet;
                    propertySet5.mVisibilityMode = a.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = c.motion;
                    motion4.mMotionStagger = a.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = c.layout;
                    layout52.constrainedWidth = a.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = c.layout;
                    layout53.constrainedHeight = a.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Motion motion5 = c.motion;
                    motion5.mAnimateCircleAngleTo = a.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case 83:
                    Transform transform12 = c.transform;
                    transform12.transformPivotTarget = lookupID(a, index, transform12.transformPivotTarget);
                    break;
                case 84:
                    Motion motion6 = c.motion;
                    motion6.mQuantizeMotionSteps = a.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case 85:
                    Motion motion7 = c.motion;
                    motion7.mQuantizeMotionPhase = a.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case 86:
                    int i2 = a.peekValue(index).type;
                    if (i2 == 1) {
                        c.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                        Motion motion8 = c.motion;
                        if (motion8.mQuantizeInterpolatorID != -1) {
                            motion8.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        c.motion.mQuantizeInterpolatorString = a.getString(index);
                        if (c.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                            c.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                            c.motion.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            c.motion.mQuantizeInterpolatorType = -1;
                            break;
                        }
                    } else {
                        Motion motion9 = c.motion;
                        motion9.mQuantizeInterpolatorType = a.getInteger(index, motion9.mQuantizeInterpolatorID);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 91:
                    Layout layout54 = c.layout;
                    layout54.baselineToTop = lookupID(a, index, layout54.baselineToTop);
                    break;
                case 92:
                    Layout layout55 = c.layout;
                    layout55.baselineToBottom = lookupID(a, index, layout55.baselineToBottom);
                    break;
                case 93:
                    Layout layout56 = c.layout;
                    layout56.baselineMargin = a.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case 94:
                    Layout layout57 = c.layout;
                    layout57.goneBaselineMargin = a.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case 95:
                    parseDimensionConstraints(c.layout, a, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(c.layout, a, index, 1);
                    break;
                case 97:
                    Layout layout58 = c.layout;
                    layout58.mWrapBehavior = a.getInt(index, layout58.mWrapBehavior);
                    break;
            }
        }
        Layout layout59 = c.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private int[] convertReferenceString(View view, String referenceIdString) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = referenceIdString.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public Constraint getConstraint(int id) {
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            return this.mConstraints.get(Integer.valueOf(id));
        }
        return null;
    }

    public void setForceId(boolean forceId) {
        this.mForceId = forceId;
    }

    public void setValidateOnParse(boolean validate) {
        this.mValidate = validate;
    }
}
