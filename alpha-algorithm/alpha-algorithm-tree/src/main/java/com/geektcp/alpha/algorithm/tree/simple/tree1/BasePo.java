package com.geektcp.alpha.algorithm.tree.simple.tree1;

import alpha.common.base.constant.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author tanghaiyang on 2018/5/15.
 */
@Data
@MappedSuperclass
public class BasePo implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "enabled_flag", length = 1)
    protected String enabledFlag = Constants.Y;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "created_dt",insertable = false,updatable = false)
    protected Date createdDt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "updated_dt",insertable = false,updatable = false)
    protected Date updatedDt;

    @Column(name = "created_by",updatable = false, length = 50)
    protected String createdById;

    @Column(name = "updated_by", length = 50)
    protected String updateById;
}
