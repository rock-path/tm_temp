package com.psh.service.impl;

import com.psh.mapper.TmCommodityMapper;
import com.psh.service.TmCommodityService;
import com.psh.entity.TmCommodity;
import com.psh.entity.request.ReqTmCommodityAdd;
import com.psh.entity.request.ReqTmCommodityUpdate;
import com.psh.entity.request.ReqTmCommodityQuery;
import com.psh.entity.response.ResTmCommodity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psh.domain.BaseResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.psh.common.ResultStatus;
import com.psh.domain.BaseException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TmCommodityServiceImpl extends ServiceImpl<TmCommodityMapper, TmCommodity> implements TmCommodityService {

    @Autowired
    private TmCommodityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel getOneById(Long id) {
        TmCommodity entity = baseMapper.selectById(id);
        if (null == entity) {
            throw new BaseException(ResultStatus.NO_RECORDS.getCode(), ResultStatus.NO_RECORDS.getMessage());
        }
        ResTmCommodity res = new ResTmCommodity();
        BeanUtil.copyProperties(entity, res);
        return BaseResultModel.success(res);
    }

    @Override
    @Transactional
    public BaseResultModel insert(ReqTmCommodityAdd req) {
        TmCommodity entity = new TmCommodity();
        BeanUtil.copyProperties(req, entity);
        entity.setDeleted("0");
        entity.setCtime(new Date());
        entity.setMtime(new Date());
        if (!this.save(entity)) {
            throw new BaseException(ResultStatus.INSERT_FAIL.getCode(), ResultStatus.INSERT_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }

    @Override
    @Transactional
    public BaseResultModel update(Long id, ReqTmCommodityUpdate req) {
        TmCommodity exist = baseMapper.selectById(id);
        if (null == exist) {
            throw new BaseException(ResultStatus.NO_RECORDS.getCode(), ResultStatus.NO_RECORDS.getMessage());
        }
        BeanUtil.copyProperties(req, exist);

        if (!this.updateById(exist)) {
            throw new BaseException(ResultStatus.UPDATE_FAIL.getCode(), ResultStatus.UPDATE_FAIL.getMessage());
        }
        return BaseResultModel.success();

    }

    @Override
    @Transactional
    public BaseResultModel deleteOne(Long id) {
        if (!this.removeById(id)) {
            throw new BaseException(ResultStatus.DELETE_FAIL.getCode(), ResultStatus.DELETE_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }

    @Override
    @Transactional
    public BaseResultModel deleteBatch(List<Long> ids) {
        //批量删除
        if (!this.removeByIds(ids)) {
            throw new BaseException(ResultStatus.DELETE_BATCH_FAIL.getCode(), ResultStatus.DELETE_BATCH_FAIL.getMessage());
        }
        return BaseResultModel.success();


    }

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel<IPage<ResTmCommodity>> page(Page<ResTmCommodity> page, ReqTmCommodityQuery req) {
        List<ResTmCommodity> res = mapper.listByPage(page, req);
        page.setRecords(res);
        return BaseResultModel.success(page);
    }
}
