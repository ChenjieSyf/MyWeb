package com.example.demo.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelData implements Comparable<ExcelData> {
    private String appName;
    private String publishContext;
    private long publishDate;
    private String ownerName;

    @Override
    public int compareTo(ExcelData o) {
        if (o == null || !(o instanceof ExcelData)) {
            return -1;
        }
        return (int) (this.getPublishDate() - o.getPublishDate());
    }
}
