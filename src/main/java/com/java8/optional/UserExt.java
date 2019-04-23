/**
 * @(#)UserExt.java, Apr 15, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.java8.optional;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author wangxw03
 */
@Data
@Accessors(chain = true)
public class UserExt {
    private boolean fired;
    private Date date;
}