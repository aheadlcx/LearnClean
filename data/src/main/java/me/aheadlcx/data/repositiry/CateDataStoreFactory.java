package me.aheadlcx.data.repositiry;

/**
 * Description:
 * Creator: aheadlcx
 * Date:16/3/24 下午6:31
 */
public class CateDataStoreFactory {

    public CateDataStore createCloundDataStore(){
        return new CloundCateDataStore();
    }

}
