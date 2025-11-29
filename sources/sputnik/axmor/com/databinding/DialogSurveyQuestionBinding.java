package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogSurveyQuestionBinding implements ViewBinding {
    public final AppCompatButton btnDoesntLike;
    public final AppCompatButton btnLike;
    public final AppCompatButton btnOpenStore;
    public final FrameLayout container;
    public final LinearLayout layoutButtons;
    private final FrameLayout rootView;
    public final TextView tvMessage;

    private DialogSurveyQuestionBinding(FrameLayout frameLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView) {
        this.rootView = frameLayout;
        this.btnDoesntLike = appCompatButton;
        this.btnLike = appCompatButton2;
        this.btnOpenStore = appCompatButton3;
        this.container = frameLayout2;
        this.layoutButtons = linearLayout;
        this.tvMessage = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogSurveyQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_survey_question, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSurveyQuestionBinding bind(View view) {
        int i = R.id.btnDoesntLike;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnDoesntLike);
        if (appCompatButton != null) {
            i = R.id.btnLike;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnLike);
            if (appCompatButton2 != null) {
                i = R.id.btnOpenStore;
                AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnOpenStore);
                if (appCompatButton3 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.layoutButtons;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layoutButtons);
                    if (linearLayout != null) {
                        i = R.id.tvMessage;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvMessage);
                        if (textView != null) {
                            return new DialogSurveyQuestionBinding(frameLayout, appCompatButton, appCompatButton2, appCompatButton3, frameLayout, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
