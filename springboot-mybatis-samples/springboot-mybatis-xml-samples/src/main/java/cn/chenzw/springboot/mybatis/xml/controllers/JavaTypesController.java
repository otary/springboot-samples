package cn.chenzw.springboot.mybatis.xml.controllers;

import cn.chenzw.springboot.mybatis.xml.domain.dto.JavaTypesEntityQueryDto;
import cn.chenzw.springboot.mybatis.xml.domain.dto.PageResult;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.xml.service.JavaTypesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class JavaTypesController {

    @Autowired
    JavaTypesService javaTypesService;

    @GetMapping("/list")
    public PageResult listAll(JavaTypesEntityQueryDto javaTypesEntityQueryDto) {
        PageHelper.startPage(0, 2);
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll(javaTypesEntityQueryDto);
        System.out.println(javaTypesEntities);

        Page page = (Page) javaTypesEntities;
        System.out.println(page.getTotal());
        System.out.println(page);

        PageInfo pageInfo = new PageInfo(javaTypesEntities);

        PageResult<List<JavaTypesEntity>> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setData(pageInfo.getList());
        pageResult.setCode(HttpStatus.OK.value());

        return pageResult;
    }

}
