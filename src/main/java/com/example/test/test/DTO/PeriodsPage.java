package com.example.test.test.DTO;


import com.example.test.test.entity.SchedulePeriod;
import lombok.Data;

import java.util.List;

@Data
public class PeriodsPage {
    public List<SchedulePeriod> periods;

    public Pagination pagination;

}
