package com.java8.optional;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author wxweven
 */
@Data
@Accessors(chain = true)
public class UserExt {
    private boolean fired;
    private Date date;
}