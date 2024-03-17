package com.example.test.test.service;

import com.example.test.test.DTO.FilterDTO;
import com.example.test.test.entity.SchedulePeriod;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FilterSpecification {


    public static Specification<SchedulePeriod> getSpecification(FilterDTO filter){
        ArrayList<Specification<SchedulePeriod>> specificationPredicates = new ArrayList<Specification<SchedulePeriod>>();

        if(filter == null){
            return Specification.allOf();
        }

        if(filter.getId() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), filter.getId())));
        }

        if(filter.getAdministratorId() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("administrator_id"), filter.getAdministratorId())));
        }

        if(filter.getExecutorId() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("executor_id"), filter.getExecutorId())));
        }

        if(filter.getScheduleId() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("schedule_id"), filter.getScheduleId())));
        }

        if(filter.getSlotId() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("slot_id"), filter.getSlotId())));
        }

        if(filter.getSlotType() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("slot_type"), filter.getSlotType())));
        }

        if(filter.getBegin_time() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("slot").get("begin_time"), filter.getBegin_time())));
        }

        if(filter.getEnd_time() != null){
            specificationPredicates.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("slot").get("end_time"), filter.getEnd_time())));
        }


        return Specification.allOf(specificationPredicates);
    }
}
