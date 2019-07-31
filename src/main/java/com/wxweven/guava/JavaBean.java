/**
 * @(#)JavaBean.java, Jul 02, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.guava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangxw03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JavaBean {
    private int id;
    private String name;
}