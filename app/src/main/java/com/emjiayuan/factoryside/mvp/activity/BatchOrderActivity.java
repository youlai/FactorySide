package com.emjiayuan.factoryside.mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.emjiayuan.nll.R;
import com.emjiayuan.nll.base.BaseActivity;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

public class BatchOrderActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.icon_back)
    ImageView mIconBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.icon_search)
    ImageView mIconSearch;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_download)
    TextView mTvDownload;
    @BindView(R.id.tv_code)
    TextView mTvCode;
    @BindView(R.id.tv_detail)
    TextView mTvDetail;
    @BindView(R.id.btn_add)
    Button mBtnAdd;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_batch_order;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_back:
                finish();
                break;
            case R.id.icon_search:
                finish();
                break;
        }
    }

}