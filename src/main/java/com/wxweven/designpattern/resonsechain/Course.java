/**
 * @(#)Course.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangxw03
 */
@Data
@Builder
public class Course {
    private int id;
    private String name;
    private String article;
    private String video;
}