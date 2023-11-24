package com.example.batterysimjobmanager_prototype.ResultData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {
    private String id;
    private List<ResultData> results;
}
