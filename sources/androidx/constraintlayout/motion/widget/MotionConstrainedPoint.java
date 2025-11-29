package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    private float height;
    private float position;
    int visibility;
    private float width;
    private float x;
    private float y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float a, float b) {
        return (Float.isNaN(a) || Float.isNaN(b)) ? Float.isNaN(a) != Float.isNaN(b) : Math.abs(a - b) > 1.0E-6f;
    }

    void different(MotionConstrainedPoint points, HashSet<String> keySet) {
        if (diff(this.alpha, points.alpha)) {
            keySet.add("alpha");
        }
        if (diff(this.elevation, points.elevation)) {
            keySet.add("elevation");
        }
        int i = this.visibility;
        int i2 = points.visibility;
        if (i != i2 && this.mVisibilityMode == 0 && (i == 0 || i2 == 0)) {
            keySet.add("alpha");
        }
        if (diff(this.rotation, points.rotation)) {
            keySet.add("rotation");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(points.mPathRotate)) {
            keySet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(points.mProgress)) {
            keySet.add("progress");
        }
        if (diff(this.rotationX, points.rotationX)) {
            keySet.add("rotationX");
        }
        if (diff(this.rotationY, points.rotationY)) {
            keySet.add("rotationY");
        }
        if (diff(this.mPivotX, points.mPivotX)) {
            keySet.add("transformPivotX");
        }
        if (diff(this.mPivotY, points.mPivotY)) {
            keySet.add("transformPivotY");
        }
        if (diff(this.scaleX, points.scaleX)) {
            keySet.add("scaleX");
        }
        if (diff(this.scaleY, points.scaleY)) {
            keySet.add("scaleY");
        }
        if (diff(this.translationX, points.translationX)) {
            keySet.add("translationX");
        }
        if (diff(this.translationY, points.translationY)) {
            keySet.add("translationY");
        }
        if (diff(this.translationZ, points.translationZ)) {
            keySet.add("translationZ");
        }
    }

    void setBounds(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint o) {
        return Float.compare(this.position, o.position);
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    public void addValues(HashMap<String, ViewSpline> splines, int mFramePosition) {
        ViewSpline viewSpline;
        for (String str : splines.keySet()) {
            viewSpline = splines.get(str);
            str.hashCode();
            switch (str) {
                case "rotationX":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case "rotationY":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case "translationX":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case "translationY":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case "translationZ":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                case "progress":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case "scaleX":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case "scaleY":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case "transformPivotX":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case "transformPivotY":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case "rotation":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case "elevation":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                    break;
                case "transitionPathRotate":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                case "alpha":
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (viewSpline instanceof ViewSpline.CustomSet) {
                                ((ViewSpline.CustomSet) viewSpline).setPoint(mFramePosition, constraintAttribute);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + mFramePosition + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
            }
        }
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }
}
