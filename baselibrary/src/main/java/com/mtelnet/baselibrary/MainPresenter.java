package com.mtelnet.baselibrary;

/**
 * Created by hongzhenyue on 17/2/24.
 * 该层持有V和M的对象。
 * getValue方法会调用M的方法并返回数据，成功后调用V层的方法把数据现象出来，这样我们Presenter就完成了M、V的交互。
 */

public class MainPresenter extends MainContract.Presenter {
    public MainPresenter(MainContract.View view) {
        super(view, new MainModel());
    }

    @Override
    public void getValue() {
        mModel.getValue(new ICallBack() {
            @Override
            public void success(String value) {
                mView.setValue(value);
            }
        },mView.getActivity());
    }
}
