package com.sputnik.oboarding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sputnik.oboarding.databinding.ItemAccountBindingImpl;
import com.sputnik.oboarding.databinding.ItemCountryPhoneCodeBindingImpl;
import com.sputnik.oboarding.databinding.ItemSelectLangiageBindingImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R$layout.item_account, 1);
        sparseIntArray.put(R$layout.item_country_phone_code, 2);
        sparseIntArray.put(R$layout.item_select_langiage, 3);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i2 == 1) {
            if ("layout/item_account_0".equals(tag)) {
                return new ItemAccountBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for item_account is invalid. Received: " + tag);
        }
        if (i2 == 2) {
            if ("layout/item_country_phone_code_0".equals(tag)) {
                return new ItemCountryPhoneCodeBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for item_country_phone_code is invalid. Received: " + tag);
        }
        if (i2 != 3) {
            return null;
        }
        if ("layout/item_select_langiage_0".equals(tag)) {
            return new ItemSelectLangiageBindingImpl(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for item_select_langiage is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.sputnik.common.DataBinderMapperImpl());
        return arrayList;
    }
}
