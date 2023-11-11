package com.psh.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psh.domain.BaseResultModel;
import com.psh.entity.TmFunctions;
import com.psh.entity.request.ReqTmFunctionsAdd;
import com.psh.entity.request.ReqTmFunctionsQuery;
import com.psh.entity.request.ReqTmFunctionsUpdate;
import com.psh.entity.response.ResTmFunctions;
import com.psh.mapper.TmFunctionsMapper;
import com.psh.service.TmFunctionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.psh.common.ResultStatus;
import com.psh.domain.BaseException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TmFunctionsServiceImpl extends ServiceImpl<TmFunctionsMapper, TmFunctions> implements TmFunctionsService {
    
    @Autowired
    private TmFunctionsMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel getOneById(Long id) {
        TmFunctions entity = baseMapper.selectById(id);
        if(null == entity){
               throw new BaseException(ResultStatus.NO_RECORDS.getCode(),ResultStatus.NO_RECORDS.getMessage());
        }
        ResTmFunctions res = new ResTmFunctions();
        BeanUtil.copyProperties(entity, res);
        return BaseResultModel.success(res);
    }
    
    @Override
    @Transactional
    public BaseResultModel insert(ReqTmFunctionsAdd req){
        TmFunctions entity = new TmFunctions();
        BeanUtil.copyProperties(req, entity);
        if (!this.save(entity)) {
                        throw new BaseException(ResultStatus.INSERT_FAIL.getCode(),ResultStatus.INSERT_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }
    
    @Override
    @Transactional
    public BaseResultModel update(Long id, ReqTmFunctionsUpdate req){
        TmFunctions exist = baseMapper.selectById(id);
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
    public BaseResultModel<IPage<ResTmFunctions>> page(Page<ResTmFunctions> page, ReqTmFunctionsQuery req){
        List<ResTmFunctions> res = mapper.listByPage(page,req);
        page.setRecords(res);
        return BaseResultModel.success(page);
    }
}
