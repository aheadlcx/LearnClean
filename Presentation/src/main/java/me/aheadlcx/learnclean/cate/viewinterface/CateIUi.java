package me.aheadlcx.learnclean.cate.viewinterface;

import java.util.List;

import me.aheadlcx.learnclean.baseui.IUi;
import me.aheadlcx.domain.Cate;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午3:27
 */
public interface CateIUi extends IUi {

    void fillData(List<Cate> data);
}
