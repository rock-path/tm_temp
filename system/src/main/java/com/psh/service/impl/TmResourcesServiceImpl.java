package com.psh.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psh.domain.BaseResultModel;
import com.psh.entity.TmResources;
import com.psh.entity.request.ReqTmResourcesAdd;
import com.psh.entity.request.ReqTmResourcesQuery;
import com.psh.entity.request.ReqTmResourcesUpdate;
import com.psh.entity.response.ResTmResources;
import com.psh.mapper.TmResourcesMapper;
import com.psh.service.TmResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.psh.common.ResultStatus;
import com.psh.domain.BaseException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TmResourcesServiceImpl extends ServiceImpl<TmResourcesMapper, TmResources> implements TmResourcesService {
    
    @Autowired
    private TmResourcesMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel getOneById(Long id) {
        TmResources entity = baseMapper.selectById(id);
        if(null == entity){
               throw new BaseException(ResultStatus.NO_RECORDS.getCode(),ResultStatus.NO_RECORDS.getMessage());
        }
        ResTmResources res = new ResTmResources();
        BeanUtil.copyProperties(entity, res);
        return BaseResultModel.success(res);
    }
    
    @Override
    @Transactional
    public BaseResultModel insert(ReqTmResourcesAdd req){
        TmResources entity = new TmResources();
        BeanUtil.copyProperties(req, entity);
        if (!this.save(entity)) {
                        throw new BaseException(ResultStatus.INSERT_FAIL.getCode(),ResultStatus.INSERT_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }
    
    @Override
    @Transactional
    public BaseResultModel update(Long id, ReqTmResourcesUpdate req){
        TmResources exist = baseMapper.selectById(id);
        if(null == exist){
                        throw new BaseException(ResultStatus.NO_RECORDS.getCode(),ResultStatus.NO_RECORDS.getMessage());
        }
        BeanUtil.copyProperties(req, exist);

        if (!this.updateById(exist)) {
                       throw new BaseException(ResultStatus.UPDATE_FAIL.getCode(),ResultStatus.UPDATE_FAIL.getMessage());
        }
        return BaseResultModel.success();
        
    }
    
    @Override
    @Transactional
    public BaseResultModel deleteOne(Long id){
        if (!this.removeById(id)) {
                        throw new BaseException(ResultStatus.DELETE_FAIL.getCode(),ResultStatus.DELETE_FAIL.getMessage());
        }
         return BaseResultModel.success();
    }

    @Override
    @Transactional
    public BaseResultModel deleteBatch(List<Long> ids){
        //批量删除
        if (!this.removeByIds(ids)) {
                        throw new BaseException(ResultStatus.DELETE_BATCH_FAIL.getCode(),ResultStatus.DELETE_BATCH_FAIL.getMessage());
        }
        return BaseResultModel.success();
        
        
    }
        
    @Override
    @Transactional(readOnly = true)
    public BaseResultModel<IPage<ResTmResources>> page(Page<ResTmResources> page, ReqTmResourcesQuery req){
        List<ResTmResources> res = mapper.listByPage(page,req);
        page.setRecords(res);
        return BaseResultModel.success(page);
    }
}
