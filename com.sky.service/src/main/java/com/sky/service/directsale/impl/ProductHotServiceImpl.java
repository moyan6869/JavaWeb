package com.sky.service.directsale.impl;

import com.sky.common.piting.Pager;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.DbUtil;
import com.sky.common.util.JdbcModuleDaoSupport2;
import com.sky.common.util.StringUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.enums.ProductTypeEnum;
import com.sky.dao.vo.ProductBean;
import com.sky.service.directsale.ProductHotService;
import com.sky.service.directsale.ProductStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductHotServiceImpl
 *
 * @author
 **/
@Service("ProductHotService")
public class ProductHotServiceImpl extends BaseServiceImpl implements ProductHotService {
    @Resource
    private ProductStockService productStockService;

//    （默认排序/销量排序）
    @Override
    public Pager<ProductBean> listAll(Pager<ProductBean> page) throws Exception {
        ProductBean bean = new ProductBean();
        StringBuffer sbSql = new StringBuffer();

        sbSql.append("select p.product_id, p.category_id, p.name, p.short_name, p.brand,p.sales, p.retail_price, p.market_price,p.is_profit,p.team_flag,pi.thumb_url, 1 as hiddenFlag");
        sbSql.append(" from product p left join product_image pi on p.product_id=pi.product_id where 1=1 " +
                "  and p.type='10'   and  p.delete_flag = 0  and p.product_type= 0 and p.status = 0 order by sort_index");
        sbSql.append(" limit " + (page.getPageOffset() - 1) * page.getPageSize() + "," + page.getPageSize() + "");

        List<ProductBean> datas = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sbSql.toString(), bean, DbUtil.getMod4DbRandom());

        //分页 截取
        int totalRows = datas.size();
        int offSet=(page.getPageOffset() - 1) * page.getPageSize();
        int endSet=offSet+ page.getPageSize();
        //防越界
        datas =datas.size()>endSet?datas.subList(offSet,endSet):datas.subList(offSet,datas.size());

        if (!StringUtil.isNull(datas) && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                bean = datas.get(i);
                bean.setStock(productStockService.getProductStock(bean.getProductId()));
            }
        } else {
            datas = new ArrayList<ProductBean>();
        }

        page.setDatas(datas);
//        int totalRows = this.count();
        page.setTotalRecord(totalRows);
        page.setTotalPage(totalRows);
        return page;
    }


    public int count() throws Exception {
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("select p.product_id, p.category_id, p.name, p.short_name, p.brand,p.sales, p.retail_price, p.market_price,p.is_profit,p.team_flag,pi.thumb_url, 1 as hiddenFlag");
        sbSql.append(" from product p left join product_image pi on p.product_id=pi.product_id where 1=1 and p.delete_flag = 0  and p.product_type= 0 and p.status = 0 order by sort_index");
        return JdbcModuleDaoSupport2.count(DataBaseType.BASE_DATA, sbSql.toString(), null, DbUtil.getMod4DbRandom());
    }
}
