package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentCommentSurveyBinding extends ViewDataBinding {
    public final AppCompatButton acceptButton;
    public final TextView etHeader;
    public final EditText etTextComment;
    public final LinearLayout rootView;
    public final Toolbar toolbarSurvey;

    protected FragmentCommentSurveyBinding(Object obj, View view, int i, AppCompatButton appCompatButton, TextView textView, EditText editText, LinearLayout linearLayout, Toolbar toolbar) {
        super(obj, view, i);
        this.acceptButton = appCompatButton;
        this.etHeader = textView;
        this.etTextComment = editText;
        this.rootView = linearLayout;
        this.toolbarSurvey = toolbar;
    }

    public static FragmentCommentSurveyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCommentSurveyBinding bind(View view, Object obj) {
        return (FragmentCommentSurveyBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_comment_survey);
    }
}
