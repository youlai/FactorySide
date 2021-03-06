package com.emjiayuan.nll.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emjiayuan.nll.R;
import com.emjiayuan.nll.model.Commentdata;
import com.emjiayuan.nll.model.Order;
import com.emjiayuan.nll.utils.MyUtils;
import com.google.gson.Gson;
import com.hedgehog.ratingbar.RatingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cyl on 2018年5月10日 09:52:49.
 */

public class JudgeAdapter extends BaseAdapter {

    private Context mContext;
    private int checked;
    private List<Commentdata> commentdataList=new ArrayList<>();
    private Map<Integer,Float> map=new HashMap<>();
    private Map<Integer,String> map2=new HashMap<>();

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
        notifyDataSetChanged();
    }

    private List<Order.ProductListBean> grouplists = new ArrayList<>();

    public List<Order.ProductListBean> getGrouplists() {
        return grouplists;
    }

    public void setGrouplists(List<Order.ProductListBean> grouplists) {
        this.grouplists = grouplists;
    }

    private LayoutInflater mInflater;

    public JudgeAdapter(Context mContext, List<Order.ProductListBean> grouplists) {
        super();
        this.mContext = mContext;
        this.grouplists = grouplists;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
//        return 4;
        return grouplists.size();
    }

    @Override
    public Order.ProductListBean getItem(int position) {
        return grouplists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.judge_item, parent, false);
            holder = new ViewHolder(view,position);
            view.setTag(holder);
        }
        Order.ProductListBean item=grouplists.get(position);
        Glide.with(mContext).load(item.getImages()).into(holder.icon);
        holder.name.setText(item.getName());
        holder.ratingbar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float RatingCount) {
                map.put(position,RatingCount);
            }
        });

        return view;
    }
    public String getCommentdata(){
        commentdataList.clear();
        for (int i = 0; i < grouplists.size(); i++) {
            Commentdata commentdata=new Commentdata();
            commentdata.setProductid(grouplists.get(i).getProductid());
            if (map2.size()!=grouplists.size()){
                MyUtils.showToast(mContext,"请输入评价！");
                return  null;
            }
            commentdata.setComment(map2.get(i));
            if (map.size()!=grouplists.size()){
                MyUtils.showToast(mContext,"请评分！");
                return  null;
            }
            commentdata.setScore1(map.get(i));
            commentdataList.add(commentdata);
        }
        Gson gson=new Gson();
        return gson.toJson(commentdataList);
    }

    class ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.et_pj)
        EditText etPj;
        @BindView(R.id.pj)
        ImageView pj;
        @BindView(R.id.ratingbar)
        RatingBar ratingbar;

        ViewHolder(View view, int position) {
            ButterKnife.bind(this, view);
            etPj.setTag(position);//存tag值
            etPj.addTextChangedListener(new TextSwitcher(this));
        }
    }

    class TextSwitcher implements TextWatcher {
        private ViewHolder mHolder;

        public TextSwitcher(ViewHolder mHolder) {
            this.mHolder = mHolder;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int position = (int) mHolder.etPj.getTag();//取tag值
            map2.put(position,s.toString());
//            ((JudgeActivity)mContext).saveEditData(position, s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
