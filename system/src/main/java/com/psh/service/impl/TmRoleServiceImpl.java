package com.psh.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psh.domain.BaseResultModel;
import com.psh.entity.TmRole;
import com.psh.entity.request.ReqTmRoleAdd;
import com.psh.entity.request.ReqTmRoleQuery;
import com.psh.entity.request.ReqTmRoleUpdate;
import com.psh.entity.response.ResTmRole;
import com.psh.entity.response.ResTmRoleVO;
import com.psh.mapper.TmRoleMapper;
import com.psh.service.TmRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.psh.common.ResultStatus;
import com.psh.domain.BaseException;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TmRoleServiceImpl extends ServiceImpl<TmRoleMapper, TmRole> implements TmRoleService {

    @Autowired
    private TmRoleMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel getOneById(Long id) {
        TmRole entity = baseMapper.selectById(id);
        if (null == entity) {
            throw new BaseException(ResultStatus.NO_RECORDS.getCode(), ResultStatus.NO_RECORDS.getMessage());
        }
        ResTmRole res = new ResTmRole();
        BeanUtil.copyProperties(entity, res);
        return BaseResultModel.success(res);
    }

    @Override
    @Transactional
    public BaseResultModel insert(ReqTmRoleAdd req) {
        TmRole entity = new TmRole();
        BeanUtil.copyProperties(req, entity);
        if (!this.save(entity)) {
            throw new BaseException(ResultStatus.INSERT_FAIL.getCode(), ResultStatus.INSERT_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }

    @Override
    @Transactional
    public BaseResultModel update(Long id, ReqTmRoleUpdate req) {
        TmRole exist = baseMapper.selectById(id);
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
    public BaseResultModel<IPage<ResTmRole>> page(Page<ResTmRole> page, ReqTmRoleQuery req) {
        List<ResTmRole> res = mapper.listByPage(page, req);
        page.setRecords(res);
        return BaseResultModel.success(page);
    }

    @Override
    public List<ResTmRoleVO> selectbyAccount(String account) {
        List<String> li = mapper.selectRole(account);
        if (null == li || li.isEmpty()) {
            log.info("用户不存在角色");
            return null;
        }
        //查询角色的权限，角色对应着几个菜单
        return  mapper.selectByRole(li);
    }
}
