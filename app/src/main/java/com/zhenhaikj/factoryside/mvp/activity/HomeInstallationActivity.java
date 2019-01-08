package com.zhenhaikj.factoryside.mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhenhaikj.factoryside.mvp.base.BaseActivity;
import com.zhenhaikj.factoryside.R;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

public class HomeInstallationActivity extends BaseActivity implements View.OnClickListener {


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
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.tv_add_product)
    TextView mTvAddProduct;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_detail)
    TextView mTvDetail;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.rb1)
    RadioButton mRb1;
    @BindView(R.id.rb2)
    RadioButton mRb2;
    @BindView(R.id.rg1)
    RadioGroup mRg1;
    @BindView(R.id.rb_not)
    RadioButton mRbNot;
    @BindView(R.id.rb_ok)
    RadioButton mRbOk;
    @BindView(R.id.rg2)
    RadioGroup mRg2;
    @BindView(R.id.tv_add_num)
    TextView mTvAddNum;
    @BindView(R.id.tv_add)
    TextView mTvAdd;
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_fault_description)
    TextView mTvFaultDescription;
    @BindView(R.id.login)
    Button mLogin;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_home_installation;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mIconBack.setOnClickListener(this);
        mIconSearch.setOnClickListener(this);
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