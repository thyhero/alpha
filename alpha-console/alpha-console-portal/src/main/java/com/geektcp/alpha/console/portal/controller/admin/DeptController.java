package com.geektcp.alpha.console.portal.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.geektcp.alpha.console.common.portal.controller.AbstractController;
import com.geektcp.alpha.console.portal.model.entity.SysDept;
import com.geektcp.alpha.console.portal.service.ISysDeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 部门控制器
 */
@Controller
@RequestMapping("/admin/dept")
public class DeptController extends AbstractController<ISysDeptService,SysDept> {

    @Override
    protected String getTemplatePath() {
        return "ftl/admin/dept/";
    }

    @Override
    protected QueryWrapper<SysDept> getSearchQW(String search, Model model) {
        QueryWrapper<SysDept> qw = new QueryWrapper<SysDept>();
        if(StringUtils.isNotBlank(search)){
            qw.like("dept_name",search);
            model.addAttribute("search",search);
        }
        return qw;
    }
}
