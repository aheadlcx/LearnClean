package me.aheadlcx.learnclean.cate.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import me.aheadlcx.data.repositiry.CateDataRepository;
import me.aheadlcx.domain.Cate;
import me.aheadlcx.domain.GetCateList;
import me.aheadlcx.domain.PostExecutionThread;
import me.aheadlcx.learnclean.R;
import me.aheadlcx.learnclean.baseui.BaseFragment;
import me.aheadlcx.learnclean.cate.adapter.CateAdapter;
import me.aheadlcx.learnclean.cate.present.CatePresent;
import me.aheadlcx.learnclean.cate.viewinterface.CateIUi;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午4:21
 */
public class CateFragment extends BaseFragment implements CateIUi{
    RecyclerView mRecyclerView;
    CircularProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;
    CatePresent mPresent;
    CateAdapter mAdapter;
    View progressbarParent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act_cate, null);
        initViews(view);
        return view;
    }

    @Override
    public void initPresent() {
        super.initPresent();
        mPresent = new CatePresent(getActivity(), this);
        mPresent.setCateCase(new GetCateList(new PostExecutionThread() {
            @Override
            public Scheduler getScheduler() {
                return AndroidSchedulers.mainThread();
            }
        }, new CateDataRepository()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initViews(View view) {
        progressbarParent = view.findViewById(R.id.progressbarParent);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        progressBar = (CircularProgressBar) view.findViewById(R.id.progress_bar);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mAdapter = new CateAdapter(null);
        mRecyclerView.setAdapter(mAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onRefreshData();
            }
        });


        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void onRefreshData() {
        swipeRefreshLayout.setRefreshing(true);
        initData();
    }

    private void initData() {
        mPresent.getData();
    }


    @Override
    public void fillData(List<Cate> data) {
        progressBar.setVisibility(View.GONE);
        progressbarParent.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.setLists(data);
        mAdapter.notifyDataSetChanged();
//        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        if (mPresent != null) {
            mPresent.onDestory();
        }
        super.onDestroy();
    }
}
