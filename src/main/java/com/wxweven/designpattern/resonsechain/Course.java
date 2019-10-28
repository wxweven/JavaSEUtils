package com.wxweven.designpattern.resonsechain;

import lombok.Builder;
import lombok.Data;

/**
 * @author wxweven
 */
@Data
@Builder
public class Course {
    private int id;
    private String name;
    private String article;
    private String video;
}