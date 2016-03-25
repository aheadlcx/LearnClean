package me.aheadlcx.learnclean.cate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.aheadlcx.learnclean.R;
import me.aheadlcx.domain.Cate;

/**
 * Description:
 * Creator: ZhangJinWei
 * Date:16/3/1 下午5:43
 */
public class CateAdapter extends RecyclerView.Adapter<CateAdapter.CateHolder> {

    private List<Cate> lists;

    private OnItemClickCallBack mCallBack;

    public void setCallBack(OnItemClickCallBack callBack) {
        mCallBack = callBack;
    }

    public CateAdapter(List<Cate> lists) {
        this.lists = lists;
    }

    public void setLists(List<Cate> lists) {
        this.lists = lists;
    }

    @Override
    public CateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cate, null);
        CateHolder holder = new CateHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CateHolder holder, final int position) {
        holder.bind(lists.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onItemClick(lists.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (lists == null) {
            return 0;
        }
        return lists.size();
    }

    public static class CateHolder extends RecyclerView.ViewHolder{
        private ImageView imgCateItem;
        private TextView content;
        public CateHolder(View itemView) {
            super(itemView);
            imgCateItem = (ImageView) itemView.findViewById(R.id.imgCateItem);
            content = (TextView) itemView.findViewById(R.id.txtCateItem);

        }

        public void bind(Cate bean){
            if (  bean != null) {
                content.setText(bean.getContent());
                Glide.with(itemView.getContext()).load(bean.getPic()).into
                        (imgCateItem);
            }
        }
    }

    public interface OnItemClickCallBack{
        void onItemClick(Cate Cate);
    }
}
