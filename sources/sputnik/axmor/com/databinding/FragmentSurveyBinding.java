package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSurveyBinding implements ViewBinding {
    public final AppCompatButton btnSend;
    public final CheckedTextView cbFunctions;
    public final CheckedTextView cbNoneCalls;
    public final CheckedTextView cbOther;
    public final CheckedTextView cbUncomfortable;
    public final EditText etComment;
    public final TextView etHeader;
    private final LinearLayout rootView;
    public final TextView surveyHeader;
    public final Toolbar toolbarSurvey;

    private FragmentSurveyBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, EditText editText, TextView textView, TextView textView2, Toolbar toolbar) {
        this.rootView = linearLayout;
        this.btnSend = appCompatButton;
        this.cbFunctions = checkedTextView;
        this.cbNoneCalls = checkedTextView2;
        this.cbOther = checkedTextView3;
        this.cbUncomfortable = checkedTextView4;
        this.etComment = editText;
        this.etHeader = textView;
        this.surveyHeader = textView2;
        this.toolbarSurvey = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSurveyBinding bind(View view) {
        int i = R.id.btnSend;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnSend);
        if (appCompatButton != null) {
            i = R.id.cbFunctions;
            CheckedTextView checkedTextView = (CheckedTextView) ViewBindings.findChildViewById(view, R.id.cbFunctions);
            if (checkedTextView != null) {
                i = R.id.cbNoneCalls;
                CheckedTextView checkedTextView2 = (CheckedTextView) ViewBindings.findChildViewById(view, R.id.cbNoneCalls);
                if (checkedTextView2 != null) {
                    i = R.id.cbOther;
                    CheckedTextView checkedTextView3 = (CheckedTextView) ViewBindings.findChildViewById(view, R.id.cbOther);
                    if (checkedTextView3 != null) {
                        i = R.id.cbUncomfortable;
                        CheckedTextView checkedTextView4 = (CheckedTextView) ViewBindings.findChildViewById(view, R.id.cbUncomfortable);
                        if (checkedTextView4 != null) {
                            i = R.id.etComment;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.etComment);
                            if (editText != null) {
                                i = R.id.et_header;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.et_header);
                                if (textView != null) {
                                    i = R.id.survey_header;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.survey_header);
                                    if (textView2 != null) {
                                        i = R.id.toolbar_survey;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_survey);
                                        if (toolbar != null) {
                                            return new FragmentSurveyBinding((LinearLayout) view, appCompatButton, checkedTextView, checkedTextView2, checkedTextView3, checkedTextView4, editText, textView, textView2, toolbar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
