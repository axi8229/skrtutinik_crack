package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    String mTransitionEasing = null;
    int mPathMotionArc = Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
    }

    public KeyPosition() {
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R$styleable.KeyPosition));
    }

    private static class Loader {
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R$styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R$styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R$styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R$styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R$styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R$styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R$styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R$styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R$styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R$styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition c, TypedArray a) {
            int indexCount = a.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = a.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = a.getResourceId(index, c.mTargetId);
                            c.mTargetId = resourceId;
                            if (resourceId == -1) {
                                c.mTargetString = a.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (a.peekValue(index).type == 3) {
                            c.mTargetString = a.getString(index);
                            break;
                        } else {
                            c.mTargetId = a.getResourceId(index, c.mTargetId);
                            break;
                        }
                    case 2:
                        c.mFramePosition = a.getInt(index, c.mFramePosition);
                        break;
                    case 3:
                        if (a.peekValue(index).type == 3) {
                            c.mTransitionEasing = a.getString(index);
                            break;
                        } else {
                            c.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        c.mCurveFit = a.getInteger(index, c.mCurveFit);
                        break;
                    case 5:
                        c.mDrawPath = a.getInt(index, c.mDrawPath);
                        break;
                    case 6:
                        c.mPercentX = a.getFloat(index, c.mPercentX);
                        break;
                    case 7:
                        c.mPercentY = a.getFloat(index, c.mPercentY);
                        break;
                    case 8:
                        float f = a.getFloat(index, c.mPercentHeight);
                        c.mPercentWidth = f;
                        c.mPercentHeight = f;
                        break;
                    case 9:
                        c.mPositionType = a.getInt(index, c.mPositionType);
                        break;
                    case 10:
                        c.mPathMotionArc = a.getInt(index, c.mPathMotionArc);
                        break;
                    case 11:
                        c.mPercentWidth = a.getFloat(index, c.mPercentWidth);
                        break;
                    case 12:
                        c.mPercentHeight = a.getFloat(index, c.mPercentHeight);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
            if (c.mFramePosition == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyPosition keyPosition = (KeyPosition) src;
        this.mTransitionEasing = keyPosition.mTransitionEasing;
        this.mPathMotionArc = keyPosition.mPathMotionArc;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mPercentWidth = keyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = keyPosition.mPercentX;
        this.mPercentY = keyPosition.mPercentY;
        this.mAltPercentX = keyPosition.mAltPercentX;
        this.mAltPercentY = keyPosition.mAltPercentY;
        this.mCalculatedPositionX = keyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = keyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo2211clone() {
        return new KeyPosition().copy(this);
    }
}
