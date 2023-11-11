package com.psh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psh.entity.response.ResTmRole;
import com.psh.entity.response.ResTmRoleVO;
import com.psh.mapper.TmUserMapper;
import com.psh.service.TmRoleService;
import com.psh.service.TmUserService;
import com.psh.entity.TmUser;
import com.psh.entity.request.ReqTmUserAdd;
import com.psh.entity.request.ReqTmUserUpdate;
import com.psh.entity.request.ReqTmUserQuery;
import com.psh.entity.response.ResTmUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psh.domain.BaseResultModel;
import com.psh.utils.RedisTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.psh.common.ResultStatus;
import com.psh.domain.BaseException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class TmUserServiceImpl extends ServiceImpl<TmUserMapper, TmUser> implements TmUserService {

    @Autowired
    private TmUserMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResultModel getOneById(Long id) {
        TmUser entity = baseMapper.selectById(id);
        if (null == entity) {
            throw new BaseException(ResultStatus.NO_RECORDS.getCode(), ResultStatus.NO_RECORDS.getMessage());
        }
        ResTmUser res = new ResTmUser();
        BeanUtil.copyProperties(entity, res);
        return BaseResultModel.success(res);
    }

    @Override
    @Transactional
    public BaseResultModel insert(ReqTmUserAdd req) {
        TmUser entity = new TmUser();
        BeanUtil.copyProperties(req, entity);
        if (!this.save(entity)) {
            throw new BaseException(ResultStatus.INSERT_FAIL.getCode(), ResultStatus.INSERT_FAIL.getMessage());
        }
        return BaseResultModel.success();
    }

    @Override
    @Transactional
    public BaseResultModel update(Long id, ReqTmUserUpdate req) {
        TmUser exist = baseMapper.selectById(id);
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
    public BaseResultModel<IPage<ResTmUser>> page(Page<ResTmUser> page, ReqTmUserQuery req) {
        List<ResTmUser> res = mapper.listByPage(page, req);
        page.setRecords(res);
        return BaseResultModel.success(page);
    }

    @Resource
    private TmRoleService roleService;


    @Value("${session.timeOut}")
    private Integer timeOut;

    @Override
    public BaseResultModel<ResTmUser> selectByUser(TmUser tmUser, HttpServletRequest request, HttpServletResponse response) {
        if (null == tmUser || StringUtils.isEmpty(tmUser.getAccount()) || StringUtils.isEmpty(tmUser.getPassword())) {
            log.info("登录用户为空-------》");
            return BaseResultModel.fail("登录用户为空");
        }
        //查询用户的角色信息,判断用户是否存在
        QueryWrapper<TmUser> query = new QueryWrapper<>();
        query.eq("account", tmUser.getAccount());
        query.eq("password", tmUser.getPassword());
        query.eq("deleted", "0");
        TmUser tm = mapper.selectOne(query);
        if (null == tm) {
            log.info("用户不存在-------》");
            return BaseResultModel.fail("用户不存在");
        }
        //获取用户角色、权限
        List<ResTmRoleVO> userRoleFunction = roleService.selectbyAccount(tm.getAccount());
        //组装数据
        Map<String, Map<String, Map<String, List<ResTmRoleVO>>>> map = extracted(userRoleFunction);
        ResTmUser res = new ResTmUser();
        BeanUtils.copyProperties(tm, res);
        res.setUserRoleFunction(map);

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(timeOut);
        session.setAttribute("User", res.getAccount());
        String str =UUID.randomUUID().toString().replace("-","");
        session.setAttribute("uuid", str);
        RedisTemplateUtils.set(res.getAccount(),str);

        return BaseResultModel.success(res);
    }

    private Map<String, Map<String, Map<String, List<ResTmRoleVO>>>> extracted(List<ResTmRoleVO> userRoleFunction) {
        Map<String, Map<String, Map<String, List<ResTmRoleVO>>>> ma = new HashMap<>();
        Map<String, List<ResTmRoleVO>> collect =
                userRoleFunction.stream().collect(Collectors.groupingBy(a -> a.getRoleName()));
        Set<String> set = collect.keySet();
        //按角色分组
        for (String ss : set) {
            List<ResTmRoleVO> resTmRoleVOS = collect.get(ss);
            //一级菜单 的名字
            List<ResTmRoleVO> listOne = resTmRoleVOS.stream().filter(a -> "0".equals(a.getParentId())).collect(Collectors.toList());
            //二级菜单
            Map<String, Map<String, List<ResTmRoleVO>>> res = new HashMap<>();
            for (ResTmRoleVO s1 : listOne) {
                //二级菜单的名字
                List<ResTmRoleVO> listTwo = resTmRoleVOS.stream().filter(a -> s1.getFunctionId().equals(a.getParentId())).
                        collect(Collectors.toList());
                Map<String, List<ResTmRoleVO>> mapTwo = new HashMap<>();
                for (ResTmRoleVO s2 : listTwo) {
                    //获取二级菜单的路由页面
                    List<ResTmRoleVO> listPage = resTmRoleVOS.stream().filter(a -> s2.getFunctionId().equals(a.getParentId())).collect(Collectors.toList());

                    mapTwo.put(s2.getFunctionName(), listPage);
                }
                res.put(s1.getFunctionName(), mapTwo);
            }
            //具体页面的权限
//            List<ResTmRoleVO> coll = resTmRoleVOS.stream().filter(a -> "1".equals(a.getFunctionType())).collect(Collectors.toList());
            //二级菜单

//            Map<String, Map<String,List<ResTmRoleVO>>> res = extracted(resTmRoleVOS, listOne, coll);

            ma.put(ss, res);
        }
        return ma;
    }


    private Map<String, Map<String, List<ResTmRoleVO>>> extracted(List<ResTmRoleVO> resTmRoleVOS,
                                                                  List<String> listOne, List<ResTmRoleVO> list) {
        Map<String, Map<String, List<ResTmRoleVO>>> map = new HashMap<>();
        for (String res : listOne) {
            //二级菜单
            List<ResTmRoleVO> coll = resTmRoleVOS.stream().filter(a -> res.equals
                    (a.getFunctionName())).collect(Collectors.toList());
            Map<String, List<ResTmRoleVO>> ma = new HashMap<>();
            for (ResTmRoleVO re : list) {
                List<ResTmRoleVO> collect1 = coll.stream().filter(a -> a.getFunctionId().equals(re.getFunctionId())).collect(Collectors.toList());
                ma.put(re.getFunctionName(), collect1);
            }

            map.put(res, ma);
        }
        return map;
    }


}
